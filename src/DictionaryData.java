public class DictionaryData {
    public Dictionary dictionary;
    public DictionaryCommandline commandline;
    public DictionaryManagement management;
    public DictionaryData() {
        dictionary = new Dictionary();
        commandline = new DictionaryCommandline();
        management = new DictionaryManagement();
        dictionary.addWord(management.insertFromFile());
    }
}
