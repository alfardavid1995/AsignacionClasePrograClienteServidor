/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
   public ArrayList listaArticulo=new ArrayList<>();
   public  DefaultTableModel modelo=new DefaultTableModel();

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
    
    
    public  void  CrearInventario()
    {   try{
        PreparedStatement ps=Conexion.getConnection().prepareStatement("INSERT INTO inventario (codigoArticulo,nombreArticulo,precioArticulo,descripcionArticulo,cantidad) VALUES (?,?,?,?,?)");
          
            ps.setString(1, codigoArticulo);
            ps.setString(2, nombreArticulo);
            ps.setDouble(3, precioArticulo);
            ps.setString(4, descripcionArticulo);
            ps.setInt(5, cantidad);
            
            ps.execute();
            JOptionPane.showMessageDialog(null,"Se ha guardado el usuario");
                
            }
            catch (SQLException exception)
            {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, exception);
        }
    }
    
    public void limpiartabla()
    {
        for(int i=0; i<100;i++)
        {
            modelo.removeRow(i);
        }
        
    }
    
    public  void BuscarInventario()
    {
        try {
            
            
            
            PreparedStatement consulta =Conexion.getConnection().prepareStatement("SELECT * FROM inventario as a WHERE a.codigoarticulo IN(?)");
          consulta.setString(1,codigoArticulo );
            ResultSet rs= consulta.executeQuery();
           JOptionPane.showMessageDialog(null,"Hola");
            
            
        while(rs!=null&&rs.next()){    
            this.Id=rs.getInt(1);
            this.codigoArticulo=rs.getString(2);
            this.nombreArticulo=rs.getString(3);
            this.precioArticulo=rs.getDouble(4);
            this.descripcionArticulo=rs.getString(5);
            this.cantidad=rs.getInt(6);
            
          
        }
            
            
            }
            catch (SQLException exception)
            {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, exception);
        }   
    } 
    
    public void actualizarInventario()
    {
      try {
            PreparedStatement ps=Conexion.getConnection().prepareStatement("update Inventario set nombreArticulo=?,"
                    + "precioArticulo=? , descripcionArticulo=?,cantidad=? where codigoarticulo=?" );
        
            ps.setString(1, nombreArticulo);
            ps.setDouble(2, precioArticulo);
            ps.setString(3, descripcionArticulo);
            ps.setInt(4, cantidad);
            ps.setString(5, codigoArticulo);
            
            ps.executeUpdate();  
        } catch (SQLException e) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, e);

        }

    }
    
    public void modificarInventario()
    {
        try {
            PreparedStatement ps=Conexion.getConnection().prepareStatement("update Inventario set nombreArticulo=?,"
                    + "precioArticulo=? , descripcionArticulo=?,cantidad=? where codigoarticulo=?" );
        
            ps.setString(1, nombreArticulo);
            ps.setDouble(2, precioArticulo);
            ps.setString(3, descripcionArticulo);
            ps.setInt(4, cantidad);
            ps.setString(5, codigoArticulo);
            
            ps.executeUpdate();  
        } catch (SQLException e) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, e);

        }
    }
    
    public void eliminarInventario()
    {
          try {
            PreparedStatement ps=Conexion.getConnection().prepareStatement("delete from inventario where codigoarticulo='?'");
        
            ps.setString(1, codigoArticulo);
       
        } catch (SQLException e) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, e);

        }
        
    }
    
   public void mostrarInventario()
   {
       try {
            
        
        PreparedStatement consulta =Conexion.getConnection().prepareStatement("Select * from inventario ");
        ResultSet rs= consulta.executeQuery();
          
                
                modelo.addColumn("ID");
                modelo.addColumn("Codigo Articulo");
                modelo.addColumn("Nombre Articulo");
                modelo.addColumn("Precio");
                modelo.addColumn("Descripcion");
                modelo.addColumn("Cantidad");
              
        while(rs!=null&&rs.next())
            {
               this.Id=rs.getInt(1);
               this.codigoArticulo=rs.getString(2);
               this.nombreArticulo=rs.getString(3);
               this.precioArticulo=rs.getDouble(4);
               this.descripcionArticulo=rs.getString(5);
               this.cantidad=rs.getInt(6);
                listaArticulo.add(0, Id);
                listaArticulo.add(1,codigoArticulo);
                listaArticulo.add(2,nombreArticulo);
                listaArticulo.add(3,precioArticulo);
                listaArticulo.add(4,descripcionArticulo);
                listaArticulo.add(5,cantidad);
                
                modelo.addRow(listaArticulo.toArray());
                
            }
        } catch (SQLException e) {
             Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE,null, e);
        }   
   }
        
}
