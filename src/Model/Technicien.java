/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author molka
 */
public class Technicien extends Utilisateur{

    public Technicien() {
        super();
    }
 public Technicien(String id, String nom, String prenom, String email, String password, String tel, String poste, String type, String user_img) {
        super(id, nom, prenom, email, password, tel, poste, type, user_img);
    }
    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
}
