/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author diego
 */
public class Pizza {
    int ID;
    String Nombre;
    String tamano;
    int Precio;

    public Pizza(int ID, String Nombre, String tamano, int Precio) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.tamano = tamano;
        this.Precio = Precio;
    }

    public Pizza(String Nombre, String tamano, int Precio) {
        this.Nombre = Nombre;
        this.tamano = tamano;
        this.Precio = Precio;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        return "Pizza{" + "ID=" + ID + ", Nombre=" + Nombre + ", tamano=" + tamano + ", Precio=" + Precio + '}';
    }
    
    
    
}
