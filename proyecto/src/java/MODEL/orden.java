
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Date;
import java.util.List;

// ingresoUsuario.jsp
//
// EIF209 - Programación 4 – Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez 
// 

public class orden {
    int ID;
    Date fecha; 
    String estado;
    Usuario USU;
    List<Pizza> pizza;
    List <Producto> producto;
    List <Ingredientes> ingredientes;

    public orden(int ID, Date fecha, String estado, Usuario USU) {
        this.ID = ID;
        this.fecha = fecha;
        this.estado = estado;
        this.USU = USU;
 
    }

    public orden(int ID, Date fecha, String estado, Usuario USU, List<Pizza> pizza, List<Producto> producto, List<Ingredientes> ingredientes) {
        this.ID = ID;
        this.fecha = fecha;
        this.estado = estado;
        this.USU = USU;
        this.pizza = pizza;
        this.producto = producto;
        this.ingredientes = ingredientes;
    }

    public orden(Date fecha, String estado, Usuario USU, List<Pizza> pizza, List<Producto> producto, List<Ingredientes> ingredientes) {
        this.fecha = fecha;
        this.estado = estado;
        this.USU = USU;
        this.pizza = pizza;
        this.producto = producto;
        this.ingredientes = ingredientes;
    }

    public List<Pizza> getPizza() {
        return pizza;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public int getID() {
        return ID;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Usuario getUSU() {
        return USU;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUSU(Usuario USU) {
        this.USU = USU;
    }

    @Override
    public String toString() {
        return "orden{" + "ID=" + ID + ", fecha=" + fecha + ", estado=" + estado + ", USU=" + USU + ", pizza=" + pizza + ", producto=" + producto + ", ingredientes=" + ingredientes + '}';
    }

 
}