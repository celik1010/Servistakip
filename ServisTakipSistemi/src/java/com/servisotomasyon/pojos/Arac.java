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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SELİM
 */
@Entity
@Table(name = "arac")
@NamedQueries({
    @NamedQuery(name = "Arac.findAll", query = "SELECT a FROM Arac a")})
public class Arac implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aracNo")
    private List<Durakbiner> durakbinerList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "aracNo")
    private Integer aracNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "plaka")
    private String plaka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marka")
    private String marka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "model")
    private int model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sinif")
    private int sinif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kapasite")
    private int kapasite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "durum")
    private int durum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aracNo")
    private List<Sahip> sahipList;
    @JoinColumn(name = "sirketNo", referencedColumnName = "sirketNo")
    @ManyToOne
    private Sirket sirketNo;

    public Arac() {
    }

    public Arac(Integer aracNo) {
        this.aracNo = aracNo;
    }

    public Arac(Integer aracNo, String plaka, String marka, int model, int sinif, int kapasite, int durum) {
        this.aracNo = aracNo;
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.sinif = sinif;
        this.kapasite = kapasite;
        this.durum = durum;
    }

    public Integer getAracNo() {
        return aracNo;
    }

    public void setAracNo(Integer aracNo) {
        this.aracNo = aracNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getSinif() {
        return sinif;
    }

    public void setSinif(int sinif) {
        this.sinif = sinif;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }

    public List<Sahip> getSahipList() {
        return sahipList;
    }

    public void setSahipList(List<Sahip> sahipList) {
        this.sahipList = sahipList;
    }

    public Sirket getSirketNo() {
        return sirketNo;
    }

    public void setSirketNo(Sirket sirketNo) {
        this.sirketNo = sirketNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aracNo != null ? aracNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arac)) {
            return false;
        }
        Arac other = (Arac) object;
        if ((this.aracNo == null && other.aracNo != null) || (this.aracNo != null && !this.aracNo.equals(other.aracNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Arac[ aracNo=" + aracNo + " ]";
    }

    public List<Durakbiner> getDurakbinerList() {
        return durakbinerList;
    }

    public void setDurakbinerList(List<Durakbiner> durakbinerList) {
        this.durakbinerList = durakbinerList;
    }
    
}
