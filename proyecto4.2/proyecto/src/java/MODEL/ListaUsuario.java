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

/**
 *
 * @author diego
 */
@XmlRootElement(name = "lista-usuario")
public class ListaUsuario implements Serializable{

     @XmlElement(name = "usuario")
    private final List<Usuario> Usuarios;
    
     public ListaUsuario() {
        Usuarios = new ArrayList<>();
    }
     
         @Override
    public String toString() {
        return toJSON().toString(4);
    }
    
        public JSONObject toJSON() {
        JSONArray a = new JSONArray();
        Usuarios.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-pizzas", a);
        return r;
    }

    public ListaUsuario(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }
}