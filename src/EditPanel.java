import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditPanel extends TranslatePanel {
    private JTextField targetLang, sourceLang;
    private JPanel edit;
    private JLabel saveButton;
    private Word selectedWord;

    public EditPanel() {
        super();
        selectedWord = new Word();
        edit = new JPanel();
        edit.setBounds(0, CommonFunc.CANVAS_WIDTH / 2 - 150, CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT / 2);
        edit.setBackground(ColorManagement.BAR_BLUE);
        edit.setLayout(null);
        add(edit);

        targetLang = new JTextField("NTKong");
        targetLang.setFont(CommonFunc.font);
        targetLang.setBounds(50, 20, CommonFunc.CANVAS_WIDTH - 100 , 50);
        edit.add(targetLang);

        sourceLang = new JTextField("Nguyễn Thành Công");
        sourceLang.setFont(CommonFunc.font);
        sourceLang.setBounds(50, 90, CommonFunc.CANVAS_WIDTH - 100, 50);
        edit.add(sourceLang);
        edit_word();

        saveButton = new JLabel();
        initButton(saveButton, "Save");
        saveButton.setBounds(CommonFunc.CANVAS_WIDTH / 2 - 125, 140, 250, CommonFunc.BUTTON_HEIGHT);
        edit.add(saveButton);
    }

    public void initButton(JLabel button, String name) {
        ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s.png", name));
        Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(imageScale));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (management.deleteData(dictionary, selectedWord)) {
                    management.addData(dictionary, new Word(targetLang.getText(), sourceLang.getText()));
                    management.dictionaryExportToFile(dictionary);
                }
                ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s_Pressed.png", name));
                Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(imageScale));
                updateSearch();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s.png", name));
                Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(imageScale));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s_Entered.png", name));
                Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(imageScale));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s.png", name));
                Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(imageScale));
            }
        });
    }

    public void edit_word() {
        vnJlist.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (vnJlist.getSelectedIndex() == -1) {
                    System.out.println(-1);
                } else {
                    enJlist.setSelectedIndex(vnJlist.getSelectedIndex());
                    targetLang.setText((enJlist.getSelectedValue()));
                    sourceLang.setText(vnJlist.getSelectedValue());
                    selectedWord.setWord(targetLang.getText(), sourceLang.getText());
                }
            }
        });
        enJlist.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (enJlist.getSelectedIndex() == -1) {
                    System.out.println(-1);
                } else {
                    vnJlist.setSelectedIndex(enJlist.getSelectedIndex());
                    sourceLang.setText((vnJlist.getSelectedValue()));
                    targetLang.setText(enJlist.getSelectedValue());
                    selectedWord.setWord(targetLang.getText(),sourceLang.getText());
                }
            }
        });
    }
}
