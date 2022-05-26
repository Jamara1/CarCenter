/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author jamar
 */
@Named(value = "documentType")
@SessionScoped
public class DocumentType implements Serializable {

    private int index;
    
    private int id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    
    public DocumentType() {
        
    }

    public DocumentType(DocumentType documentType) {
        this.id = documentType.getId();
        this.name = documentType.getName();
        this.createdAt = documentType.getCreatedAt();
        this.updatedAt = documentType.getUpdatedAt();
    }
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public void setModelNull() {
        this.id = 0;
        this.name = null;
        this.createdAt = null;
        this.updatedAt = null;
    }
}
