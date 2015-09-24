package pe.edu.upc.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> 
{
	String create(T o) throws SQLException;
	T read(int id) throws SQLException;
	String update(T o)throws SQLException;
	String delete(int id)throws SQLException;	
	List<T> getAll()throws SQLException;
}
