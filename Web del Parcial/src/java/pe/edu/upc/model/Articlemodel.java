
package pe.edu.upc.model;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.dao.IArticle;
import pe.edu.upc.entity.Article;
import pe.edu.upc.factory.Factory;
import pe.edu.upc.factory.FactoryType;

public class Articlemodel implements Imodel<Article>{
    
    IArticle dao  = Factory.getFactory(FactoryType.MYSQL_FACTORY).getArticle();
            
            
    @Override
    public String Register(Article t) throws SQLException {
        return dao.create(t);
    }

    @Override
    public String Update(Article t) throws SQLException {
        return dao.update(t);
    }

    @Override
    public String Delete(int id) throws SQLException {
        return dao.delete(id);
    }

    @Override
    public Article Get(int id) throws SQLException {
        return dao.read(id);
    }

    @Override
    public List<Article> GetList() throws SQLException {
        return dao.getAll();
    }

  
}
