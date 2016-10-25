package com.servisotomasyon.beans;

import com.servisotomasyon.database.DBDurak;
import com.servisotomasyon.database.DBGuzergah;
import com.servisotomasyon.database.DBGuzergahKonumlari;
import com.servisotomasyon.database.GenelCRUD;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.Guzergah;
import com.servisotomasyon.pojos.GuzergahDurak;
import com.servisotomasyon.pojos.Guzergahkonumlari;

@ManagedBean
@ViewScoped
public class GuzergahBean implements Serializable {

    private Integer guzergahNo;
    private String guzergahAdi, durumButon = "true";

    private Double simdikiKonumX = 38.70349658219017, simdikiKonumY = 35.522446632385254;

    private Integer simdikiZoom = 15;
    private List<Durak> duraklar, konumlar;
    private List<Guzergah> guzergahList;
    List<Guzergahkonumlari> liste;

    Guzergah guzergah;
    private List<Object> param;
    private Durak durak;

    private MapModel guzergahEkleModel, guzergahGosterModel;
    private Marker marker;
    Polyline polyline;

    GenelCRUD gcrud = new GenelCRUD();
    Guzergahkonumlari guzergahkonumlari;
    GuzergahDurak guzergahDurak;

    private List<Durak> konumListesi = new ArrayList<>();
//    private List<Durak> durakListesi = new ArrayList<>();
    DBDurak dBDurak = new DBDurak();
    DBGuzergah dBGuzergah = new DBGuzergah();
    DBGuzergahKonumlari dBGuzergahKonumlari = new DBGuzergahKonumlari();

    public GuzergahBean() {
        guzergahList();
    }

    private void guzergahList() {
        param = new ArrayList<>();
        guzergahList = dBGuzergah.list(param);
    }

    public void guzergahEkle() {
        int durakSirasi = 1;
        duraklar = new ArrayList<>();
        guzergah = new Guzergah();
        guzergah.setGuzergahNo(guzergahNo);
        guzergah.setGuzergahAd(guzergahAdi);
        gcrud.insert(guzergah);

        for (int i = 0; i < konumListesi.size(); i++) {
            guzergahkonumlari = new Guzergahkonumlari();
            guzergahkonumlari.setGuzergahNo(guzergah);
            guzergahkonumlari.setKonumSira(i + 1);
            guzergahkonumlari.setKonumX(konumListesi.get(i).getKonumX());
            guzergahkonumlari.setKonumY(konumListesi.get(i).getKonumY());
            gcrud.insert(guzergahkonumlari);
        }
        for (int i = 0; i < konumListesi.size(); i++) {
            if (dBDurak.durakVarmi(konumListesi.get(i).getKonumX(), konumListesi.get(i).getKonumY())) {
                guzergahDurak = new GuzergahDurak();
                guzergahDurak.setGuzergahNo(guzergah);
                guzergahDurak.setDurakNo(dBDurak.durakBul(konumListesi.get(i).getKonumX(), konumListesi.get(i).getKonumY()));
                guzergahDurak.setDurakSirasi(i + 1);
                gcrud.insert(guzergahDurak);
                durakSirasi++;
            }
        }
        guzergahList();
    }  

  

    ///////////////Bütün Durakları haritaya Yükle///////////////////////
    public void durakNoktalariYukle() {
        param = new ArrayList<>();
        setDuraklar((List<Durak>) dBDurak.list(param));
        guzergahEkleModel = new DefaultMapModel();

        for (int i = 0; i < getDuraklar().size(); i++) {
            guzergahEkleModel.addOverlay(new Marker(new LatLng(getDuraklar().get(i).getKonumX(), getDuraklar().get(i).getKonumY()), "selim"));
        }
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        param = new ArrayList<>();
        param.add(marker.getLatlng().getLat());
        param.add(marker.getLatlng().getLng());

        durak = new Durak();
        durak.setKonumX(marker.getLatlng().getLat());
        durak.setKonumY(marker.getLatlng().getLng());

        duraklar = new ArrayList<>();
        konumlar = new ArrayList<>();
        polyline = new Polyline();

        for (int i = 0; i < this.konumListesi.size(); i++) {
            konumlar.add(this.konumListesi.get(i));
        }

        konumlar.add(durak);
        this.konumListesi.add(durak);

        for (int i = 0; i < this.konumListesi.size(); i++) {
            if (dBDurak.durakVarmi(konumListesi.get(i).getKonumX(), konumListesi.get(i).getKonumY())) {
                duraklar.add(dBDurak.durakBul(konumListesi.get(i).getKonumX(), konumListesi.get(i).getKonumY()));
            }
        }

        for (int i = 0; i < konumlar.size(); i++) {
            polyline.getPaths().add(new LatLng(konumlar.get(i).getKonumX(), konumlar.get(i).getKonumY()));
        }
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);

