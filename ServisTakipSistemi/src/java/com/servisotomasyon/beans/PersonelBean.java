package com.servisotomasyon.beans;

import com.servisotomasyon.javas.Util;
import com.servisotomasyon.database.DBDurak;
import com.servisotomasyon.database.DBGuzergahDurak;
import com.servisotomasyon.database.DBPersonel;
import com.servisotomasyon.database.DBSeferBaslar;
import com.servisotomasyon.database.GenelCRUD;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import com.servisotomasyon.pojos.Adres;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.Durakbiner;
import com.servisotomasyon.pojos.Personel;
import com.servisotomasyon.pojos.Sirket;

@Named(value = "personelBean")
@ViewScoped
public class PersonelBean {

    private Integer sirketNo, hours, minutes;
    private String sirketAdi, sirketTel, sirketMail;
    private Long personelTc;
    private String personelAdi, personelSoyadi, telefon, mail, tamAdres;
    private String il, ilce, mahalle, cadde, sokak, apartman;
    private Integer daireNo, durakNo, aracNo, cinsiyet;
    private Date basTarih, bitTarih, saat;
    private List<Personel> liste;
    private List<Durak> duraklar;
    private List<Arac> araclar;
    private Personel secilenPersonel, personel;
    private Adres adres;
    private Durak durak;
    private Durakbiner durakbiner;

    private Double simdikiKonumX = 38.70416639509346, simdikiKonumY = 35.52247881889343;
    private MapModel personelDurakModel;
    private Marker marker;

    GenelCRUD gcrud = new GenelCRUD();
    DBPersonel dbp = new DBPersonel();
    DBDurak dBDurak = new DBDurak();
    DBSeferBaslar dBSeferBaslar = new DBSeferBaslar();

    List<Object> param;

    public PersonelBean() {
        setSirketBilgileri();
        personelList();
    }

    public void personelList() {
        param = new ArrayList<>();
        param.add(new Sirket(sirketNo));
        liste = dbp.list(param);
    }

    public void personelEkle() {
        saat = new Date();
        personel = new Personel();
        adres = new Adres();
        durakbiner = new Durakbiner();
        durak = new Durak();
        durak.setDurakNo(durakNo);
        Arac arac = new Arac();
        arac.setAracNo(aracNo);
        personel.setPersonelTc(personelTc);
        personel.setPersonelAd(personelAdi);
        personel.setPersonelSoyad(personelSoyadi);
        personel.setEPosta(mail);
        personel.setTelefon(telefon);
        personel.setCinsiyet(cinsiyet);
        personel.setSirketNo(new Sirket(sirketNo));
        adres.setIl(il);
        adres.setIlce(ilce);
        adres.setMahalle(mahalle);
        adres.setSokak(sokak);
        adres.setCadde(cadde);
        adres.setApartman(apartman);
        adres.setDaireNo(daireNo);
        adres.setPersonelTc(personelTc);
//        durakbiner.setAracNo(arac);
//        durakbiner.setDurakNo(durak);
//        durakbiner.setPersonelTc(personel);
//        durakbiner.setBasTarih(basTarih);
//        saat.setHours(hours);
//        saat.setMinutes(minutes);
//        durakbiner.setSaati(saat);
        gcrud.insert(personel);
        gcrud.insert(adres);
//        gcrud.insert(durakbiner);

        personelList();

    }

    public void personelDuzenle() {

        personel = new Personel();
        adres = new Adres();
        durakbiner = new Durakbiner();
        personel.setPersonelTc(personelTc);
        personel.setPersonelAd(personelAdi);
        personel.setPersonelSoyad(personelSoyadi);
        personel.setEPosta(mail);
        personel.setTelefon(telefon);
        personel.setCinsiyet(cinsiyet);
        personel.setSirketNo(new Sirket(sirketNo));
        adres.setIl(il);
        adres.setIlce(ilce);
        adres.setMahalle(mahalle);
        adres.setSokak(sokak);
        adres.setCadde(cadde);
        adres.setApartman(apartman);
        adres.setDaireNo(daireNo);
        adres.setPersonelTc(personelTc);
        gcrud.update(personel);
        gcrud.update(adres);

        personelList();
    }

    public void personelSil() {
        personel = new Personel();
        adres = new Adres();
        durakbiner=new Durakbiner();
        personel.setPersonelTc(personelTc);
        adres.setPersonelTc(personelTc);
        durakbiner.setPersonelTc(personel);
        
        gcrud.delete(durakbiner);
        gcrud.delete(adres);
        gcrud.delete(personel);
        
        personelList();
    }

    public void setDegerler() {
        setPersonelTc(null);
        setPersonelAdi(null);
        setPersonelSoyadi(null);
        setTelefon(null);
        setMail(null);
        setCinsiyet(null);
        setIl(null);
        setIlce(null);
        setMahalle(null);
        setCadde(null);
        setSokak(null);
        setApartman(null);
        setDaireNo(null);

    }

