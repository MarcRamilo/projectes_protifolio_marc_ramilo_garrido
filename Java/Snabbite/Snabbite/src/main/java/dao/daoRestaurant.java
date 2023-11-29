/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Restaurant;

/**
 *
 * @author Marc
 */
public class daoRestaurant extends DBConnection implements DAO<Restaurant> {

    private final String ALL = "SELECT * FROM RESTAURANT";

    @Override
    public void insert(Restaurant t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Restaurant t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Restaurant t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Restaurant> selectAll() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            connect();
            PreparedStatement ps = connection.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numRestaurant = rs.getInt("Numrestaurant");
                String nomRestaurant = rs.getString("Nomrestaurant");
                //String quanitatproducte = rs.getString("quanitatProducte");
                Restaurant r1 = new Restaurant(numRestaurant, nomRestaurant);
                restaurants.add(r1);
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        closeConnection();
        return restaurants;
    }

}
