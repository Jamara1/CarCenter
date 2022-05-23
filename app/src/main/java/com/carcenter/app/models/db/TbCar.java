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
import javax.validation.constraints.Size;

/**
 *
 * @author jamar
 */
@Entity
@Table(name = "TB_CAR")
@NamedQueries({
    @NamedQuery(name = "TbCar.findAll", query = "SELECT t FROM TbCar t"),
    @NamedQuery(name = "TbCar.findByIdCar", query = "SELECT t FROM TbCar t WHERE t.idCar = :idCar"),
    @NamedQuery(name = "TbCar.findByPlaca", query = "SELECT t FROM TbCar t WHERE t.placa = :placa"),
    @NamedQuery(name = "TbCar.findByBrand", query = "SELECT t FROM TbCar t WHERE t.brand = :brand"),
    @NamedQuery(name = "TbCar.findByModel", query = "SELECT t FROM TbCar t WHERE t.model = :model"),
    @NamedQuery(name = "TbCar.findByYear", query = "SELECT t FROM TbCar t WHERE t.year = :year"),
    @NamedQuery(name = "TbCar.findByStatus", query = "SELECT t FROM TbCar t WHERE t.status = :status"),
    @NamedQuery(name = "TbCar.findByCreatedAt", query = "SELECT t FROM TbCar t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbCar.findByUpdatedAt", query = "SELECT t FROM TbCar t WHERE t.updatedAt = :updatedAt")})
public class TbCar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CAR")
    private BigDecimal idCar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BRAND")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YEAR")
    private BigInteger year;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCar")
    private Collection<TbIncidence> tbIncidenceCollection;
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
    @ManyToOne(optional = false)
    private TbClient idClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCar")
    private Collection<TbService> tbServiceCollection;

    public TbCar() {
    }

    public TbCar(BigDecimal idCar) {
        this.idCar = idCar;
    }

    public TbCar(BigDecimal idCar, String placa, String brand, String model, BigInteger year, short status, Date createdAt) {
        this.idCar = idCar;
        this.placa = placa;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.status = status;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdCar() {
        return idCar;
    }

    public void setIdCar(BigDecimal idCar) {
        this.idCar = idCar;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getYear() {
        return year;
    }

    public void setYear(BigInteger year) {
        this.year = year;
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

    public Collection<TbIncidence> getTbIncidenceCollection() {
        return tbIncidenceCollection;
    }

    public void setTbIncidenceCollection(Collection<TbIncidence> tbIncidenceCollection) {
        this.tbIncidenceCollection = tbIncidenceCollection;
    }

    public TbClient getIdClient() {
        return idClient;
    }

    public void setIdClient(TbClient idClient) {
        this.idClient = idClient;
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
        hash += (idCar != null ? idCar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCar)) {
            return false;
        }
        TbCar other = (TbCar) object;
        if ((this.idCar == null && other.idCar != null) || (this.idCar != null && !this.idCar.equals(other.idCar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbCar[ idCar=" + idCar + " ]";
    }
    
}
