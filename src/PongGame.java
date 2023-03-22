import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel{

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 460;
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        gameBall.paint(g);
    }
    private Ball gameBall;

    public PongGame(){
        gameBall = new Ball(300,200,3,3,10,3,Color.YELLOW);
    }
    public void gameLogic(){
        gameBall.moveBall();
        gameBall.bounceOffEdges(0,WINDOW_HEIGHT);
    }
}
