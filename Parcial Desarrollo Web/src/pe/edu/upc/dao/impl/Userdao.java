package pe.edu.upc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.dao.IUser;
import pe.edu.upc.db.Database;
import pe.edu.upc.entity.User;

public class Userdao implements IUser
{
    private Connection con = null;
    
    @Override
    public String create(User o) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
 
        String insert = "INSERT INTO User (username,mail,password,create_time,name,lastname,score,steamid,facebookid,profileinfo) VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement prepare = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
        
        prepare.setString(1, o.getUsername());
        prepare.setString(2, o.getEmail());
        prepare.setString(3, o.getPassword());
        java.sql.Date createDate = new java.sql.Date(o.getCreate_time().getTime());
        prepare.setDate(4,createDate);
        prepare.setString(5, o.getName());
        prepare.setString(6, o.getLastname());
        prepare.setInt(7, o.getScore());
        prepare.setString(8, o.getSteamid());
        prepare.setString(9, o.getFacebookid());
        prepare.setString(10, o.getProfileinfo());
        
        rpta = prepare.executeUpdate();

        if (rpta > 0) 
        {
            con.commit();
            con.close();
            return "Usuario creado";
        } 
        
        else 
        {
            con.rollback();
            con.close();
            return "Error al crear Usuario";
        }
    }

    @Override
    public User read(int id) throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(User o) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
       
        String insert = "UPDATE Comment SET username=?,email=?,password=?,create_time=?,name=?,lastname=?,score=?,steamid=?,facebookid=?,profileinfo=? WHERE idcomment=?";                
        PreparedStatement prepare = con.prepareStatement(insert);
        prepare.setString(1, o.getUsername());
        prepare.setString(2, o.getEmail());
        prepare.setString(3, o.getPassword());
        java.sql.Date createDate = new java.sql.Date(o.getCreate_time().getTime());
        prepare.setDate(4,createDate);
        prepare.setString(5, o.getName());
        prepare.setString(6, o.getLastname());
        prepare.setInt(7, o.getScore());
        prepare.setString(8, o.getSteamid());
        prepare.setString(9, o.getFacebookid());
        prepare.setString(10, o.getProfileinfo());
        prepare.setInt(11, o.getIduser());
        
        rpta = prepare.executeUpdate();
         
         if (rpta > 0)
         {  
            con.commit();
            con.close();
            return "Usuario actualizado correctamente";
         } 
         else 
         {        
            con.rollback();
            con.close();
            return "Error al actualizar usuario";
         }
    }

    @Override
    public String delete(int id) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
        
        String insert = "DELETE FROM User WHERE iduser=?";                
        PreparedStatement prepare = con.prepareStatement(insert);        
        prepare.setInt(1, id);
        
        rpta = prepare.executeUpdate();
        
        if (rpta > 0) 
        { 
            con.commit();
            con.close();
            return "Usuario eliminado";
        } 
        
        else 
        {       
            con.rollback();
            con.close();
            return "No se pudo eliminar el usuario";
        }
    }

    @Override
    public List<User> getAll() throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
