/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import daos.ServicioUsuario;
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
public class Usuario {

    String ID;
    String tipo;
    String Password;
    String nombre;
    String apellido;
    String direccion;
    String telefono;

    public Usuario(String ID, String tipo, String Password, String nombre, String apellido, String direccion, String telefono) {
        this.ID = ID;
        this.tipo = tipo;
        this.Password = Password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Usuario() {
    }

    public String getID() {
        return ID;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPassword() {
        return Password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", tipo=" + tipo + ", Password=" + Password + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("id", getID());
        r.put("tipo", getNombre());
        r.put("password", getPassword());
        r.put("nombre", getNombre());
        r.put("apellido", getApellido());
        r.put("direccion", getDireccion());
        r.put("telefono", this.getTelefono());

        return r;
    }

}

