/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.models;

import java.util.Date;

/**
 *
 * @author jamar
 */
public class BillReplacementSiteModel {
    private int id;
    private int idReplacementStore;
    private Date createdAt;
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReplacementStore() {
        return idReplacementStore;
    }

    public void setIdReplacementStore(int idReplacementStore) {
        this.idReplacementStore = idReplacementStore;
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
