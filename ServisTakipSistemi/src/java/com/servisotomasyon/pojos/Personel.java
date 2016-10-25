/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servisotomasyon.pojos;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SELİM
 */
@Entity
@Table(name = "personel")
@NamedQueries({
    @NamedQuery(name = "Personel.findAll", query = "SELECT p FROM Personel p")})
public class Personel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "personelTc")
    private Long personelTc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "personelAd")
    private String personelAd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "personelSoyad")
    private String personelSoyad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ePosta")
    private String ePosta;
    @Column(name = "cinsiyet")
    private Integer cinsiyet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personelTc")
    private List<Durakbiner> durakbinerList;
    @JoinColumn(name = "sirketNo", referencedColumnName = "sirketNo")
    @ManyToOne(optional = false)
    private Sirket sirketNo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personel")
    private Adres adres;

    public Personel() {
    }

    public Personel(Long personelTc) {
        this.personelTc = personelTc;
    }

    public Personel(Long personelTc, String personelAd, String personelSoyad, String telefon, String ePosta) {
        this.personelTc = personelTc;
        this.personelAd = personelAd;
        this.personelSoyad = personelSoyad;
        this.telefon = telefon;
        this.ePosta = ePosta;
    }

    public Long getPersonelTc() {
        return personelTc;
    }

    public void setPersonelTc(Long personelTc) {
        this.personelTc = personelTc;
    }

    public String getPersonelAd() {
        return personelAd;
    }

    public void setPersonelAd(String personelAd) {
        this.personelAd = personelAd;
    }

    public String getPersonelSoyad() {
        return personelSoyad;
    }

    public void setPersonelSoyad(String personelSoyad) {
        this.personelSoyad = personelSoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEPosta() {
        return ePosta;
    }

    public void setEPosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public Integer getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Integer cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public List<Durakbiner> getDurakbinerList() {
        return durakbinerList;
    }

    public void setDurakbinerList(List<Durakbiner> durakbinerList) {
        this.durakbinerList = durakbinerList;
    }

    public Sirket getSirketNo() {
        return sirketNo;
    }

    public void setSirketNo(Sirket sirketNo) {
        this.sirketNo = sirketNo;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
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
        if (!(object instanceof Personel)) {
            return false;
        }
        Personel other = (Personel) object;
        if ((this.personelTc == null && other.personelTc != null) || (this.personelTc != null && !this.personelTc.equals(other.personelTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Personel[ personelTc=" + personelTc + " ]";
    }
    
}
