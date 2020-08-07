/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author Imam-pc
 */
public class PenilaianRekap {
    
    private String id_nilai;
    private String kd_mapel;
    @TableColumn(number = 1, name = "Mata Pelajaran")
    private String nm_mapel;
    @TableColumn(number = 2, name = "UH")
    private Double UH;
    @TableColumn(number = 3, name = "UTS")
    private Double UTS;
    @TableColumn(number = 4, name = "UAS")
    private Double UAS;
    @TableColumn(number = 5, name = "Raport")
    private Double rapor;
    private int jumlah;

    public String getId_nilai() {
        return id_nilai;
    }

    public void setId_nilai(String id_nilai) {
        this.id_nilai = id_nilai;
    }

    public String getKd_mapel() {
        return kd_mapel;
    }

    public void setKd_mapel(String kd_mapel) {
        this.kd_mapel = kd_mapel;
    }

    public String getNm_mapel() {
        return nm_mapel;
    }

    public void setNm_mapel(String nm_mapel) {
        this.nm_mapel = nm_mapel;
    }

    public Double getUH() {
        return UH;
    }

    public void setUH(Double UH) {
        this.UH = UH;
    }

    public Double getUTS() {
        return UTS;
    }

    public void setUTS(Double UTS) {
        this.UTS = UTS;
    }

    public Double getUAS() {
        return UAS;
    }

    public void setUAS(Double UAS) {
        this.UAS = UAS;
    }

    public Double getRapor() {
        return rapor;
    }

    public void setRapor(Double rapor) {
        this.rapor = rapor;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
    
    
}
