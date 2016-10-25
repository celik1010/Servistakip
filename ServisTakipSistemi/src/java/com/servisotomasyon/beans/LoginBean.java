package com.servisotomasyon.beans;

import com.servisotomasyon.javas.Util;
import com.servisotomasyon.database.DBDurakBiner;
import com.servisotomasyon.database.DBPersonel;
import com.servisotomasyon.database.GenelCRUD;
import com.servisotomasyon.database.HibernateUtil;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Durakbiner;
import com.servisotomasyon.pojos.Sirket;

@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {

    private Integer sirketNo;
    private String parola, sirketAdi, sirketMail, telefon;
    private List<Sirket> liste;
    Sirket sirket;

    private Long personelTc;
    private String personelAdi, personelSoyadi, personelTelefon, personelMail;
    private String il, ilce, mahalle, cadde, sokak, apartman;
    private Integer daireNo, durakNo, aracNo, cinsiyet;
    private Date basTarih, bitTarih, saat;

    DBPersonel dBPersonel = new DBPersonel();
    DBDurakBiner dbDurakBiner=new DBDurakBiner();

    public LoginBean() {
    }

    public void personelSorgula() {
        personelAdi = dBPersonel.select(personelTc).getPersonelAd();
        personelSoyadi = dBPersonel.select(personelTc).getPersonelSoyad();
        personelMail = dBPersonel.select(personelTc).getEPosta();
        personelTelefon = dBPersonel.select(personelTc).getTelefon();
        cinsiyet = dBPersonel.select(personelTc).getCinsiyet();
        il = dBPersonel.select(personelTc).getAdres().getIl();
        ilce = dBPersonel.select(personelTc).getAdres().getIlce();
//        durakNo=(dbDurakBiner.select(personelTc).getDurakNo()).getDurakNo();
    }

    /**
     * *************** LOGİN METOD ***************
     */
    public String login() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Sirket.class);

        cr.add(Restrictions.eq("sirketNo", sirketNo));
        cr.add(Restrictions.eq("parola", parola));

        liste = cr.list();
        session.getTransaction().commit();
        session.close();

        if (!liste.isEmpty()) {
            HttpSession httpSession = Util.getSession();
            httpSession.setAttribute("sirketNo", liste.get(0).getSirketNo());
            httpSession.setAttribute("sirketAdi", liste.get(0).getSirketAdi());
            httpSession.setAttribute("ePosta", liste.get(0).getEPosta());
            httpSession.setAttribute("telefon", liste.get(0).getTelefon());

            return "Anasayfa?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tekrar Deneyiniz", "Şirket No yada Parola yanlış."));
            return "index";
        }
    }

    /**
     * *********LOGOUT METOD **********
     */
    public String logout() {
        HttpSession hs = Util.getSession();
        hs.invalidate();
        return "index?faces-redirect=true";
    }

    /**
     * *********ŞİRKET INSERT METOD *********
     */
    public void sirketEkle() {

    }

    /**
     * *********ŞİRKET UPDATE METOD *********
     */
    public void sirketUpdate() {
        sirket = new Sirket();
        sirket.setSirketAdi(sirketAdi);
        sirket.setEPosta(sirketMail);
        sirket.setTelefon(telefon);
        GenelCRUD genelCRUD = new GenelCRUD();
        genelCRUD.update(this.sirket);
    }

//    public void sirketNoBelirle()
//    {
//        Random random=new Random();
//        Integer sayi=random.nextInt((10000-1000)+1)+1000;
//        setSirketNo(sayi);
//    }
    public List<Sirket> getListe() {
        return liste;
    }

    public Integer getSirketNo() {
        return sirketNo;
    }

    public void setSirketNo(Integer sirketNo) {
        this.sirketNo = sirketNo;
    }

    public void setSirketNo(int sirketNo) {
        this.sirketNo = sirketNo;
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

    public String getSirketMail() {
        return sirketMail;
    }

    public void setSirketMail(String sirketMail) {
        this.sirketMail = sirketMail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public Long getPersonelTc() {
        return personelTc;
    }

    public void setPersonelTc(Long personelTc) {
        this.personelTc = personelTc;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    public String getPersonelSoyadi() {
        return personelSoyadi;
    }

    public void setPersonelSoyadi(String personelSoyadi) {
        this.personelSoyadi = personelSoyadi;
    }

    public String getPersonelTelefon() {
        return personelTelefon;
    }

    public void setPersonelTelefon(String personelTelefon) {
        this.personelTelefon = personelTelefon;
    }

    public String getPersonelMail() {
        return personelMail;
    }

    public void setPersonelMail(String personelMail) {
        this.personelMail = personelMail;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getCadde() {
        return cadde;
    }

    public void setCadde(String cadde) {
        this.cadde = cadde;
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public String getApartman() {
        return apartman;
    }

    public void setApartman(String apartman) {
        this.apartman = apartman;
    }

    public Integer getDaireNo() {
        return daireNo;
    }

    public void setDaireNo(Integer daireNo) {
        this.daireNo = daireNo;
    }

    public Integer getDurakNo() {
        return durakNo;
    }

    public void setDurakNo(Integer durakNo) {
        this.durakNo = durakNo;
    }

    public Integer getAracNo() {
        return aracNo;
    }

    public void setAracNo(Integer aracNo) {
        this.aracNo = aracNo;
    }

    public Integer getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Integer cinsiyet) {
        this.cinsiyet = cinsiyet;
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

    public DBPersonel getdBPersonel() {
        return dBPersonel;
    }

    public void setdBPersonel(DBPersonel dBPersonel) {
        this.dBPersonel = dBPersonel;
    }

}
