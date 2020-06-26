/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONArray;
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
@XmlRootElement(name = "lista-productos")
public class ListaProducto implements Serializable{

     @XmlElement(name = "producto")
    private final List<Producto> Productos;
    
     public ListaProducto() {
        Productos = new ArrayList<>();
    }
     
         @Override
    public String toString() {
        return toJSON().toString(4);
    }
    
        public JSONObject toJSON() {
        JSONArray a = new JSONArray();
        Productos.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-productos", a);
        return r;
    }

    public ListaProducto(List<Producto> Productos) {
        this.Productos = Productos;
    }
}

