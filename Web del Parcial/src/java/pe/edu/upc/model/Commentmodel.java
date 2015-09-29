
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
    public String Register(Comment t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Update(Comment t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment Get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comment> GetList() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
