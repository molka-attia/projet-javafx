/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

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
public class AdminTechnicienController implements Initializable {


    @FXML
    private BorderPane border;
     @FXML
    private TextField Email;

    @FXML
    private PasswordField Mdp;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Poste;

    @FXML
    private TextField Prenom;

    @FXML
    private TextField Tel;

    

    @FXML
    private Button btnajouter;

    @FXML
    private Button btnmodifier;

    @FXML
    private TableColumn<Utilisateur,String> email;

    @FXML
    private TableColumn<Utilisateur,String> idCol;
    

    @FXML
    private TableColumn<Utilisateur,String> nom;

    @FXML
    private TableColumn<Utilisateur,String> poste;

    @FXML
    private TableColumn<Utilisateur,String> prenom;

    @FXML
    private TableView<Utilisateur> tableuser;
    
        @FXML
    private ComboBox<String> groupecombo;

    @FXML
    private TableColumn<Utilisateur,String> tel;
    /**
     * Initializes the controller class.
     */
//    ObservableList<Utilisateur>list=FXCollections.observableArrayList(
//    new Utilisateur("id1", "nom1", "prenom", "email", "password"," tel", "poste"," type")
//    );
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//     try {
//            // Check to see if the border pane is correctly injected
//            if (border == null) {
//                System.err.println("BorderPane is not injected! Check your FXML file.");
//                return;
//            }
//
//            // Load the FXML file
//            Parent sidebar = FXMLLoader.load(getClass().getResource("../views/sidebardashbord.fxml"));
//
//            // Check if the loaded sidebar is null
//            if (sidebar == null) {
//                System.err.println("FXML file not loaded properly!");
//                return;
//            }
//
//            // Set the loaded sidebar as the left element of the BorderPane
//            border.setLeft(sidebar);
//            id.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("id"));
//             nom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("nom"));
//              prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("prenom"));
//               email.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("email"));
//                tel.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("tel"));
//                poste.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("poste"));
//          //  tableuser.setItems(list);
//            
//            
//        } catch (IOException ex) {
//            System.err.println("Exception while loading FXML: " + ex);
//        }
//    }
//}
//
 @FXML
    private void handleButtonAction(ActionEvent event) {
    
    }
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
           pst = con.prepareStatement("select id,nom,prenom,email,password,tel,poste,type from utilisateur where type='tech'");  
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
                tableuser.setItems(users);
                idCol.setCellValueFactory(f -> f.getValue().idProperty());
                
                nom.setCellValueFactory(f -> f.getValue().nomProperty());
                
                prenom.setCellValueFactory(f -> f.getValue().prenomProperty());
                email.setCellValueFactory(f -> f.getValue().emailProperty());
                poste.setCellValueFactory(f -> f.getValue().posteProperty());
                tel.setCellValueFactory(f -> f.getValue().telProperty());
                
                //CourseColmn.setCellValueFactory(f -> f.getValue().courseProperty());
                
               
       }
       
       catch (SQLException ex) 
       {
         // Logger.getLogger(AdminUserControllerController.class.getName()).log(Level.SEVERE, null, ex);
       }
                tableuser.setRowFactory( tv -> {
             TableRow<Utilisateur> myRow = new TableRow<>();
             myRow.setOnMouseClicked (event -> 
             {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    myIndex =  tableuser.getSelectionModel().getSelectedIndex();
         
                   id = Integer.parseInt(String.valueOf(tableuser.getItems().get(myIndex).getId()));

                   Nom.setText(tableuser.getItems().get(myIndex).getNom());
                    Prenom.setText(tableuser.getItems().get(myIndex).getPrenom());
                  Tel.setText(tableuser.getItems().get(myIndex).getTel());
                  Email.setText(tableuser.getItems().get(myIndex).getEmail());
                  Mdp.setText(tableuser.getItems().get(myIndex).getPassword());
                     Poste.setText(tableuser.getItems().get(myIndex).getPoste());
                           
                         
                           
                }
             });
                return myRow;
                   });
    
    
      }
     
      @FXML
    void Add(ActionEvent event) {
        
            String stnom,stprenom,stemail,stposte,sttel,stpassw;
            stnom = Nom.getText();
            stprenom=Prenom.getText();
            stemail=Email.getText();
            stposte=Poste.getText();
            sttel=Tel.getText();
            stpassw=Mdp.getText();
            
         
            
//            mobile = txtMobile.getText();
//            course = txtCourse.getText();
        try 
        {
            pst = con.prepareStatement("INSERT INTO `utilisateur`(`nom`, `prenom`, `email`, `password`, `tel`, `poste`, `type`,`groupe`) values(?,?,?,?,?,?,?,?)");
            pst.setString(1, stnom);
            pst.setString(2, stprenom);
            pst.setString(3, stemail);
             pst.setString(4, stpassw);
               pst.setString(5, sttel);
               pst.setString(6, stposte);
               pst.setString(7, "tech");
                  if(groupecombo.getSelectionModel().getSelectedItem().toString().equals("software")){
                pst.setInt(8, 1);
            }
            if(groupecombo.getSelectionModel().getSelectedItem().toString().equals("hardware")){
                pst.setInt(8, 2);
            }
             

            
            pst.executeUpdate();
          
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajout Utilisateur");
        
        alert.setHeaderText("Utilisateur ajouté");
        alert.setContentText("Ajouter!");
        alert.showAndWait();
            table();
            
            Prenom.setText("");
            Nom.setText("");
            Email.setText("");
            Tel.setText("");
            Poste.setText("");
            Mdp.setText("");       } 
        catch (SQLException ex)
        {
            Logger.getLogger(AdminUserController.class.getName()).log(Level.SEVERE, null, ex);
         //   System.out.println("erreur 5let");
        }
    }
    
    
