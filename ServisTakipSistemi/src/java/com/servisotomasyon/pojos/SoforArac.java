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
@Table(name = "sofor_arac")
@NamedQueries({
    @NamedQuery(name = "SoforArac.findAll", query = "SELECT s FROM SoforArac s")})
public class SoforArac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "soforAracNo")
    private Integer soforAracNo;
    @Column(name = "basTarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date basTarih;
    @Column(name = "bitTarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bitTarih;
    @JoinColumn(name = "soforTc", referencedColumnName = "soforTc")
    @ManyToOne(optional = false)
    private Sofor soforTc;
    @JoinColumn(name = "aracNo", referencedColumnName = "aracNo")
    @ManyToOne(optional = false)
    private Arac aracNo;

    public SoforArac() {
    }

    public SoforArac(Integer soforAracNo) {
        this.soforAracNo = soforAracNo;
    }

    public Integer getSoforAracNo() {
        return soforAracNo;
    }

    public void setSoforAracNo(Integer soforAracNo) {
        this.soforAracNo = soforAracNo;
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

    public Sofor getSoforTc() {
        return soforTc;
    }

    public void setSoforTc(Sofor soforTc) {
        this.soforTc = soforTc;
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
        hash += (soforAracNo != null ? soforAracNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoforArac)) {
            return false;
        }
        SoforArac other = (SoforArac) object;
        if ((this.soforAracNo == null && other.soforAracNo != null) || (this.soforAracNo != null && !this.soforAracNo.equals(other.soforAracNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.SoforArac[ soforAracNo=" + soforAracNo + " ]";
    }
    
}
