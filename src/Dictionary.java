import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public ArrayList<Word> words = new ArrayList<>();
    public DictionaryCommandline commandline;
    public Dictionary() {
        commandline = new DictionaryCommandline();
    }

    //thêm và sắp xếp luôn danh sách từ
    public void addWord(Word newWord) {
        //words.add(newWord);
        if (words.size() == 0) {
            words.add(newWord);
        } else {
            if (words.size() == 1) {
                if (newWord.getTarget().compareTo(words.get(0).getTarget()) > 0) {
                    words.add(newWord);
                } else {
                    words.add(0, newWord);
                }
            } else {
                if (newWord.getTarget().compareTo(words.get(0).getTarget()) < 0) {
                    words.add(0, newWord);
                } else {
                    if (newWord.getTarget().compareTo(words.get(words.size() - 1).getTarget()) > 0) {
                        words.add(newWord);
                    } else {
                        for (int i = 0; i < words.size() - 1; i++) {
                            if (words.get(i).getTarget().compareTo(newWord.getTarget()) <= 0 &&
                                    words.get(i + 1).getTarget().compareTo(newWord.getTarget()) >= 0) {
                                words.add(i + 1, newWord);
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    public void addWord(String target, String explain) {
        Word word = new Word(target, explain);
        this.addWord(word);
    }

    public void addWord(List<Word> newWords) {
        for (Word newWord : newWords) {
            this.addWord(newWord);
        }
    }
}