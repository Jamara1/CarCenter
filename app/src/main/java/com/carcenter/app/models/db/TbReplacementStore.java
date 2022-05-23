/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jamar
 */
@Entity
@Table(name = "TB_REPLACEMENT_STORE")
@NamedQueries({
    @NamedQuery(name = "TbReplacementStore.findAll", query = "SELECT t FROM TbReplacementStore t"),
    @NamedQuery(name = "TbReplacementStore.findByIdReplacementStore", query = "SELECT t FROM TbReplacementStore t WHERE t.idReplacementStore = :idReplacementStore"),
    @NamedQuery(name = "TbReplacementStore.findByQuantity", query = "SELECT t FROM TbReplacementStore t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TbReplacementStore.findByStatusOperation", query = "SELECT t FROM TbReplacementStore t WHERE t.statusOperation = :statusOperation"),
    @NamedQuery(name = "TbReplacementStore.findByCreatedAt", query = "SELECT t FROM TbReplacementStore t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbReplacementStore.findByUpdatedAt", query = "SELECT t FROM TbReplacementStore t WHERE t.updatedAt = :updatedAt")})
public class TbReplacementStore implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPLACEMENT_STORE")
    private BigDecimal idReplacementStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_OPERATION")
    private short statusOperation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "ID_REPLACEMENT", referencedColumnName = "ID_REPLACEMENT")
    @ManyToOne(optional = false)
    private TbReplacement idReplacement;
    @JoinColumn(name = "ID_STORE", referencedColumnName = "ID_STORE")
    @ManyToOne(optional = false)
    private TbStore idStore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReplacementStore")
    private Collection<TbBillReplacementStore> tbBillReplacementStoreCollection;

    public TbReplacementStore() {
    }

    public TbReplacementStore(BigDecimal idReplacementStore) {
        this.idReplacementStore = idReplacementStore;
    }

    public TbReplacementStore(BigDecimal idReplacementStore, BigInteger quantity, short statusOperation, Date createdAt) {
        this.idReplacementStore = idReplacementStore;
        this.quantity = quantity;
        this.statusOperation = statusOperation;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdReplacementStore() {
        return idReplacementStore;
    }

    public void setIdReplacementStore(BigDecimal idReplacementStore) {
        this.idReplacementStore = idReplacementStore;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public short getStatusOperation() {
        return statusOperation;
    }

    public void setStatusOperation(short statusOperation) {
        this.statusOperation = statusOperation;
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

    public TbReplacement getIdReplacement() {
        return idReplacement;
    }

    public void setIdReplacement(TbReplacement idReplacement) {
        this.idReplacement = idReplacement;
    }

    public TbStore getIdStore() {
        return idStore;
    }

    public void setIdStore(TbStore idStore) {
        this.idStore = idStore;
    }

    public Collection<TbBillReplacementStore> getTbBillReplacementStoreCollection() {
        return tbBillReplacementStoreCollection;
    }

    public void setTbBillReplacementStoreCollection(Collection<TbBillReplacementStore> tbBillReplacementStoreCollection) {
        this.tbBillReplacementStoreCollection = tbBillReplacementStoreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReplacementStore != null ? idReplacementStore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbReplacementStore)) {
            return false;
        }
        TbReplacementStore other = (TbReplacementStore) object;
        if ((this.idReplacementStore == null && other.idReplacementStore != null) || (this.idReplacementStore != null && !this.idReplacementStore.equals(other.idReplacementStore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbReplacementStore[ idReplacementStore=" + idReplacementStore + " ]";
    }
    
}
