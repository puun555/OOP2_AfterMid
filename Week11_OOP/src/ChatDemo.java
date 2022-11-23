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
import java.io.*;

public class ChatDemo {
    
    String chatText = "";
    
    
    private JFrame fr;
    
    private JPanel pn1;
    private JPanel pn2;
    
    private JTextField txtf;
    private JTextArea txtA;
    
    private JButton bn1;
    private JButton bn2;
    private EventHandler ehandle;
    
    //getter setter

    public JTextField getTxtf() {
        return txtf;
    }

    public void setTxtf(JTextField txtf) {
        this.txtf = txtf;
    }

    public JTextArea getTxtA() {
        return txtA;
    }

    public void setTxtA(JTextArea txtA) {
        this.txtA = txtA;
    }

    public JButton getBn1() {
        return bn1;
    }

    public void setBn1(JButton bn1) {
        this.bn1 = bn1;
    }

    public JButton getBn2() {
        return bn2;
    }

    public void setBn2(JButton bn2) {
        this.bn2 = bn2;
    }
    
    
    public ChatDemo() {
        
        fr = new JFrame("ChatDemo");
        
        pn1 = new JPanel();
        pn2 = new JPanel();
        
        txtf = new JTextField(45);
        txtA = new JTextArea(20, 45);
        
        bn1 = new JButton("Submit");
        bn2 = new JButton("Reset");
        
        ehandle = new EventHandler(this);
        
        //setLay
        fr.setLayout(new BorderLayout());
        pn1.setLayout(new FlowLayout());
        pn2.setLayout(new GridLayout(2,1));
        
        try (FileReader fileRead = new FileReader("ChatDemo.dat")) {
            System.out.println("Fuck u read");
            int ch;
            while ((ch = fileRead.read()) != -1) {
                chatText += (char)ch;
            }
            txtA.setText(chatText);
        }
        catch(IOException e) {
            System.out.println(e);
        }
        
        
        //add
        pn1.add(bn1);
        pn1.add(bn2);
        
        pn2.add(txtf);
        pn2.add(pn1);
        
        fr.add(txtA, BorderLayout.NORTH);
        fr.add(pn2, BorderLayout.SOUTH);
        
        //event
        bn1.addActionListener(ehandle);
        bn2.addActionListener(ehandle);
        
        fr.addWindowListener(ehandle);
        
        //setr
        fr.setVisible(true);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
