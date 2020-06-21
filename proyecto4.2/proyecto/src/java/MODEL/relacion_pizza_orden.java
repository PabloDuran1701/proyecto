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
public class relacion_pizza_orden {
    
    int orden;
    int pizza;
    int cantidad;

    public relacion_pizza_orden(int orden, int pizza, int cantidad) {
        this.orden = orden;
        this.pizza = pizza;
        this.cantidad = cantidad;
    }

    public relacion_pizza_orden() {
    }

    public int getOrden() {
        return orden;
    }

    public int getPizza() {
        return pizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
