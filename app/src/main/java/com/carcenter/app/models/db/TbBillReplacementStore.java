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
@Table(name = "TB_BILL_REPLACEMENT_STORE")
@NamedQueries({
    @NamedQuery(name = "TbBillReplacementStore.findAll", query = "SELECT t FROM TbBillReplacementStore t"),
    @NamedQuery(name = "TbBillReplacementStore.findByIdBillReplacementStore", query = "SELECT t FROM TbBillReplacementStore t WHERE t.idBillReplacementStore = :idBillReplacementStore"),
    @NamedQuery(name = "TbBillReplacementStore.findByQuantity", query = "SELECT t FROM TbBillReplacementStore t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TbBillReplacementStore.findByStatus", query = "SELECT t FROM TbBillReplacementStore t WHERE t.status = :status"),
    @NamedQuery(name = "TbBillReplacementStore.findByCreatedAt", query = "SELECT t FROM TbBillReplacementStore t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbBillReplacementStore.findByUpdatedAt", query = "SELECT t FROM TbBillReplacementStore t WHERE t.updatedAt = :updatedAt")})
public class TbBillReplacementStore implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BILL_REPLACEMENT_STORE")
    private BigDecimal idBillReplacementStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private BigInteger quantity;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBillReplacementStore")
    private Collection<TbBill> tbBillCollection;
    @JoinColumn(name = "ID_REPLACEMENT_STORE", referencedColumnName = "ID_REPLACEMENT_STORE")
    @ManyToOne(optional = false)
    private TbReplacementStore idReplacementStore;

    public TbBillReplacementStore() {
    }

    public TbBillReplacementStore(BigDecimal idBillReplacementStore) {
        this.idBillReplacementStore = idBillReplacementStore;
    }

    public TbBillReplacementStore(BigDecimal idBillReplacementStore, BigInteger quantity, short status, Date createdAt) {
        this.idBillReplacementStore = idBillReplacementStore;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdBillReplacementStore() {
        return idBillReplacementStore;
    }

    public void setIdBillReplacementStore(BigDecimal idBillReplacementStore) {
        this.idBillReplacementStore = idBillReplacementStore;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
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

    public Collection<TbBill> getTbBillCollection() {
        return tbBillCollection;
    }

    public void setTbBillCollection(Collection<TbBill> tbBillCollection) {
        this.tbBillCollection = tbBillCollection;
    }

    public TbReplacementStore getIdReplacementStore() {
        return idReplacementStore;
    }

    public void setIdReplacementStore(TbReplacementStore idReplacementStore) {
        this.idReplacementStore = idReplacementStore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBillReplacementStore != null ? idBillReplacementStore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBillReplacementStore)) {
            return false;
        }
        TbBillReplacementStore other = (TbBillReplacementStore) object;
        if ((this.idBillReplacementStore == null && other.idBillReplacementStore != null) || (this.idBillReplacementStore != null && !this.idBillReplacementStore.equals(other.idBillReplacementStore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbBillReplacementStore[ idBillReplacementStore=" + idBillReplacementStore + " ]";
    }
    
}
