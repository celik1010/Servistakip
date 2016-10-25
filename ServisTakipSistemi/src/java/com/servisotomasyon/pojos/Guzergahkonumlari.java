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
@Table(name = "guzergahkonumlari")
@NamedQueries({
    @NamedQuery(name = "Guzergahkonumlari.findAll", query = "SELECT g FROM Guzergahkonumlari g")})
public class Guzergahkonumlari implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "konumlarNo")
    private Integer konumlarNo;
    @Basic(optional = false)    
    @Column(name = "konumSira")
    private int konumSira;
    @Basic(optional = false)
    @NotNull
    @Column(name = "konumX")
    private double konumX;
    @Basic(optional = false)
    @NotNull
    @Column(name = "konumY")
    private double konumY;
    @JoinColumn(name = "guzergahNo", referencedColumnName = "guzergahNo")
    @ManyToOne(optional = false)
    private Guzergah guzergahNo;

    public Guzergahkonumlari() {
    }

    public Guzergahkonumlari(Integer konumlarNo) {
        this.konumlarNo = konumlarNo;
    }

    public Guzergahkonumlari(Integer konumlarNo, int konumSira, double konumX, double konumY) {
        this.konumlarNo = konumlarNo;
        this.konumSira = konumSira;
        this.konumX = konumX;
        this.konumY = konumY;
    }

    public Integer getKonumlarNo() {
        return konumlarNo;
    }

    public void setKonumlarNo(Integer konumlarNo) {
        this.konumlarNo = konumlarNo;
    }

    public int getKonumSira() {
        return konumSira;
    }

    public void setKonumSira(int konumSira) {
        this.konumSira = konumSira;
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

    public Guzergah getGuzergahNo() {
        return guzergahNo;
    }

    public void setGuzergahNo(Guzergah guzergahNo) {
        this.guzergahNo = guzergahNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (konumlarNo != null ? konumlarNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guzergahkonumlari)) {
            return false;
        }
        Guzergahkonumlari other = (Guzergahkonumlari) object;
        if ((this.konumlarNo == null && other.konumlarNo != null) || (this.konumlarNo != null && !this.konumlarNo.equals(other.konumlarNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Guzergahkonumlari[ konumlarNo=" + konumlarNo + " ]";
    }

    public void setGuzergahNo(Integer guzergahNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
