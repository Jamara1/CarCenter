/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jamar
 */
@Entity
@Table(name = "TB_STORE")
@NamedQueries({
    @NamedQuery(name = "TbStore.findAll", query = "SELECT t FROM TbStore t"),
    @NamedQuery(name = "TbStore.findByIdStore", query = "SELECT t FROM TbStore t WHERE t.idStore = :idStore"),
    @NamedQuery(name = "TbStore.findByName", query = "SELECT t FROM TbStore t WHERE t.name = :name"),
    @NamedQuery(name = "TbStore.findByStatus", query = "SELECT t FROM TbStore t WHERE t.status = :status"),
    @NamedQuery(name = "TbStore.findByCreatedAt", query = "SELECT t FROM TbStore t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbStore.findByUpdatedAt", query = "SELECT t FROM TbStore t WHERE t.updatedAt = :updatedAt")})
public class TbStore implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_STORE")
    private BigDecimal idStore;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStore")
    private Collection<TbReplacementStore> tbReplacementStoreCollection;

    public TbStore() {
    }

    public TbStore(BigDecimal idStore) {
        this.idStore = idStore;
    }

    public TbStore(BigDecimal idStore, String name, short status, Date createdAt) {
        this.idStore = idStore;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdStore() {
        return idStore;
    }

    public void setIdStore(BigDecimal idStore) {
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
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

    public Collection<TbReplacementStore> getTbReplacementStoreCollection() {
        return tbReplacementStoreCollection;
    }

    public void setTbReplacementStoreCollection(Collection<TbReplacementStore> tbReplacementStoreCollection) {
        this.tbReplacementStoreCollection = tbReplacementStoreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStore != null ? idStore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbStore)) {
            return false;
        }
        TbStore other = (TbStore) object;
        if ((this.idStore == null && other.idStore != null) || (this.idStore != null && !this.idStore.equals(other.idStore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbStore[ idStore=" + idStore + " ]";
    }
    
}
