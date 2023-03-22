import java.awt.*;

public class Ball {
    private int x,y,cx,cy,size,speed;
    private Color color;

    public Ball (int x, int y, int cx, int cy, int size, int speed, Color color){
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.size = size;
        this.speed = speed;
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,size,size);
    }
    public void moveBall(){
        x += cx;
        y += cy;
    }
}
