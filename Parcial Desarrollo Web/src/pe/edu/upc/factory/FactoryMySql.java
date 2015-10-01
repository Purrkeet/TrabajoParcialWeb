package pe.edu.upc.factory;

import pe.edu.upc.dao.IArticle;
import pe.edu.upc.dao.ICategory;
import pe.edu.upc.dao.IComment;
import pe.edu.upc.dao.IUser;
import pe.edu.upc.dao.impl.Articledao;
import pe.edu.upc.dao.impl.Categorydao;
import pe.edu.upc.dao.impl.Commentdao;
import pe.edu.upc.dao.impl.Userdao;

public class FactoryMySql extends Factory 
{

    @Override
    public IArticle getArticle() 
    {
       return new Articledao();
    }

    @Override
    public ICategory getCategory() 
    {
       return new Categorydao();
    }

    @Override
    public IComment getComment() 
    {
       return new Commentdao();
    }

    @Override
    public IUser getUser() 
    {
       return new Userdao();
    }

}