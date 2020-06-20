package MODEL;

import daos.ServicioPizza;
import java.util.List;
import org.json.JSONObject;

// ingresoUsuario.jsp
//
// EIF209 - Programación 4 – Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez 
// 
public class Pizza {

    public Pizza() {
    }

    int ID;
    String Nombre;
    String tamano;
    int Precio;
    List<Ingredientes> Adicionales;
    List<Ingredientes> Ingredientes;

    public Pizza(int ID, String Nombre, String tamano, int Precio) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.tamano = tamano;
        this.Precio = Precio;
    }

    public Pizza(String Nombre, String tamano, int Precio, List<Ingredientes> adicionales, List<Ingredientes> ingredientes) {
        this.Nombre = Nombre;
        this.tamano = tamano;
        this.Precio = Precio;
        this.Adicionales = adicionales;
        this.Ingredientes = ingredientes;
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
        return toJSON().toString(4);
    }
     
    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getID());
        r.put("nombre", getNombre());
        r.put("tamano", getTamano());
        r.put("precio", getPrecio());
        return r;
    }
    
        public String listaPizzasJSON() {
        ServicioPizza g = new ServicioPizza();
        ListaPizzas pizzas = new ListaPizzas(g.obtenerListaPizza());
        return pizzas.toString();
    }


}

