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
 
        String insert = "INSERT INTO Comment (text,score,iduser,idarticle,idcomment) VALUES(?,?,?,?,?)";
        
        PreparedStatement prepare = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
        prepare.setString(1, o.getTEXT());
        prepare.setInt(2, o.getScore());
        prepare.setInt(3, o.getUser().getIduser());
        prepare.setInt(4, o.getArticle().getIdarticle());
        if(o.getPadre() == null) prepare.setInt(5,0);
        else prepare.setInt(5, o.getPadre().getIdcomment());
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
    public Comment read(int id) throws SQLException 
    {
        con=Database.getConnection();
        User user = null;
        Article article = null;
        Comment comment = null;
        Comment padre = null;
        
        String select="SELECT c.idcomment, c.TEXT, c.score, u.iduser"
                    + "FROM Article a, Comment c, User u "
                    + "WHERE a.idarticle=c.idarticle "
                    + "AND c.idcomment=?";
       
        PreparedStatement prepare = con.prepareStatement(select);
        prepare.setInt(1, id);
        
        ResultSet rs = prepare.executeQuery();
        
        if (rs.next())
        {
            comment = new Comment();
            user = new User();
            article = new Article();
            padre = new Comment();
            
            comment.setIdcomment(rs.getInt("idcomment"));
            comment.setTEXT(rs.getString("TEXT"));
            comment.setScore("score");
            comment.
            c.setIdcurso(rs.getInt("idcurso"));
            c.setNombre(rs.getString("curso"));
            c.setDescripcion(rs.getString("desccurso"));
            c.setDuracion(rs.getInt("duracion"));
            a.setNombre(rs.getString("nombrearea"));
            c.setArea(a);                   
        }
        
        con.close();
        return comment;
    }

    @Override
    public String update(Comment o) throws SQLException 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(int id) throws SQLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> getAll() throws SQLException 
    {
        //SELECT idcomment, TEXT, c.score, article_idarticle, user_iduser, u.username 	FROM `comment` c, user u 	WHERE u.iduser=c.user_iduser and c.article_idarticle = ?
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
