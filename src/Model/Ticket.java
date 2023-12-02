/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author molka
 */
public class Ticket {
    private String id;
    private String description;
    private String priorite;
    private Date datecreation;
    private String etat;
    private String solution;
    private Date Datecloturation;


    public Ticket() {
    }

    public Ticket(String id, String description, String priorite, Date datecreation, String etat, String solution) {
        this.id = id;
        this.description = description;
        this.priorite = priorite;
        this.datecreation = datecreation;
        this.etat = etat;
        this.solution = solution;
    }

    public Ticket(String id, String description, String priorite, Date datecreation, String etat) {
        this.id = id;
        this.description = description;
        this.priorite = priorite;
        this.datecreation = datecreation;
        this.etat = etat;
        this.solution = "";
    }

    
    
    
    public void cloturer(){
        setDatecloturation(new Date());
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the priorite
     */
    public String getPriorite() {
        return priorite;
    }

    /**
     * @param priorite the priorite to set
     */
    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    /**
     * @return the datecreation
     */
    public Date getDatecreation() {
        return datecreation;
    }

    /**
     * @param datecreation the datecreation to set
     */
    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return the solution
     */
    public String getSolution() {
        return solution;
    }

    /**
     * @param solution the solution to set
     */
    public void setSolution(String solution) {
        this.solution = solution;
    }

    /**
     * @return the Datecloturation
     */
    public Date getDatecloturation() {
        return Datecloturation;
    }

    /**
     * @param Datecloturation the Datecloturation to set
     */
    public void setDatecloturation(Date Datecloturation) {
        this.Datecloturation = Datecloturation;
    }
    
    
    
}
