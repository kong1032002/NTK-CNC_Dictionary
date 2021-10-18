import javax.swing.*;

public class ShowAllWord extends JPanel {

    JList<String> vnJList;
    JList<String> enJlist;
    DefaultListModel<String> vni;
    DefaultListModel<String> eng;
    public ShowAllWord() {
        vni = new DefaultListModel<>();
        eng = new DefaultListModel<>();
        vnJList = new JList<>();
        enJlist = new JList<>();
    }
}
