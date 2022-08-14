/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import Gestion.GestionAdministrador;

/**
 *
 * @author Christian Castro y David Alfaro
 */
public class Administrador 
{
private String nombre;
private String password;
public GestionAdministrador gestionAdministrador= new GestionAdministrador();
    public Administrador(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public Administrador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void  login()
    {
     
        gestionAdministrador.validacionestudiante(nombre, password);
    }

}
