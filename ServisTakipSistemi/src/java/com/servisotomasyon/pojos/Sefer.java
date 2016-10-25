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
@Table(name = "sefer")
@NamedQueries({
    @NamedQuery(name = "Sefer.findAll", query = "SELECT s FROM Sefer s")})
public class Sefer implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seferNo")
    private List<SeferBaslar> seferBaslarList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "seferNo")
    private Integer seferNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "seferAd")
    private String seferAd;

    public Sefer() {
    }

    public Sefer(Integer seferNo) {
        this.seferNo = seferNo;
    }

    public Sefer(Integer seferNo, String seferAd) {
        this.seferNo = seferNo;
        this.seferAd = seferAd;
    }

    public Integer getSeferNo() {
        return seferNo;
    }

    public void setSeferNo(Integer seferNo) {
        this.seferNo = seferNo;
    }

    public String getSeferAd() {
        return seferAd;
    }

    public void setSeferAd(String seferAd) {
        this.seferAd = seferAd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seferNo != null ? seferNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sefer)) {
            return false;
        }
        Sefer other = (Sefer) object;
        if ((this.seferNo == null && other.seferNo != null) || (this.seferNo != null && !this.seferNo.equals(other.seferNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Sefer[ seferNo=" + seferNo + " ]";
    }

    public List<SeferBaslar> getSeferBaslarList() {
        return seferBaslarList;
    }

    public void setSeferBaslarList(List<SeferBaslar> seferBaslarList) {
        this.seferBaslarList = seferBaslarList;
    }
    
}
