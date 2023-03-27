import java.awt.*;

public class Ball {
    private int x,y,cx,cy,size,speed;
    private Color color;

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getSize(){
        return size;
    }

    public Ball (int x, int y, int cx, int cy, int size, int speed, Color color){
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,size,size);
    }

    public void moveBall(){
        x += cx;
        y += cy;
    }

    public void bounceOffEdges(int top,int bottom){
        if (y > bottom - size){
            reverseY();
        }
        else if(y < top){
            reverseY();
        }
    }
    public void reverseX(){
        cx *= -1;
    }
    public void reverseY(){
        cy *= -1;
    }
}
