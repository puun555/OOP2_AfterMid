/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.awt.event.*;
import java.io.*;

public class EventStudent extends WindowAdapter implements ActionListener {
    private StudentView gui;
    private Student student;
    
    
    public EventStudent(StudentView gui) {
        this.gui = gui;
    }
    
    public void actionPerformed(ActionEvent ae) {
        int money = Integer.parseInt(gui.getMoneyText().getText());
        if (ae.getSource().equals(gui.getbDeposit())) {
            money += 100;
            gui.getMoneyText().setText(money + "");
        }
        else {
            if (money-100 < 0) {
                money = money;
                gui.getMoneyText().setText(money + "");
            }
            else {
                money -= 100;
                gui.getMoneyText().setText(money + "");
            }
        }
    }
    
    public void windowClosing(WindowEvent we) {
        try (FileOutputStream fileOutput = new FileOutputStream("StudentM.dat")) {
            System.out.println("Fuck Closing");
            student = new Student(gui.getNameText().getText(), Integer.parseInt(gui.getIdText().getText()), Integer.parseInt(gui.getMoneyText().getText()));
            ObjectOutputStream upt = new ObjectOutputStream(fileOutput);
            upt.writeObject(student);
//            new Student(gui.getNameText().getText(), Integer.parseInt(gui.getIdText().getText()), Integer.parseInt(gui.getMoneyText().getText()))
        }
        catch (IOException e) {
            System.out.println(e + " Close IO Exception");
        }
    }
    
    
    
}
