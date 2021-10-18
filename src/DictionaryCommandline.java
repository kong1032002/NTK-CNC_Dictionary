import java.util.ArrayList;

public class DictionaryCommandline {
    public DictionaryCommandline() {
    }

    public void showAllWords(ArrayList<Word> words) {
        System.out.format("%-3s %-15s %-15s \n", "No", "English", "VietNamese");
        for (int i = 0; i < words.size(); i++) {
            System.out.format("%-3s %-15s %-15s \n", i + 1, "| " + words.get(i).getTarget(), "| " + words.get(i).getExplain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement management = new DictionaryManagement();
        Dictionary dictionary = new Dictionary();
        dictionary.addWord(management.insertFromCommandline());
        showAllWords(dictionary.words);
    }

    public void dictionaryAdvance() {
        DictionaryManagement management = new DictionaryManagement();
        Dictionary dictionary = new Dictionary();
        dictionary.addWord(management.insertFromFile());
        showAllWords(dictionary.words);
        management.dictionaryLookup(dictionary.words, "cho");
    }

    //tim kiem bang dong lenh
    public ArrayList<Word> dictionarySearcher(Dictionary dictionary, String key) {
        if (key.isEmpty()) {
            return dictionary.words;
        }
        Dictionary d1 = new Dictionary();
        for (int i = 0; i < dictionary.words.size(); i++) {
            if (dictionary.words.get(i).getTarget().length() < key.length()) {
                continue;
            }
            if (dictionary.words.get(i).getTarget().substring(0, key.length()).equalsIgnoreCase(key)) {
                d1.addWord(dictionary.words.get(i));
            }
            if (dictionary.words.get(i).getTarget().charAt(0) > key.charAt(0)) {
                break;
            }
        }
        return d1.words;
    }
}