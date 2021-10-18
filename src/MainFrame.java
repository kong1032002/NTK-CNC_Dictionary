import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements ButtonPanel.ButtonListener {
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }

    private MyCanvas canvas;
    private JPanel mainPanel, buttonPanel, translatePanel, editPanel, addRemovePanel, dictionaryPanel;
    private Dictionary dictionary;

    public MainFrame() {

        setBounds(0,0, CommonFunc.WIDTH, CommonFunc.HEIGHT);
        setMinimumSize(new Dimension(CommonFunc.WIDTH, CommonFunc.HEIGHT));
        setMaximumSize(new Dimension(CommonFunc.WIDTH, CommonFunc.HEIGHT));
        setPreferredSize(new Dimension(CommonFunc.WIDTH, CommonFunc.HEIGHT));
        setResizable(false);
        getContentPane().setBackground(ColorManagement.BACKGROUND);
        setTitle("Dictonary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0, CommonFunc.WIDTH, CommonFunc.HEIGHT);
        mainPanel.setBackground(ColorManagement.backGround);
        add(mainPanel);

        buttonPanel = new ButtonPanel(this);
        buttonPanel.setBounds(0, 150, 250, CommonFunc.HEIGHT);
        buttonPanel.setBackground(ColorManagement.BACKGROUND);
        mainPanel.add(buttonPanel);

        translatePanel = new TranslatePanel();
        translatePanel.setBounds(250, 80, CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT);
        translatePanel.setBackground(ColorManagement.CANVAS_BACKGROUND);
        translatePanel.setVisible(false);
        mainPanel.add(translatePanel);

        editPanel = new EditPanel();
        editPanel.setBounds(250, 80, CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT);
        editPanel.setBackground(ColorManagement.CANVAS_BACKGROUND);
        editPanel.setVisible(false);
        mainPanel.add(editPanel);

        addRemovePanel = new AddRemovePanel();
        addRemovePanel.setBounds(250, 80, CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT);
        addRemovePanel.setBackground(ColorManagement.CANVAS_BACKGROUND);
        addRemovePanel.setVisible(false);
        mainPanel.add(addRemovePanel);

        dictionaryPanel = new DictionaryPanel();
        dictionaryPanel.setBounds(250, 80, CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT);
        dictionaryPanel.setBackground(ColorManagement.CANVAS_BACKGROUND);
        dictionaryPanel.setVisible(false);
        mainPanel.add(dictionaryPanel);

        canvas = new MyCanvas();
        canvas.setBounds(250, 80, CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT);
        canvas.setFocusable(false);
        canvas.setPreferredSize(new Dimension(CommonFunc.CANVAS_WIDTH, CommonFunc.CANVAS_HEIGHT));
        mainPanel.add(canvas);

        pack();
    }

    public void ButtonClicked(int id) {
        switch (id) {
            case 0:
                System.out.println("Translate");
                editPanel.setVisible(false);
                dictionaryPanel.setVisible(false);
                addRemovePanel.setVisible(false);
                translatePanel.setVisible(true);
                break;
            case 1:
                dictionaryPanel.setVisible(false);
                addRemovePanel.setVisible(false);
                translatePanel.setVisible(false);
                editPanel.setVisible(true);
                break;
            case 2:
                dictionaryPanel.setVisible(false);
                editPanel.setVisible(false);
                translatePanel.setVisible(false);
                addRemovePanel.setVisible(true);
                break;
            case 3:
                dictionaryPanel.setVisible(true);
                editPanel.setVisible(false);
                translatePanel.setVisible(false);
                addRemovePanel.setVisible(false);
                break;
        }
    }
}