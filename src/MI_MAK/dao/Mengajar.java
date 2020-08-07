/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;
import MI_MAK.widget.TimeCellRendererTable;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.sql.Time;
import java.sql.Timestamp;
/**
 *
 * @author Alvian Syakh
 */
public class Mengajar {

private int id;
@TableColumn(number = 1, name = "Kode")
private String kd_ajar;
@TableColumn(number = 2, name = "Mata Pelajaran")
private String nm_mapel;
private String kd_mapel;
@TableColumn(number = 3, name = "Nama Kelas")
private String nm_kelas;
private String kd_kelas;
@TableColumn(number = 4, name = "Nama Guru")
private String nm_guru;
private String kd_guru;
@TableColumn(number = 5, name = "Hari")
private String hari;
@TableColumn(number = 6, name = "Jam Mulai", renderer = TimeCellRendererTable.class)
private Time jamMulai;
@TableColumn(number = 7, name = "Jam Selesai", renderer = TimeCellRendererTable.class)
private Time jamSelesai;
@TableColumn(number = 8, name = "Tahun Ajaran")
private String tahunAjaran;

private int flag;
private String createdby;
private Timestamp createddate;
private String updatedby;
private Timestamp updateddate;

    public String getNm_mapel() {
        return nm_mapel;
    }

    public void setNm_mapel(String nm_mapel) {
        this.nm_mapel = nm_mapel;
    }

    public String getNm_kelas() {
        return nm_kelas;
    }

    public void setNm_kelas(String nm_kelas) {
        this.nm_kelas = nm_kelas;
    }

    public String getNm_guru() {
        return nm_guru;
    }

    public void setNm_guru(String nm_guru) {
        this.nm_guru = nm_guru;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKd_ajar() {
        return kd_ajar;
    }

    public void setKd_ajar(String kd_ajar) {
        this.kd_ajar = kd_ajar;
    }

    public String getKd_mapel() {
        return kd_mapel;
    }

    public void setKd_mapel(String kd_mapel) {
        this.kd_mapel = kd_mapel;
    }

    public String getKd_kelas() {
        return kd_kelas;
    }

    public void setKd_kelas(String kd_kelas) {
        this.kd_kelas = kd_kelas;
    }

    public String getKd_guru() {
        return kd_guru;
    }

    public void setKd_guru(String kd_guru) {
        this.kd_guru = kd_guru;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public Time getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(Time jamMulai) {
        this.jamMulai = jamMulai;
    }

    public Time getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(Time jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
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



    
}
