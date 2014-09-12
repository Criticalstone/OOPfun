import java.awt.*;

/**
 * Created by Kevin on 2014-09-11.
 */
public class Ball {
    int width,height,x,y = 0;
    int dx = 1;
    int dy = 1;
    Rectangle rect;
    Rectangle bounds;
    public Ball(int screenWidth, int screenHeight, int width, int height, Rectangle bounds){
        this.x = (int)(Math.random()*screenWidth);
        this.y = (int)(Math.random()*screenHeight);
        this.dx = (int) (Math.random()*2)-1;
        this.dy = (int) (Math.random()*2)-1;
        if(this.dx == 0 || this.dy == 0){
            this.dx = 1;
            this.dy = 1;
        }
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(this.x, this.y, width, height);
        this.bounds = bounds;
    }

    public void update(){
        this.x += dx;
        this.y += dy;
        this.rect.setLocation(this.x, this.y);

        if(this.rect.getMaxX() > this.bounds.getMaxX()){
            dx = -1;
        }else if(this.rect.getMinX() < bounds.getMinX()){
            dx = 1;
        }

        if(this.rect.getMaxY() > bounds.getMaxY()){
            dy = -1;
        }else if(this.rect.getMinY() < bounds.getMinY() + 45){
            dy = 1;
        }
    }
}
