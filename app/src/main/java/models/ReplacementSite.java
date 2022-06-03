/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.ReplacementController;
import controllers.SiteController;
import java.sql.SQLException;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author jamar
 */
@Named(value = "replacementSite")
@ApplicationScoped
public class ReplacementSite {
    private int index;
    
    private int id;
    private int idReplacement;
    private int idSite;
    private String quantity;
    private Date createdAt;
    private Date updatedAt;
    
    private Replacement replacement;
    private Site site;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReplacement() {
        return idReplacement;
    }

    public void setIdReplacement(int idReplacement) {
        this.idReplacement = idReplacement;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Replacement getReplacement() {
        return replacement;
    }

    public void setReplacement(Replacement replacement) {
        this.replacement = replacement;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    public Replacement relationReplacement(int id) throws SQLException {        
        ReplacementController replacementController = new ReplacementController();
        
        return replacementController.getReplacement(id);
    }
    
    public Site relationSite(int id) throws SQLException {        
        SiteController siteController = new SiteController();
        
        return siteController.getSite(id);
    }
}
