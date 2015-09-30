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
        User user = new User();
        List<User> lista = new ArrayList<>();
        String login, password;
        
        try (PrintWriter out = response.getWriter()) 
        {
           switch(peticion)
           {
               case "login":
                   
                    login = request.getParameter("usuario");
                    password = request.getParameter("contraseÃ±a");
                                     
                    user.setUsername(login);
                    user.setPassword(password);
                    
                    user = umodel.login(user);
                    
                    if(user != null)
                    {  
                       response.sendRedirect("home.jsp");
                    }
                    
                    else
                    {
                        response.sendRedirect("faq.jsp");
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
