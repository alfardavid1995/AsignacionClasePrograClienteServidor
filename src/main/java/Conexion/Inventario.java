/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class Inventario 
{
   private int Id ;
   private String codigoArticulo ;
   private String  nombreArticulo;
   private double precioArticulo ;
   private String descripcionArticulo;
   private int cantidad ; 

    public Inventario(int Id, String codigoArticulo, String nombreArticulo, double precioArticulo, String descripcionArticulo, int cantidad) {
        this.Id = Id;
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioArticulo = precioArticulo;
        this.descripcionArticulo = descripcionArticulo;
        this.cantidad = cantidad;
    }

    public Inventario() {
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public String getDescripcionArticulo() {
        return descripcionArticulo;
    }

    public void setDescripcionArticulo(String descripcionArticulo) {
        this.descripcionArticulo = descripcionArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public  void  crearUsuarios()
    {
        PreparedStatement ps=Conexion.getConnection().prepareStatement("INSERT INTO usuarios(nombreusuarios,primerApellido,SegundoApellido,Email,FechaNacimiento,ipv4)VALUES (?,?,?,?,?,?)");
          
            ps.setString(1, nombrePersona);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, email);
            ps.setDate(5, fechaNacimiento);
            ps.setString(6, ip);
            consutaRoles.setInt(1,ipsiguien);
            consutaRoles.setInt(2, rol);
            ps.execute();
            consutaRoles.execute();
            JOptionPane.showMessageDialog(null,"Se ha guardado el usuario");
                
            }
            catch (SQLException exception)
            {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, exception);
        }
    }
}
