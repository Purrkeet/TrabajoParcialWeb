/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.upc.dao.IArticle;
import pe.edu.upc.dao.IComment;
import pe.edu.upc.dao.IUser;
import pe.edu.upc.dao.impl.Userdao;
import pe.edu.upc.entity.Article;
import pe.edu.upc.entity.Comment;
import pe.edu.upc.entity.User;
import pe.edu.upc.factory.Factory;
import pe.edu.upc.factory.FactoryType;



/**
 *
 * @author Rodri1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* User oUser1 = new User();
        oUser1.setName("Giu");
        oUser1.setPassword("go");
        oUser1.setUsername("Giuseppe");
        oUser1.setEmail("Giu@sep.pe");
        oUser1.setLastname("Seppe");
        oUser1.setIduser(1);
        User oUser = new User();
        oUser.setName("Erik");
        oUser.setPassword("123456");
        oUser.setUsername("Erikk");
        oUser.setEmail("erik@upc.com");
        oUser.setLastname("Medina");
        oUser.setIduser(2);
         Article oArticle = new Article();
         oArticle.setIdarticle(1);
         oArticle.setTitle("Programando no ando");
         oArticle.setText("askjfhaskf asdlkfjh sadfjh asdjhf sakldjfh\nasfsdfkjhsdfjkhsfjksahf\nsdfaishfudasdfasdf "
                 + "\nasdfasodifjasoifaso\nsadoifjsadoifjsadoifjasodifj");
         oArticle.setUser(oUser);
         Comment oComm= new Comment();
         oComm.setArticle(oArticle);
         oComm.setUser(oUser);
         oComm.setTEXT("Oh gosh!!");*/
         IArticle aDao = Factory.getFactory(FactoryType.MYSQL_FACTORY).getArticle();
         IUser uDao= Factory.getFactory(FactoryType.MYSQL_FACTORY).getUser();
         IComment cDao = Factory.getFactory(FactoryType.MYSQL_FACTORY).getComment();
        try {
           /* uDao.create(oUser1);
            uDao.create(oUser);
            aDao.create(oArticle);
            cDao.create(oComm);*/
            List<User> lU= uDao.getAll();
            for ( User u :lU ) {
               System.out.println( u.toString());
            }
            for (Article a: aDao.getAll()) {
                System.out.println( a.toString());
                for (Comment c : cDao.getAllcommentsbyarticle(a.getIdarticle())) {
                    System.out.println( c.toString());
                }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
