import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class BouncingBall implements Runnable {
    private static final int MAX_RADIUS = 40;
    private static final int MIN_RADIUS = 3;
    private static final int MAX_SPEED = 15;

    private Field field;
    private int radius;
    private Color color;

    private double x, y;

    private int speed;
    private double speedX;
    private double speedY;

    public BouncingBall(Field field){
        this.field = field;
        radius = new Double(Math.random()* //возвращает число на отрезке [0;1]
                (MAX_RADIUS - MIN_RADIUS)).intValue() + MIN_RADIUS;
        speed = new Double(Math.round(5*MAX_SPEED / radius)).intValue();
        if(speed>MAX_SPEED){
            speed = MAX_SPEED;
        }
        //направление скорости
        double angle = Math.random()*2* Math.PI;
        //составляющие скорости
        speedX = Math.cos(angle);
        speedY = Math.sin(angle);
        color = new Color((int)Math.random(),
                (int)Math.random(),(int)Math.random());
        Thread T = new Thread(this);
        T.start();
    }

