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
import static javafx.scene.input.KeyCode.INSERT;
import model.Restaurant;
import model.Usuari;
import model.adresa;

/**
 *
 * @author Marc
 */
public class daoUsuari extends DBConnection implements DAO<Usuari> {
    private final String ALL = "SELECT * FROM RESTAURANT";
    private final String INSERT = "INSERT INTO USUARI(ID,Nom,Cognom,Telefon,Contrasenya) VALUES(?,?,?,?,?)";

    @Override
    public void insert(Usuari u) {
       try {
            connect();
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setString(2, t.getNom());
            ps.setString(3, t.getCognom());
            ps.setInt(4, t.getEdat());
            ps.setString(5, t.getNif());
            ps.executeUpdate();
            int id = ps.getGeneratedKeys().getInt(1);
            t.setId(id);
            closeConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Usuari u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Usuari u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuari> selectAll() {
        List<Usuari> usuaris = new ArrayList<Usuari>();
        try {
            connect();
            PreparedStatement ps = connection.prepareStatement(ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("Nom");
                String cognom = rs.getString("Cognom");
                String telefon = rs.getString("Telefon");
                String contra = rs.getString("Contrasenya");
                String num = rs.getString("Num");
                String carrer = rs.getString("Carrer");
                String ciutat = rs.getString("Ciutat");
                //String quanitatproducte = rs.getString("quanitatProducte");
                adresa a1 = new adresa(num, carrer, ciutat);
                
                Usuari u1 = new Usuari(nom, cognom, telefon, contra, id, a1);
                usuaris.add(u1);
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        closeConnection();
        return usuaris;
    }
    
}
