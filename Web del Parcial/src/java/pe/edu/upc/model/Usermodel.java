
package pe.edu.upc.model;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.dao.IUser;
import pe.edu.upc.entity.User;
import pe.edu.upc.factory.Factory;
import pe.edu.upc.factory.FactoryType;

public class Usermodel implements Imodel<User>
{
    IUser daoUser = Factory.getFactory(FactoryType.MYSQL_FACTORY).getUser();

    @Override
    public String Register(User t) throws SQLException 
    {
        return daoUser.create(t);
    }

    @Override
    public String Update(User t) throws SQLException 
    {
        return daoUser.update(t);
    }

    @Override
    public String Delete(int id) throws SQLException 
    {
        return daoUser.delete(id);
    }

    @Override
    public User Get(int id) throws SQLException 
    {
        return daoUser.read(id);
    }

    @Override
    public List<User> GetList() throws SQLException 
    {
        return daoUser.getAll();    
    }

     public User login(User o) throws SQLException
     {
         return daoUser.login(o);
     }
    
}
