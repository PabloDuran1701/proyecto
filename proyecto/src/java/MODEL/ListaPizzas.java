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
 * @author Lenovo
 */

@XmlRootElement(name = "lista-pizzas")
public class ListaPizzas implements Serializable {

    public ListaPizzas() {
        Pizzas = new ArrayList<>();
    }

    public ListaPizzas(List<Pizza> Pizzas) {
        this.Pizzas = new ArrayList<>(Pizzas);
    }

    @Override
    public String toString() {
        return toJSON().toString(4);
    }

    public JSONObject toJSON() {
        JSONArray a = new JSONArray();
        Pizzas.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-pizzas", a);
        return r;
    }

    @XmlElement(name = "pizza")
    private final List<Pizza> Pizzas;
}

   
