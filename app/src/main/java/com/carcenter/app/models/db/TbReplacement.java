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
@Table(name = "TB_REPLACEMENT")
@NamedQueries({
    @NamedQuery(name = "TbReplacement.findAll", query = "SELECT t FROM TbReplacement t"),
    @NamedQuery(name = "TbReplacement.findByIdReplacement", query = "SELECT t FROM TbReplacement t WHERE t.idReplacement = :idReplacement"),
    @NamedQuery(name = "TbReplacement.findByName", query = "SELECT t FROM TbReplacement t WHERE t.name = :name"),
    @NamedQuery(name = "TbReplacement.findByPrice", query = "SELECT t FROM TbReplacement t WHERE t.price = :price"),
    @NamedQuery(name = "TbReplacement.findByQuantity", query = "SELECT t FROM TbReplacement t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TbReplacement.findByStatus", query = "SELECT t FROM TbReplacement t WHERE t.status = :status"),
    @NamedQuery(name = "TbReplacement.findByCreatedAt", query = "SELECT t FROM TbReplacement t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbReplacement.findByUpdatedAt", query = "SELECT t FROM TbReplacement t WHERE t.updatedAt = :updatedAt")})
public class TbReplacement implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPLACEMENT")
    private BigDecimal idReplacement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigInteger price;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReplacement")
    private Collection<TbReplacementStore> tbReplacementStoreCollection;

    public TbReplacement() {
    }

    public TbReplacement(BigDecimal idReplacement) {
        this.idReplacement = idReplacement;
    }

    public TbReplacement(BigDecimal idReplacement, String name, BigInteger price, BigInteger quantity, short status, Date createdAt) {
        this.idReplacement = idReplacement;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdReplacement() {
        return idReplacement;
    }

    public void setIdReplacement(BigDecimal idReplacement) {
        this.idReplacement = idReplacement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
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

    public Collection<TbReplacementStore> getTbReplacementStoreCollection() {
        return tbReplacementStoreCollection;
    }

    public void setTbReplacementStoreCollection(Collection<TbReplacementStore> tbReplacementStoreCollection) {
        this.tbReplacementStoreCollection = tbReplacementStoreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReplacement != null ? idReplacement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbReplacement)) {
            return false;
        }
        TbReplacement other = (TbReplacement) object;
        if ((this.idReplacement == null && other.idReplacement != null) || (this.idReplacement != null && !this.idReplacement.equals(other.idReplacement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbReplacement[ idReplacement=" + idReplacement + " ]";
    }
    
}
