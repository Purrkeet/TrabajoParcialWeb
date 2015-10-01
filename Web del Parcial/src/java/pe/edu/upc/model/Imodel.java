/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alumnos
 */
public interface Imodel <T>{
    public String Register(T t) throws SQLException;
    public String Update(T t) throws SQLException;
    public String Delete(int id) throws SQLException;
    public T Get(int id) throws SQLException;
    public List<T> GetList() throws SQLException;
    
}
