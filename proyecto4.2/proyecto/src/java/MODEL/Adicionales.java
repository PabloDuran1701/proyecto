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
public class Adicionales {
    
    int ingredientes;
    int pizza;
    int orden;

    public Adicionales(int ingredientes, int pizza, int orden) {
        this.ingredientes = ingredientes;
        this.pizza = pizza;
        this.orden = orden;
    }

    public Adicionales() {
    }

    public int getIngredientes() {
        return ingredientes;
    }

    public int getPizza() {
        return pizza;
    }

    public int getOrden() {
        return orden;
    }

    public void setIngredientes(int ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setPizza(int pizza) {
        this.pizza = pizza;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "Adicionales{" + "ingredientes=" + ingredientes + ", pizza=" + pizza + ", orden=" + orden + '}';
    }
    
    
    
}
