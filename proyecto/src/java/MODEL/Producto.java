/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;


// ingresoUsuario.jsp
//
// EIF209 - Programación 4 – Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez 
// 

public class Producto {
 int ID;
 String Nombre;
 int precio;
  String descripcion;
 

 

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

   

    public int getPrecio() {
        return precio;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

   

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Producto(int ID, String Nombre, int precio, String descripcion) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Producto(String Nombre, int precio, String descripcion) {
        this.Nombre = Nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

   
 
 
}
