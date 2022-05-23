/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jamar
 */
@Entity
@Table(name = "TB_BILL")
@NamedQueries({
    @NamedQuery(name = "TbBill.findAll", query = "SELECT t FROM TbBill t"),
    @NamedQuery(name = "TbBill.findByIdBill", query = "SELECT t FROM TbBill t WHERE t.idBill = :idBill"),
    @NamedQuery(name = "TbBill.findByQuantity", query = "SELECT t FROM TbBill t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TbBill.findByStatus", query = "SELECT t FROM TbBill t WHERE t.status = :status"),
    @NamedQuery(name = "TbBill.findByCreatedAt", query = "SELECT t FROM TbBill t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbBill.findByUpdatedAt", query = "SELECT t FROM TbBill t WHERE t.updatedAt = :updatedAt")})
public class TbBill implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BILL")
    private BigDecimal idBill;
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
    @JoinColumn(name = "ID_BILL_REPLACEMENT_STORE", referencedColumnName = "ID_BILL_REPLACEMENT_STORE")
    @ManyToOne(optional = false)
    private TbBillReplacementStore idBillReplacementStore;
    @JoinColumn(name = "ID_SERVICE", referencedColumnName = "ID_SERVICE")
    @ManyToOne(optional = false)
    private TbService idService;

    public TbBill() {
    }

    public TbBill(BigDecimal idBill) {
        this.idBill = idBill;
    }

    public TbBill(BigDecimal idBill, BigInteger quantity, short status, Date createdAt) {
        this.idBill = idBill;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdBill() {
        return idBill;
    }

    public void setIdBill(BigDecimal idBill) {
        this.idBill = idBill;
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

    public TbBillReplacementStore getIdBillReplacementStore() {
        return idBillReplacementStore;
    }

    public void setIdBillReplacementStore(TbBillReplacementStore idBillReplacementStore) {
        this.idBillReplacementStore = idBillReplacementStore;
    }

    public TbService getIdService() {
        return idService;
    }

    public void setIdService(TbService idService) {
        this.idService = idService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBill != null ? idBill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBill)) {
            return false;
        }
        TbBill other = (TbBill) object;
        if ((this.idBill == null && other.idBill != null) || (this.idBill != null && !this.idBill.equals(other.idBill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbBill[ idBill=" + idBill + " ]";
    }
    
}
