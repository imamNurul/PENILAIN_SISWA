/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;
import MI_MAK.widget.FlagCellRendererTable;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Alvian Syakh
 */
public class Guru {
    
    //@TableColumn(number = 1, name = "No.")
    private int id;
    @TableColumn(number = 2, name = "NIP")
    private String nip;
    @TableColumn(number = 3, name = "Nama")
    private String nama_guru;
    @TableColumn(number = 4, name = "Tempat Lahir")
    private String tempat_lahir;
    @TableColumn(number = 5, name = "Tgl Lahir")
    private Date tanggal_lahir;
    @TableColumn(number = 6, name = "P/L")
    private String jenis_kelamin;
    @TableColumn(number = 7, name = "Agama")
    private String agama;
    @TableColumn(number = 8, name = "Pendidikan")
    private String pendidikan_terakhir;
    @TableColumn(number = 9, name = "Telp")
    private String telp;
    @TableColumn(number = 10, name = "Status")
    private String status;
    @TableColumn(number = 11, name = "Alamat")
    private String alamat;
    private String photo;
    private int flag;
    private String waliKelas;
    private String kd_kelas;
    @TableColumn(number = 12, name = "Wali Kelas")
    private String nm_kelas;
    private String kd_mapel;
    @TableColumn(number = 13, name = "Mata Pelajaran")
    private String nm_mapel;
    private String createdby;
    private Timestamp createddate;
    private String updatedby;
    private Timestamp updateddate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNip() {
        return nip;
    }

    public String getWaliKelas() {
        return waliKelas;
    }

    public void setWaliKelas(String waliKelas) {
        this.waliKelas = waliKelas;
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
    
    

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
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

    public String getPendidikan_terakhir() {
        return pendidikan_terakhir;
    }

    public void setPendidikan_terakhir(String pendidikan_terakhir) {
        this.pendidikan_terakhir = pendidikan_terakhir;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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
        return getNip()+"-"+getNama_guru();
    }

    
    
    
    
    
}
