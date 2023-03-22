import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel{

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 640;

    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
    }
}
