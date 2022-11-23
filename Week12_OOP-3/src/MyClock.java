/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
public class MyClock extends JLabel implements Runnable{
    private int time;
    private boolean paused;
    public void run(){
        try{
            while(true){
                checkPause();
                
                //<------------------------- NO2 ---------------------->
//                Calendar d = Calendar.getInstance();
//                int sec = d.get(Calendar.SECOND);
//                int min = d.get(Calendar.MINUTE);
//                int hour = d.get(Calendar.HOUR_OF_DAY);
                
                //<------------------------- NO3,NO4 ---------------------->
                int sec = time%60;
                int min = (time/60)%60;
                int hour = (time/3600)%24;
                
                this.setEnabled(false);
                this.setBorder(null);
                this.setFont(new Font("Tahoma",Font.BOLD, 80));
                this.setText(String.format("%02d:%02d:%02d", hour, min, sec));
                Thread.sleep(1000);
                time++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void pauseThread(){
        paused = true;
        System.out.println("Paused");
    }
    
    public void checkPause(){
        while(paused){
            try{
                this.wait();
            }catch(Exception e){
//                e.printStackTrace();
            }
        }
    }
    
    public synchronized void resumeThread(){
        paused = false;
        this.notify();
        System.out.println("UnPaused");
    }
}
