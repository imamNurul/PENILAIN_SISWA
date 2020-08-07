/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.sql.Timestamp;
import java.util.Objects;
/**
 *
 * @author Alvian Syakh
 */
public class Mapel {
private int id;
@TableColumn(number = 1, name = "Kode Mapel")
private String kd_mapel;
@TableColumn(number = 2, name = "Mata Pelajaran")
private String nama_mapel;
@TableColumn(number = 3, name = "Keterangan")
private String keterangan;
private int flag;
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

    public String getKd_mapel() {
        return kd_mapel;
    }

    public void setKd_mapel(String kd_mapel) {
        this.kd_mapel = kd_mapel;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
        return getKd_mapel()+"-"+getNama_mapel();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.kd_mapel);
        hash = 79 * hash + Objects.hashCode(this.nama_mapel);
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
        final Mapel other = (Mapel) obj;
        if (!Objects.equals(this.kd_mapel, other.kd_mapel)) {
            return false;
        }
        if (!Objects.equals(this.nama_mapel, other.nama_mapel)) {
            return false;
        }
        return true;
    }
    
    


    
}
