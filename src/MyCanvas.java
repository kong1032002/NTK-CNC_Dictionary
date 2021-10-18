import java.awt.*;

public class MyCanvas extends Canvas {
    public MyCanvas() {
        super();
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        clear(graphics);
    }

    public void clear(Graphics graphics) {
        graphics.setColor(ColorManagement.CANVAS_BACKGROUND);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }
}
