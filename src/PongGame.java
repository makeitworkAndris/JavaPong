import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 460;
    private Ball gameBall;
    private Paddle userPaddle,pcPaddle;

    private int userMouseY;


    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);

        gameBall.paint(g);

        userPaddle.paint(g);
        pcPaddle.paint(g);

    }


    public PongGame(){
        gameBall = new Ball(200,200,3,3,10,3,Color.YELLOW);
        userPaddle = new Paddle(5,180,75,3,Color.RED);
        pcPaddle = new Paddle(620,180,75,3,Color.BLUE);

        userMouseY = 0;
        addMouseMotionListener(this);
    }
    public void gameLogic(){
        gameBall.moveBall();
        gameBall.bounceOffEdges(0,WINDOW_HEIGHT);
        userPaddle.moveTowards(userMouseY);

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }
}
