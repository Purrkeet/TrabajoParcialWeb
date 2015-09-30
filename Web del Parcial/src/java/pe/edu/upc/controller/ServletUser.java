package pe.edu.upc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.entity.User;
import pe.edu.upc.model.Usermodel;

@WebServlet(name = "ServletUser", urlPatterns = {"/ServletUser"})
public class ServletUser extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        String peticion = request.getParameter("peticion");
        Usermodel umodel = new Usermodel();
        User e = new User();
        List<User> lista = new ArrayList<>();
        String login, password;
        try (PrintWriter out = response.getWriter()) 
        {
           switch(peticion)
           {
               case "login":
                    login = request.getParameter("login");
                    password = request.getParameter("password");
                    
                    //TODO: Completar el codigo                    
                    e.setUsername(login);
                    e.setPassword(password);
                    
                    e=umodel.login(e);
                    if(e!=null){
                        //if(e.getRol().equals("vendedor")){
                            request.getSession().setAttribute("idusuario", e.getIduser());
                            response.sendRedirect("home.jsp");
                        //}else{
                          //   response.sendRedirect("admin/index.jsp");
                        //}
                    }else{
                        response.sendRedirect("ingresar.jsp");
                    }                    
                    
                    
                    break;
                   
               case "CREATE":
                   
                   break;
               case "READ":
                   break;
               case "UPDATE":
                   break;
               case "DELETE":
                   break;
               case "GETAll":
                   break;
           }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        try 
        {
            processRequest(request, response);
        } 
        
        catch (SQLException ex) 
        {
            Logger.getLogger(ServletUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try 
        {
            processRequest(request, response);
        } 
        
        catch (SQLException ex)
        {
            Logger.getLogger(ServletUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
