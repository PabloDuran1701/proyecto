package daos;

import MODEL.Ingredientes;
import MODEL.Pizza;
import MODEL.Producto;
import MODEL.Usuario;
import MODEL.orden;
import ejemplo.datos.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ServicioOrden {

    public Optional<orden> obtenerOrden(String id) {
        Optional<orden> r = Optional.empty();
        ServicioUsuario US = new ServicioUsuario();
        List<Pizza> pizza = new ArrayList();
        List <Producto> producto = new ArrayList();;
        List <Ingredientes> ingredientes = new ArrayList();;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Orden.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            
            try (ResultSet rs = stm.executeQuery()) {
                Optional<Usuario> us = US.obtenerEstudiante(rs.getString("usuario"));    
                if (rs.next()) {
                    r = Optional.of(new orden(
                            rs.getInt("id"),
                            rs.getDate("fecha"),
                            rs.getString("estado"),
                            us.get()
                    )
                    );
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

    public List<orden> obtenerListaOrden() {
        List<orden> r = new ArrayList<>();
        ServicioUsuario US = new ServicioUsuario();
        ServicioPizzaOrden SPO = new ServicioPizzaOrden();
        ServicioAdicionales SA = new ServicioAdicionales(); 
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Orden.LISTAR.obtenerComando())) {
            while (rs.next()) {
                 Optional<Usuario> us = US.obtenerEstudiante(rs.getString("usuario"));  
                orden e = new orden(
                         rs.getInt("id"),
                            rs.getDate("fecha"),
                            rs.getString("estado"),
                            us.get(),
                        SPO.obtenerListaPizza(rs.getInt("id")),
                        null,
                        null
                );
                r.add(e);
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

    public static void main(String[] args) {
        ServicioOrden se = new ServicioOrden();
        List<orden> estudiantes = se.obtenerListaOrden();
        int i = 0;
        for (orden e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }
    
     


}
