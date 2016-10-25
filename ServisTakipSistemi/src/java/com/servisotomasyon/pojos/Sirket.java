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
@Table(name = "sirket")
@NamedQueries({
    @NamedQuery(name = "Sirket.findAll", query = "SELECT s FROM Sirket s")})
public class Sirket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sirketNo")
    private Integer sirketNo;
    @Size(max = 50)
    @Column(name = "ePosta")
    private String ePosta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "parola")
    private String parola;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sirketAdi")
    private String sirketAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefon")
    private String telefon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sirketNo")
    private List<Personel> personelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sirketNo")
    private List<Arac> aracList;

    public Sirket() {
    }

    public Sirket(Integer sirketNo) {
        this.sirketNo = sirketNo;
    }

    public Sirket(Integer sirketNo, String parola, String sirketAdi, String telefon) {
        this.sirketNo = sirketNo;
        this.parola = parola;
        this.sirketAdi = sirketAdi;
        this.telefon = telefon;
    }

    public Integer getSirketNo() {
        return sirketNo;
    }

    public void setSirketNo(Integer sirketNo) {
        this.sirketNo = sirketNo;
    }

    public String getEPosta() {
        return ePosta;
    }

    public void setEPosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Personel> getPersonelList() {
        return personelList;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }

    public List<Arac> getAracList() {
        return aracList;
    }

    public void setAracList(List<Arac> aracList) {
        this.aracList = aracList;
    }
}
