import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class TranslatePanel extends JPanel {
    public JTextField searchBar;
    private JLabel searchLabel;
    public JPanel searchPanel;
    public DefaultListModel<String> vni;
    public DefaultListModel<String> eng;
    public JList<String> vnJlist;
    public JList<String> enJlist;
    public ArrayList<Word> words;
    public DictionaryCommandline commandline;
    public DictionaryManagement management;
    public static Dictionary dictionary;

    public TranslatePanel() {
        super();
        management = new DictionaryManagement();
        commandline = new DictionaryCommandline();
        if (isVisible()) {
            dictionary = new Dictionary();
            words = management.insertFromFile();
        }

        dictionary.addWord(words);
        commandline.showAllWords(words);

        setLayout(null);
//        font = new Font("Arial", Font.PLAIN, 20);

        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBounds(0,0, CommonFunc.CANVAS_WIDTH,70);
        searchPanel.setBackground(ColorManagement.tabBarBG);
        add(searchPanel);

        searchLabel = new JLabel("Search: ");
        searchLabel.setFont(CommonFunc.font);
        searchLabel.setForeground(ColorManagement.TEXT);
        searchLabel.setLabelFor(searchBar);
        searchPanel.add(searchLabel);

        searchBar = new JTextField("Type here to search");
        searchBar.setFont(CommonFunc.font);
        searchBar.setPreferredSize(new Dimension(600, 40));
        searchPanel.add(searchBar);

        search();

        eng = new DefaultListModel<>();
        vni = new DefaultListModel<>();

        vnJlist = new JList<>(vni);
        vnJlist.setFont(CommonFunc.font);
        vnJlist.setBackground(ColorManagement.tabBarBG);
        vnJlist.setBounds(CommonFunc.CANVAS_WIDTH / 2 - 20 + 15, 80, CommonFunc.CANVAS_WIDTH / 2 - 20, CommonFunc.CANVAS_HEIGHT / 2 - 50);
        vnJlist.setForeground(ColorManagement.TEXT);
        add(vnJlist);

        enJlist = new JList<>(eng);
        enJlist.setFont(CommonFunc.font);
        enJlist.setBackground(ColorManagement.BACKGROUND);
        enJlist.setBounds(10, 80, CommonFunc.CANVAS_WIDTH / 2 - 20, CommonFunc.CANVAS_HEIGHT / 2 - 50);
        enJlist.setForeground(ColorManagement.TEXT);
        add(enJlist);
    }

    public void updateSearch() {
        ArrayList<Word> result = commandline.dictionarySearcher(dictionary, searchBar.getText());
        dictionary.words.clear();
        dictionary.addWord(management.insertFromFile());
        vni.clear();
        eng.clear();
        if (result != null) {
            for (Word word : result) {
                vni.add(vni.size(), word.getExplain());
                eng.add(eng.size(), word.getTarget());
            }
        }
    }

    public void search() {
        searchBar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                ArrayList<Word> result = commandline.dictionarySearcher(dictionary, searchBar.getText());
                vni.clear();
                eng.clear();
                if (result != null) {
                    for (Word word : result) {
                        vni.add(vni.size(), word.getExplain());
                        eng.add(eng.size(), word.getTarget());
                    }
                }
            }
        });
    }
}
