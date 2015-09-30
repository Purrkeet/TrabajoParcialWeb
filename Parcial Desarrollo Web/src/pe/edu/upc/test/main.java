/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.test;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.upc.dao.IUser;
import pe.edu.upc.dao.impl.Userdao;
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
        User oUser = new User();
        oUser.setName("Erik");
        oUser.setPassword("123456");
        oUser.setUsername("Erikk");
        oUser.setEmail("erik@upc.com");
        oUser.setLastname("Medina");
        
        IUser uDao= Factory.getFactory(FactoryType.MYSQL_FACTORY).getUser();
        try {
            uDao.create(oUser);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
