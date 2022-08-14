/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilo2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author css124646
 */
public class MultiThreading extends Thread{

    public Calendar fechaHoy;
    public String formattedDate;
    
    @Override
    public void run(){
        

        while (true){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            formattedDate = simpleDateFormat.format(calendar.getTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MultiThreading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }
    
}