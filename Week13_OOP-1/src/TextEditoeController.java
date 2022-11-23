/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class TextEditoeController implements ActionListener{
    private TextEditorView view;
    private TextEditorModel model;
    
    public TextEditoeController() {
        view = new TextEditorView();
        model = new TextEditorModel();
        
        view.getFileItems1().addActionListener(this);
        view.getFileItems2().addActionListener(this);
        view.getFileItems3().addActionListener(this);
        view.getFileItems4().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (null != ae.getActionCommand())//        JMenuItem mf1 = view.getFileItems1();
//        JMenuItem mf2 = view.getFileItems2();
//        JMenuItem mf3 = view.getFileItems3();
//        JMenuItem mf4 = view.getFileItems4();
//        
//        JTextArea textA = view.getTexta();
        //new
        switch (ae.getActionCommand()) {
            case "New":
                view.getTexta().setText("");
                break;
            case "Open":
                break;
            case "Save":
                break;
            case "close":
                System.exit(0);
            default:
                break;
        }
        
    }
}
