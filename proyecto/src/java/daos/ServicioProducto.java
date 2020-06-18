package daos;

import MODEL.Producto;
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


public class ServicioProducto {

    public Optional<Producto> obtenerEstudiante(String id) {
        Optional<Producto> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Producto.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Producto(
                            rs.getInt("ID"),
                            rs.getString("nombre"),
                            rs.getInt("precio"),
                            rs.getString("descripcion")
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

    public List<Producto> obtenerListaEstudiantes() {
        List<Producto> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Producto.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Producto e = new Producto(
                        rs.getInt("ID"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getString("descripcion")
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
        ServicioProducto se = new ServicioProducto();
        List<Producto> estudiantes = se.obtenerListaEstudiantes();
        int i = 0;
        for (Producto e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }

}
