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
import java.io.*;
public class StudentView implements ActionListener, WindowListener{
    private JLabel idLabel, nameLabel, moneyLabel;
    private JTextField idTextField, nameTextField, moneyTextField;
    private JButton depositButton, withdrawButton;
    private JPanel idPanel, namePanel, moneyPanel, buttonPanel, topPanel, bottomPanel;
    private JFrame frame;
    public StudentView(){
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        moneyLabel = new JLabel("Money:");
        idTextField = new JTextField();
        nameTextField = new JTextField();
        moneyTextField = new JTextField("0");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        idPanel = new JPanel();
        namePanel = new JPanel();
        moneyPanel = new JPanel();
        buttonPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        frame = new JFrame();
        
        Student s = null;
        try(FileInputStream fileInput = new FileInputStream("StudentM.dat");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);){
            s = (Student) objectInput.readObject();
        }catch(IOException e){
            System.out.print(e);
        }catch(ClassNotFoundException c){
            System.out.print(c);
        }
        
        if(s != null){
            idTextField.setText(s.getID()+"");
            nameTextField.setText(s.getName());
            moneyTextField.setText(s.getMoney()+"");
        }else{
            idTextField.setText("");
            nameTextField.setText("");
            moneyTextField.setText(0+"");
        }
        
        idPanel.setLayout(new GridLayout(1,2));
        idPanel.add(idLabel);   idPanel.add(idTextField);
        
        namePanel.setLayout(new GridLayout(1,2));
        namePanel.add(nameLabel);   namePanel.add(nameTextField);
        
        moneyPanel.setLayout(new GridLayout(1,2));
        moneyTextField.setEditable(false);
        moneyPanel.add(moneyLabel);    moneyPanel.add(moneyTextField);
        
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(depositButton);    buttonPanel.add(withdrawButton);
        
        topPanel.setLayout(new GridLayout(3,1));
        topPanel.add(idPanel);    topPanel.add(namePanel);   topPanel.add(moneyPanel);
        
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(topPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        depositButton.addActionListener(this);    withdrawButton.addActionListener(this);
        frame.addWindowListener(this);
        
        frame.setLayout(new FlowLayout());
        frame.add(bottomPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
    
    public static void main(String[] args){
        new StudentView();
    }
    
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(depositButton)){
            moneyTextField.setText((Integer.parseInt(moneyTextField.getText())+100)+"");
        }else if(ev.getSource().equals(withdrawButton)){
            if((Integer.parseInt(moneyTextField.getText())-100)<0){
                moneyTextField.setText("0");
            }else{
                moneyTextField.setText((Integer.parseInt(moneyTextField.getText())-100)+"");
            }
        }
    }
    
    public void windowOpened(WindowEvent ev){}
    public void windowClosed(WindowEvent ev){}
    public void windowClosing(WindowEvent ev){
        try(FileOutputStream fileOutput = new FileOutputStream("StudentM.dat");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);){
            objectOutput.writeObject(new Student(nameTextField.getText(), Integer.parseInt(idTextField.getText()), Integer.parseInt(moneyTextField.getText())));
        }catch(IOException e){
            System.out.print(e);
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public void windowIconified(WindowEvent ev){}
    public void windowDeiconified(WindowEvent ev){}
    public void windowActivated(WindowEvent ev){}
    public void windowDeactivated(WindowEvent ev){}
}
