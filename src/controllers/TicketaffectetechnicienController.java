/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Model.Technicien;
import Model.Ticket;
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
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author molka
 */
public class TicketaffectetechnicienController implements Initializable {

     @FXML
    private BorderPane border;

    @FXML
    private TableColumn<Ticket, Date> datecreation;

    @FXML
    private TableColumn<Ticket, String> description;

    @FXML
    private TableColumn<Ticket, String> etat;

    @FXML
    private TableColumn<Ticket, String> id;

    @FXML
    private TableColumn<Ticket, String> priorite;

    @FXML
    private TableView<Ticket> tableticket;
      @FXML
    private ComboBox<String> prioriteform;
    /**
     * Initializes the controller class.
     */
      
    private String[] pri ={"faible", "moyenne","urgent"};
    
    ObservableList<Ticket>list=FXCollections.observableArrayList(
    new Ticket("id", "description", "priorite", new Date(), "etat")
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
            Parent sidebar = FXMLLoader.load(getClass().getResource("../views/sidebardashbordtechnicien.fxml"));
   
            // Check if the loaded sidebar is null
            if (sidebar == null) {
                System.err.println("FXML file not loaded properly!");
                return;
            }

            // Set the loaded sidebar as the left element of the BorderPane
           border.setLeft(sidebar);
           
          
            
            
            id.setCellValueFactory(new PropertyValueFactory<Ticket,String>("id"));
             description.setCellValueFactory(new PropertyValueFactory<Ticket, String>("description"));
              priorite.setCellValueFactory(new PropertyValueFactory<Ticket, String>("priorite"));
               etat.setCellValueFactory(new PropertyValueFactory<Ticket, String>("etat"));
                datecreation.setCellValueFactory(new PropertyValueFactory<Ticket, Date>("datecreation"));
               
            tableticket.setItems(list);
            
            //prioriteform.getItems().addAll(pri); 
          
            
        } catch (IOException ex) {
            System.err.println("Exception while loading FXML: " + ex);
        }
    }
}


