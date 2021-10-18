import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddRemovePanel extends TranslatePanel {
    private JPanel addRemove;
    private JTextField targetLang, sourceLang;
    private JLabel addButton, removeButton;
    public AddRemovePanel() {
        super();

        addRemove = new JPanel();
        addRemove.setBounds(0, CommonFunc.CANVAS_WIDTH / 2 - 150, CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT / 2);
        addRemove.setBackground(ColorManagement.tab);
        addRemove.setLayout(null);
        add(addRemove);

        targetLang = new JTextField();
        targetLang.setFont(CommonFunc.font);
        targetLang.setBounds(50, 20, CommonFunc.CANVAS_WIDTH - 100 , 50);
        addRemove.add(targetLang);

        sourceLang = new JTextField();
        sourceLang.setFont(CommonFunc.font);
        sourceLang.setBounds(50, 90, CommonFunc.CANVAS_WIDTH - 100, 50);
        addRemove.add(sourceLang);

        addButton = new JLabel();
        initButton(addButton, "Add");
        addButton.setBounds(CommonFunc.CANVAS_WIDTH / 2 - 300, 140, 250, CommonFunc.BUTTON_HEIGHT);
        addRemove.add(addButton);

        removeButton = new JLabel();
        initButton(removeButton, "Remove");
        removeButton.setBounds(CommonFunc.CANVAS_WIDTH / 2 + 50, 140, 250, CommonFunc.BUTTON_HEIGHT);
        addRemove.add(removeButton);

        add_remove();
    }

    public void initButton(JLabel button, String name) {
        ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s.png", name));
        Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(imageScale));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Word word = new Word(targetLang.getText(), sourceLang.getText());
                if (name.equalsIgnoreCase("Add")) {
                    management.addData(dictionary, word);
                } else {
                    management.deleteData(dictionary, word);
                };
                management.dictionaryExportToFile(dictionary);
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

    public void add_remove() {
        vnJlist.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if (vnJlist.getSelectedIndex() == -1) {
                    System.out.println(-1);
                } else {
                    enJlist.setSelectedIndex(vnJlist.getSelectedIndex());
                    targetLang.setText((enJlist.getSelectedValue()));
                    sourceLang.setText(vnJlist.getSelectedValue());
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
                }
            }
        });
    }
}
