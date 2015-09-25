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
        String insert1 = "INSERT INTO Article (numviews, score,text,iduser,tscreate,tsupdate) " + "VALUES(?,?,?,?,?,?)";
        

        PreparedStatement prepare1 = con.prepareStatement(insert1, PreparedStatement.RETURN_GENERATED_KEYS);
        prepare1.setInt(1, o.getNumviews());
        prepare1.setInt(2, o.getScore());
        prepare1.setString(3, o.getText());
        prepare1.setInt(4, o.getUser().getIduser());
        //revisar - 
        prepare1.setDate(5, (Date) o.getCreate_time());
        prepare1.setDate(6, (Date) o.getUpdate_time());
        rpta = prepare1.executeUpdate();

        if (rpta > 0) {

           

            con.commit();
            con.close();
            return "Registro area ok";
        } else {
            con.rollback();
            con.close();
            return "Error registro area ";
        }
        
    }

    @Override
    public String update(Article o) throws SQLException {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
        String update = "UPDATE Article SET score=?,text=?,numviews=?,create_time=?"
                       +"      update_time=?,iduser=? WHERE idarticle=?";
        PreparedStatement prepare = con.prepareStatement(update);
        prepare.setInt(1, o.getScore());
        prepare.setString(2, o.getText());
        prepare.setInt(3, o.getNumviews());
        java.sql.Date createDate = new java.sql.Date(o.getCreate_time().getTime());
        prepare.setDate(4,createDate);
        java.sql.Date updateDate = new java.sql.Date(o.getUpdate_time().getTime());
        prepare.setDate(5,updateDate);
        prepare.setInt(6,o.getUser().getIduser());
        rpta = prepare.executeUpdate();
        
        
        if (rpta > 0)
         {  
            con.commit();
            con.close();
            return "Article actualizada correctamente";
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
        String del = "DELETE FROM Article WHERE idarticle=?";                
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
                String select = "SELECT idarticle,score,text,numviews,create_time,update_time FROM Article WHERE idarticle=?";
                PreparedStatement prepare = con.prepareStatement(select);
                prepare.setInt(1, id);
                ResultSet rs = prepare.executeQuery();
               
                article = new Article();
                article.setIdarticle(rs.getInt("idarticle"));
                article.setScore(rs.getInt("score"));
                article.setText(rs.getString("text"));
                article.setNumviews(rs.getInt("numviews"));
                article.setCreate_time(rs.getDate("create_time"));
                article.setUpdate_time(rs.getDate("update_time"));


                con.close();
                return article;
    }

    @Override
    public List<Article> getAll() throws SQLException {
        con = Database.getConnection();
        Article article = null;
        List<Article> lista = new ArrayList<>();
        String select = "SELECT idarticle,score,text,numviews,create_time,update_time FROM Article ";
        PreparedStatement prepare = con.prepareStatement(select);
        ResultSet rs = prepare.executeQuery();
        
        while (rs.next()) 
        {
            article = new Article();
            article.setIdarticle(rs.getInt("idarticle"));
            article.setScore(rs.getInt("score"));
            article.setText(rs.getString("text"));
            article.setNumviews(rs.getInt("numviews"));
            article.setCreate_time(rs.getDate("create_time"));
            article.setUpdate_time(rs.getDate("update_time"));
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
            String select="SELECT c.idarticle, c.TEXT, c.score, c.iduser, c.idarticle FROM Article a," + " User u WHERE u.iduser = c.iduser AND u.iduser = ?";                   
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
                article.setCreate_time(rs.getDate("create_time"));
                article.setUpdate_time(rs.getDate("update_time"));
                lista.add(article);
            }
             
             con.close();
             return lista;  
            
            
    }

    @Override
    public List<Article> getAllarticlesbytitle(int iduser) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
