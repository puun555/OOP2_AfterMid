
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class EventHandler extends WindowAdapter implements ActionListener{
    private ChatDemo gui;
    
    public EventHandler(ChatDemo gui) {
        this.gui = gui;
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        String textf = gui.getTxtf().getText();
        String texta = gui.getTxtA().getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if (ae.getSource().equals(gui.getBn1())){
            gui.getTxtA().setText(texta + dtf.format(LocalDateTime.now()) + " : " + textf + "\n");
            gui.getTxtf().setText("");
        }
        else {
            gui.getTxtA().setText("");
            gui.getTxtf().setText("");
        }
    }
    
    public void windowClosing(WindowEvent we){
        String texta = gui.getTxtA().getText();
        try (FileWriter fileWriter = new FileWriter("ChatDemo.dat")) {
            fileWriter.write(texta);
            System.out.println("Fuck u Close");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
