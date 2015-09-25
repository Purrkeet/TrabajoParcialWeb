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
        /*String insert = "UPDATE Area SET nombre=?,descripcion=? "
         + "WHERE idarea=?";                
         PreparedStatement prepare = con.prepareStatement(insert);
         prepare.setString(1, o.getNombre());
         prepare.setString(2, o.getDescripcion());
         prepare.setInt(3, o.getIdarea());
         rpta = prepare.executeUpdate();
         if (rpta > 0) {  
         con.commit();
         con.close();
         return "Actualización area ok";
         } else {        
         con.rollback();
         con.close();
         return "Error actualización area ";
         }*/

        return "Not Implemented";
    }

    @Override
    public String delete(int id) throws SQLException {
        int rpta;
        con = Database.getConnection();
        con.setAutoCommit(false);
        /*String insert = "DELETE FROM Area WHERE idarea=?";                
         PreparedStatement prepare = con.prepareStatement(insert);        
         prepare.setInt(1, id);
         rpta = prepare.executeUpdate();
         if (rpta > 0) { 
         con.commit();
         con.close();
         return "Eliminación area ok";
         } else {  
         con.rollback();
         con.close();
         return "Error eliminación area ";
         }*/

        return "Not Implemented";
    }

    @Override
    public Article read(int id) throws SQLException {
        con = Database.getConnection();
        Article a = null;
        String select = "SELECT idarea,nombre,descripcion FROM Area WHERE idarea=?";
        PreparedStatement prepare = con.prepareStatement(select);
        prepare.setInt(1, id);
        ResultSet rs = prepare.executeQuery();
        if (rs.next()) {
            a = new Article();
            /*a.setIdarea(rs.getInt("idarea"));
             a.setNombre(rs.getString("nombre"));
             a.setDescripcion(rs.getString("descripcion")); */
        }
        con.close();
        return a;
    }

    @Override
    public List<Article> getAll() throws SQLException {
        con = Database.getConnection();
        Article a = null;
        List<Article> lista = new ArrayList<>();
        /*String select="SELECT idarea,nombre,descripcion FROM Area";
         PreparedStatement prepare = con.prepareStatement(select);
         ResultSet rs = prepare.executeQuery();
         while (rs.next()) {
         a=new Area();
         a.setIdarea(rs.getInt("idarea"));
         a.setNombre(rs.getString("nombre"));
         a.setDescripcion(rs.getString("descripcion"));
         lista.add(a);
         }
         con.close();*/
        return lista;
    }

    @Override
    public List<Article> getAllarticlesbyid(int idarticle) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> getAllarticlesbyuser(int iduser) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> getAllarticlesbytitle(int iduser) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
