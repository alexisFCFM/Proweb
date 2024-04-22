/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.pw1.servlets;

import com.mycompany.pw1.models.Usuarios;
import com.mycompany.pw1.persistencia.UsuariosJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Persistence;

/**
 *
 * @author sadam
 */
@WebServlet(name = "registroServlet", urlPatterns = {"/registroServlet"})
@MultipartConfig
public class registroServlet extends HttpServlet {

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
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String nombreUsuario = request.getParameter("fusuario");
        String pass = request.getParameter("fcontra");
    
        Part filePart = request.getPart("imgRuta"); // Retrieves <input type="file" name="file">
        String fileName = filePart.getSubmittedFileName();
        String urlImg = nombreUsuario+"_"+fileName;
           
        filePart.write("C:\\Users\\sadam\\OneDrive\\Documentos\\NetBeansProjects\\PW1\\src\\main\\webapp\\imagenes\\usuarios\\"+urlImg);
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String text_fechaNacimiento = request.getParameter("fechaNacimiento");
        Date fecha_Nacimiento = null;
        
        try {
        fecha_Nacimiento = dateFormat.parse(text_fechaNacimiento);
        }catch(Exception e) {
          System.out.println("Error occurred"+ e.getMessage());
        }
        
        Date fechaCreacion = new Date();
        Date fechaMovimiento = new Date();
       
       UsuariosJpaController usuarioController =  new UsuariosJpaController(Persistence.createEntityManagerFactory("bdpw1"));
      
       Usuarios usuario = new Usuarios();
 
       
       usuario.setNombreUsuario(nombreUsuario);
       usuario.setPassword(pass);
       usuario.setUrlImgPerfil(urlImg);
       usuario.setFechaNacimiento(fecha_Nacimiento);
       usuario.setFechaCreacion(fechaCreacion);
       usuario.setFechaMovimiento(fechaMovimiento);
       usuario.setBitStatus(true);
       
       usuarioController.create(usuario);
       
         
    }
private String getFileName(Part file){
String contentDisposition = file.getHeader("content-disposition");

if(!contentDisposition.contains("filename=")){

return null;

}

int beginIndex = contentDisposition.indexOf("filename=")+10;
int endIndex = contentDisposition.length()-1;

    return contentDisposition.substring(beginIndex, endIndex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
