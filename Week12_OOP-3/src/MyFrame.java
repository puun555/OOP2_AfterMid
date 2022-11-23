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
    private JFrame window;
    private MyClock clock;
    private Thread t;
    private int checkPause = 0;

    public MyFrame(){
        window = new JFrame();
        clock = new MyClock();
        t = new Thread(clock);
        t.start();
        
        clock.addMouseListener(this);
        
        window.setLayout(new FlowLayout());
        window.add(clock);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450, 150);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    public static void main(String[] args){
        new MyFrame();
    }
    
    public synchronized void mouseClicked(MouseEvent ev){
        if(checkPause%2 == 0){
            clock.pauseThread();
        }
        else{
            clock.resumeThread();
        }
        checkPause++;
    }
    public void mouseEntered(MouseEvent ev){}
    public void mouseExited(MouseEvent ev){}
    public void mousePressed(MouseEvent ev){}
    public void mouseReleased(MouseEvent ev){}
    
}
