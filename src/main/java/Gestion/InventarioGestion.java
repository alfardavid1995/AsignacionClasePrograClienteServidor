/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class InventarioGestion 
{
  //Permite mostrar el listado de estudiantes en pantalla
    private static final String SQL_SELECT_ESTUDIANTES= "Select * from estudiante";
        private static final String SQL_VALIDACION_ESTUDIANTES= "Select c.idEstudiante,c.nombre from estudiante as c";
    private static final String SQL_INSERT_ESTUDIANTES= "insert into articulo values (7,'Articulo 007',507)"; 
   
    public void mostrar_reporte_de_estudiantes (){
        
        try{
            
            //Estamos haciendo uso de la clase conexión a la base de datos y mandando el script de traer todos los estudiantes
            PreparedStatement consulta= Conexion.getConnection().prepareStatement(SQL_SELECT_ESTUDIANTES);
            ResultSet rs = consulta.executeQuery();
            
            while (rs!=null && rs.next()){
                
                System.out.print("Cédula: " + rs.getString(2)+",");
                System.out.print("Nombre: " + rs.getString(3)+",");
                System.out.print("Primer Apellido: " + rs.getString(4)+",");
                System.out.print("Segundo Apellido: " + rs.getString(5)+",");
                System.out.print("Fecha de Nacimiento: " + rs.getDate(6)+",");
                System.out.print("Fecha de Ingreso: " + rs.getDate(7)+",");
                System.out.print("Género: " + rs.getString(8).charAt(0));
                System.out.println("");
                
            }
            
            
        }catch (SQLException ex){
            Logger.getLogger(InventarioGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
    }
          public void enviardatos ()
          {
                   
        try{
            
          Statement stmt = Conexion.getConnection().createStatement();
           stmt.executeUpdate(SQL_INSERT_ESTUDIANTES);
            System.out.println("Guardado");
                
            }
            catch (Exception ex)
            {
            Logger.getLogger(InventarioGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
          }  
            
           public void enviardatosartculos ()
          {
                   
        try{
            int id=Integer.parseInt(JOptionPane.showInputDialog("Digite el id"));
            String descripcion=JOptionPane.showInputDialog("Digite la decripcion del articulo");
            String precio=JOptionPane.showInputDialog("Digite el precio");
          Statement stmt = Conexion.getConnection().createStatement();
           stmt.executeUpdate("insert into articulo(id,descripcion,precio) values ("+String.valueOf(id)+",'"+descripcion+"',"+precio+")");
            System.out.println("Guardado");
                
            }
            catch (SQLException ex)
            {
            Logger.getLogger(InventarioGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
          } 
        public void validacionestudiante()
        {
            try{
            String  nombreDeUsuario=JOptionPane.showInputDialog("Digite el nombre del estudiante");
            String cedula=JOptionPane.showInputDialog("Digite la cedula");
            //Estamos haciendo uso de la clase conexión a la base de datos y mandando el script de traer todos los estudiantes
            PreparedStatement consulta= Conexion.getConnection().prepareStatement("Select c.idEstudiante,c.nombre from estudiante as c WHERE nombre IN ('"+nombreDeUsuario+"') AND idEstudiante IN('"+cedula+"')");
            ResultSet rs = consulta.executeQuery();
            
            while (rs!=null && rs.next()){
                
                String cedulavalidacion=rs.getString(1);
                String nombrevalidacion=rs.getString(2);
                
                if (nombrevalidacion.equals(nombreDeUsuario)&&cedulavalidacion.equals(cedula)) 
                {
                    
                      JOptionPane.showMessageDialog(null,"Eres Estudiante");
                    
                  
                }
                else if(nombrevalidacion.equals(nombreDeUsuario)!=true&&cedulavalidacion.equals(cedula)!= true)
                {
                     JOptionPane.showMessageDialog(null,"Eres no eres Estudiante");
                }
                
                
//                System.out.print("Cédula: " + rs.getString(1)+",");
//                System.out.print("Nombre: " + rs.getString(2)+",");
                
            }
            
            
        }catch (SQLException ex){
            Logger.getLogger(InventarioGestion.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
            
        }
            
}
