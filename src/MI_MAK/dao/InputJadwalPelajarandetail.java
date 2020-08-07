/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;

import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author Alvian Syakh
 */
public class InputJadwalPelajarandetail {
    private int id;
    private String kode_mengajar;
    private String kode_kelas;
    private String kode_guru;
    private String kode_mapel;
    private String hari;
    private String jam;
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

    public String getKode_mengajar() {
        return kode_mengajar;
    }

    public void setKode_mengajar(String kode_mengajar) {
        this.kode_mengajar = kode_mengajar;
    }

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getKode_guru() {
        return kode_guru;
    }

    public void setKode_guru(String kode_guru) {
        this.kode_guru = kode_guru;
    }

    public String getKode_mapel() {
        return kode_mapel;
    }

    public void setKode_mapel(String kode_mapel) {
        this.kode_mapel = kode_mapel;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
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
