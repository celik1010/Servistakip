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
@Table(name = "sofor")
@NamedQueries({
    @NamedQuery(name = "Sofor.findAll", query = "SELECT s FROM Sofor s")})
public class Sofor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "soforTc")
    private String soforTc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "soforAd")
    private String soforAd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "soforSoyad")
    private String soforSoyad;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soforTc")
    private List<SoforArac> soforAracList;

    public Sofor() {
    }

    public Sofor(String soforTc) {
        this.soforTc = soforTc;
    }

    public Sofor(String soforTc, String soforAd, String soforSoyad, String tel1, String tel2) {
        this.soforTc = soforTc;
        this.soforAd = soforAd;
        this.soforSoyad = soforSoyad;
        this.tel1 = tel1;
        this.tel2 = tel2;
    }

    public String getSoforTc() {
        return soforTc;
    }

    public void setSoforTc(String soforTc) {
        this.soforTc = soforTc;
    }

    public String getSoforAd() {
        return soforAd;
    }

    public void setSoforAd(String soforAd) {
        this.soforAd = soforAd;
    }

    public String getSoforSoyad() {
        return soforSoyad;
    }

    public void setSoforSoyad(String soforSoyad) {
        this.soforSoyad = soforSoyad;
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

    public List<SoforArac> getSoforAracList() {
        return soforAracList;
    }

    public void setSoforAracList(List<SoforArac> soforAracList) {
        this.soforAracList = soforAracList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soforTc != null ? soforTc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sofor)) {
            return false;
        }
        Sofor other = (Sofor) object;
        if ((this.soforTc == null && other.soforTc != null) || (this.soforTc != null && !this.soforTc.equals(other.soforTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Sofor[ soforTc=" + soforTc + " ]";
    }
    
}
