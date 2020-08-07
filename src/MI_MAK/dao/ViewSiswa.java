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
public class ViewSiswa {
    
    @TableColumn(number = 1, name = "Nomor Induk")
    private String kd_siswa;
    @TableColumn(number = 2, name = "Nama Siswa")
    private String nm_siswa;
    private String kd_kelas;
    @TableColumn(number = 3, name = "Nama Kelas")
    private String nm_kelas;
    @TableColumn(number = 4, name = "P/L")
    private String PL;
    @TableColumn(number = 5, name = "Tahun Masuk")
    private int thnMasuk;

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
    
    

    public String getPL() {
        return PL;
    }

    public void setPL(String PL) {
        this.PL = PL;
    }

    public int getThnMasuk() {
        return thnMasuk;
    }

    public void setThnMasuk(int thnMasuk) {
        this.thnMasuk = thnMasuk;
    }
    
    
    
}
