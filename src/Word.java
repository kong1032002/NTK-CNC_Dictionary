public class Word {
    private String target;
    private String explain;

    public Word() {
        this.target = "chua co dư lieu";
        this.explain = "non information";
    }

    public Word(String target, String explain) {
        this.target = target;
        this.explain = explain;
    }

    public Word(Word word) {
        this.target = word.target;
        this.explain = word.explain;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public void setWord(String target, String explain) {
        this.target = target;
        this.explain = explain;
    }

    public String getTarget() {
        return this.target;
    }

    public String getExplain() {
        return this.explain;
    }
}