    public void dataTableSecimi(SelectEvent event) {
        personelTc = ((Personel) event.getObject()).getPersonelTc();
        personelAdi = ((Personel) event.getObject()).getPersonelAd();
        personelSoyadi = ((Personel) event.getObject()).getPersonelSoyad();
        telefon = ((Personel) event.getObject()).getTelefon();
        mail = ((Personel) event.getObject()).getEPosta();
        cinsiyet = ((Personel) event.getObject()).getCinsiyet();
        il = ((Personel) event.getObject()).getAdres().getIl();
        ilce = ((Personel) event.getObject()).getAdres().getIlce();
        mahalle = ((Personel) event.getObject()).getAdres().getMahalle();
        cadde = ((Personel) event.getObject()).getAdres().getCadde();
        sokak = ((Personel) event.getObject()).getAdres().getSokak();
        apartman = ((Personel) event.getObject()).getAdres().getApartman();
        daireNo = ((Personel) event.getObject()).getAdres().getDaireNo();        
    }

    public void dataTableSecimiAracSec(SelectEvent event) {
        aracNo = ((Arac) event.getObject()).getAracNo();
    }

    /**
     * ********** ŞİRKET BİLGİLERİ getSESSION**********
     */
    private void setSirketBilgileri() {
        sirketNo = Util.getSirketNo();
        sirketAdi = Util.getSirketAdi();
        sirketMail = Util.getSirketMail();
        sirketTel = Util.getSirketTelefon();
    }

    ///////////////Bütün Durakları haritaya Yükle///////////////////////
    public void durakNoktalariYukle() {
        param = new ArrayList<>();
        setDuraklar((List<Durak>) dBDurak.list(param));
        personelDurakModel = new DefaultMapModel();

        for (int i = 0; i < getDuraklar().size(); i++) {
            personelDurakModel.addOverlay(new Marker(new LatLng(getDuraklar().get(i).getKonumX(), getDuraklar().get(i).getKonumY()), "selim"));
        }
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();

        durakNo = dBDurak.durakBul(marker.getLatlng().getLat(), marker.getLatlng().getLng()).getDurakNo();
    }

    public void aaracListesi() {
        param = new ArrayList<>();
        araclar = new ArrayList<>();
        DBGuzergahDurak dBGuzergahDurak = new DBGuzergahDurak();

        param.add(durakNo);
        araclar = dBSeferBaslar.list(param);

    }

    public void setSaat() {
        param = new ArrayList<>();
        DBGuzergahDurak dBGuzergahDurak = new DBGuzergahDurak();

        param.add(durakNo);
        param.add(aracNo);

        hours = dBGuzergahDurak.getSeferSaati(param).getHours();
        minutes = dBGuzergahDurak.getSeferSaati(param).getMinutes();
    }

    /**
     * **********GETTER AND SETTER ***************
     */
    public List<Personel> getListe() {
        return liste;
    }

    public void setListe(List<Personel> liste) {
        this.liste = liste;
    }

    public Personel getSecilenPersonel() {
        return secilenPersonel;
    }

    public void setSecilenPersonel(Personel secilenPersonel) {
        this.secilenPersonel = secilenPersonel;
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

    public Integer getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Integer cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getSirketNo() {
        return sirketNo;
    }

    public void setSirketNo(Integer sirketNo) {
        this.sirketNo = sirketNo;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getSirketTel() {
        return sirketTel;
    }

    public void setSirketTel(String sirketTel) {
        this.sirketTel = sirketTel;
    }

    public String getSirketMail() {
        return sirketMail;
    }

    public void setSirketMail(String sirketMail) {
        this.sirketMail = sirketMail;
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

    public String getTamAdres() {
        return tamAdres;
    }

    public void setTamAdres(String tamAdres) {
        this.tamAdres = tamAdres;
    }

    public Double getSimdikiKonumX() {
        return simdikiKonumX;
    }

    public void setSimdikiKonumX(Double simdikiKonumX) {
        this.simdikiKonumX = simdikiKonumX;
    }

    public Double getSimdikiKonumY() {
        return simdikiKonumY;
    }

    public void setSimdikiKonumY(Double simdikiKonumY) {
        this.simdikiKonumY = simdikiKonumY;
    }

    public MapModel getPersonelDurakModel() {
        return personelDurakModel;
    }

    public void setPersonelDurakModel(MapModel personelDurakModel) {
        this.personelDurakModel = personelDurakModel;
    }

    public List<Durak> getDuraklar() {
        return duraklar;
    }

    public void setDuraklar(List<Durak> duraklar) {
        this.duraklar = duraklar;
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

    public List<Arac> getAraclar() {
        return araclar;
    }

    public void setAraclar(List<Arac> araclar) {
        this.araclar = araclar;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

}
