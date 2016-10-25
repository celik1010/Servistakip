package com.servisotomasyon.beans;

import com.servisotomasyon.javas.Util;
import com.servisotomasyon.database.DBArac;
import com.servisotomasyon.database.GenelCRUD;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Sahip;
import com.servisotomasyon.pojos.Sirket;

@ManagedBean
@ViewScoped
public class AracBean {

    private Integer aracNo, model, kapasite, durum, siketNo, sinif, filtreSinif, filtreDurum, filtreKapasite;
    private Long sahipTc;
    private String sahipAdi,sahipSoyadi,sahipTel1,sahipTel2,plaka, marka, filtreMarka;
    private List markaList, kapasiteList;
    private List<Arac> aracListesi;

    private Arac arac;
    private Sahip sahip;
    DBArac dBArac = new DBArac();
    GenelCRUD gcrud = new GenelCRUD();

    List<Object> param;

    public AracBean() {
        markaList = dBArac.markaListesi();
        kapasiteList = dBArac.kapasiteListesi();
        setIlkDegerler();
        araclist();
    }

    public static void main(String[] args) {
//        AracBean ab = new AracBean();
//
//        ab.araclist();
//        System.out.println(ab.aracListesi);
    }

    private void setIlkDegerler() {
        setFiltreSinif(0);
        setFiltreKapasite(0);
        setFiltreMarka("0");
        setFiltreDurum(1);
    }

    public void araclist() {
        param = new ArrayList<>();
        param.add(new Sirket(Util.getSirketNo()));
        param.add(filtreSinif);
        param.add(filtreMarka);
        param.add(filtreKapasite);
        param.add(filtreDurum);
        aracListesi = dBArac.list(param);
    }

    private Integer getSinif(Integer model) {
        int sinif;
        if (model >= 2010) {
            sinif = 1;
        } else if (model <= 2009 && model >= 2000) {
            sinif = 2;
        } else {
            sinif = 3;
        }
        return sinif;

    }

    public void aracEkle() {
        arac = new Arac();
        sahip=new Sahip();      
        
        
        arac.setAracNo(aracNo);
        arac.setPlaka(plaka);
        arac.setMarka(marka);
        arac.setModel(model);
        arac.setSinif(getSinif(model));
        arac.setKapasite(kapasite);
        arac.setDurum(0);
        arac.setSirketNo(new Sirket(Util.getSirketNo()));
        
//        sahip.setSahipTc(sahipTc);       
//        sahip.setSahipAd(sahipAdi);
//        sahip.setSahipSoyad(sahipSoyadi);
//        sahip.setTel1(sahipTel1);
//        sahip.setTel2(sahipTel2);
//        sahip.setAracNo(new Arac(arac.getAracNo()));
        
        
       gcrud.insert(arac);
//        gcrud.insert(sahip);
       
        
        
        araclist();
    }
    
        public void aracDuzenle() {
        arac = new Arac();
//        sahip=new Sahip();      
        
        
        arac.setAracNo(aracNo);
        arac.setPlaka(plaka);
        arac.setMarka(marka);
        arac.setModel(model);
        arac.setSinif(getSinif(model));
        arac.setKapasite(kapasite);
        arac.setDurum(1);
        arac.setSirketNo(new Sirket(Util.getSirketNo()));
        
//        sahip.setSahipTc(sahipTc);       
//        sahip.setSahipAd(sahipAdi);
//        sahip.setSahipSoyad(sahipSoyadi);
//        sahip.setTel1(sahipTel1);
//        sahip.setTel2(sahipTel2);
//        sahip.setAracNo(new Arac(arac.getAracNo()));        
        
       gcrud.update(arac);
//        gcrud.insert(sahip);
       
        
        
        araclist();
    }

  
    public void aracSil() {
        arac = new Arac();
        arac.setAracNo(aracNo);
        gcrud.delete(arac);
        araclist();
    }
    public void degerlerAta(){
    
    }

    public void dataTableSecimi(SelectEvent event) {
        aracNo = ((Arac) event.getObject()).getAracNo();  
        model=((Arac) event.getObject()).getModel();
        marka=((Arac) event.getObject()).getMarka();
        kapasite=((Arac) event.getObject()).getKapasite();
        sinif=((Arac) event.getObject()).getSinif();
        plaka=((Arac) event.getObject()).getPlaka();            
        
    }

    public List<Arac> getAracListesi() {
        return aracListesi;
    }

    public void setAracListesi(List<Arac> aracListesi) {
        this.aracListesi = aracListesi;
    }

    public List getMarkaList() {
        return markaList;
    }

    public void setMarkaList(List markaList) {
        this.markaList = markaList;
    }

    public List getKapasiteList() {
        return kapasiteList;
    }

    public void setKapasiteList(List kapasiteList) {
        this.kapasiteList = kapasiteList;
    }

    public Integer getAracNo() {
        return aracNo;
    }

    public void setAracNo(Integer aracNo) {
        this.aracNo = aracNo;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getKapasite() {
        return kapasite;
    }

    public void setKapasite(Integer kapasite) {
        this.kapasite = kapasite;
    }

    public Integer getDurum() {
        return durum;
    }

    public void setDurum(Integer durum) {
        this.durum = durum;
    }

    public Integer getSiketNo() {
        return siketNo;
    }

    public void setSiketNo(Integer siketNo) {
        this.siketNo = siketNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Integer getSinif() {
        return sinif;
    }

    public void setSinif(Integer sinif) {
        this.sinif = sinif;
    }

    public Integer getFiltreSinif() {
        return filtreSinif;
    }

    public void setFiltreSinif(Integer filtreSinif) {
        this.filtreSinif = filtreSinif;
    }

    public Integer getFiltreDurum() {
        return filtreDurum;
    }

    public void setFiltreDurum(Integer filtreDurum) {
        this.filtreDurum = filtreDurum;
    }

    public Integer getFiltreKapasite() {
        return filtreKapasite;
    }

    public void setFiltreKapasite(Integer filtreKapasite) {
        this.filtreKapasite = filtreKapasite;
    }

    public String getFiltreMarka() {
        return filtreMarka;
    }

    public void setFiltreMarka(String filtreMarka) {
        this.filtreMarka = filtreMarka;
    }

    public Long getSahipTc() {
        return sahipTc;
    }

    public void setSahipTc(Long sahipTc) {
        this.sahipTc = sahipTc;
    }

 

    public String getSahipAdi() {
        return sahipAdi;
    }

    public void setSahipAdi(String sahipAdi) {
        this.sahipAdi = sahipAdi;
    }

    public String getSahipSoyadi() {
        return sahipSoyadi;
    }

    public void setSahipSoyadi(String sahipSoyadi) {
        this.sahipSoyadi = sahipSoyadi;
    }

    public String getSahipTel1() {
        return sahipTel1;
    }

    public void setSahipTel1(String sahipTel1) {
        this.sahipTel1 = sahipTel1;
    }

    public String getSahipTel2() {
        return sahipTel2;
    }

    public void setSahipTel2(String sahipTel2) {
        this.sahipTel2 = sahipTel2;
    }

}
