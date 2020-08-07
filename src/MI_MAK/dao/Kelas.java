/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.dao;
import MI_MAK.widget.FlagCellRendererTable;
import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
/**
 *
 * @author Alvian Syakh
 */
public class Kelas implements Serializable{
    private int id;
    @TableColumn(number = 1, name = "Kode Kelas")
    private String kd_kelas;
    @TableColumn(number = 2, name = "Nama Kelas")
    private String nama_kelas;
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
        return getKd_kelas()+"-"+getNama_kelas();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.kd_kelas);
        hash = 47 * hash + Objects.hashCode(this.nama_kelas);
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
        final Kelas other = (Kelas) obj;
        if (!Objects.equals(this.kd_kelas, other.kd_kelas)) {
            return false;
        }
        if (!Objects.equals(this.nama_kelas, other.nama_kelas)) {
            return false;
        }
        return true;
    }
    
    

       
}
