import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private Scanner scanner;

    public DictionaryManagement() {
        scanner = null;
    }

    public Word insertFromCommandline() {
        this.scanner = new Scanner(System.in);
        return new Word(scanner.nextLine(), scanner.nextLine());
    }

    // đọc file Dictionaries.txt tạo thành một danh sách từ
    public ArrayList<Word> insertFromFile() {
        String url = "src\\Dictionaries.txt";
        ArrayList<Word> words = new ArrayList<>();
        FileInputStream fileInputStream;
        // néu lỗi thoát vòng lặp
        try {
            fileInputStream = new FileInputStream(url);
            scanner = new Scanner(fileInputStream);
            // khi trong file còn tự tiếp tục đọc
            while (scanner.hasNextLine()) {
                // dọc và tách 1 chuỗi thành 2 phân cách bởi dấu - .VD cho - dog
                String[] data = scanner.nextLine().split(" - ");
                //thêm từ vừa đọc được vào chuỗi đích đích
                words.add(new Word(data[0], data[1]));
            }
        } catch (IOException ex) {
            System.out.println(-1);
        }
        return words;
    }

    public Word dictionaryLookup(ArrayList<Word> words, String target) {
        scanner = new Scanner(System.in);
        Word result = new Word();
        for (Word word : words) {
            // tìm từ cần tìm rồi đưa ra ý nghĩa
            if (word.getTarget().equalsIgnoreCase(target)) {
                System.out.println(target + " " + word.getExplain());
                return new Word(target, word.getExplain());
            } else if (word.getExplain().equalsIgnoreCase(target)) {
                System.out.println(target + " " + word.getTarget());
                return new Word(word.getTarget(), target);
            }
        }
        return null;
    }

    // xoa du lieu bang dong lenh
    public boolean deleteData(Dictionary dictionary, Word deletedWord) {
        for (int i = 0; i < dictionary.words.size(); i++) {
            if (dictionary.words.get(i).getTarget().equalsIgnoreCase(deletedWord.getTarget())
                    || dictionary.words.get(i).getExplain().equalsIgnoreCase(deletedWord.getExplain())) {
                return dictionary.words.remove(dictionary.words.get(i));
            }
        }
        return false;
    }

    //them du lieu bang dong lenh
    public void addData(Dictionary dictionary, Word addedWord) {
        scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < dictionary.words.size(); i++) {
            if (dictionary.words.get(i).getTarget().compareToIgnoreCase(addedWord.getTarget()) == 0
            && dictionary.words.get(i).getExplain().compareToIgnoreCase(addedWord.getExplain()) == 0) {
                System.out.println("Từ bạn muốn thêm đã tồn tại.");
                count++;
                break;
            }
        }
        if (count == 0) {
            dictionary.addWord(addedWord);
        }
    }

    //xuat du lieu ra file text
    public void dictionaryExportToFile(ArrayList<Word> words){
        String url = "src\\Dictionaries.txt";
        File file = new File(url);
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            for (Word word : words) {
                outputStreamWriter.write(word.getTarget() + " - " + word.getExplain());
                outputStreamWriter.write("\n");
            }
            outputStreamWriter.flush();
        } catch (IOException e) {

        }
    }
}