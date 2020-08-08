/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.ViewSiswa;
import MI_MAK.dao.Siswa;
import MI_MAK.db.DatabaseUtilitas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Imam-pc
 */
public class SiswaService {
    
     private final Connection koneksi;
     
     public SiswaService(){
         koneksi = DatabaseUtilitas.getkoneksi();
         
         try{
             koneksi.setAutoCommit(false);
             
         }catch (SQLException ex){
             Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     
     public void insert(Siswa siswa){
         
         PreparedStatement prepare = null;
         
         try{
             String sql = "INSERT INTO tbl_siswa(nomor_induk, nama_siswa, tempat_lahir, jenis_kelamin, agama, tahun_masuk, "
                     + "alamat_siswa, nama_ayah, nama_ibu, kj_ayah, kj_ibu, telp_wali, tanggal_lahir, flag, photo, "
                     + "kode_kelas, nama_kelas, createdby, createddate)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, siswa.getNomor_induk());
            prepare.setString(2, siswa.getNama_siswa());
            prepare.setString(3, siswa.getTempat_lahir());
            prepare.setString(4, siswa.getJenis_kelamin());
            prepare.setString(5, siswa.getAgama());
            prepare.setInt(6, siswa.getTahun_masuk());
            prepare.setString(7, siswa.getAlamat_siswa());
            prepare.setString(8, siswa.getNama_ayah());
            prepare.setString(9, siswa.getNama_ibu());
            prepare.setString(10, siswa.getKj_ayah());
            prepare.setString(11, siswa.getKj_ibu());
            prepare.setString(12, siswa.getTelp_wali());
            prepare.setDate(13, new java.sql.Date(siswa.getTanggal_lahir().getTime()));
            prepare.setInt(14, siswa.getFlag());
            prepare.setString(15, siswa.getPhoto());
            prepare.setString(16, siswa.getKode_kelas());
            prepare.setString(17, siswa.getNama_kelas());
            prepare.setString(18, siswa.getCreatedby());
            prepare.setTimestamp(19, new java.sql.Timestamp(siswa.getCreateddate().getTime()));
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
         }catch(SQLException e){
             try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Siswa : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Siswa : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Siswa : '" +e+"'.");
                   
                }
            }
        }
        
     }
     
