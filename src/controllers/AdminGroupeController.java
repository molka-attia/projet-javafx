/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import Model.Groupe;
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
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import Model.Technicien;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;
import javafx.scene.layout.BorderPane;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
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
  
   
     @FXML
    private TableColumn<Utilisateur, String> emails;

    @FXML
    private TableView<Utilisateur> hardware;

    @FXML
    private TableColumn<Utilisateur,String> noms;

    @FXML
    private TableColumn<Utilisateur,String> prenoms;

    @FXML
    private TableView<Utilisateur> software;

    @FXML
    private TableColumn<Utilisateur, String> tels;
    
     @FXML
    private TableColumn<Utilisateur,String> nomh;

    @FXML
    private TableColumn<Utilisateur,String> prenomh;

 
    @FXML
    private TableColumn<Utilisateur, String> telh;
    
    @FXML
    private TableColumn<Utilisateur, String> emailh;
  
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
//    ObservableList<Technicien>list=FXCollections.observableArrayList(
//    new Technicien("id1", "tech1", "technicien", "email", "password"," tel", "poste"," type", "user_img")
//    );
   
       Connection con;
    PreparedStatement pst;
    int myIndex;
   int id;
   
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
    
      public void table()
      {
          Connect();
          ObservableList<Utilisateur> users = FXCollections.observableArrayList();
       try 
       {
           pst = con.prepareStatement("select id,nom,prenom,email,password,tel,poste,type from utilisateur where groupe=1");  
           ResultSet rs = pst.executeQuery();
      {
        while (rs.next())
        {
            Utilisateur st = new Utilisateur();
            st.setId(rs.getString("id"));
           // st.setId("2");
            st.setNom(rs.getString("nom"));
            st.setPrenom(rs.getString("prenom"));
            st.setEmail(rs.getString("email"));
            st.setPassword(rs.getString("password"));
            st.setTel(rs.getString("tel")); 
            st.setPoste(rs.getString("poste"));
            //st.setType(rs.getString("type"));
              
           
            users.add(st);
       }
    } 
                software.setItems(users);
              
                
                noms.setCellValueFactory(f -> f.getValue().nomProperty());
                
                prenoms.setCellValueFactory(f -> f.getValue().prenomProperty());
                emails.setCellValueFactory(f -> f.getValue().emailProperty());
               
                tels.setCellValueFactory(f -> f.getValue().telProperty());
                
                //CourseColmn.setCellValueFactory(f -> f.getValue().courseProperty());
                
               
       }
       
       catch (SQLException ex) 
       {
         // Logger.getLogger(AdminUserControllerController.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    
      }
     
   
   
     public void table2()
      {
          Connect();
          ObservableList<Utilisateur> users = FXCollections.observableArrayList();
       try 
       {
           pst = con.prepareStatement("select id,nom,prenom,email,password,tel,poste,type from utilisateur where groupe=2");  
           ResultSet rs = pst.executeQuery();
      {
        while (rs.next())
        {
            Utilisateur st = new Utilisateur();
            st.setId(rs.getString("id"));
           // st.setId("2");
            st.setNom(rs.getString("nom"));
            st.setPrenom(rs.getString("prenom"));
            st.setEmail(rs.getString("email"));
            st.setPassword(rs.getString("password"));
            st.setTel(rs.getString("tel")); 
            st.setPoste(rs.getString("poste"));
            //st.setType(rs.getString("type"));
              
           
            users.add(st);
       }
    } 
                hardware.setItems(users);
              
                
                nomh.setCellValueFactory(f -> f.getValue().nomProperty());
                
                prenomh.setCellValueFactory(f -> f.getValue().prenomProperty());
                emailh.setCellValueFactory(f -> f.getValue().emailProperty());
               
                telh.setCellValueFactory(f -> f.getValue().telProperty());
                
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

  
        Connect();
        
 table();
  table2();


        } catch (IOException ex) {
            System.err.println("Exception while loading FXML: " + ex);
        }
    }
}


