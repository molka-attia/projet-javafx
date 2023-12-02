/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author molka
 */
public class Groupe {
    private String id;
    private String specialite;
    private ArrayList<Technicien> techniciens;

    public Groupe() {
    }

    public Groupe(String id, String specialite, ArrayList<Technicien> techniciens) {
        this.id = id;
        this.specialite = specialite;
        this.techniciens = techniciens;
    }
 public Groupe(String id, String specialite) {
        this.id = id;
        this.specialite = specialite;
        this.techniciens=new ArrayList<Technicien>();
       
    }
    public  void ajouterTechnicien(Technicien tech){
    techniciens.add(tech);
    } 
     
  public Technicien chercherTechnicien(int idtech) {
    try {
        Technicien technicien = techniciens.get(idtech);
        if (technicien == null) {
            throw new IllegalArgumentException("Aucun technicien trouvé avec l'ID : " + idtech);
        }
        else{
        return technicien;
        }
    } catch (IndexOutOfBoundsException e) {
        throw new IndexOutOfBoundsException("L'indice spécifié est en dehors des limites de la liste des techniciens.");
    }
}
    
    public void afficherTechnicien(){
    for (Technicien tech : techniciens) {
        System.out.println(tech) ; }
    }
    
    
    
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * @return the techniciens
     */
    public ArrayList<Technicien> getTechniciens() {
        return techniciens;
    }

    /**
     * @param techniciens the techniciens to set
     */
    public void setTechniciens(ArrayList<Technicien> techniciens) {
        this.techniciens = techniciens;
    }

    @Override
    public String toString() {
        return "Groupe :"+id; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
