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
@Table(name = "durak")
@NamedQueries({
    @NamedQuery(name = "Durak.findAll", query = "SELECT d FROM Durak d")})
public class Durak implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "durakNo")
    private Integer durakNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "durakAd")
    private String durakAd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "aciklama")
    private String aciklama;
    @Basic(optional = false)
    @NotNull
    @Column(name = "konumX")
    private double konumX;
    @Basic(optional = false)
    @NotNull
    @Column(name = "konumY")
    private double konumY;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "durakNo")
    private List<GuzergahDurak> guzergahDurakList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "durakNo")
    private List<Durakbiner> durakbinerList;

    public Durak() {
    }

    public Durak(Integer durakNo) {
        this.durakNo = durakNo;
    }

    public Durak(Integer durakNo, String durakAd, String aciklama, double konumX, double konumY) {
        this.durakNo = durakNo;
        this.durakAd = durakAd;
        this.aciklama = aciklama;
        this.konumX = konumX;
        this.konumY = konumY;
    }

    public Integer getDurakNo() {
        return durakNo;
    }

    public void setDurakNo(Integer durakNo) {
        this.durakNo = durakNo;
    }

    public String getDurakAd() {
        return durakAd;
    }

    public void setDurakAd(String durakAd) {
        this.durakAd = durakAd;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public double getKonumX() {
        return konumX;
    }

    public void setKonumX(double konumX) {
        this.konumX = konumX;
    }

    public double getKonumY() {
        return konumY;
    }

    public void setKonumY(double konumY) {
        this.konumY = konumY;
    }

    public List<GuzergahDurak> getGuzergahDurakList() {
        return guzergahDurakList;
    }

    public void setGuzergahDurakList(List<GuzergahDurak> guzergahDurakList) {
        this.guzergahDurakList = guzergahDurakList;
    }

    public List<Durakbiner> getDurakbinerList() {
        return durakbinerList;
    }

    public void setDurakbinerList(List<Durakbiner> durakbinerList) {
        this.durakbinerList = durakbinerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (durakNo != null ? durakNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Durak)) {
            return false;
        }
        Durak other = (Durak) object;
        if ((this.durakNo == null && other.durakNo != null) || (this.durakNo != null && !this.durakNo.equals(other.durakNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Durak[ durakNo=" + durakNo + " ]";
    }
    
}
