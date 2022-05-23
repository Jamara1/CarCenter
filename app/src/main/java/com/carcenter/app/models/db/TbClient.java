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
@Table(name = "TB_CLIENT")
@NamedQueries({
    @NamedQuery(name = "TbClient.findAll", query = "SELECT t FROM TbClient t"),
    @NamedQuery(name = "TbClient.findByIdClient", query = "SELECT t FROM TbClient t WHERE t.idClient = :idClient"),
    @NamedQuery(name = "TbClient.findByFirstName", query = "SELECT t FROM TbClient t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "TbClient.findByLastName", query = "SELECT t FROM TbClient t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "TbClient.findByFirstSurname", query = "SELECT t FROM TbClient t WHERE t.firstSurname = :firstSurname"),
    @NamedQuery(name = "TbClient.findBySecondSurname", query = "SELECT t FROM TbClient t WHERE t.secondSurname = :secondSurname"),
    @NamedQuery(name = "TbClient.findByDocumentNumber", query = "SELECT t FROM TbClient t WHERE t.documentNumber = :documentNumber"),
    @NamedQuery(name = "TbClient.findByCellphone", query = "SELECT t FROM TbClient t WHERE t.cellphone = :cellphone"),
    @NamedQuery(name = "TbClient.findByAddress", query = "SELECT t FROM TbClient t WHERE t.address = :address"),
    @NamedQuery(name = "TbClient.findByEmail", query = "SELECT t FROM TbClient t WHERE t.email = :email"),
    @NamedQuery(name = "TbClient.findByStatus", query = "SELECT t FROM TbClient t WHERE t.status = :status"),
    @NamedQuery(name = "TbClient.findByCreatedAt", query = "SELECT t FROM TbClient t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "TbClient.findByUpdatedAt", query = "SELECT t FROM TbClient t WHERE t.updatedAt = :updatedAt")})
public class TbClient implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENT")
    private BigDecimal idClient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 30)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRST_SURNAME")
    private String firstSurname;
    @Size(max = 30)
    @Column(name = "SECOND_SURNAME")
    private String secondSurname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENT_NUMBER")
    private BigInteger documentNumber;
    @Column(name = "CELLPHONE")
    private BigInteger cellphone;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<TbCar> tbCarCollection;
    @JoinColumn(name = "ID_DOCUMENT_TYPE", referencedColumnName = "ID_DOCUMENT_TYPE")
    @ManyToOne(optional = false)
    private TbDocumentType idDocumentType;

    public TbClient() {
    }

    public TbClient(BigDecimal idClient) {
        this.idClient = idClient;
    }

    public TbClient(BigDecimal idClient, String firstName, String firstSurname, BigInteger documentNumber, String email, short status, Date createdAt) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.firstSurname = firstSurname;
        this.documentNumber = documentNumber;
        this.email = email;
        this.status = status;
        this.createdAt = createdAt;
    }

    public BigDecimal getIdClient() {
        return idClient;
    }

    public void setIdClient(BigDecimal idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public BigInteger getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(BigInteger documentNumber) {
        this.documentNumber = documentNumber;
    }

    public BigInteger getCellphone() {
        return cellphone;
    }

    public void setCellphone(BigInteger cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Collection<TbCar> getTbCarCollection() {
        return tbCarCollection;
    }

    public void setTbCarCollection(Collection<TbCar> tbCarCollection) {
        this.tbCarCollection = tbCarCollection;
    }

    public TbDocumentType getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(TbDocumentType idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbClient)) {
            return false;
        }
        TbClient other = (TbClient) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.carcenter.app.models.db.TbClient[ idClient=" + idClient + " ]";
    }
    
}
