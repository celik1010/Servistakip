/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servisotomasyon.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SELİM
 */
@Entity
@Table(name = "sefer_baslar")
@NamedQueries({
    @NamedQuery(name = "SeferBaslar.findAll", query = "SELECT s FROM SeferBaslar s")})
public class SeferBaslar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seferBaslarNo")
    private Integer seferBaslarNo;
    @Column(name = "basTarih")
    @Temporal(TemporalType.DATE)
    private Date basTarih;
    @Column(name = "bitTarih")
    @Temporal(TemporalType.DATE)
    private Date bitTarih;
    @Column(name = "saat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date saat;
    @JoinColumn(name = "seferNo", referencedColumnName = "seferNo")
    @ManyToOne(optional = false)
    private Sefer seferNo;
    @JoinColumn(name = "guzergahNo", referencedColumnName = "guzergahNo")
    @ManyToOne(optional = false)
    private Guzergah guzergahNo;
    @JoinColumn(name = "aracNo", referencedColumnName = "aracNo")
    @ManyToOne(optional = false)
    private Arac aracNo;

    public SeferBaslar() {
    }

    public SeferBaslar(Integer seferBaslarNo) {
        this.seferBaslarNo = seferBaslarNo;
    }

    public Integer getSeferBaslarNo() {
        return seferBaslarNo;
    }

    public void setSeferBaslarNo(Integer seferBaslarNo) {
        this.seferBaslarNo = seferBaslarNo;
    }

    public Date getBasTarih() {
        return basTarih;
    }

    public void setBasTarih(Date basTarih) {
        this.basTarih = basTarih;
    }

    public Date getBitTarih() {
        return bitTarih;
    }

    public void setBitTarih(Date bitTarih) {
        this.bitTarih = bitTarih;
    }

    public Date getSaat() {
        return saat;
    }

    public void setSaat(Date saat) {
        this.saat = saat;
    }

    public Sefer getSeferNo() {
        return seferNo;
    }

    public void setSeferNo(Sefer seferNo) {
        this.seferNo = seferNo;
    }

    public Guzergah getGuzergahNo() {
        return guzergahNo;
    }

    public void setGuzergahNo(Guzergah guzergahNo) {
        this.guzergahNo = guzergahNo;
    }

    public Arac getAracNo() {
        return aracNo;
    }

    public void setAracNo(Arac aracNo) {
        this.aracNo = aracNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seferBaslarNo != null ? seferBaslarNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeferBaslar)) {
            return false;
        }
        SeferBaslar other = (SeferBaslar) object;
        if ((this.seferBaslarNo == null && other.seferBaslarNo != null) || (this.seferBaslarNo != null && !this.seferBaslarNo.equals(other.seferBaslarNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.SeferBaslar[ seferBaslarNo=" + seferBaslarNo + " ]";
    }
    
}