     public void update(Siswa siswa){
         
         PreparedStatement prepare = null;
         
         try{
             String sql = "UPDATE tbl_siswa SET nomor_induk = ?, nama_siswa = ?, tempat_lahir = ?, jenis_kelamin = ?, "
                     + "agama = ?, tahun_masuk = ?, alamat_siswa = ?, nama_ayah = ?, nama_ibu = ?, kj_ayah = ?, kj_ibu = ?, "
                     + "telp_wali = ?, tanggal_lahir = ?, flag = ?, photo = ?, kode_kelas = ?, nama_kelas = ?, "
                     + "updatedby = ?, updateddate = ? WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, siswa.getNomor_induk());
            prepare.setString(2, siswa.getNama_siswa());
            prepare.setString(3, siswa.getTempat_lahir());
            prepare.setString(4, siswa.getJenis_kelamin());
            prepare.setString(5, siswa.getAgama());
            prepare.setInt(6, siswa.getTahun_masuk());
            prepare.setString(7, siswa.getAlamat_siswa());
            prepare.setString(8, siswa.getNama_ayah());
            prepare.setString(9, siswa.getNama_ibu());
            prepare.setString(10, siswa.getKj_ayah());
            prepare.setString(11, siswa.getKj_ibu());
            prepare.setString(12, siswa.getTelp_wali());
            prepare.setDate(13, new java.sql.Date(siswa.getTanggal_lahir().getTime()));
            prepare.setInt(14, siswa.getFlag());
            prepare.setString(15, siswa.getPhoto());
            prepare.setString(16, siswa.getKode_kelas());
            prepare.setString(17, siswa.getNama_kelas());
            prepare.setString(18, siswa.getUpdatedby());
            prepare.setTimestamp(19, new java.sql.Timestamp(siswa.getUpdateddate().getTime()));
            prepare.setInt(20, siswa.getId());
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
            
         }catch(SQLException e){
               try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah Siswa : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah Siswa : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Ubah Siswa : '" +e+"'.");
                   
                }
            }
        }
         
     }
     
     public void delete(int NIS){
         
         PreparedStatement prepare = null;
         
         try{
             String sql = "UPDATE tbl_siswa SET  flag = ? WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
         Siswa siswa = new Siswa();  
           
            prepare.setInt(1, siswa.getFlag());
            prepare.setInt(2, NIS);
            
            prepare.executeUpdate();
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
            }catch(SQLException e){
                    
                    
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                }
            }
        }
         
     }
     
     public List<Siswa> selectAllByFlag(int fg){
         
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Siswa> list = new ArrayList<>();
        
        try{
             String sql = "SELECT * FROM tbl_siswa where flag = "+fg+"";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Siswa siswa = new Siswa();
                siswa.setAgama(resultSet.getString("agama"));
                siswa.setAlamat_siswa(resultSet.getString("alamat_siswa"));
                siswa.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
                siswa.setKj_ayah(resultSet.getString("kj_ayah"));
                siswa.setKj_ibu(resultSet.getString("kj_ibu"));
                siswa.setNama_ayah(resultSet.getString("nama_ayah"));
                siswa.setNama_ibu(resultSet.getString("nama_ibu"));
                siswa.setNama_siswa(resultSet.getString("nama_siswa"));
                siswa.setNomor_induk(resultSet.getString("nomor_induk"));
                siswa.setPhoto(resultSet.getString("photo"));
                siswa.setTahun_masuk(resultSet.getInt("tahun_masuk"));
                siswa.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));
                siswa.setTelp_wali(resultSet.getString("telp_wali"));
                siswa.setTempat_lahir(resultSet.getString("tempat_lahir"));
                siswa.setId(resultSet.getInt("id"));
                siswa.setNama_kelas(resultSet.getString("nama_kelas"));
                siswa.setKode_kelas(resultSet.getString("kode_kelas"));
                
                list.add(siswa);
                
            }
            
            return list;
            
        }catch(SQLException e){
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                }
            }
        }
         
     }
     
     public List<Siswa> selectAll(){
         
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Siswa> list = new ArrayList<>();
        
        try{
             String sql = "SELECT * FROM tbl_siswa";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Siswa siswa = new Siswa();
                siswa.setAgama(resultSet.getString("agama"));
                siswa.setAlamat_siswa(resultSet.getString("alamat_siswa"));
                siswa.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
                siswa.setKj_ayah(resultSet.getString("kj_ayah"));
                siswa.setKj_ibu(resultSet.getString("kj_ibu"));
                siswa.setNama_ayah(resultSet.getString("nama_ayah"));
                siswa.setNama_ibu(resultSet.getString("nama_ibu"));
                siswa.setNama_siswa(resultSet.getString("nama_siswa"));
                siswa.setNomor_induk(resultSet.getString("nomor_induk"));
                siswa.setPhoto(resultSet.getString("photo"));
                siswa.setTahun_masuk(resultSet.getInt("tahun_masuk"));
                siswa.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));
                siswa.setTelp_wali(resultSet.getString("telp_wali"));
                siswa.setTempat_lahir(resultSet.getString("tempat_lahir"));
                siswa.setId(resultSet.getInt("id"));
                siswa.setNama_kelas(resultSet.getString("nama_kelas"));
                siswa.setKode_kelas(resultSet.getString("kode_kelas"));
                
                list.add(siswa);
                
            }
            
            return list;
            
        }catch(SQLException e){
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                }
            }
        }
         
     }
     
     public List<Siswa> getSiswaByKelas(String kls){
        
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<Siswa> list = new ArrayList<>();
        
        try{
            
            String sql = "SELECT nomor_induk, nama_siswa FROM tbl_siswa WHERE kode_kelas like '%"+kls+"%'";

            prepare = koneksi.prepareStatement(sql);
            //prepare.setString(1, kls);

            result = prepare.executeQuery();
            
            while(result.next()){
                Siswa siswa = new Siswa();
                
                siswa.setNomor_induk(result.getString("nomor_induk"));
                siswa.setNama_siswa(result.getString("nama_siswa"));
                
                list.add(siswa);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error Cari siswa "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Image By Code "+ex.getMessage());
                }
            }
            if(result != null){
                try{
                    result.close();
                }catch(SQLException ex){
                }
            }
        }
        
    }
     
     
     public List<ViewSiswa> CariSiswaByKelas(String kls){
        
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<ViewSiswa> list = new ArrayList<>();
        
        try{
            
            String sql = "SELECT kode_kelas, nama_kelas, nomor_induk, nama_siswa, jenis_kelamin, tahun_masuk "
                    + "FROM tbl_siswa WHERE kode_kelas = ? and flag = 1";

            prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, kls);

            result = prepare.executeQuery();
            
            while(result.next()){
                ViewSiswa siswa = new ViewSiswa();
                
                siswa.setKd_kelas(result.getString("kode_kelas"));
                siswa.setNm_kelas(result.getString("nama_kelas"));
                siswa.setKd_siswa(result.getString("nomor_induk"));
                siswa.setNm_siswa(result.getString("nama_siswa"));
                siswa.setPL(result.getString("jenis_kelamin"));
                siswa.setThnMasuk(result.getInt("tahun_masuk"));
                
                list.add(siswa);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error Cari siswa "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Image By Code "+ex.getMessage());
                }
            }
            if(result != null){
                try{
                    result.close();
                }catch(SQLException ex){
                }
            }
        }
        
    }
     
     
    public Siswa SelectImgByCode(String NIS){
        
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        Siswa siswa = null;
        
        try{
            
            String sql = "SELECT nomor_induk, photo FROM tbl_siswa WHERE nomor_induk = ?";

            prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, NIS);

            result = prepare.executeQuery();
            
            while(result.next()){
                siswa = new Siswa();
                
                siswa.setPhoto(result.getString("photo"));
                
            }

            return siswa;
            
        }catch(SQLException e){
            System.out.println("Error select Image By Code "+e.getMessage());
             return siswa;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Image By Code "+ex.getMessage());
                }
            }
            if(result != null){
                try{
                    result.close();
                }catch(SQLException ex){
                }
            }
        }
        
    }
    
}
