/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Imam-pc
 */
public class Penilaian {
    
    private int id;
    @TableColumn(number = 1, name = "Kode Nilai")
    private String id_nilai;
    private String kd_kelas;
    @TableColumn(number = 2, name = "Kelas")
    private String nm_kelas;
    private String kd_mapel;
    @TableColumn(number = 3, name = "Matapelajaran")
    private String nm_mapel;
    @TableColumn(number = 4, name = "Semester")
    private String semester;
    @TableColumn(number = 5, name = "Tahun Ajaran")
    private String thnAjaran;
    private String createdBy;
    private Timestamp createdDate;
    private String updateBy;
    private Timestamp updateDate;
    
     private List<PenilaianDetail> nilaiDetail = new ArrayList<>();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_nilai() {
        return id_nilai;
    }

    public void setId_nilai(String id_nilai) {
        this.id_nilai = id_nilai;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getThnAjaran() {
        return thnAjaran;
    }

    public void setThnAjaran(String thnAjaran) {
        this.thnAjaran = thnAjaran;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public List<PenilaianDetail> getNilaiDetail() {
        return nilaiDetail;
    }

    public void setNilaiDetail(List<PenilaianDetail> nilaiDetail) {
        this.nilaiDetail = nilaiDetail;
    }
    
    
    
    public void tambahDetailNilai(PenilaianDetail detail) {
        detail.setPenilaian(this);
        nilaiDetail.add(detail);
    }

    
    
}
