/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import MODEL.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daos.ServicioUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio", "/newUser"})
public class Inicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getServletPath().equals("/Inicio")) {
            System.out.println("login");
            this.InicioSesion(request, response);
        }
        if (request.getServletPath().equals("/newUser")) {
            System.out.println("login");
            this.CrearUsuario(request, response);
        }

    }

    protected void InicioSesion(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String cedula = request.getParameter("Cedula");
        String contra = request.getParameter("Contra");
        ServicioUsuario su = new ServicioUsuario();

        Usuario us = su.obtenerUsuario(cedula).get();
        if (us != null) {
            request.getSession(true).setAttribute("usuarioSesion", us);
            request.getRequestDispatcher("/presentation/CrudMenu.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/presentation/Principal.jsp").forward(request, response);

        }
    }

    protected void CrearUsuario(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            String nombre = request.getParameter("nombreUsuario");
            String apellidos = request.getParameter("apellidoUsuario");
            String id = request.getParameter("idUsuario");
            String direccion = request.getParameter("Direccion");
            String tel = request.getParameter("telUsuario");
            String password = request.getParameter("contrasena1Usuario");
            Usuario newUser = new Usuario(id, "cliente", password, nombre, apellidos, direccion, tel);
            Usuario u = (Usuario) request.getSession().getAttribute("usuarioSesion");
            ServicioUsuario su = new ServicioUsuario();
           

            request.getRequestDispatcher("/presentation/Principal.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/presentation/Principal.jsp").forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
