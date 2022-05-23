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
@Table(name = "TB_DOCUMENT_TYPE")
@NamedQueries({
    @NamedQuery(name = "TbDocumentType.findAll", query = "SELECT t FROM TbDocumentType t"),
    @NamedQuery(name = "TbDocumentType.findByIdDocumentType", query = "SELECT t FROM TbDocumentType t WHERE t.idDocumentType = :idDocumentType"),
    @NamedQuery(name = "TbDocumentType.findByName", query = "SELECT t FROM TbDocumentType t WHERE t.name = :name"),
    @NamedQuery(name = "TbDocumentType.findByCreatedAt", query = "SELECT t FROM TbDocumentType t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbDocumentType.findByUpdatedAt", query = "SELECT t FROM TbDocumentType t WHERE t.updatedAt = :updatedAt")})
public class TbDocumentType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCUMENT_TYPE")
    private BigDecimal idDocumentType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumentType")
    private Collection<TbMechanic> tbMechanicCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumentType")
    private Collection<TbClient> tbClientCollection;

    public TbDocumentType() {
    }

    public TbDocumentType(BigDecimal idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public TbDocumentType(BigDecimal idDocumentType, String name, Date createdAt) {
        this.idDocumentType = idDocumentType;
        this.name = name;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(BigDecimal idDocumentType) {
        this.idDocumentType = idDocumentType;
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

    public Collection<TbMechanic> getTbMechanicCollection() {
        return tbMechanicCollection;
    }

    public void setTbMechanicCollection(Collection<TbMechanic> tbMechanicCollection) {
        this.tbMechanicCollection = tbMechanicCollection;
    }

    public Collection<TbClient> getTbClientCollection() {
        return tbClientCollection;
    }

    public void setTbClientCollection(Collection<TbClient> tbClientCollection) {
        this.tbClientCollection = tbClientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentType != null ? idDocumentType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDocumentType)) {
            return false;
        }
        TbDocumentType other = (TbDocumentType) object;
        if ((this.idDocumentType == null && other.idDocumentType != null) || (this.idDocumentType != null && !this.idDocumentType.equals(other.idDocumentType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbDocumentType[ idDocumentType=" + idDocumentType + " ]";
    }
    
}
