package pe.edu.upc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.dao.ICategory;
import pe.edu.upc.db.Database;
import pe.edu.upc.entity.Category;

public class Categorydao implements ICategory
{
    private Connection con = null;
    
    @Override
    public String create(Category o) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
 
        String insert = "INSERT INTO Category (name) " + "VALUES(?)";
        
        PreparedStatement prepare = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
        prepare.setString(1, o.getName());
        rpta = prepare.executeUpdate();

        if (rpta > 0) 
        {
            con.commit();
            con.close();
            return "Categoria creada";
        } 
        
        else 
        {
            con.rollback();
            con.close();
            return "Error al crear categoria";
        }
    }

    @Override
    public Category read(int id) throws SQLException
    {
        con = Database.getConnection();
        Category category = null;
        String select = "SELECT idcategory,name FROM Category";
        PreparedStatement prepare = con.prepareStatement(select);
        ResultSet rs = prepare.executeQuery();
        
        if (rs.next()) 
        {
            category = new Category();
            category.setIdcategory(rs.getInt("idcategory"));
            category.setName(rs.getString("name")); 
        }
        con.close();
        return category;
    }

    @Override
    public String update(Category o) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
       
        String insert = "UPDATE Category SET name=? WHERE idcategory=?";                
        PreparedStatement prepare = con.prepareStatement(insert);
        prepare.setString(1, o.getName());
        prepare.setInt(3, o.getIdcategory());
        
        rpta = prepare.executeUpdate();
         
         if (rpta > 0)
         {  
            con.commit();
            con.close();
            return "Categoria actualizada correctamente";
         } 
         else 
         {        
            con.rollback();
            con.close();
            return "Error al actualizar categoria";
         }

    }

    @Override
    public String delete(int id) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
        
        String insert = "DELETE FROM Category WHERE idcategory=?";                
        PreparedStatement prepare = con.prepareStatement(insert);        
        prepare.setInt(1, id);
        
        rpta = prepare.executeUpdate();
        
        if (rpta > 0) 
        { 
            con.commit();
            con.close();
            return "Eliminación area ok";
        } 
        
        else 
        {       
            con.rollback();
            con.close();
            return "Error eliminación area ";
        }
    }

    @Override
    public List<Category> getAll() throws SQLException 
    {
        con = Database.getConnection();
        Category category = null;
        List<Category> lista = new ArrayList<>();
        
        String select="SELECT idcategory,name FROM Category";
        PreparedStatement prepare = con.prepareStatement(select);
        
        ResultSet rs = prepare.executeQuery();
        
        while (rs.next()) 
        {
            category = new Category();
            category.setIdcategory(rs.getInt("idcategory"));
            category.setName(rs.getString("name"));
            lista.add(category);
        }
        
        con.close();
        return lista;
    }
    
}
