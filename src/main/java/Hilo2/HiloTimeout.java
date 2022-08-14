/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilo2;

import Aplicaciones.Inicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class HiloTimeout extends Thread{
    public Inicio inicioPincipal;
    public  int tiempoRestante = 60;
    
    public HiloTimeout(Inicio inicio) {
        inicioPincipal=inicio;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }
    
    
    
    public void run(){
        while (tiempoRestante>=0){
        try {
            Thread.sleep(1000);
            tiempoRestante--;
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTimeout.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }if(tiempoRestante<0)
    {
       JOptionPane.showMessageDialog(null,"Cerrado Por timeout de 60 segundos");
        inicioPincipal.dispose();
    }
   }
    
                
   
}
