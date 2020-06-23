package daos;

import MODEL.Adicionales;
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


public class ServicioAdicionales {

    public Optional<Adicionales> obtenerAdicionales(int ingre, int pizza, int orden) {
        Optional<Adicionales> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Adicionales.CONSULTAR.obtenerComando());) {
                stm.clearParameters();
                stm.setInt(1, ingre);
                stm.setInt(2, pizza);
                stm.setInt(3, orden);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Adicionales(
                            rs.getInt("ingredientes"),
                            rs.getInt("pizza"),
                            rs.getInt("orden")
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

    public List<Adicionales> obtenerListaAdicioanles(int pi) {
        List<Adicionales> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Adicionales.LISTAR.obtenerComando())) {
                stm.clearParameters();
                stm.setInt(1, pi);
            try (ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Adicionales e = new Adicionales(
                      rs.getInt("ingredientes"),
                            rs.getInt("pizza"),
                            rs.getInt("orden")
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
    
     public void ingresarAdicionales(Adicionales adi){
        
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Adicionales.INSERTAR.obtenerComando());) {       
                stm.clearParameters();
                stm.setInt(1, adi.getIngredientes());
                stm.setInt(2, adi.getPizza());
                stm.setInt(3, adi.getOrden());
                
                stm.executeUpdate();
                 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioAdicionales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioAdicionales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioAdicionales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioAdicionales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioAdicionales.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
      
    }
    
    
}
