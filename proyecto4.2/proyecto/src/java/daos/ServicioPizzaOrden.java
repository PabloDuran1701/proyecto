package daos;

import MODEL.Pizza;
import ejemplo.datos.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ServicioPizzaOrden {
/*
    public Optional<Pizza> obtenerEstudiante(String id) {
        Optional<Pizza> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Estudiante.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Pizza(
                        rs.getInt("ID"),
                        rs.getString("nombre"),
                        rs.getString("tamano"),
                        rs.getInt("precio")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }
*/
    public List<Pizza> obtenerListaPizza(int orden) {
        List<Pizza> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                 PreparedStatement stm = cnx.prepareStatement(IMEC_pizzaOrden.LISTAR.obtenerComando())) {
                stm.clearParameters();
                stm.setInt(1, orden);
                try (ResultSet rs = stm.executeQuery()) {   
            while (rs.next()) {
                Pizza e = new Pizza(
                        rs.getInt("ID"),
                        rs.getString("nombre"),
                        rs.getString("tamano"),
                        rs.getInt("precio")
                );
                r.add(e);
            }
        } 
        }catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Connection cnx = bd.obtenerConexion();
        return cnx;
    }
/*
    public static void main(String[] args) {
        ServicioPizzaOrden se = new ServicioPizzaOrden();
        List<Pizza> estudiantes = se.obtenerListaPizza();
        int i = 0;
        for (Pizza e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }
*/
}
