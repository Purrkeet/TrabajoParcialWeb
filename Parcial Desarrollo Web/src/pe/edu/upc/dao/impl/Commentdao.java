package pe.edu.upc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.dao.IComment;
import pe.edu.upc.db.Database;
import pe.edu.upc.entity.Article;
import pe.edu.upc.entity.Comment;
import pe.edu.upc.entity.User;

public class Commentdao implements IComment
{

    private Connection con = null;
     
    @Override
    public String create(Comment o) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
 
        String insert = "INSERT INTO comment (TEXT,score,user_iduser,article_idarticle) VALUES(?,?,?,?)";
        
        PreparedStatement prepare = con.prepareStatement(insert);
        prepare.setString(1, o.getTEXT());
        prepare.setInt(2, o.getScore());
        prepare.setInt(3, o.getUser().getIduser());
        prepare.setInt(4, o.getArticle().getIdarticle());
        rpta = prepare.executeUpdate();

        if (rpta > 0) 
        {
            con.commit();
            con.close();
            return "Comentario creado";
        } 
        
        else 
        {
            con.rollback();
            con.close();
            return "Error al crear comentario";
        }
    }

    @Override
    public Comment read(int id) throws SQLException 
    {
        //En ninguna situacion se buscara un solo comentario.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Comment o) throws SQLException 
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
       
        String insert = "UPDATE comment SET TEXT=?,score=?,user_iduser=?,article_idarticle=? WHERE idcomment=?";                
        PreparedStatement prepare = con.prepareStatement(insert);
        prepare.setString(1, o.getTEXT());
        prepare.setInt(2, o.getScore());
        prepare.setInt(3, o.getUser().getIduser());
        prepare.setInt(4, o.getArticle().getIdarticle());
        prepare.setInt(5, o.getIdcomment());
        
        rpta = prepare.executeUpdate();
         
         if (rpta > 0)
         {  
            con.commit();
            con.close();
            return "Comentario actualizado correctamente";
         } 
         else 
         {        
            con.rollback();
            con.close();
            return "Error al actualizar comentario";
         }
    }

    @Override
    public String delete(int id) throws SQLException
    {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
        
        String insert = "DELETE FROM comment WHERE idcomment=?";                
        PreparedStatement prepare = con.prepareStatement(insert);        
        prepare.setInt(1, id);
        
        rpta = prepare.executeUpdate();
        
        if (rpta > 0) 
        { 
            con.commit();
            con.close();
            return "Comentario Eliminado";
        } 
        
        else 
        {       
            con.rollback();
            con.close();
            return "No se pudo eliminar el comentario";
        }
    }

    @Override
    public List<Comment> getAll() throws SQLException 
    {
        //En ninguna situacion se buscara todos los comentarios que existen.
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> getAllcommentsbyarticle(int idarticle) throws SQLException 
    {
        con=Database.getConnection();
        Comment comment = null;
        User user = null;  
        Article article = null;
        List<Comment> lista = new ArrayList<>();
        
        String select="SELECT c.idcomment, c.TEXT, c.score, c.user_iduser, c.article_idarticle FROM comment c, user u, article a WHERE c.article_idarticle = a.idarticle AND a.idarticle=?";                   
        PreparedStatement prepare = con.prepareStatement(select);
        prepare.setInt(1, idarticle);
        ResultSet rs = prepare.executeQuery();
        
        while (rs.next()) 
        {
            comment = new Comment();
            user = new User();
            article = new Article();
            
            comment.setIdcomment(rs.getInt("idcomment"));
            comment.setTEXT(rs.getString("TEXT"));
            comment.setScore(rs.getInt("score"));
            user.setIduser(rs.getInt("user_iduser"));
            comment.setUser(user);   
            article.setIdarticle(rs.getInt("article_idarticle"));
            comment.setArticle(article);
            lista.add(comment);
        }
        
        con.close();
        return lista;
    }

    @Override
    public List<Comment> getAllcommentsbyuser(int iduser) throws SQLException 
    {
        con=Database.getConnection();
        Comment comment = null;
        User user = null;  
        Article article = null;
        List<Comment> lista = new ArrayList<>();
        
        String select="SELECT c.idcomment, c.TEXT, c.score, c.user_iduser, c.article_idarticle FROM comment c, user u WHERE u.iduser = c.iduser AND u.iduser = ?";                   
        PreparedStatement prepare = con.prepareStatement(select);
        prepare.setInt(1, iduser);
        ResultSet rs = prepare.executeQuery();
        
        while (rs.next()) 
        {
            comment = new Comment();
            user = new User();
            article = new Article();
            
            comment.setIdcomment(rs.getInt("idcomment"));
            comment.setTEXT(rs.getString("TEXT"));
            comment.setScore(rs.getInt("score"));
            user.setIduser(rs.getInt("user_iduser"));
            comment.setUser(user);   
            article.setIdarticle(rs.getInt("article_idarticle"));
            comment.setArticle(article);
            lista.add(comment);
        }
        
        con.close();
        return lista;
    }
    
}
