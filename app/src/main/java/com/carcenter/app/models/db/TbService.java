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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TB_SERVICE")
@NamedQueries({
    @NamedQuery(name = "TbService.findAll", query = "SELECT t FROM TbService t"),
    @NamedQuery(name = "TbService.findByIdService", query = "SELECT t FROM TbService t WHERE t.idService = :idService"),
    @NamedQuery(name = "TbService.findByDescpt", query = "SELECT t FROM TbService t WHERE t.descpt = :descpt"),
    @NamedQuery(name = "TbService.findByStatus", query = "SELECT t FROM TbService t WHERE t.status = :status"),
    @NamedQuery(name = "TbService.findByCreatedAt", query = "SELECT t FROM TbService t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbService.findByUpdatedAt", query = "SELECT t FROM TbService t WHERE t.updatedAt = :updatedAt")})
public class TbService implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICE")
    private BigDecimal idService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "DESCPT")
    private String descpt;
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
    @JoinColumn(name = "ID_CAR", referencedColumnName = "ID_CAR")
    @ManyToOne(optional = false)
    private TbCar idCar;
    @JoinColumn(name = "ID_MECHANIC_SERVICE", referencedColumnName = "ID_MECHANIC_SERVICE")
    @ManyToOne(optional = false)
    private TbMechanicService idMechanicService;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idService")
    private Collection<TbBill> tbBillCollection;

    public TbService() {
    }

    public TbService(BigDecimal idService) {
        this.idService = idService;
    }

    public TbService(BigDecimal idService, String descpt, short status, Date createdAt) {
        this.idService = idService;
        this.descpt = descpt;
        this.status = status;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdService() {
        return idService;
    }

    public void setIdService(BigDecimal idService) {
        this.idService = idService;
    }

    public String getDescpt() {
        return descpt;
    }

    public void setDescpt(String descpt) {
        this.descpt = descpt;
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

    public TbCar getIdCar() {
        return idCar;
    }

    public void setIdCar(TbCar idCar) {
        this.idCar = idCar;
    }

    public TbMechanicService getIdMechanicService() {
        return idMechanicService;
    }

    public void setIdMechanicService(TbMechanicService idMechanicService) {
        this.idMechanicService = idMechanicService;
    }

    public Collection<TbBill> getTbBillCollection() {
        return tbBillCollection;
    }

    public void setTbBillCollection(Collection<TbBill> tbBillCollection) {
        this.tbBillCollection = tbBillCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idService != null ? idService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbService)) {
            return false;
        }
        TbService other = (TbService) object;
        if ((this.idService == null && other.idService != null) || (this.idService != null && !this.idService.equals(other.idService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbService[ idService=" + idService + " ]";
    }
    
}
