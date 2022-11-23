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

public class StudentView {
    private Student student;
    private EventStudent es; 
    
    private JFrame frame;
    
    private JPanel pn1;
    private JPanel pn2;
    private JPanel pn3;
    private JPanel pn4;
    
    private JButton bDeposit;
    private JButton bWithdraw;
    
    private JTextField idText;
    private JTextField nameText;
    private JTextField moneyText;
    
    private JLabel idlab;
    private JLabel namelab;
     private JLabel moneylab;
    
    //setter getter

    public JButton getbDeposit() {
        return bDeposit;
    }

    public JButton getbWithdraw() {
        return bWithdraw;
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getNameText() {
        return nameText;
    }
    public JTextField getMoneyText() {
        return moneyText;
    }
    
    
    
    //constructor
    public StudentView() {
        student = new Student();
        es = new EventStudent(this);
        
        frame = new JFrame("StudentView");
        
        pn1 = new JPanel();
        pn2 = new JPanel();
        pn3 = new JPanel();
        pn4 = new JPanel();
        
        bDeposit = new JButton("Deposite");
        bWithdraw = new JButton("Withdraw");
        
        idText = new JTextField("0");
        nameText = new JTextField();
        moneyText = new JTextField("0");
        
        idlab = new JLabel("ID:");
        namelab = new JLabel("Name:");
        moneylab = new JLabel("Money:");
        
        //setlayout
        frame.setLayout(new GridLayout(4,1));
        pn1.setLayout(new GridLayout(1,2));
        pn2.setLayout(new GridLayout(1,2));
        pn3.setLayout(new GridLayout(1,2));
        pn4.setLayout(new GridLayout(1,2, 10,20));
        
        //add
        pn1.add(idlab);
        pn1.add(idText);
        
        pn2.add(namelab);
        pn2.add(nameText);
        
        pn3.add(moneylab);
        pn3.add(moneyText);
        
        pn4.add(bDeposit);
        pn4.add(bWithdraw);
        
        frame.add(pn1);
        frame.add(pn2);
        frame.add(pn3);
        frame.add(pn4);
        
        //event
        bDeposit.addActionListener(es);
        bWithdraw.addActionListener(es);
        
        frame.addWindowListener(es);
        
        //set
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        
        //file Reader
        Student student = null;
        try (FileInputStream fileInput = new FileInputStream("StudentM.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);) {
            System.out.println("Fuck u Opening");
            student = (Student) objectInput.readObject();
        }
        catch (IOException e) {
            System.out.println(e + " Open IO Exception");
        }
        catch (ClassNotFoundException cnf) {
            System.out.println(cnf+"\n Classnotfound");
        }
        if(student != null){
            idText.setText(student.getID()+"");
            nameText.setText(student.getName());
            moneyText.setText(student.getMoney()+"");
            
        }else{
//            idText.setText("");
//            nameText.setText("");
//            moneyText.setText(0+"");
            student = new Student();
        }
    }
}
