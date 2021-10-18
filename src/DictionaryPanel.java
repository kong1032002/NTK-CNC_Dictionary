import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DictionaryPanel extends TranslatePanel {
    public DictionaryPanel() {
        super();
        ArrayList<Word> words = commandline.dictionarySearcher(dictionary, "");
        vni.clear();
        eng.clear();
        for (Word word : words) {
            vni.add(vni.size(), word.getExplain());
            eng.add(eng.size(), word.getTarget());
        }
        setLayout(new FlowLayout());
        vnJlist.setPreferredSize(new Dimension(CommonFunc.CANVAS_WIDTH / 2 - 100, CommonFunc.CANVAS_HEIGHT));
        enJlist.setPreferredSize(new Dimension(CommonFunc.CANVAS_WIDTH / 2 - 100, CommonFunc.CANVAS_HEIGHT));
        searchPanel.setVisible(false);
    }
}
