/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;
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
public class BaseDeConnaissanceController implements Initializable {

   
  @FXML
    private BorderPane border;

    @FXML
    private TableColumn<Ticket, Date> datecreation;

    @FXML
    private TableColumn<Ticket, String> description;



    @FXML
    private TableColumn<Ticket, String> id;

    @FXML
    private TableColumn<Ticket, String> priorite;
    
        @FXML
    private TableColumn<Ticket, String> solution;
        
          @FXML
    private TableColumn<Ticket, Date> Datecloturation;

    @FXML
    private TableView<Ticket> tableticket;
     
    /**
     * Initializes the controller class.
     */
      
  
    
    ObservableList<Ticket>list=FXCollections.observableArrayList(
    new Ticket("id", "description", "priorite", new Date(), "cloturé","solution est")
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
           
          
            
            
            id.setCellValueFactory(new PropertyValueFactory<Ticket,String>("id"));
             description.setCellValueFactory(new PropertyValueFactory<Ticket, String>("description"));
              priorite.setCellValueFactory(new PropertyValueFactory<Ticket, String>("priorite"));
                solution.setCellValueFactory(new PropertyValueFactory<Ticket, String>("solution"));
                datecreation.setCellValueFactory(new PropertyValueFactory<Ticket, Date>("datecreation"));
                Datecloturation.setCellValueFactory(new PropertyValueFactory<Ticket, Date>("Datecloturation"));
                
            tableticket.setItems(list);
            
            //prioriteform.getItems().addAll(pri); 
          
            
        } catch (IOException ex) {
            System.err.println("Exception while loading FXML: " + ex);
        }
    }
}


