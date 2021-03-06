package daos;

import MODEL.Usuario;
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
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioUsuario {

    public Optional<Usuario> obtenerUsuario(String id) {
        Optional<Usuario> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Usuario(
                            rs.getString("id"),
                            rs.getString("tipo"),
                            rs.getString("password"),
                            rs.getString("nombre"),
                            rs.getString("apellido1"),
                            rs.getString("direccion"),
                            rs.getString("telefono")
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

    public List<Usuario> obtenerListaUsuario() {
        List<Usuario> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Usuario.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Usuario e = new Usuario(
                        rs.getString("id"),
                        rs.getString("tipo"),
                        rs.getString("password"),
                        rs.getString("nmombre"),
                        rs.getString("apellido1"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
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
    
    public void ingresarUsuario(String id, String  tipo, String  password, String  nombre, String  apellido1, String  direccion, String  telefono){
        
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());) {       
                stm.clearParameters();
                stm.setString(1, id);
                stm.setString(2, tipo);
                stm.setString(3, password);
                stm.setString(4, nombre);
                stm.setString(5, apellido1);
                stm.setString(6, direccion);
                stm.setString(7, telefono);
                
                stm.executeUpdate();
                 
        }   
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        ServicioUsuario se = new ServicioUsuario();
        List<Usuario> estudiantes = se.obtenerListaUsuario();
        int i = 0;
        for (Usuario e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }

}
