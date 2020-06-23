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
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioProducto {

    public Optional<Producto> obtenerProducto(String id) {
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

    public List<Producto> obtenerListaProducto() {
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
        List<Producto> estudiantes = se.obtenerListaProducto();
        int i = 0;
        for (Producto e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }
    
    
     public void ingresarProducto(Producto pro){
        
         
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Producto.INSERTAR.obtenerComando());) {       
                stm.clearParameters();
                stm.setInt(1, pro.getID());
                stm.setString(2, pro.getNombre());
                stm.setInt(3, pro.getPrecio());
                stm.setString(4, pro.getDescripcion());
                
                stm.executeUpdate();
                 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioProducto.class.getName()).log(Level.SEVERE, null, ex);
        }   

    }

}
