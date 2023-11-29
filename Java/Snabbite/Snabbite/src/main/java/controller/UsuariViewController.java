/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;

/**
 * FXML Controller class
 *
 * @author Marc
 */
public class UsuariViewController implements Initializable {

    @FXML
    private Menu menuBarLogout;
    @FXML
    private Menu menuBarHome;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelCognom;
    @FXML
    private Label labelTelefon;
    @FXML
    private Label labelContrassenya;
    @FXML
    private Label labelCiutat;
    @FXML
    private Label labelCarrer;
    @FXML
    private Label labelNum;
    @FXML
    private Button buttonEdita;
    @FXML
    private ListView<?> listVIewComandes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
