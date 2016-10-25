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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SELİM
 */
@Entity
@Table(name = "sahip")
@NamedQueries({
    @NamedQuery(name = "Sahip.findAll", query = "SELECT s FROM Sahip s")})
public class Sahip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sahipTc")
    private Long sahipTc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sahipAd")
    private String sahipAd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sahipSoyad")
    private String sahipSoyad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tel1")
    private String tel1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tel2")
    private String tel2;
    @JoinColumn(name = "aracNo", referencedColumnName = "aracNo")
    @ManyToOne(optional = false)
    private Arac aracNo;

    public Sahip() {
    }

    public Sahip(Long sahipTc) {
        this.sahipTc = sahipTc;
    }

    public Sahip(Long sahipTc, String sahipAd, String sahipSoyad, String tel1, String tel2) {
        this.sahipTc = sahipTc;
        this.sahipAd = sahipAd;
        this.sahipSoyad = sahipSoyad;
        this.tel1 = tel1;
        this.tel2 = tel2;
    }

    public Long getSahipTc() {
        return sahipTc;
    }

    public void setSahipTc(Long sahipTc) {
        this.sahipTc = sahipTc;
    }

    public String getSahipAd() {
        return sahipAd;
    }

    public void setSahipAd(String sahipAd) {
        this.sahipAd = sahipAd;
    }

    public String getSahipSoyad() {
        return sahipSoyad;
    }

    public void setSahipSoyad(String sahipSoyad) {
        this.sahipSoyad = sahipSoyad;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
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
        hash += (sahipTc != null ? sahipTc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sahip)) {
            return false;
        }
        Sahip other = (Sahip) object;
        if ((this.sahipTc == null && other.sahipTc != null) || (this.sahipTc != null && !this.sahipTc.equals(other.sahipTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Sahip[ sahipTc=" + sahipTc + " ]";
    }
    
}
