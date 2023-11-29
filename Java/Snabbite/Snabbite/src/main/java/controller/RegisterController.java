/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marc
 */
public class RegisterController implements Initializable {

    @FXML
    private Menu menuBarRegister;
    @FXML
    private Menu menuBarLogin;
    @FXML
    private Menu menuBarHome;
    @FXML
    private Button buttonRegister;
    @FXML
    private TextField textFieldNom;
    @FXML
    private TextField textFieldCognom;
    @FXML
    private TextField textFieldTelefon;
    @FXML
    private TextField textFieldContrssaenya;
    @FXML
    private TextField textFieldCiutat;
    @FXML
    private TextField textFieldCarrer;
    @FXML
    private TextField textFieldNum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Register(ActionEvent event) {
        
        String nom,cognom,telefon,contrassenya,ciutat,carrer,num;
        
        nom = textFieldNom.getText();
        cognom = textFieldCognom.getText();
        telefon = textFieldNom.getText();
        nom = textFieldNom.getText();
        nom = textFieldNom.getText();
        nom = textFieldNom.getText();
        nom = textFieldNom.getText();
        nom = textFieldNom.getText();
        
    }
    
}
