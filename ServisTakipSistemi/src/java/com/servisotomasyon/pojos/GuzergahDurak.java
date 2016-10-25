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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SELİM
 */
@Entity
@Table(name = "guzergah_durak")
@NamedQueries({
    @NamedQuery(name = "GuzergahDurak.findAll", query = "SELECT g FROM GuzergahDurak g")})
public class GuzergahDurak implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "guzergahDurakNo")
    private Integer guzergahDurakNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "durakSirasi")
    private int durakSirasi;  
    @JoinColumn(name = "durakNo", referencedColumnName = "durakNo")
    @ManyToOne(optional = false)
    private Durak durakNo;
    @JoinColumn(name = "guzergahNo", referencedColumnName = "guzergahNo")
    @ManyToOne(optional = false)
    private Guzergah guzergahNo;

    public GuzergahDurak() {
    }

    public GuzergahDurak(Integer guzergahDurakNo) {
        this.guzergahDurakNo = guzergahDurakNo;
    }

    public GuzergahDurak(Integer guzergahDurakNo, int durakSirasi, int durakMi) {
        this.guzergahDurakNo = guzergahDurakNo;
        this.durakSirasi = durakSirasi;
    }

    public Integer getGuzergahDurakNo() {
        return guzergahDurakNo;
    }

    public void setGuzergahDurakNo(Integer guzergahDurakNo) {
        this.guzergahDurakNo = guzergahDurakNo;
    }

    public int getDurakSirasi() {
        return durakSirasi;
    }

    public void setDurakSirasi(int durakSirasi) {
        this.durakSirasi = durakSirasi;
    }

    public Durak getDurakNo() {
        return durakNo;
    }

    public void setDurakNo(Durak durakNo) {
        this.durakNo = durakNo;
    }

    public Guzergah getGuzergahNo() {
        return guzergahNo;
    }

    public void setGuzergahNo(Guzergah guzergahNo) {
        this.guzergahNo = guzergahNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guzergahDurakNo != null ? guzergahDurakNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuzergahDurak)) {
            return false;
        }
        GuzergahDurak other = (GuzergahDurak) object;
        if ((this.guzergahDurakNo == null && other.guzergahDurakNo != null) || (this.guzergahDurakNo != null && !this.guzergahDurakNo.equals(other.guzergahDurakNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.GuzergahDurak[ guzergahDurakNo=" + guzergahDurakNo + " ]";
    }

    public void setGuzergahNo(Integer guzergahNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
