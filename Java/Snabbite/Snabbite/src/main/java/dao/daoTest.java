/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static java.lang.System.Logger.Level.ALL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuari;

/**
 *
 * @author Marc
 */
public class daoTest extends DBConnection implements DAO<Usuari> {
    private final String ALL = "SELECT * FROM USUARI";

    @Override
    public void insert(Usuari t) {
        System.out.println("");
    }

    @Override
    public void update(Usuari t) {
        System.out.println("");
    }

    @Override
    public void delete(Usuari t) {
        System.out.println("");
    }

     @Override
    public List<Usuari> selectAll() {
        List<Usuari> persones = new ArrayList<Usuari>();
        try {
            connect();
            PreparedStatement ps = connection.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String cognom = rs.getString("cognom");
                String telefon = rs.getString("telefon");
                String contrassenya = rs.getString("contrasenya");
                Usuari u1 = new Usuari(nom, cognom, telefon, contrassenya, id);
                u1.toString();
                persones.add(u1);
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        closeConnection();
        return persones;
    }

}
