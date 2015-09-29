
package pe.edu.upc.model;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.dao.ICategory;
import pe.edu.upc.entity.Category;
import pe.edu.upc.factory.Factory;
import pe.edu.upc.factory.FactoryType;

public class Categorymodel implements Imodel<Category>{
    ICategory  dao  = Factory.getFactory(FactoryType.MYSQL_FACTORY).getCategory();
            
            
    @Override
    public String Register(Category t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Update(Category t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category Get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> GetList() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
