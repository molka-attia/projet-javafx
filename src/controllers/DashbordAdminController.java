/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import Model.Ticket;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author molka
 */
public class DashbordAdminController implements Initializable {

  
    @FXML
    private BorderPane border;
    @FXML
    private Label nbrusers;
     @FXML
    private Label nbrticket;
      @FXML
    private Label nbrtechnicien;
      
      

    @FXML
    private TableColumn<Ticket, Date> datecreation;

    @FXML
    private TableColumn<Ticket, String> description;

    @FXML
    private TableColumn<Ticket, String> etat;

    @FXML
    private ComboBox<String> groupeliste;

    @FXML
    private TableColumn<Ticket,String > idCol;

 

    @FXML
    private TableColumn<Ticket, String> priorite;
 @FXML
    private TableColumn<Ticket, String> responsable;
  

    @FXML
    private TableView<Ticket> tableticket;
   
    

    int myIndex;
   int id;
  
   
      
    /**
     * Initializes the controller class.
     */
    
        Connection con;
    PreparedStatement pst;
     PreparedStatement pst2; PreparedStatement pst3;
     
  
     public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/java_helpdesk","root","");
            System.out.println("connected succefuly 2");
        } catch (ClassNotFoundException ex) {
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     
          public void table() {
    Connect();

    try {
        pst = con.prepareStatement("SELECT COUNT(*) AS userCount FROM utilisateur where type='user'");
        pst2 = con.prepareStatement("SELECT COUNT(*) AS ticketCount FROM ticket");
        pst3 = con.prepareStatement("SELECT COUNT(*) AS technicienCount FROM utilisateur where type='tech'");
        ResultSet rs = pst.executeQuery();
        ResultSet rs2 = pst2.executeQuery();
        ResultSet rs3 = pst3.executeQuery();

        if (rs.next()) {
            int userCount = rs.getInt("userCount");
         
            System.out.println("Nombre total d'utilisateurs : " + userCount);

            // Affichage du nombre d'utilisateurs dans un Text nommé "nombreUtilisateursText"
            nbrusers.setText(""+userCount);
         
            
        }
            if (rs2.next()) {
           
            int ticketCount = rs2.getInt("ticketCount");
      

            // Affichage du nombre d'utilisateurs dans un Text nommé "nombreUtilisateursText"
      
            nbrticket.setText(""+ticketCount);
        
            
        }
                if (rs3.next()) {
          
            int technicienCount = rs3.getInt("technicienCount");
            
            // Affichage du nombre d'utilisateurs dans un Text nommé "nombreUtilisateursText"
         
            nbrtechnicien.setText(""+technicienCount);
            
        }
    }
    catch (SQLException ex) {
        // Gérer les exceptions SQL
        ex.printStackTrace();
    }
  }
   
          
          
          
          
          
          
          
          
             public void table2()
      {
          Connect();
          ObservableList<Ticket> tickets = FXCollections.observableArrayList();
       try 
       {
           pst = con.prepareStatement("SELECT  `description`, `priorite`, `responsable` FROM `ticket` where datecreation= CURDATE();");  
           ResultSet rs = pst.executeQuery();
      {
        while (rs.next())
        {
           Ticket st = new Ticket();
           // st.setId(rs.getString("id"));
           // st.setId("2");
            st.setDescription(rs.getString("description"));
            st.setPriorite(rs.getString("priorite"));
          //  st.setDatecreation(rs.getDate("datecreation"));
         //   st.setEtat(rs.getString("etat"));
           // st.setSolution(rs.getString("solution")); 
            st.setResponsable(rs.getString("responsable"));
            //st.setType(rs.getString("type"));
              
           
            tickets.add(st);
       }
    } 
                tableticket.setItems(tickets);
                
                
                description.setCellValueFactory(f -> f.getValue().descriptionProperty());
                priorite.setCellValueFactory(f -> f.getValue().prioriteProperty());
              //  datecreation.setCellValueFactory(f -> f.getValue().datecreationProperty());
               // etat.setCellValueFactory(f -> f.getValue().etatProperty());
                //responsable.setCellValueFactory(f -> {if(f.getValue().responsableProperty().equals(2))return "hardware";else return "software";});
    responsable.setCellValueFactory(f -> {
    // Get the value of the property using getValue() method
    String propertyValue = f.getValue().responsableProperty().getValue();

    // Replace the condition with your own logic
    if ("2".equals(propertyValue)) {
        System.out.println(propertyValue);
        return new SimpleStringProperty("hardware");
    } else {
        System.out.println(propertyValue);
        return new SimpleStringProperty("software");
    }
});

                //CourseColmn.setCellValueFactory(f -> f.getValue().courseProperty());
                
               
       }
       
       catch (SQLException ex) 
       {
         // Logger.getLogger(AdminUserControllerController.class.getName()).log(Level.SEVERE, null, ex);
       }
                
    
      }
   
          
          
          
          
          
          
          
          
          
          
          
          
          
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
           Connect();
 table();
 table2();
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
        } catch (IOException ex) {
            System.err.println("Exception while loading FXML: " + ex);
        }
    }
}

