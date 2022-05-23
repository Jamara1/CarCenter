/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carcenter.app.models.db;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;

/**
 *
 * @author jamar
 */
@Entity
@Table(name = "TB_INCIDENCE")
@NamedQueries({
    @NamedQuery(name = "TbIncidence.findAll", query = "SELECT t FROM TbIncidence t"),
    @NamedQuery(name = "TbIncidence.findByIdIncidence", query = "SELECT t FROM TbIncidence t WHERE t.idIncidence = :idIncidence"),
    @NamedQuery(name = "TbIncidence.findByPhoto", query = "SELECT t FROM TbIncidence t WHERE t.photo = :photo"),
    @NamedQuery(name = "TbIncidence.findByCreatedAt", query = "SELECT t FROM TbIncidence t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbIncidence.findByUpdatedAt", query = "SELECT t FROM TbIncidence t WHERE t.updatedAt = :updatedAt")})
public class TbIncidence implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INCIDENCE")
    private BigDecimal idIncidence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PHOTO")
    private String photo;
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

    public TbIncidence() {
    }

    public TbIncidence(BigDecimal idIncidence) {
        this.idIncidence = idIncidence;
    }

    public TbIncidence(BigDecimal idIncidence, String photo, Date createdAt) {
        this.idIncidence = idIncidence;
        this.photo = photo;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdIncidence() {
        return idIncidence;
    }

    public void setIdIncidence(BigDecimal idIncidence) {
        this.idIncidence = idIncidence;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncidence != null ? idIncidence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbIncidence)) {
            return false;
        }
        TbIncidence other = (TbIncidence) object;
        if ((this.idIncidence == null && other.idIncidence != null) || (this.idIncidence != null && !this.idIncidence.equals(other.idIncidence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbIncidence[ idIncidence=" + idIncidence + " ]";
    }
    
}
