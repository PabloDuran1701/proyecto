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
public class relacion_pizza_ingredientes {
    
    int pizza;
    int ingredinetes;

    public relacion_pizza_ingredientes(int pizza, int ingredinetes) {
        this.pizza = pizza;
        this.ingredinetes = ingredinetes;
    }

    public relacion_pizza_ingredientes() {
    }

    public int getPizza() {
        return pizza;
    }

    public int getIngredinetes() {
        return ingredinetes;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public void setIngredinetes(int ingredinetes) {
        this.ingredinetes = ingredinetes;
    }

    @Override
    public String toString() {
        return "relacion_pizza_ingredientes{" + "pizza=" + pizza + ", ingredinetes=" + ingredinetes + '}';
    }
    
}
