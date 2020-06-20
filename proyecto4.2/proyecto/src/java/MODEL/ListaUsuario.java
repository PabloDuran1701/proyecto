/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@XmlRootElement(name = "lista-usuario")
public class ListaUsuario implements Serializable{

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
        r.put("lista-pizzas", a);
        return r;
    }

    public ListaProducto(List<Producto> Productos) {
        this.Productos = Productos;
    }
}