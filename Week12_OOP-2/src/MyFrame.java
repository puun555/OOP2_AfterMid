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

public class MyFrame implements MouseListener{
    private JFrame fr;
    private MyClock clock;
    private Thread t;
    private int checkPause = 0;
    
    public MyFrame() {
        fr = new JFrame();
        clock = new MyClock();
        t = new Thread(clock);
        t.start();
        
        clock.addMouseListener(this);
        
        fr.setLayout(new FlowLayout());
        fr.add(clock);
        
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setSize(200,100);
    }
    
    public static void main(String[] args) {
        new MyFrame();
    }
    public synchronized void mouseClicked(MouseEvent ev) {
        if (checkPause%2 == 0) {
            clock.pauseThread();
        }
        else {
            clock.resumeThread();
        }
        checkPause++;
        
    }
    public void mouseEntered(MouseEvent ev){}
    public void mouseExited(MouseEvent ev){}
    public void mousePressed(MouseEvent ev){}
    public void mouseReleased(MouseEvent ev){}
}
