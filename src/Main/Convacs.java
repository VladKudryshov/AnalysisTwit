package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class Convacs extends JPanel {

    private int [] x;
    private int [] y;

    public Convacs(int []x, int y[]){
        setPreferredSize(new Dimension(1280,600));
        this.x = x;
        this.y = y;
    }




    public void paintComponent(Graphics g){
        super.paintComponents(g);


        ArrayList<Point2D.Double> point = new ArrayList<>();

        point.add((new Point2D.Double (1280-75.414089*10,600-39.804456*10)));
        point.add((new Point2D.Double (1280-75.507197*10,600-39.683964*10)));
        point.add((new Point2D.Double (1280-75.611259*10,600-39.61824*10)));
        point.add((new Point2D.Double (1280-75.589352*10,600-39.459409*10)));
        point.add((new Point2D.Double (1280-75.441474*10,600-39.311532*10)));
        point.add((new Point2D.Double (1280-75.403136*10,600-39.065069*10)));
        point.add((new Point2D.Double (1280-75.189535*10,600-38.807653*10)));
        point.add((new Point2D.Double (1280-75.09095*10,600-38.796699*10)));
        point.add((new Point2D.Double (1280-75.047134*10,600-38.451652*10)));
        point.add((new Point2D.Double (1280-75.693413*10,600-38.462606*10)));
        point.add((new Point2D.Double (1280-75.786521*10,600-39.722302*10)));
        point.add((new Point2D.Double (1280-75.616736*10,600-39.831841*10)));
        point.add((new Point2D.Double (1280-75.414089*10,600-39.804456*10)));






        Graphics2D g2d=(Graphics2D)g;
        g2d.setPaint(Color.BLACK);
        Polygon r = new Polygon();
        Polygon w = new Polygon(x,y,x.length);


        for(int i = point.size()-1; i>0; i--){
            g2d.draw(new Line2D.Double(point.get(i).x,point.get(i).y,point.get(i-1).x,point.get(i-1).y));
        }


    }
}