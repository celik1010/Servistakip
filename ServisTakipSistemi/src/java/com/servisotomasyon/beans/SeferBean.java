package com.servisotomasyon.beans;

import com.servisotomasyon.database.DBArac;
import com.servisotomasyon.database.DBGuzergah;
import com.servisotomasyon.database.DBSefer;
import com.servisotomasyon.database.GenelCRUD;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Guzergah;
import com.servisotomasyon.pojos.Sefer;
import com.servisotomasyon.pojos.SeferBaslar;

@ManagedBean
@ViewScoped
public class SeferBean {

    private Integer seferNo, aracNo, guzergahNo, seferSaat, seferDakika;
    private String seferAd;
    private Date basTarih, bitTarih;
    private Date saat;
    private Boolean butonDurumEkle = false, butonDurumDuzenle = false;

    private List<Integer> saatler, dakikalar;
    private Arac arac;
    private Guzergah guzergah;

    private List<Sefer> seferListesi;
    private List aracListesi;
    private List guzergahListesi;
    GenelCRUD gcrud = new GenelCRUD();
    Sefer sefer;
    SeferBaslar seferBaslat;

    DBArac dBArac = new DBArac();
    DBGuzergah dBGuzergah = new DBGuzergah();
    DBSefer dBSefer = new DBSefer();

    public SeferBean() {
        aracListesi = dBArac.markaListesi();
        guzergahListesi = dBGuzergah.guzergahAdiListesi();
        seferList();

        basTarih = new Date();
        saatDakikaListesi();
    }

    public static void main(String[] args) {
        Date saat = new Date();
        saat.setHours(12);
        System.out.println(saat.getHours());
    }

    public void seferEkle() {
        Arac arac=new Arac();
        arac.setDurum(1);
        saat = new Date();
        sefer = new Sefer();
        sefer.setSeferNo(seferNo);
        sefer.setSeferAd(seferAd);
        gcrud.insert(sefer);

        seferBaslat = new SeferBaslar();
        seferBaslat.setSeferNo(sefer);
        seferBaslat.setAracNo(dBArac.aracDonder(aracNo));
        seferBaslat.setGuzergahNo(dBGuzergah.guzergahDonder(guzergahNo));
        seferBaslat.setBasTarih(basTarih);
        saat.setSeconds(0);
        saat.setHours(seferSaat);
        saat.setMinutes(seferDakika);
        seferBaslat.setSaat(saat);
        gcrud.insert(seferBaslat);
        seferList();
    }

    public void dataTableSecimi(SelectEvent event) {
        seferNo = ((Sefer) event.getObject()).getSeferNo();
    }

    public void seferList() {
        List<Object> param = new ArrayList<>();
        seferListesi = dBSefer.list(param);
    }

    public void dataTableSecimiaracSec(SelectEvent event) {
        aracNo = ((Arac) event.getObject()).getAracNo();
    }

    private void saatDakikaListesi() {
        saatler = new ArrayList<>();
        dakikalar = new ArrayList<>();
        for (int i = 10; i < 24; i++) {
            saatler.add(i);
        }
        for (int i = 10; i < 60; i++) {
            dakikalar.add(i);
        }
    }

    public void butonDurumEkleDegistir() {

        butonDurumEkle = false;
        butonDurumDuzenle = true;
    }

    public void butonDurumDuzenleDegistir() {
        butonDurumEkle = true;
        butonDurumDuzenle = false;
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

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public Guzergah getGuzergah() {
        return guzergah;
    }

    public void setGuzergah(Guzergah guzergah) {
        this.guzergah = guzergah;
    }

    public List getAracListesi() {
        return aracListesi;
    }

    public void setAracListesi(List aracListesi) {
        this.aracListesi = aracListesi;
    }

    public List getGuzergahListesi() {
        return guzergahListesi;
    }

    public void setGuzergahListesi(List guzergahListesi) {
        this.guzergahListesi = guzergahListesi;
    }

    public Integer getAracNo() {
        return aracNo;
    }

    public void setAracNo(Integer aracNo) {
        this.aracNo = aracNo;
    }

    public Integer getGuzergahNo() {
        return guzergahNo;
    }

    public void setGuzergahNo(Integer guzergahNo) {
        this.guzergahNo = guzergahNo;
    }

    public Integer getSeferSaat() {
        return seferSaat;
    }

    public void setSeferSaat(Integer seferSaat) {
        this.seferSaat = seferSaat;
    }

    public Integer getSeferDakika() {
        return seferDakika;
    }

    public void setSeferDakika(Integer seferDakika) {
        this.seferDakika = seferDakika;
    }

    public List<Integer> getSaatler() {
        return saatler;
    }

    public void setSaatler(List<Integer> saatler) {
        this.saatler = saatler;
    }

    public List<Integer> getDakikalar() {
        return dakikalar;
    }

    public void setDakikalar(List<Integer> dakikalar) {
        this.dakikalar = dakikalar;
    }

    public List<Sefer> getSeferListesi() {
        return seferListesi;
    }

    public void setSeferListesi(List<Sefer> seferListesi) {
        this.seferListesi = seferListesi;
    }

    public Boolean getButonDurumEkle() {
        return butonDurumEkle;
    }

    public void setButonDurumEkle(Boolean butonDurumEkle) {
        this.butonDurumEkle = butonDurumEkle;
    }

    public Boolean getButonDurumDuzenle() {
        return butonDurumDuzenle;
    }

    public void setButonDurumDuzenle(Boolean butonDurumDuzenle) {
        this.butonDurumDuzenle = butonDurumDuzenle;
    }

}
