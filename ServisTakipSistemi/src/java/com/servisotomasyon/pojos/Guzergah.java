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
@Table(name = "guzergah")
@NamedQueries({
    @NamedQuery(name = "Guzergah.findAll", query = "SELECT g FROM Guzergah g")})
public class Guzergah implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guzergahNo")
    private List<Guzergahkonumlari> guzergahkonumlariList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "guzergahNo")
    private Integer guzergahNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "guzergahAd")
    private String guzergahAd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guzergahNo")
    private List<GuzergahDurak> guzergahDurakList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guzergahNo")
    private List<SeferBaslar> seferBaslarList;

    public Guzergah() {
    }

    public Guzergah(Integer guzergahNo) {
        this.guzergahNo = guzergahNo;
    }

    public Guzergah(Integer guzergahNo, String guzergahAd) {
        this.guzergahNo = guzergahNo;
        this.guzergahAd = guzergahAd;
    }

    public Integer getGuzergahNo() {
        return guzergahNo;
    }

    public void setGuzergahNo(Integer guzergahNo) {
        this.guzergahNo = guzergahNo;
    }

    public String getGuzergahAd() {
        return guzergahAd;
    }

    public void setGuzergahAd(String guzergahAd) {
        this.guzergahAd = guzergahAd;
    }

    public List<GuzergahDurak> getGuzergahDurakList() {
        return guzergahDurakList;
    }

    public void setGuzergahDurakList(List<GuzergahDurak> guzergahDurakList) {
        this.guzergahDurakList = guzergahDurakList;
    }

    public List<SeferBaslar> getSeferBaslarList() {
        return seferBaslarList;
    }

    public void setSeferBaslarList(List<SeferBaslar> seferBaslarList) {
        this.seferBaslarList = seferBaslarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guzergahNo != null ? guzergahNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guzergah)) {
            return false;
        }
        Guzergah other = (Guzergah) object;
        if ((this.guzergahNo == null && other.guzergahNo != null) || (this.guzergahNo != null && !this.guzergahNo.equals(other.guzergahNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Guzergah[ guzergahNo=" + guzergahNo + " ]";
    }

    public List<Guzergahkonumlari> getGuzergahkonumlariList() {
        return guzergahkonumlariList;
    }

    public void setGuzergahkonumlariList(List<Guzergahkonumlari> guzergahkonumlariList) {
        this.guzergahkonumlariList = guzergahkonumlariList;
    }
    
}