        guzergahEkleModel.addOverlay(polyline);

    }

    public void dataTableSecimi(SelectEvent event) {
        guzergahNo = ((Guzergah) event.getObject()).getGuzergahNo();
    }

    public void guzergahGoster() {
        guzergahGosterModel = new DefaultMapModel();
        param = new ArrayList();
        param.add(guzergahNo);
        liste = new ArrayList<>();
        liste = dBGuzergahKonumlari.list(param);

        polyline = new Polyline();

        for (int i = 0; i < liste.size(); i++) {
            polyline.getPaths().add(new LatLng(liste.get(i).getKonumX(), liste.get(i).getKonumY()));
        }
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);

        guzergahGosterModel.addOverlay(polyline);

        simdikiKonumX = liste.get(3).getKonumX();
        simdikiKonumY = liste.get(3).getKonumY();
    }

    public void onPointSelect(PointSelectEvent event) {
        LatLng latLng = event.getLatLng();
        durak = new Durak();
        durak.setKonumX(latLng.getLat());
        durak.setKonumY(latLng.getLng());

        konumlar = new ArrayList<>();
        polyline = new Polyline();

        for (int i = 0; i < this.konumListesi.size(); i++) {
            konumlar.add(this.konumListesi.get(i));
        }
        konumlar.add(durak);
        this.konumListesi.add(durak);

        for (int i = 0; i < konumlar.size(); i++) {
            polyline.getPaths().add(new LatLng(konumlar.get(i).getKonumX(), konumlar.get(i).getKonumY()));
        }
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);

        guzergahEkleModel.addOverlay(polyline);

    }

    public void geriAl() {
        konumlar = new ArrayList<>();
        polyline = new Polyline();
        guzergahEkleModel = new DefaultMapModel();

        param = new ArrayList<>();
        setDuraklar((List<Durak>) dBDurak.list(param));
        for (int i = 0; i < getDuraklar().size(); i++) {
            guzergahEkleModel.addOverlay(new Marker(new LatLng(getDuraklar().get(i).getKonumX(), getDuraklar().get(i).getKonumY()), "selim"));
        }

        for (int i = 0; i < this.konumListesi.size(); i++) {
            konumlar.add(this.konumListesi.get(i));
        }

        konumlar.remove(konumlar.size() - 1);
        this.konumListesi.remove(konumlar.size());

        for (int i = 0; i < konumlar.size(); i++) {
            polyline.getPaths().add(new LatLng(konumlar.get(i).getKonumX(), konumlar.get(i).getKonumY()));
        }
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);

        guzergahEkleModel.addOverlay(polyline);
    }

    public void onStateChange(StateChangeEvent event) {
        // LatLngBounds bounds = event.getBounds();
        this.simdikiZoom = event.getZoomLevel();

        this.simdikiKonumX = event.getCenter().getLat();
        this.simdikiKonumY = event.getCenter().getLng();
    }

    public void butonDurumFalseYap() {
        durumButon = "false";
    }

    ////////////Durak Listesni Temizle ////////////////////
    public void setDurakListesi() {
        this.konumListesi.clear();
    }

    public Marker getMarker() {
        return marker;
    }

    public MapModel getGuzergahEkleModel() {
        return guzergahEkleModel;
    }

    public void setGuzergahEkleModel(MapModel guzergahEkleModel) {
        this.guzergahEkleModel = guzergahEkleModel;
    }

    public Integer getGuzergahNo() {
        return guzergahNo;
    }

    public void setGuzergahNo(Integer guzergahNo) {
        this.guzergahNo = guzergahNo;
    }

    public String getGuzergahAdi() {
        return guzergahAdi;
    }

    public void setGuzergahAdi(String guzergahAdi) {
        this.guzergahAdi = guzergahAdi;
    }

    public List<Durak> getKonumListesi() {
        return getDuraklar();
    }

    public void setKonumListesi(List<Durak> konumListesi) {
        this.setDuraklar(konumListesi);
    }

    public List<Guzergah> getGuzergahList() {
        return guzergahList;
    }

    public void setGuzergahList(List<Guzergah> guzergahList) {
        this.guzergahList = guzergahList;
    }

    public List<Durak> getDuraklar() {
        return duraklar;
    }

    public void setDuraklar(List<Durak> duraklar) {
        this.duraklar = duraklar;
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

    public Integer getSimdikiZoom() {
        return simdikiZoom;
    }

    public void setSimdikiZoom(Integer simdikiZoom) {
        this.simdikiZoom = simdikiZoom;
    }

    public Durak getDurak() {
        return durak;
    }

    public void setDurak(Durak durak) {
        this.durak = durak;
    }

    public String getDurumButon() {
        return durumButon;
    }

    public void setDurumButon(String durumButon) {
        this.durumButon = durumButon;
    }

    public MapModel getGuzergahGosterModel() {
        return guzergahGosterModel;
    }

    public void setGuzergahGosterModel(MapModel guzergahGosterModel) {
        this.guzergahGosterModel = guzergahGosterModel;
    }

}
