/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author jamar
 */
@Named(value = "bill")
@ApplicationScoped
public class Bill {
    private int index;
    
    private int id;
    private int idBillService;
    private int idBillReplacementSite;
    private boolean status;
    private Date createdAt;
    private Date updatedAt;

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

    public int getIdBillService() {
        return idBillService;
    }

    public void setIdBillService(int idBillService) {
        this.idBillService = idBillService;
    }

    public int getIdBillReplacementSite() {
        return idBillReplacementSite;
    }

    public void setIdBillReplacementSite(int idBillReplacementSite) {
        this.idBillReplacementSite = idBillReplacementSite;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
    
    
}
