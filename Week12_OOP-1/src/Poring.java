/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Poring implements Runnable, MouseListener{
    private JFrame pFrame;
    
    private JLabel countLb;
    private JLabel imgLb;
    private Random random;
    
    public Poring(int count) {
        random = new Random();
        
        pFrame = new JFrame();
        
        countLb = new JLabel(count + "");

        imgLb = new JLabel(new ImageIcon("./src/what.jpg"));
        
        pFrame.setDefaultCloseOperation(pFrame.DO_NOTHING_ON_CLOSE);
        pFrame.setLocation(random.nextInt(1000), random.nextInt(800));
        pFrame.setSize(250, 250);
        pFrame.setVisible(true);
        
        pFrame.setLayout(new FlowLayout());
        
        pFrame.add(imgLb);
        pFrame.add(countLb);
        
        pFrame.addMouseListener(this);

    }
    
    public void run(){
        
        try {
            while(true) {
                Thread.sleep(220);
//                pFrame.setLocation(pFrame.getX()+2, pFrame.getY()+2);
//                pFrame.setLocation(pFrame.getX()+4, pFrame.getY()+4);
                pFrame.setLocation(pFrame.getLocation().x + random.nextInt(80), pFrame.getLocation().y + random.nextInt(80) );
                pFrame.setLocation(pFrame.getLocation().x - random.nextInt(80), pFrame.getLocation().y - random.nextInt(80) );
//                if (Math.random()<=0.5) {
//                    if (Math.random()<=0.5){
//                        pFrame.setLocation(pFrame.getX()+2, pFrame.getY()+2);
//                    }
//                    else {
//                        pFrame.setLocation(pFrame.getX()+2, pFrame.getY()+2);
//                    }
//                }
//                else {
//                    if (Math.random()<=0.5){
//                        pFrame.setLocation(pFrame.getX()+2, pFrame.getY()+2);
//                    }
//                    else {
//                        pFrame.setLocation(pFrame.getX()+2, pFrame.getY()+2);
//                    }
//                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public synchronized void mouseClicked(MouseEvent ev){}
    public void mouseEntered(MouseEvent ev){}
    public void mouseExited(MouseEvent ev){}
    public void mousePressed(MouseEvent ev){pFrame.dispose();}
    public void mouseReleased(MouseEvent ev){}
}
