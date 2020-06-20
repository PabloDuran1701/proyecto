package daos;

import MODEL.Ingredientes;
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


public class ServicioAdicionales {
/*
    public Optional<Ingredientes> obtenerEstudiante(String id) {
        Optional<Ingredientes> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Adicionales.CONSULTAR.obtenerComando());) {
                stm.clearParameters();
                stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Estudiante(
                            rs.getString("id"),
                            rs.getString("apellidos"),
                            rs.getString("nombre")
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
    public List<Ingredientes> obtenerListaAdicioanles(int pi) {
        List<Ingredientes> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Adicionales.LISTAR.obtenerComando())) {
                stm.clearParameters();
                stm.setInt(1, pi);
            try (ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Ingredientes e = new Ingredientes(
                        rs.getInt("ID"),
                        rs.getString("nombre"),
                        rs.getInt("precio")
                );
                r.add(e);
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
        ServicioEstudiante se = new ServicioEstudiante();
        List<Estudiante> estudiantes = se.obtenerListaEstudiantes();
        int i = 0;
        for (Estudiante e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }
*/
}
