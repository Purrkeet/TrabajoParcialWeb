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
import pe.edu.upc.entity.Category;
import pe.edu.upc.model.Categorymodel;

@WebServlet(name = "ServletCategory", urlPatterns = {"/ServletCategory"})
public class ServletCategory extends HttpServlet 
{

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String peticion = request.getParameter("peticion");
        Categorymodel categorymodel = new Categorymodel();
        Category category = new Category();
        List<Category> lista = new ArrayList<>();

        String nombre, descripcion;
        int idcategory;
        
        try (PrintWriter out = response.getWriter()) 
        {
            case "LIST":
            
                Lis(request, response,lista, amodel);                  
                break;

            case "INS":
                   //TODO

                    Listarreas(request, response,lista, amodel);  
                    break;

            case "EDIT":
                    //TODO
                    
                    response.sendRedirect("admin/updarea.jsp");
                    break;

            case "UPD":
                    //TODO

                    amodel.Actualizararea(a);

                    Listarreas(request, response,lista, amodel);  
                    break;

            case "DEL":
                    //TODO
                    
                    Listarreas(request, response,lista, amodel);  
                    break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try 
        {
            processRequest(request, response);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServletCategory.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
