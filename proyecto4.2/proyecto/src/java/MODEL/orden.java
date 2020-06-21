
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Date;
import java.util.List;

// ingresoUsuario.jsp
//
// EIF209 - Programación 4 – Proyecto #2
// Junio 2020
//
// Autores:
// - 304990923 Jose Pablo Duran
// - 116350565 Diego Pinto Gomez 
// 

public class orden {
    int ID;
    Date fecha; 
    String estado;
    int usuario;

  
    public orden(int ID, Date fecha, String estado, int USU) {
        this.ID = ID;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = USU;
 
    }
    public orden(Date fecha, String estado, int USU) {
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = USU;
    }

   
    
    public int getID() {
        return ID;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public int getUSU() {
        return usuario;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUSU(int USU) {
        this.usuario = USU;
    }

    @Override
    public String toString() {
        return "orden{" + "ID=" + ID + ", fecha=" + fecha + ", estado=" + estado + ", usuario=" + usuario + '}';
    }
}