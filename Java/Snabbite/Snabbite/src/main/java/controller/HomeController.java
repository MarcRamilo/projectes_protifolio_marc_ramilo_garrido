/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.daoRestaurant;
import dao.daoTest;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import model.Usuari;
import dao.*;
import javafx.event.ActionEvent;
import model.Restaurant;

/**
 * FXML Controller class
 *
 * @author Marc
 */
public class HomeController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxCercador;
    @FXML
    private Menu menuBarLogin;
    @FXML
    private Menu menuBarRegister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        daoRestaurant dr1 = new daoRestaurant();
        
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        
        restaurants = dr1.selectAll();
        
        for (int i = 0; i < restaurants.size(); i++) {
            comboBoxCercador.getItems().add(restaurants.get(i).toName());
        }
        
    }    

    @FXML
    private void goToLogin(ActionEvent event) {
        
        
        
    }

    @FXML
    private void goToRegister(ActionEvent event) {
    }
    
    
    
}
