package pe.edu.upc.dao;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.entity.Article;

public interface IArticle extends IDao<Article >
{
    List<Article> getAllarticlesbyid (int idarticle)throws SQLException;
    List<Article> getAllarticlesbyuser (int iduser)throws SQLException;
    List<Article> getAllarticlesbytitle (int iduser)throws SQLException;
}
