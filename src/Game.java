import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Kevin on 2014-09-11.
 */

public class Game extends JFrame {
    int screenWidth, screenHeight;
    Ball ball;
    int dx = 1;
    int dy = 1;
    Rectangle bounds;
    ArrayList<Ball> balls = new ArrayList<Ball>();

    public static void main(String[] args){
        new Game();
    }
    public Game(){
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GTEST");
        setVisible(true);
        setResizable(false);
        bounds = getBounds();
        for(int i = 0; i < 10; i++) {
            this.balls.add(new Ball(screenWidth, screenHeight, 100, 100, bounds));
        }
    }

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenWidth, screenHeight);
        g.setColor(Color.BLUE);
        for(int i = 0; i < this.balls.size(); i++) {
            this.balls.get(i).update();
            g.fillRect(this.balls.get(i).x, this.balls.get(i).y, this.balls.get(i).width, this.balls.get(i).height);
        }
        repaint();
    }
}

