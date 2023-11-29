/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Marc
 */
import java.util.List;

public interface DAO<T> {

    public void insert(T t);

    public void update(T t);

    public void delete(T t);


    public List<T> selectAll();
}
