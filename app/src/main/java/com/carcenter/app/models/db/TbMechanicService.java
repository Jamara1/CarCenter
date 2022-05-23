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

/**
 *
 * @author jamar
 */
@Entity
@Table(name = "TB_MECHANIC_SERVICE")
@NamedQueries({
    @NamedQuery(name = "TbMechanicService.findAll", query = "SELECT t FROM TbMechanicService t"),
    @NamedQuery(name = "TbMechanicService.findByIdMechanicService", query = "SELECT t FROM TbMechanicService t WHERE t.idMechanicService = :idMechanicService"),
    @NamedQuery(name = "TbMechanicService.findByCreatedAt", query = "SELECT t FROM TbMechanicService t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbMechanicService.findByUpdatedAt", query = "SELECT t FROM TbMechanicService t WHERE t.updatedAt = :updatedAt")})
public class TbMechanicService implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MECHANIC_SERVICE")
    private BigDecimal idMechanicService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "ID_MECHANIC", referencedColumnName = "ID_MECHANIC")
    @ManyToOne(optional = false)
    private TbMechanic idMechanic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMechanicService")
    private Collection<TbService> tbServiceCollection;

    public TbMechanicService() {
    }

    public TbMechanicService(BigDecimal idMechanicService) {
        this.idMechanicService = idMechanicService;
    }

    public TbMechanicService(BigDecimal idMechanicService, Date createdAt) {
        this.idMechanicService = idMechanicService;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdMechanicService() {
        return idMechanicService;
    }

    public void setIdMechanicService(BigDecimal idMechanicService) {
        this.idMechanicService = idMechanicService;
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

    public TbMechanic getIdMechanic() {
        return idMechanic;
    }

    public void setIdMechanic(TbMechanic idMechanic) {
        this.idMechanic = idMechanic;
    }

    public Collection<TbService> getTbServiceCollection() {
        return tbServiceCollection;
    }

    public void setTbServiceCollection(Collection<TbService> tbServiceCollection) {
        this.tbServiceCollection = tbServiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMechanicService != null ? idMechanicService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMechanicService)) {
            return false;
        }
        TbMechanicService other = (TbMechanicService) object;
        if ((this.idMechanicService == null && other.idMechanicService != null) || (this.idMechanicService != null && !this.idMechanicService.equals(other.idMechanicService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbMechanicService[ idMechanicService=" + idMechanicService + " ]";
    }
    
}
