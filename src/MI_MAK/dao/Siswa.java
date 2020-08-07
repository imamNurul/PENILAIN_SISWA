/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Imam-pc
 */
public class Siswa implements Serializable{
    
    //@TableColumn(number = 1, name = "No.")
    private int Id;
    @TableColumn(number = 2, name = "Nomor Induk")
    private String nomor_induk;
    @TableColumn(number = 3, name = "Nama")
    private String nama_siswa;
    @TableColumn(number = 4, name = "Tempat Lahir")
    private String tempat_lahir;
    @TableColumn(number = 5, name = "L/P")
    private String jenis_kelamin;
    @TableColumn(number = 6, name = "Agama")
    private String agama;
    @TableColumn(number = 7, name = "Tahun Masuk")
    private int tahun_masuk;
    @TableColumn(number = 8, name = "Alamat")
    private String alamat_siswa;
    private String nama_ayah;
    private String nama_ibu;
    private String kj_ayah;
    private String kj_ibu;
    private String telp_wali;
    private Date tanggal_lahir;
    private int flag;
    private String photo;
    private String kode_kelas;
    @TableColumn(number = 9, name = "Kelas")
    private String nama_kelas;
    private String createdby;
    private Timestamp createddate;
    private String updatedby;
    private Timestamp updateddate;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public int getTahun_masuk() {
        return tahun_masuk;
    }

    public void setTahun_masuk(int tahun_masuk) {
        this.tahun_masuk = tahun_masuk;
    }

    public String getAlamat_siswa() {
        return alamat_siswa;
    }

    public void setAlamat_siswa(String alamat_siswa) {
        this.alamat_siswa = alamat_siswa;
    }

    public String getNama_ayah() {
        return nama_ayah;
    }

    public void setNama_ayah(String nama_ayah) {
        this.nama_ayah = nama_ayah;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public String getKj_ayah() {
        return kj_ayah;
    }

    public void setKj_ayah(String kj_ayah) {
        this.kj_ayah = kj_ayah;
    }

    public String getKj_ibu() {
        return kj_ibu;
    }

    public void setKj_ibu(String kj_ibu) {
        this.kj_ibu = kj_ibu;
    }

    public String getTelp_wali() {
        return telp_wali;
    }

    public void setTelp_wali(String telp_wali) {
        this.telp_wali = telp_wali;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

   
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Timestamp getUpdateddate() {
        return updateddate;
    }

    public void setUpdateddate(Timestamp updateddate) {
        this.updateddate = updateddate;
    }

    @Override
    public String toString() {
        return getNomor_induk()+"-"+getNama_siswa();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nomor_induk);
        hash = 97 * hash + Objects.hashCode(this.nama_siswa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Siswa other = (Siswa) obj;
        if (!Objects.equals(this.nomor_induk, other.nomor_induk)) {
            return false;
        }
        if (!Objects.equals(this.nama_siswa, other.nama_siswa)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
