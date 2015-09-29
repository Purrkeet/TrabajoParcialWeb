package pe.edu.upc.dao;

import java.sql.SQLException;
import pe.edu.upc.entity.User;

public interface IUser extends IDao<User>
{
    public User login(User o) throws SQLException;
}
