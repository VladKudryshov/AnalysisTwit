package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;


public class test extends JFrame{
    Image image;
    Image image2;

    public test(){
        this.setTitle("Remember g for Graphics");
        this.setSize(450,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
    public void paint(Graphics g){
        ImageIcon i = new ImageIcon("image/Abstract-background-1.p­ng");
        image = i.getImage();
        g.drawImage(image, 0, 0, null);
        g.setColor(Color.BLACK);
        g.drawRect(40, 40, 30, 30);
        g.setColor(Color.RED);
        g.drawOval(80, 80, 30, 30);
        g.fillArc(140, 140, 30, 30, 180, 10);
        g.drawLine(100, 300, 350, 400);
        g.setFont(new Font("Arial",Font.BOLD,34));
        g.drawString("Paint this!", 150, 100);
        ImageIcon i2 = new ImageIcon("image/madBoySprite.png");
        image2 = i2.getImage();
        g.drawImage(image2, 100, 200, null);
    }

    public static void main(String[] args){
        new test(); }

}