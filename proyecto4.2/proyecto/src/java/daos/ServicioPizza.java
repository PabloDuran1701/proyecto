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
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServicioPizza {

    public Optional<Pizza> obtenerPizza(String id) {
        Optional<Pizza> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Pizza.CONSULTAR.obtenerComando());) {
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

    public List<Pizza> obtenerListaPizza() {
        List<Pizza> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Pizza.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Pizza e = new Pizza(
                         rs.getInt("ID"),
                         rs.getString("nombre"),
                         rs.getString("tamano"),                                                        
                         rs.getInt("precio")
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
        ServicioPizza se = new ServicioPizza();
        List<Pizza> estudiantes = se.obtenerListaPizza();
        int i = 0;
        for (Pizza e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }
    
     public void ingresarPizzaOsrden(int orden,int pizza,int cantidad){
       
         try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_pizzaOrden.INSERTAR.obtenerComando());) {       
                stm.clearParameters();
                stm.setInt(1, orden);
                stm.setInt(2, pizza);
                stm.setInt(3, cantidad);
                
                 try (ResultSet rs = stm.executeQuery()){}
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioPizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioPizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioPizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioPizza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioPizza.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
       
    }

}
