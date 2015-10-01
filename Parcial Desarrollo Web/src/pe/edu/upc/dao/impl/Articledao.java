package pe.edu.upc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.dao.IArticle;
import pe.edu.upc.db.Database;
import pe.edu.upc.entity.Article;
import pe.edu.upc.entity.User;

public class Articledao implements IArticle {

    private Connection con = null;

    @Override
    public String create(Article o) throws SQLException {
        int rpta, idarticulo;
        con = Database.getConnection();
        con.setAutoCommit(false);
        String insert1 = "INSERT INTO article (numviews, score,text,user_iduser,ts_create,ts_update) " + "VALUES(?,?,?,?,?,?)";
        

        PreparedStatement prepare1 = con.prepareStatement(insert1);
        prepare1.setInt(1, o.getNumviews());
        prepare1.setInt(2, o.getScore());
        prepare1.setString(3, o.getText());
        prepare1.setInt(4, o.getUser().getIduser());
        //revisar - 
        Date dt = new Date(o.getCreate_time().getTime());
        prepare1.setDate(5, dt);
        prepare1.setDate(6, dt);
        rpta = prepare1.executeUpdate();

        if (rpta > 0) {
            con.commit();
            con.close();
            return "Registro articulo ok";
        } else {
            con.rollback();
            con.close();
            return "Error articulo area ";
        }
        
    }

    @Override
    public String update(Article o) throws SQLException {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
        String update = "UPDATE article SET score=?,text=?,numviews=?,"
                       +"      ts_update=?,user_iduser=? WHERE idarticle=?";
        PreparedStatement prepare = con.prepareStatement(update);
        prepare.setInt(1, o.getScore());
        prepare.setString(2, o.getText());
        prepare.setInt(3, o.getNumviews());
        java.sql.Date createDate = new java.sql.Date(o.getCreate_time().getTime());
        
        java.sql.Date updateDate = new java.sql.Date(o.getUpdate_time().getTime());
        prepare.setDate(4,updateDate);
        prepare.setInt(5,o.getUser().getIduser());
        prepare.setInt(6, o.getIdarticle());
        rpta = prepare.executeUpdate();
        
        
        if (rpta > 0)
         {  
            con.commit();
            con.close();
            return "articulo actualizada correctamente";
         } 
         else 
         {        
            con.rollback();
            con.close();
            return "Error al actualizar Article";
         }
        
        
    }

    @Override
    public String delete(int id) throws SQLException {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
        String del = "DELETE FROM article WHERE idarticle=?";                
        PreparedStatement prepare = con.prepareStatement(del);        
        prepare.setInt(1, id);
        rpta = prepare.executeUpdate();
        
        if (rpta > 0) 
        { 
            con.commit();
            con.close();
            return "Articulo Eliminado";
        } 
        else 
        {       
            con.rollback();
            con.close();
            return "No se pudo eliminar el articulo";
        }
    }

    @Override
    public Article read(int id) throws SQLException {
                con = Database.getConnection();
                Article article = null ; 
                String select = "SELECT idarticle,score,text,numviews,ts_create,ts_update FROM article WHERE idarticle=?";
                PreparedStatement prepare = con.prepareStatement(select);
                prepare.setInt(1, id);
                ResultSet rs = prepare.executeQuery();
               
                article = new Article();
                article.setIdarticle(rs.getInt("idarticle"));
                article.setScore(rs.getInt("score"));
                article.setText(rs.getString("text"));
                article.setNumviews(rs.getInt("numviews"));
                article.setCreate_time(rs.getDate("ts_create"));
                article.setUpdate_time(rs.getDate("ts_update"));


                con.close();
                return article;
    }

    @Override
    public List<Article> getAll() throws SQLException {
        con = Database.getConnection();
        Article article = null;
        List<Article> lista = new ArrayList<>();
        String select = "SELECT idarticle,score,text,numviews,ts_create,ts_update FROM article ";
        PreparedStatement prepare = con.prepareStatement(select);
        ResultSet rs = prepare.executeQuery();
        
        while (rs.next()) 
        {
            article = new Article();
            article.setIdarticle(rs.getInt("idarticle"));
            article.setScore(rs.getInt("score"));
            article.setText(rs.getString("text"));
            article.setNumviews(rs.getInt("numviews"));
            article.setCreate_time(rs.getDate("ts_create"));
            article.setUpdate_time(rs.getDate("ts_update"));
            lista.add(article);
        }
        
        con.close();
        return lista;
    }

    @Override
    public List<Article> getAllarticlesbyuser(int iduser) throws SQLException {
            con=Database.getConnection();
            Article article = null;
            User user = null;  
            List<Article> lista = new ArrayList<>();
            //esta query esta mal , hay que corregirla
            String select="SELECT c.idarticle, c.title, c.TEXT, c.score, c.iduser FROM article a," + " user u WHERE u.iduser = c.iduser AND u.iduser = ?";                   
            PreparedStatement prepare = con.prepareStatement(select);
            prepare.setInt(1, iduser);
            ResultSet rs = prepare.executeQuery();
             while (rs.next()) 
            {
                article = new Article();
                article.setIdarticle(rs.getInt("idarticle"));
                article.setScore(rs.getInt("score"));
                article.setText(rs.getString("text"));
                article.setNumviews(rs.getInt("numviews"));
                article.setCreate_time(rs.getDate("ts_create"));
                article.setUpdate_time(rs.getDate("ts_update"));
                lista.add(article);
            }
             
             con.close();
             return lista;  
            
            
    }
    
    public List<Article> getAllarticlesbytitle(String titulo) throws SQLException {
            con=Database.getConnection();
            Article article = null;
            User user = null;  
            List<Article> lista = new ArrayList<>();
            //esta query esta mal , hay que corregirla
            String select="SELECT c.idarticle, c.title, c.TEXT, c.score, c.iduser, c.idarticle FROM article a WHERE a.title = ?";                   
            PreparedStatement prepare = con.prepareStatement(select);
            prepare.setString(1, titulo);
            ResultSet rs = prepare.executeQuery();
             while (rs.next()) 
            {
                article = new Article();
                article.setIdarticle(rs.getInt("idarticle"));
                article.setScore(rs.getInt("score"));
                article.setText(rs.getString("text"));
                article.setTitle(rs.getString("title"));
                article.setNumviews(rs.getInt("numviews"));
                article.setCreate_time(rs.getDate("ts_create"));
                article.setUpdate_time(rs.getDate("ts_update"));
                lista.add(article);
            }
             
             con.close();
             return lista;  
            
            
    }
}
