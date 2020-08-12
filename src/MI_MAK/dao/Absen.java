/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;

import MI_MAK.widget.TanggalCellRendererTable;
import MI_MAK.widget.TanggalTimeCellRendererTable;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Imam-pc
 */
public class Absen {
    
    private int id;
    @TableColumn(number = 1, name = "Kode Absen")
    private String kd_absen;
    private String kd_kelas;
    @TableColumn(number = 2, name = "Kelas")
    private String nama_kelas;
    private String kd_siswa;
    @TableColumn(number = 3, name = "Siswa")
    private String nama_siswa;
    @TableColumn(number = 4, name = "Semester")
    private String semester;
    @TableColumn(number = 5, name = "Tanggal Dari", renderer = TanggalCellRendererTable.class)
    private Date tglDari;
    @TableColumn(number = 6, name = "Tanggal Sampai", renderer = TanggalCellRendererTable.class)
    private Date tglSampai;
    @TableColumn(number = 7, name = "Hadir")
    private Long hadir;
    @TableColumn(number = 8, name = "Sakit")
    private Long sakit;
    @TableColumn(number = 9, name = "Izin")
    private Long izin;
    @TableColumn(number = 10, name = "Alpa")
    private Long alpa;
    @TableColumn(number = 11, name = "Tanggal Buat",renderer = TanggalTimeCellRendererTable.class)
    private Timestamp tgl_buat;
    @TableColumn(number = 12, name = "Tanggal Ubah",renderer = TanggalTimeCellRendererTable.class)
    private Timestamp tgl_ubah;
    private String ket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKd_absen() {
        return kd_absen;
    }

    public void setKd_absen(String kd_absen) {
        this.kd_absen = kd_absen;
    }

    public String getKd_kelas() {
        return kd_kelas;
    }

    public void setKd_kelas(String kd_kelas) {
        this.kd_kelas = kd_kelas;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getKd_siswa() {
        return kd_siswa;
    }

    public void setKd_siswa(String kd_siswa) {
        this.kd_siswa = kd_siswa;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getTglDari() {
        return tglDari;
    }

    public void setTglDari(Date tglDari) {
        this.tglDari = tglDari;
    }

    public Date getTglSampai() {
        return tglSampai;
    }

    public void setTglSampai(Date tglSampai) {
        this.tglSampai = tglSampai;
    }

    public Long getHadir() {
        return hadir;
    }

    public void setHadir(Long hadir) {
        this.hadir = hadir;
    }
    
    

    public Long getSakit() {
        return sakit;
    }

    public void setSakit(Long sakit) {
        this.sakit = sakit;
    }

    public Long getIzin() {
        return izin;
    }

    public void setIzin(Long izin) {
        this.izin = izin;
    }

    public Long getAlpa() {
        return alpa;
    }

    public void setAlpa(Long alpa) {
        this.alpa = alpa;
    }

    public Timestamp getTgl_buat() {
        return tgl_buat;
    }

    public void setTgl_buat(Timestamp tgl_buat) {
        this.tgl_buat = tgl_buat;
    }

    public Timestamp getTgl_ubah() {
        return tgl_ubah;
    }

    public void setTgl_ubah(Timestamp tgl_ubah) {
        this.tgl_ubah = tgl_ubah;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }
    
    
    
    
    
    
    
    
}
