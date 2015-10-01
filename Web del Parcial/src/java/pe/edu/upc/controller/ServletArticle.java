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
import pe.edu.upc.entity.User;
import pe.edu.upc.model.Articlemodel;
import pe.edu.upc.model.Usermodel;

@WebServlet(name = "ServletArticle", urlPatterns = {"/ServletArticle"})
public class ServletArticle extends HttpServlet 
{

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        String peticion = request.getParameter("peticion");
        Articlemodel amodel = new Articlemodel();
        Article article = new Article();
        List<Article> lista = new ArrayList<>();
        String titulo_articulo;
        String texto_articulo;
        int idusuario;
        int idarticulo;
                
        try (PrintWriter out = response.getWriter()) 
        {
           switch(peticion)
           {
               case "CREATE":
                    idusuario = Integer.parseInt((String) request.getSession().getAttribute("idusuario"));
                    titulo_articulo = request.getParameter("titulo");
                    texto_articulo = request.getParameter("articulo");
                   
                   Usermodel umodel = new Usermodel();
                   User usuario = umodel.Get(idusuario);
                   if(usuario != null) {
                       article.setUser(usuario);
                       article.setTitle(titulo_articulo);
                       article.setText(texto_articulo);
                       
                       amodel.Register(article);
                       response.sendRedirect("articulo.jsp");
                   }
                   else
                       response.sendRedirect("articulo.jsp");
                   
                   
                   break;
               case "READ":
                   idarticulo = Integer.parseInt((String)request.getParameter("idarticulo"));
                   article = amodel.Get(idarticulo);
                   
                   if(article != null) {
                       titulo_articulo = article.getTitle();
                       texto_articulo = article.getText();
                       
                       request.getSession().setAttribute("titulo_articulo", titulo_articulo);
                       request.getSession().setAttribute("texto_articulo", texto_articulo);
                       response.sendRedirect("articulo.jsp");
                   }
                   else
                       response.sendRedirect("articulo.jsp");
                   
                   break;
               case "UPDATE":
                   idarticulo = Integer.parseInt((String)request.getParameter("idarticulo"));
                   article = amodel.Get(idarticulo);
                   
                   if(article != null) {
                       titulo_articulo = request.getParameter("titulo");
                       texto_articulo = request.getParameter("articulo");
                       
                       article.setTitle(titulo_articulo);
                       article.setText(texto_articulo);
                       amodel.Update(article);
                       
                       request.getSession().setAttribute("titulo_articulo", titulo_articulo);
                       request.getSession().setAttribute("texto_articulo", texto_articulo);
                       response.sendRedirect("articulo.jsp");
                   }
                   else
                       response.sendRedirect("home.jsp");
                   break;
               case "DELETE":
                   idarticulo = Integer.parseInt((String)request.getParameter("idarticulo"));
                   article = amodel.Get(idarticulo);
                   
                   if(article != null) {
                       amodel.Delete(article.getIdarticle());
                       response.sendRedirect("home.jsp");
                   }
                   else
                       response.sendRedirect("home.jsp");
                   
                   break;
               case "GETAll":
                   lista = amodel.GetList();
                   if(lista != null) {
                       response.sendRedirect("home.jsp");
                   }
                   else
                    response.sendRedirect("home.jsp");
                   
                   break;
               case "GETAllBYUSER":
                   idusuario = Integer.parseInt((String) request.getSession().getAttribute("idusuario"));
                   lista = amodel.getAllarticlesbyuser(idusuario);
                   if(lista != null) {
                       request.getSession().setAttribute("lista_articulos", lista);
                       response.sendRedirect("ver_articulos.jsp");
                   }
                   else
                       response.sendRedirect("home.jsp");
                   
                   
                   break;
               case "GETAllBYTITLE":
                   titulo_articulo = request.getParameter("titulo_articulo");
                   if(titulo_articulo != null) {
                       lista = amodel.getAllarticlesbytitle(titulo_articulo);
                       
                       if(lista != null) {
                           request.getSession().setAttribute("lista_articulos", lista);
                           response.sendRedirect("ver_articulos.jsp");
                       }
                       else
                        response.sendRedirect("home.jsp");
                   }
                   else
                       response.sendRedirect("home.jsp");
                   
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
