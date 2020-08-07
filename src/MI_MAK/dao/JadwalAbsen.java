/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;

/**
 *
 * @author Alvian Syakh
 */
public class JadwalAbsen {
    private String id_absen;
    private String nomor_induk;
    private String nama_siswa;
    private int jml_nilai;
    private int rata_rata;
    private String peringkat;
    private String izin;
    private String sakit;
    private String alpa;

    public String getId_absen() {
        return id_absen;
    }

    public void setId_absen(String id_absen) {
        this.id_absen = id_absen;
    }

    public String getNomor_induk() {
        return nomor_induk;
    }

    public void setNomor_induk(String nomor_induk) {
        this.nomor_induk = nomor_induk;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public int getJml_nilai() {
        return jml_nilai;
    }

    public void setJml_nilai(int jml_nilai) {
        this.jml_nilai = jml_nilai;
    }

    public int getRata_rata() {
        return rata_rata;
    }

    public void setRata_rata(int rata_rata) {
        this.rata_rata = rata_rata;
    }

    public String getPeringkat() {
        return peringkat;
    }

    public void setPeringkat(String peringkat) {
        this.peringkat = peringkat;
    }

    public String getIzin() {
        return izin;
    }

    public void setIzin(String izin) {
        this.izin = izin;
    }

    public String getSakit() {
        return sakit;
    }

    public void setSakit(String sakit) {
        this.sakit = sakit;
    }

    public String getAlpa() {
        return alpa;
    }

    public void setAlpa(String alpa) {
        this.alpa = alpa;
    }
    
    
    
    
    
}
