package com.servisotomasyon.beans;

import com.servisotomasyon.database.DBDurak;
import com.servisotomasyon.database.GenelCRUD;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import com.servisotomasyon.pojos.Durak;

@ManagedBean
@ViewScoped
public class DurakBean implements Serializable {
    
    private Integer durakNo;
    private Double konumY, konumX;
    private String durakAdi, aciklama;
    private MapModel emptyModel, durakGoster;
    private List<Durak> durakListesi;
    private List<Object> param;
    
    Durak durak;
    DBDurak dBDurak = new DBDurak();
    GenelCRUD gcrud = new GenelCRUD();
    
    public DurakBean() {
        emptyModel = new DefaultMapModel();
        durakList();
    }

    public void setDegerLer() {
        setDurakNo(null);
        setDurakAdi(null);
        setAciklama(null);
        setKonumX(null);
        setKonumY(null);
    }

    public void durakList() {
        param = new ArrayList<>();
        durakListesi = dBDurak.list(param);
    }
    
    public MapModel haritadaGoster() {
        durakGoster = new DefaultMapModel();        
        LatLng latLng = new LatLng(konumX, konumY);
        durakGoster.addOverlay(new Marker(latLng));
        return durakGoster;
    }
    
    public void durakEkle() {
        durak = new Durak();
        durak.setDurakNo(durakNo);
        durak.setDurakAd(durakAdi);
        durak.setAciklama(aciklama);
        durak.setKonumX(konumX);
        durak.setKonumY(konumY);
        gcrud.insert(durak);
        
        durakList();
    }
    
    public void durakSil() {
        durak = new Durak();
        durak.setDurakNo(durakNo);
        gcrud.delete(durak);
        
        durakList();
    }
    
    public void dataTableSecimi(SelectEvent event) {
        durakNo = ((Durak) event.getObject()).getDurakNo();
        durakAdi = ((Durak) event.getObject()).getDurakAd();
        aciklama = ((Durak) event.getObject()).getAciklama();
        konumX = ((Durak) event.getObject()).getKonumX();
        konumY = ((Durak) event.getObject()).getKonumY();
    }
    
    public List<Durak> getDurakListesi() {
        return durakListesi;
    }
    
    public void setDurakListesi(List<Durak> durakListesi) {
        this.durakListesi = durakListesi;
    }
    
    public Integer getDurakNo() {
        return durakNo;
    }
    
    public void setDurakNo(Integer durakNo) {
        this.durakNo = durakNo;
    }
    
    public Double getKonumY() {
        return konumY;
    }
    
    public void setKonumY(Double konumY) {
        this.konumY = konumY;
    }
    
    public Double getKonumX() {
        return konumX;
    }
    
    public void setKonumX(Double konumX) {
        this.konumX = konumX;
    }
    
    public String getDurakAdi() {
        return durakAdi;
    }
    
    public void setDurakAdi(String durakAdi) {
        this.durakAdi = durakAdi;
    }
    
    public String getAciklama() {
        return aciklama;
    }
    
    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    public MapModel getEmptyModel() {
        return emptyModel;
    }
    
    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }
    
    public MapModel getDurakGoster() {
        return durakGoster;
    }
    
    public void setDurakGoster(MapModel durakGoster) {
        this.durakGoster = durakGoster;
    }
    
    public void addMarker() {
        Marker marker = new Marker(new LatLng(konumX, konumY));
        emptyModel.addOverlay(marker);
        
    }
}
