import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 460;
    private Ball gameBall;
    private Paddle userPaddle,pcPaddle;
    private int userMouseY;
    private int userScore; private int pcScore;

    private int bounceCount;

    public PongGame(){
        gameBall = new Ball(300,200,3,3,3,10,Color.YELLOW);
        userPaddle = new Paddle(5,180,75,3,Color.RED);
        pcPaddle = new Paddle(620,180,75,3,Color.BLUE);

        userMouseY = 0;
        userScore = 0; pcScore = 0;
        bounceCount = 0;

        addMouseMotionListener(this);
    }

    public void reset(){

        try{
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setCx(3);
        gameBall.setCy(3);
        gameBall.setSpeed(3);
        bounceCount = 0;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);

        gameBall.paint(g);

        userPaddle.paint(g);
        pcPaddle.paint(g);

        g.setColor(Color.WHITE);
        g.drawString("Score - User [ " + userScore + "] PC [ " + pcScore + "]", 250, 20);

    }



    public void gameLogic(){
        gameBall.moveBall();

        gameBall.bounceOffEdges(0,WINDOW_HEIGHT);

        userPaddle.moveTowards(userMouseY);
        pcPaddle.moveTowards(gameBall.getY());

        if(pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)){
            gameBall.reverseX();
            bounceCount++;
        }
        if(bounceCount == 3){
            bounceCount = 0;
            gameBall.increaseSpeed();
        }

        if(gameBall.getX() < 0){
            pcScore++;
            reset();
        }
        else if(gameBall.getY() > WINDOW_WIDTH){
            userScore++;
            reset();
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }


}
