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
import javax.validation.constraints.NotNull;

/**
 *
 * @author SELİM
 */
@Entity
@Table(name = "durakbiner")
@NamedQueries({
    @NamedQuery(name = "Durakbiner.findAll", query = "SELECT d FROM Durakbiner d")})
public class Durakbiner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "durakBinerNo")
    private Integer durakBinerNo;
    @Column(name = "basTarih")
    @Temporal(TemporalType.DATE)
    private Date basTarih;
    @Column(name = "bitTarih")
    @Temporal(TemporalType.DATE)
    private Date bitTarih;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saati")
    @Temporal(TemporalType.DATE)
    private Date saati;
    @JoinColumn(name = "aracNo", referencedColumnName = "aracNo")
    @ManyToOne(optional = false)
    private Arac aracNo;
    @JoinColumn(name = "durakNo", referencedColumnName = "durakNo")
    @ManyToOne(optional = false)
    private Durak durakNo;
    @JoinColumn(name = "personelTc", referencedColumnName = "personelTc")
    @ManyToOne(optional = false)
    private Personel personelTc;

    public Durakbiner() {
    }

    public Durakbiner(Integer durakBinerNo) {
        this.durakBinerNo = durakBinerNo;
    }

    public Durakbiner(Integer durakBinerNo, Date saati) {
        this.durakBinerNo = durakBinerNo;
        this.saati = saati;
    }

    public Integer getDurakBinerNo() {
        return durakBinerNo;
    }

    public void setDurakBinerNo(Integer durakBinerNo) {
        this.durakBinerNo = durakBinerNo;
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

    public Date getSaati() {
        return saati;
    }

    public void setSaati(Date saati) {
        this.saati = saati;
    }

    public Arac getAracNo() {
        return aracNo;
    }

    public void setAracNo(Arac aracNo) {
        this.aracNo = aracNo;
    }

    public Durak getDurakNo() {
        return durakNo;
    }

    public void setDurakNo(Durak durakNo) {
        this.durakNo = durakNo;
    }

    public Personel getPersonelTc() {
        return personelTc;
    }

    public void setPersonelTc(Personel personelTc) {
        this.personelTc = personelTc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (durakBinerNo != null ? durakBinerNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Durakbiner)) {
            return false;
        }
        Durakbiner other = (Durakbiner) object;
        if ((this.durakBinerNo == null && other.durakBinerNo != null) || (this.durakBinerNo != null && !this.durakBinerNo.equals(other.durakBinerNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Durakbiner[ durakBinerNo=" + durakBinerNo + " ]";
    }
    
}
