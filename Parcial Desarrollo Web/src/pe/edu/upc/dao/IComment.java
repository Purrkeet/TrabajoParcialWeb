package pe.edu.upc.dao;

import java.sql.SQLException;
import java.util.List;
import pe.edu.upc.entity.Comment;

public interface IComment extends IDao<Comment>
{
    List<Comment> getAllcommentsbyarticle (int idarticle)throws SQLException;
    List<Comment> getAllcommentsbyuser (int iduser)throws SQLException;
}