//@FXML
//void Delete(ActionEvent event) {
//    myIndex = table.getSelectionModel().getSelectedIndex();
//    if (myIndex >= 0) { // Ensuring a valid selection
//        id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
//        System.out.println(id);
//        try {
//            pst = con.prepareStatement("delete from registration where id = ? ");
//            pst.setInt(1, id);
//            int rowsAffected = pst.executeUpdate();
//
//            if (rowsAffected > 0) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Student Registration");
//                alert.setHeaderText("Student Registration");
//                alert.setContentText("Deleted!");
//                alert.showAndWait();
//                table();
//            } else {
//                // Handle case when deletion was unsuccessful
//                System.out.println("No record deleted!");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//            // Print or show an error message indicating the SQL exception details
//            ex.printStackTrace();
//        }
//    } else {
//        // Handle case when no row is selected
//        System.out.println("No row selected!");
//    }
//}
    
     @FXML
    void Delete(ActionEvent event) {
     myIndex = tableuser.getSelectionModel().getSelectedIndex();
         
        id = Integer.parseInt(String.valueOf(tableuser.getItems().get(myIndex).getId()));
            System.out.println(id);         
        try 
        {
            pst = con.prepareStatement("delete from utilisateur where id = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Suppression utilisateur");
        
        alert.setHeaderText("Suppression utilisateur");
        alert.setContentText("Deletedd!");
        alert.showAndWait();
                  table();
        } 
        catch (SQLException ex)
        {
          //  Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    void Update(ActionEvent event) {
       
       String stnom,stprenom,stemail,stposte,sttel,stpassw;
        
         myIndex = tableuser.getSelectionModel().getSelectedIndex();
         
        id = Integer.parseInt(String.valueOf(tableuser.getItems().get(myIndex).getId()));
           
           
            stnom = Nom.getText();
            stprenom=Prenom.getText();
            stemail=Email.getText();
            stposte=Poste.getText();
            sttel=Tel.getText();
            stpassw=Mdp.getText();
        try 
        {
            pst = con.prepareStatement("UPDATE `utilisateur` SET `nom`=?,`prenom`=?,`email`=?,`password`=?,`tel`=?,`poste`=?,`type`=?,`groupe`=? WHERE id=? ");
            pst.setString(1, stnom);
            pst.setString(2, stprenom);
            pst.setString(3, stemail);
             pst.setString(4, stpassw);
               pst.setString(5, sttel);
               pst.setString(6, stposte);
               pst.setString(7, "tech");
                     if(groupecombo.getSelectionModel().getSelectedItem().toString().equals("software")){
                pst.setInt(8, 1);
            }
            if(groupecombo.getSelectionModel().getSelectedItem().toString().equals("hardware")){
                pst.setInt(8, 2);
            }
             pst.setInt(9, id);
           pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("modification d'utilisateur");
        
        alert.setHeaderText("Utilisateur modifié");
        alert.setContentText("Updateddd!");
        alert.showAndWait();
                table();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(AdminUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    ObservableList listegr=FXCollections.observableArrayList();
     
       
    

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
   listegr.addAll("software","hardware");
        groupecombo.setItems(listegr);
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



        } catch (IOException ex) {
            System.err.println("Exception while loading FXML: " + ex);
        }
    }
}
