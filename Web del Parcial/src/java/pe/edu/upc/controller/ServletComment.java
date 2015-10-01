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
import pe.edu.upc.entity.Article;
import pe.edu.upc.entity.Comment;
import pe.edu.upc.entity.User;
import pe.edu.upc.model.Articlemodel;
import pe.edu.upc.model.Commentmodel;
import pe.edu.upc.model.Usermodel;

@WebServlet(name = "ServletComment", urlPatterns = {"/ServletComment"})
public class ServletComment extends HttpServlet 
{


   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        String peticion = request.getParameter("peticion");
        Commentmodel cmodel = new Commentmodel();
        Usermodel cuser= new Usermodel();
        Articlemodel cart=new Articlemodel();
        Comment comment = new Comment();
        Article art= null;
        User usr =null ; 

        int idarticulo;
        String comentario;
        List<Comment> lista = new ArrayList<>();
        
        try (PrintWriter out = response.getWriter()) 
        {
            switch(peticion)
           {
               case "CREATE":
                   comentario = request.getParameter("comentario");
                   comment.setScore(0);
                   comment.setTEXT(comentario);
                   //idarticulo=Integer.parseInt(request.getParameter("idarticulo"));
                   idarticulo=2;
                   art=cart.Get(idarticulo);
                   //usr=(User) request.getSession().getAttribute("usuario");
                   usr= cuser.Get(1);
                   comment.setArticle(art);
                   comment.setUser(usr);
                   System.out.println(cmodel.Register(comment));
                   response.sendRedirect("articulo.jsp");
                           break;
               case "UPDATE":
                   break;
               case "DELETE":
                   
                   break;
               case "GETAllBYARTICLE":
                   break;
               case "GETAllBYUSER":
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
            Logger.getLogger(ServletArticle.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
