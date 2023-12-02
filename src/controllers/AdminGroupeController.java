/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import Model.Technicien;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import Model.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author molka
 */
public class AdminGroupeController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private BorderPane border;

//    @FXML
//    private TableColumn<Technicien,String> email;
//
//    @FXML
//    private TableColumn<Technicien,String> id;
//
//    @FXML
//    private TableColumn<Technicien,String> nom;
//
//    @FXML
//    private TableColumn<Technicien,String> poste;
//
//    @FXML
//    private TableColumn<Technicien,String> prenom;
//
//    @FXML
//    private TableView<Technicien> tableuser;

//    @FXML
//    private TableColumn<Technicien,String> tel;
    /**
     * Initializes the controller class.
     */
    ObservableList<Technicien>list=FXCollections.observableArrayList(
    new Technicien("id1", "tech1", "technicien", "email", "password"," tel", "poste"," type", "user_img")
    );
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
            // Check to see if the border pane is correctly injected
            if (border == null) {
                System.err.println("BorderPane is not injected! Check your FXML file.");
                return;
            }

            // Load the FXML file
            Parent sidebar = FXMLLoader.load(getClass().getResource("../views/sidebardashbord.fxml"));

            // Check if the loaded sidebar is null
            if (sidebar == null) {
                System.err.println("FXML file not loaded properly!");
                return;
            }

            // Set the loaded sidebar as the left element of the BorderPane
           border.setLeft(sidebar);
//            id.setCellValueFactory(new PropertyValueFactory<Technicien,String>("id"));
//             nom.setCellValueFactory(new PropertyValueFactory<Technicien,String>("nom"));
//              prenom.setCellValueFactory(new PropertyValueFactory<Technicien,String>("prenom"));
//               email.setCellValueFactory(new PropertyValueFactory<Technicien,String>("email"));
//                tel.setCellValueFactory(new PropertyValueFactory<Technicien,String>("tel"));
//                poste.setCellValueFactory(new PropertyValueFactory<Technicien,String>("poste"));
//            tableuser.setItems(list);
//            
//            
        } catch (IOException ex) {
            System.err.println("Exception while loading FXML: " + ex);
        }
    }
}


