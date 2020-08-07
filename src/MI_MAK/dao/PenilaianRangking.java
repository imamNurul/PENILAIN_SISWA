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
public class PenilaianRangking {
    
    private String kd_kelas;
    private String nm_kelas;
    @TableColumn(number = 1, name = "NIS")
    private String kd_siswa;
    @TableColumn(number = 2, name = "Nama Siswa")
    private String nm_siswa;
    @TableColumn(number = 3, name = "Nilai Raport Rata-rata")
    private Double rataRata;

    public String getKd_kelas() {
        return kd_kelas;
    }

    public void setKd_kelas(String kd_kelas) {
        this.kd_kelas = kd_kelas;
    }

    public String getNm_kelas() {
        return nm_kelas;
    }

    public void setNm_kelas(String nm_kelas) {
        this.nm_kelas = nm_kelas;
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
    
    

    public Double getRataRata() {
        return rataRata;
    }

    public void setRataRata(Double rataRata) {
        this.rataRata = rataRata;
    }
    
    
    
}
