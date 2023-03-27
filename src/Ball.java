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
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public int setCx(int cx){return cx;}
    public void setCy(int cy){this.cy = cy;}
    public void setSpeed(int speed){this.speed = speed;}

    public Ball (int x, int y, int cx, int cy, int speed, int size, Color color){
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
