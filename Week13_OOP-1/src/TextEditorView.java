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

public class TextEditorView {
    private JFrame fr;
    
    private JMenuBar menuBar;
    
    private JMenu fileMenu;
    
    private JMenuItem fileItems1, fileItems2, fileItems3,fileItems4;
    
    private JTextArea texta;
    
    public TextEditorView( ) {
        //build
        fr = new JFrame("Text Editor");
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        
        fileItems1 = new JMenuItem("New");
        fileItems2 = new JMenuItem("Open");
        fileItems3 = new JMenuItem("Save");
        fileItems4 = new JMenuItem("Close");
        
        texta = new JTextArea(45,45);

        //add
        fileMenu.add(fileItems1);
        fileMenu.add(fileItems2);
        fileMenu.add(fileItems3);
        fileMenu.add(fileItems4);
        
        menuBar.add(fileMenu);
        
        fr.add(texta);
        
        //set
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setSize(500, 500);
        fr.setJMenuBar(menuBar);
        
        
    }
    
    //setter getter
    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JMenuItem getFileItems1() {
        return fileItems1;
    }

    public void setFileItems1(JMenuItem fileItems1) {
        this.fileItems1 = fileItems1;
    }

    public JMenuItem getFileItems2() {
        return fileItems2;
    }

    public void setFileItems2(JMenuItem fileItems2) {
        this.fileItems2 = fileItems2;
    }

    public JMenuItem getFileItems3() {
        return fileItems3;
    }

    public void setFileItems3(JMenuItem fileItems3) {
        this.fileItems3 = fileItems3;
    }

    public JMenuItem getFileItems4() {
        return fileItems4;
    }

    public void setFileItems4(JMenuItem fileItems4) {
        this.fileItems4 = fileItems4;
    }

    public JTextArea getTexta() {
        return texta;
    }

    public void setTexta(JTextArea texta) {
        this.texta = texta;
    }
}
