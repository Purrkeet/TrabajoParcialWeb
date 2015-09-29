
package pe.edu.upc.model;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.dao.IComment;
import pe.edu.upc.entity.Comment;
import pe.edu.upc.factory.Factory;
import pe.edu.upc.factory.FactoryType;

public class Commentmodel implements Imodel<Comment> {

    IComment dao= Factory.getFactory(FactoryType.MYSQL_FACTORY).getComment();
    
    @Override
    public String Register(Comment t) throws SQLException 
    {
        return dao.create(t);
    }

    @Override
    public String Update(Comment t) throws SQLException 
    {
        return dao.create(t);
    }

    @Override
    public String Delete(int id) throws SQLException 
    {
        return dao.delete(id);
    }

    @Override
    public Comment Get(int id) throws SQLException 
    {
        return dao.read(id);
    }

    @Override
    public List<Comment> GetList() throws SQLException 
    {
        return dao.getAll();
    }
    
    public List<Comment> getAllcommentsbyarticle(int idarticle) throws SQLException 
    {
        return dao.getAllcommentsbyarticle(idarticle);
    }
    
    public List<Comment> getAllcommentsbyuser(int iduser) throws SQLException 
    {
        return dao.getAllcommentsbyuser(iduser);
    }
    
}
