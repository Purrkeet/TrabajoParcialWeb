package pe.edu.upc.factory;

import pe.edu.upc.dao.IArticle;
import pe.edu.upc.dao.ICategory;
import pe.edu.upc.dao.IComment;
import pe.edu.upc.dao.IUser;


public abstract class Factory 
{
        //Metodos que seran implementado en las factorias 
    	public  abstract IArticle getArticle();
        public  abstract ICategory getCategory();
        public  abstract IComment getComment();
        public abstract IUser getUser();
        
        //Metodo estatico, para evitar crear una instancia de Factory.
	public static Factory getFactory(FactoryType type)
        {
		if(type.equals(FactoryType.MYSQL_FACTORY)) return new FactoryMySql();
		
		return null;
	}

}
