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

public class PoringConstructor implements ActionListener{
    private JFrame frame;
    private JButton bn1;
    private int count = 0;
    private Poring poring;
    
    public PoringConstructor() {
        frame = new JFrame();
        bn1 = new JButton("Add");
        
        //setlayout
        frame.setLayout(new FlowLayout());
        
        //add
        frame.add(bn1);
        
        //add event
        bn1.addActionListener(this);
        
        //set
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(170, 75);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(bn1)){
            count++;
            poring = new Poring(count);
            Thread thread = new Thread(poring);
            thread.start();
        }
    }
}

