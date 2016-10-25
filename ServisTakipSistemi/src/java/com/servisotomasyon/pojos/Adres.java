/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servisotomasyon.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SELİM
 */
@Entity
@Table(name = "adres")
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")})
public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "personelTc")
    private Long personelTc;
    @Size(max = 50)
    @Column(name = "il")
    private String il;
    @Size(max = 50)
    @Column(name = "ilce")
    private String ilce;
    @Size(max = 50)
    @Column(name = "mahalle")
    private String mahalle;
    @Size(max = 50)
    @Column(name = "sokak")
    private String sokak;
    @Size(max = 50)
    @Column(name = "cadde")
    private String cadde;
    @Size(max = 50)
    @Column(name = "apartman")
    private String apartman;
    @Column(name = "daireNo")
    private Integer daireNo;
    @JoinColumn(name = "personelTc", referencedColumnName = "personelTc", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personel personel;

    public Adres() {
    }

    public Adres(Long personelTc) {
        this.personelTc = personelTc;
    }

    public Long getPersonelTc() {
        return personelTc;
    }

    public void setPersonelTc(Long personelTc) {
        this.personelTc = personelTc;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public String getCadde() {
        return cadde;
    }

    public void setCadde(String cadde) {
        this.cadde = cadde;
    }

    public String getApartman() {
        return apartman;
    }

    public void setApartman(String apartman) {
        this.apartman = apartman;
    }

    public Integer getDaireNo() {
        return daireNo;
    }

    public void setDaireNo(Integer daireNo) {
        this.daireNo = daireNo;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personelTc != null ? personelTc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.personelTc == null && other.personelTc != null) || (this.personelTc != null && !this.personelTc.equals(other.personelTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Adres[ personelTc=" + personelTc + " ]";
    }
    
}
