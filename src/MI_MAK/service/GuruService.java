/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.Guru;
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
 * @author Alvian Syakh
 */
public class GuruService {
    
    private final Connection koneksi;
    
    public GuruService(){
        koneksi = DatabaseUtilitas.getkoneksi();
        
        try{
            koneksi.setAutoCommit(false);
            
            }catch (SQLException ex){
             Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    public void insert(Guru guru){
        
        PreparedStatement prepare = null;
        
        try{
            String sql = "INSERT INTO tbl_guru(nip, nama_guru, tempat_lahir,tanggal_lahir, jenis_kelamin, "
                    +"agama, pendidikan_terakhir, telp, status, alamat, photo, flag, wali_kelas, kd_kelas, nm_kelas, "
                    + "kd_mapel, nm_mapel, createdby, createddate)"
                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, guru.getNip());
            prepare.setString(2, guru.getNama_guru());
            prepare.setString(3, guru.getTempat_lahir());
            prepare.setDate(4, new java.sql.Date(guru.getTanggal_lahir().getTime()));
            prepare.setString(5, guru.getJenis_kelamin());
            prepare.setString(6, guru.getAgama());
            prepare.setString(7, guru.getPendidikan_terakhir());
            prepare.setString(8, guru.getTelp());
            prepare.setString(9, guru.getStatus());
            prepare.setString(10, guru.getAlamat());
            prepare.setString(11, guru.getPhoto());
            prepare.setInt(12, guru.getFlag());
            prepare.setString(13, guru.getWaliKelas());
            prepare.setString(14, guru.getKd_kelas());
            prepare.setString(15, guru.getNm_kelas());
            prepare.setString(16, guru.getKd_mapel());
            prepare.setString(17, guru.getNm_mapel());
            
            prepare.setString(18, guru.getCreatedby());
            prepare.setTimestamp(19, new java.sql.Timestamp(guru.getCreateddate().getTime()));
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
        }catch(SQLException e){
             try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Guru : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Guru : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Guru : '" +e+"'.");
                   
                }
            }
        }
        
     }
            
                 
    public void update(Guru guru){
        
        PreparedStatement prepare = null;
        
        try {
        String sql = "UPDATE tbl_guru SET nip = ?, nama_guru = ?, tempat_lahir = ?, tanggal_lahir = ?, jenis_kelamin = ?, "
                + "agama = ?, pendidikan_terakhir = ?, telp = ?, status = ?, alamat = ?, photo = ?, flag = ?, "
                + "wali_kelas = ?, kd_kelas = ?, nm_kelas = ?, kd_mapel = ?, nm_mapel = ?, updatedby = ?, updateddate = ? "
                +"WHERE id = ?";
            
        prepare = koneksi.prepareStatement(sql);
        
        prepare.setString(1, guru.getNip());
        prepare.setString(2, guru.getNama_guru());        
        prepare.setString(3, guru.getTempat_lahir());        
        prepare.setDate(4, new java.sql.Date(guru.getTanggal_lahir().getTime()));          
        prepare.setString(5, guru.getJenis_kelamin());        
        prepare.setString(6, guru.getAgama());        
        prepare.setString(7, guru.getPendidikan_terakhir());        
        prepare.setString(8, guru.getTelp());      
        prepare.setString(9, guru.getStatus());        
        prepare.setString(10, guru.getAlamat());   
        prepare.setString(11, guru.getPhoto());
        prepare.setInt(12, guru.getFlag());
        prepare.setString(13, guru.getWaliKelas());
        prepare.setString(14, guru.getKd_kelas());
        prepare.setString(15, guru.getNm_kelas());
        prepare.setString(16, guru.getKd_mapel());
        prepare.setString(17, guru.getNm_mapel());
        prepare.setString(18, guru.getUpdatedby());
        prepare.setTimestamp(19, new java.sql.Timestamp(guru.getUpdateddate().getTime()));
        prepare.setInt(20, guru.getId());
        
        prepare.executeUpdate();
            
        koneksi.commit();
        koneksi.setAutoCommit(true);
        
        }catch(SQLException e){
          try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah Guru : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah Guru : '" +e+"'.");          
                    
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Ubah Guru : '" +e+"'.");
                   
                }
            }
        }
        
    }    
    
        
    public void delete(int NIP){
             PreparedStatement prepare = null;
         
         try{
             String sql = "UPDATE tbl_guru SET flag = ? WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
         Guru guru = new Guru();  
           
            prepare.setInt(1, guru.getFlag());
            prepare.setInt(2, NIP);
            
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
            
    public List<Guru> SelectAll(){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Guru> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_guru";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Guru guru = new Guru();
                guru.setNip(resultSet.getString("nip"));
                guru.setNama_guru(resultSet.getString("nama_guru"));
                guru.setTempat_lahir(resultSet.getString("tempat_lahir"));
                guru.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));
                guru.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
                guru.setAgama(resultSet.getString("agama"));
                guru.setPendidikan_terakhir(resultSet.getString("pendidikan_terakhir"));
                guru.setTelp(resultSet.getString("telp"));
                guru.setStatus(resultSet.getString("status"));
                guru.setAlamat(resultSet.getString("alamat"));
                guru.setPhoto(resultSet.getString("photo"));
                guru.setId(resultSet.getInt("id"));
                guru.setWaliKelas(resultSet.getString("wali_kelas"));
                guru.setNm_kelas(resultSet.getString("nm_kelas"));
                guru.setKd_mapel(resultSet.getString("kd_mapel"));
                guru.setNm_mapel(resultSet.getString("nm_mapel"));
                guru.setKd_kelas(resultSet.getString("kd_kelas"));
               
                
                list.add(guru);
                
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
    
    public List<Guru> SelectAllByFlag(int fg){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Guru> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_guru where flag = "+fg+"";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Guru guru = new Guru();
                guru.setNip(resultSet.getString("nip"));
                guru.setNama_guru(resultSet.getString("nama_guru"));
                guru.setTempat_lahir(resultSet.getString("tempat_lahir"));
                guru.setTanggal_lahir(resultSet.getDate("tanggal_lahir"));
                guru.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
                guru.setAgama(resultSet.getString("agama"));
                guru.setPendidikan_terakhir(resultSet.getString("pendidikan_terakhir"));
                guru.setTelp(resultSet.getString("telp"));
                guru.setStatus(resultSet.getString("status"));
                guru.setAlamat(resultSet.getString("alamat"));
                guru.setPhoto(resultSet.getString("photo"));
                guru.setId(resultSet.getInt("id"));
                guru.setWaliKelas(resultSet.getString("wali_kelas"));
                guru.setNm_kelas(resultSet.getString("nm_kelas"));
                guru.setKd_mapel(resultSet.getString("kd_mapel"));
                guru.setNm_mapel(resultSet.getString("nm_mapel"));
                guru.setKd_kelas(resultSet.getString("kd_kelas"));
               
                
                list.add(guru);
                
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
    
    public Guru SelectImgByCode(String NIS){
        
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        Guru siswa = null;
        
        try{
            
            String sql = "SELECT nip, photo FROM tbl_guru WHERE nip = ?";

            prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, NIS);

            result = prepare.executeQuery();
            
            while(result.next()){
                siswa = new Guru();
                
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
    
    public List<Guru> selectGuru(){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Guru> list = new ArrayList<>();
        
        try{
            String sql = "select distinct nip, nama_guru from tbl_guru order by nama_guru ASC";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Guru guru = new Guru();
                guru.setNip(resultSet.getString("nip"));
                guru.setNama_guru(resultSet.getString("nama_guru"));
                
                list.add(guru);
                
            }
            
            return list;
            
        }catch(SQLException e){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load guru 1 : '" +e+"'.");
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load guru 2 : '" +e+"'.");
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load guru 3 : '" +ex+"'.");
                }
            }
        }
    }
    
    public List<Guru> selectGuruByMapel(String mapel){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Guru> list = new ArrayList<>();
        
        try{
            String sql = "select distinct nip, nama_guru from tbl_guru "
                    + "WHERE kd_mapel = '"+mapel+"' "
                    + "order by nama_guru ASC";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Guru guru = new Guru();
                guru.setNip(resultSet.getString("nip"));
                guru.setNama_guru(resultSet.getString("nama_guru"));
                
                list.add(guru);
                
            }
            
            return list;
            
        }catch(SQLException e){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load guru 1 : '" +e+"'.");
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load guru 2 : '" +e+"'.");
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load guru 3 : '" +ex+"'.");
                }
            }
        }
    }
    
    
    
    
}
