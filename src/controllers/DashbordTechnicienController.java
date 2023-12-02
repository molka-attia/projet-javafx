/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author molka
 */
public class DashbordTechnicienController implements Initializable {

 
    @FXML
    private BorderPane border;
    /**
     * Initializes the controller class.
     */
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
        } catch (IOException ex) {
            System.err.println("Exception while loading FXML: " + ex);
        }
    }
}

