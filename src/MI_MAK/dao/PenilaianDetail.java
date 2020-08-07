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
public class PenilaianDetail {
    
    private String id_nilai;
    @TableColumn(number = 1, name = "NIS")
    private String kd_siswa;
    @TableColumn(number = 2, name = "Nama")
    private String nm_siswa;
    @TableColumn(number = 3, name = "UH", editable = true)
    private Double UH;
    @TableColumn(number = 4, name = "UTS", editable = true)
    private Double UTS;
    @TableColumn(number = 5, name = "UAS", editable = true)
    private Double UAS;
    
    private Penilaian penilaian;

    public Penilaian getPenilaian() {
        return penilaian;
    }

    public void setPenilaian(Penilaian penilaian) {
        this.penilaian = penilaian;
    }
    


    public String getId_nilai() {
        return id_nilai;
    }

    public void setId_nilai(String id_nilai) {
        this.id_nilai = id_nilai;
    }

    public String getKd_siswa() {
        return kd_siswa;
    }

    public void setKd_siswa(String kd_siswa) {
        this.kd_siswa = kd_siswa;
    }

    public String getNm_siswa() {
        return nm_siswa;
    }

    public void setNm_siswa(String nm_siswa) {
        this.nm_siswa = nm_siswa;
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

    
    
    
    
    
    
}
