package daos;

import MODEL.Comentario;
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

public class ServicioComentario {

    public List<Comentario> obtenerListaEstudiantes() {
        List<Comentario> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Comentarios.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Comentario e = new Comentario(
                        rs.getString("id")
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
        ServicioComentario se = new ServicioComentario();
        List<Comentario> estudiantes = se.obtenerListaEstudiantes();
        int i = 0;
        for (Comentario e : estudiantes) {
            System.out.printf("%4d: %s,%n", ++i, e);
        }
    }
    
        public void ingresarComentario(Comentario com){
        
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Comentarios.INSERTAR.obtenerComando());) {       
                stm.clearParameters();
                stm.setString(1, com.getComentario());
                stm.executeUpdate();
                 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicioComentario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ServicioComentario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ServicioComentario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServicioComentario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioComentario.class.getName()).log(Level.SEVERE, null, ex);
        }   
      
    }

}
