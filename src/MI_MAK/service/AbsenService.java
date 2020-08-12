/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.Absen;
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
public class AbsenService {
    
    private final Connection koneksi;
    
    public AbsenService(){
        koneksi = DatabaseUtilitas.getkoneksi();
        
        try{
            koneksi.setAutoCommit(false);
            
            }catch (SQLException ex){
             Logger.getLogger(AbsenService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    public void insert(Absen absen){
        
        PreparedStatement prepare = null;
        
        try{
            String sql = "INSERT INTO tbl_absensi(kd_absen, kd_kelas, nama_kelas, kd_siswa, nama_siswa, "
                    + "tgl_buat, semester, tgl_dari, tgl_sampai, hadir, sakit, izin, alpa, keterangan) "
                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, absen.getKd_absen());
            prepare.setString(2, absen.getKd_kelas());
            prepare.setString(3, absen.getNama_kelas());
            prepare.setString(4, absen.getKd_siswa());
            prepare.setString(5, absen.getNama_siswa());
            prepare.setTimestamp(6, new java.sql.Timestamp(absen.getTgl_buat().getTime()));
            prepare.setString(7, absen.getSemester());
            prepare.setDate(8, new java.sql.Date(absen.getTglDari().getTime()));
            prepare.setDate(9, new java.sql.Date(absen.getTglSampai().getTime()));
            prepare.setLong(10, absen.getHadir());
            prepare.setLong(11, absen.getSakit());
            prepare.setLong(12, absen.getIzin());
            prepare.setLong(13, absen.getAlpa());
            prepare.setString(14, absen.getKet());
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
        }catch(SQLException e){
             try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(AbsenService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Absen : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Absen : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Absen : '" +e+"'.");
                   
                }
            }
        }
        
     }
            
                 
    public void update(Absen absen){
        
        PreparedStatement prepare = null;
        
        try {
        String sql = "UPDATE tbl_absensi SET kd_absen = ?, kd_kelas = ?, nama_kelas = ?, kd_siswa = ?, "
                + "nama_siswa = ?, tgl_ubah = ?, semester = ?, tgl_dari = ?, tgl_sampai = ?, hadir = ?, "
                + "sakit = ?, izin = ?, alpa = ?, keterangan = ? WHERE id = ?";
            
            prepare = koneksi.prepareStatement(sql);
        
            prepare.setString(1, absen.getKd_absen());
            prepare.setString(2, absen.getKd_kelas());
            prepare.setString(3, absen.getNama_kelas());
            prepare.setString(4, absen.getKd_siswa());
            prepare.setString(5, absen.getNama_siswa());
            prepare.setTimestamp(6, new java.sql.Timestamp(absen.getTgl_ubah().getTime()));
            prepare.setString(7, absen.getSemester());
            prepare.setDate(8, new java.sql.Date(absen.getTglDari().getTime()));
            prepare.setDate(9, new java.sql.Date(absen.getTglSampai().getTime()));
            prepare.setLong(10, absen.getHadir());
            prepare.setLong(11, absen.getSakit());
            prepare.setLong(12, absen.getIzin());
            prepare.setLong(13, absen.getAlpa());
            prepare.setString(14, absen.getKet());
            prepare.setInt(15, absen.getId());
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
        
        
        }catch(SQLException e){
           try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(AbsenService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Absen : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Absen : '" +e+"'.");          
                    
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Absen : '" +e+"'.");
                   
                }
            }
        }
        
    }    
    
        
    public void delete(int id){
            PreparedStatement prepare = null;
    
            try{
                String sql = "DELETE From tbl_absensi WHERE id = ?";
                prepare = koneksi.prepareStatement(sql);
                
                prepare.setInt(1, id);
                prepare.executeUpdate();
                
            }catch(SQLException e){
                
            }finally{
                if(prepare != null)
                    try{
                        prepare.close();
                    }catch(SQLException e){
                        
                    }
            }
            
    }
            
    public List<Absen> SelectAll(){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Absen> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_absensi";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Absen absen = new Absen();
                absen.setKd_absen(resultSet.getString("kd_absen"));
                absen.setKd_kelas(resultSet.getString("kd_kelas"));
                absen.setNama_kelas(resultSet.getString("nama_kelas"));
                absen.setSakit(resultSet.getLong("sakit"));
                absen.setKd_siswa(resultSet.getString("kd_siswa"));
                absen.setNama_siswa(resultSet.getString("nama_siswa"));
                absen.setSemester(resultSet.getString("semester"));
                absen.setIzin(resultSet.getLong("izin"));
                absen.setAlpa(resultSet.getLong("alpa"));
                absen.setTgl_buat(resultSet.getTimestamp("tgl_buat"));
                absen.setTgl_ubah(resultSet.getTimestamp("tgl_ubah"));
                absen.setId(resultSet.getInt("id"));
                absen.setTglDari(resultSet.getDate("tgl_dari"));
                absen.setTglSampai(resultSet.getDate("tgl_sampai"));
                absen.setKet(resultSet.getString("keterangan"));
                absen.setHadir(resultSet.getLong("hadir"));
               
                list.add(absen);
                
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
    
    
    
}
