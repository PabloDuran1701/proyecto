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
public class relacion_producto_orden {
    int orden;
    int cantidad;
    int producto;

    public relacion_producto_orden(int orden, int cantidad, int producto) {
        this.orden = orden;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public relacion_producto_orden() {
    }

    public int getOrden() {
        return orden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getProducto() {
        return producto;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "relacion_producto_orden{" + "orden=" + orden + ", cantidad=" + cantidad + ", producto=" + producto + '}';
    }
    
}
