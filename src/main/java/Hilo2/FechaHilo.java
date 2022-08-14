/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilo2;

import javax.swing.JOptionPane;

/**
 *
 * @author Christian Castro y David Alfaro
 */
public class FechaHilo extends Thread{
    public  int tiempo=0;
    
    public void run()
    {
        for(int i=0;i<1001;i++)
        {
            System.out.println(tiempo++); 
        
        }
    }
    
}
