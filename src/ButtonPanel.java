import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

public class ButtonPanel extends JPanel {
    private JLabel[] buttons;
    private ButtonListener buttonListener;

    public ButtonPanel(ButtonListener buttonListener) {
        super();
        this.buttonListener = buttonListener;
        buttons = new JLabel[CommonFunc.NUMBER_BUTTON];
        for (int i = 0; i < CommonFunc.NUMBER_BUTTON; i++) {
            buttons[i] = new JLabel();
        }
        initButton(buttons[0], "Translate", 0);
        initButton(buttons[1], "Edit", 1);
        initButton(buttons[2], "AddRemove", 2);
        initButton(buttons[3], "Dictionary", 3);

        setLayout(null);

        for (int i = 0; i < CommonFunc.NUMBER_BUTTON; i++) {
            buttons[i].setBounds(0, 31 + (CommonFunc.BUTTON_HEIGHT + 31) * i, CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT);
            add(buttons[i]);
        }
    }

    public void initButton(JLabel button, String name, int id) {
        ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s.png", name));
        Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);

        button.setIcon(new ImageIcon(imageScale));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                buttonListener.ButtonClicked(id);
                ImageIcon imageIcon = new ImageIcon(String.format("Icon//%s_Pressed.png", name));
                Image imageScale = imageIcon.getImage().getScaledInstance(CommonFunc.BUTTON_WIDTH, CommonFunc.BUTTON_HEIGHT, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(imageScale));
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

    public interface ButtonListener {
        void ButtonClicked(int id);
    }

}
