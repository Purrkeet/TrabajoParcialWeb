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
        String login, password = null, password2 = null, username = null, email = null, name = null, lastname = null;
         String steamid = null, facebookid = null, Descripcion = null;
         
        try (PrintWriter out = response.getWriter()) 
        {
           switch(peticion)
           {
               case "login":
                   
                    login = request.getParameter("usuario");
                    password = request.getParameter("contrasena");
                                     
                    user.setUsername(login);
                    user.setPassword(password);
                    
                    user = umodel.login(user);
                    
                    if(user != null)
                    {  
                       user = umodel.Get(user.getIduser());
                       request.getSession().setAttribute("usuario",user);
                       response.sendRedirect("home.jsp");
                    }
                    
                    else
                    {
                        response.sendRedirect("faq.jsp");
                    }  
                    break;
                   
               case "CREATE":
                   
                    email = request.getParameter("email");
                    name = request.getParameter("nombre");
                    lastname = request.getParameter("apellido");
                    login = request.getParameter("usuario");
                    password = request.getParameter("contrasena");
                    password2 = request.getParameter("contrasena2");
                    
                    /*request.getSession().setAttribute("email",email);
                    request.getSession().setAttribute("nombre",name);
                    request.getSession().setAttribute("apellido",lastname);
                    request.getSession().setAttribute("usuario",username);
                    request.getSession().setAttribute("contrasena",password);
                    request.getSession().setAttribute("contrasena2",password2);*/
                    
                    user.setEmail(email);
                    user.setName(name);
                    user.setLastname(lastname);
                    user.setUsername(login);
                    user.setPassword(password);
                    
                    umodel.Register(user);
                    response.sendRedirect("home.jsp");
                   
                   break;
                   
               case "READ":
                   break;
               case "UPDATE":
                   
                   user = (User)request.getSession(false).getAttribute("usuario");
                   
                   email = request.getParameter("mail");
                   steamid = request.getParameter("steamid");
                   facebookid = request.getParameter("facebookid");
                   Descripcion = request.getParameter("descripcion");
                   password = request.getParameter("password");
   
                    user.setEmail(email);
                    user.setSteamid(steamid);
                    user.setFacebookid(facebookid);
                    user.setProfileinfo(Descripcion);
                    user.setPassword(password);
                    
                    umodel.Update(user);
                    response.sendRedirect("home.jsp");
                    
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
