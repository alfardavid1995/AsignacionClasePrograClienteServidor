/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class GestionAdministrador
{
    public void validacionestudiante(String NombreUsuario ,String password)
        {
            try{
            ;
            PreparedStatement consulta= Conexion.getConnection().prepareStatement("Select c.nombre,c.password from Adminstrador as c WHERE nombre IN ('"+NombreUsuario+"') AND password IN('"+password+"')");
            ResultSet rs = consulta.executeQuery();
            
            while (rs!=null && rs.next()){
                
                String contraseñavalidacion=rs.getString(2);
                String nombrevalidacion=rs.getString(1);
                
                if (nombrevalidacion.equals(NombreUsuario)&&contraseñavalidacion.equals(password)) 
                {
                    
                      JOptionPane.showMessageDialog(null,"Eres Administrador");
                    
                  
                }
                else if(nombrevalidacion.equals(NombreUsuario)!=true&&contraseñavalidacion.equals(password)!= true)
                {
                    JOptionPane.showMessageDialog(null,"Eres no eres Administrador");
                }
                
                

                
            }
            
            
        }catch (SQLException ex){
            Logger.getLogger(GestionAdministrador.class.getName()).log(Level.SEVERE,null, ex);
        }
        
          
        
            
        }
}
