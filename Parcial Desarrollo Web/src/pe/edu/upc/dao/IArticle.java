package pe.edu.upc.dao;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.entity.Article;

public interface IArticle extends IDao<Article >
{
    List<Article> getAllarticlesbyuser (int iduser)throws SQLException;
    List<Article> getAllarticlesbytitle (int idtitle)throws SQLException;
}
