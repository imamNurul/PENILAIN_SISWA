/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.Mengajar;
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
public class MengajarService {
    
    private final Connection koneksi;
    
    public MengajarService(){
        koneksi = DatabaseUtilitas.getkoneksi();
        
        try{
            koneksi.setAutoCommit(false);
            
            }catch (SQLException ex){
             Logger.getLogger(MengajarService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    public void insert(Mengajar ajar){
        
        PreparedStatement prepare = null;
        
        try{
            String sql = "INSERT INTO jdl_mengajar(kode_mengajar, kode_kelas, kode_mapel, kode_guru, hari, "
                    + "jamMulai, jamSelesai, tahunAjaran, flag, createdby, createddate) "
                    +"VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, ajar.getKd_ajar());
            prepare.setString(2, ajar.getKd_kelas());
            prepare.setString(3, ajar.getKd_mapel());
            prepare.setString(4, ajar.getKd_guru());
            prepare.setString(5, ajar.getHari());
            prepare.setTime(6, ajar.getJamMulai());
            prepare.setTime(7, ajar.getJamSelesai());
            prepare.setString(8, ajar.getTahunAjaran());
            prepare.setInt(9, ajar.getFlag());
            prepare.setString(10, ajar.getCreatedby());
            prepare.setTimestamp(11, new java.sql.Timestamp(ajar.getCreateddate().getTime()));
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
        }catch(SQLException e){
             try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(MengajarService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Mengajar : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Mengajar : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Mengajar : '" +e+"'.");
                   
                }
            }
        }
        
     }
            
                 
    public void update(Mengajar ajar){
        
        PreparedStatement prepare = null;
        
        try {
        String sql = "UPDATE jdl_mengajar SET kode_mengajar = ?, kode_kelas = ?, kode_mapel = ?, kode_guru = ?, hari = ?, "
                + "jamMulai = ?, jamSelesai = ?, tahunAjaran = ?, flag = ?, updatedby = ?, updateddate = ? "
                +"WHERE id = ?";
            
            prepare = koneksi.prepareStatement(sql);
        
            prepare.setString(1, ajar.getKd_ajar());
            prepare.setString(2, ajar.getKd_kelas());
            prepare.setString(3, ajar.getKd_mapel());
            prepare.setString(4, ajar.getKd_guru());
            prepare.setString(5, ajar.getHari());
            prepare.setTime(6, ajar.getJamMulai());
            prepare.setTime(7, ajar.getJamSelesai());
            prepare.setString(8, ajar.getTahunAjaran());
            prepare.setInt(9, ajar.getFlag());
            prepare.setString(10, ajar.getUpdatedby());
            prepare.setTimestamp(11, new java.sql.Timestamp(ajar.getUpdateddate().getTime()));
            prepare.setInt(12, ajar.getId());
        
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
        
        }catch(SQLException e){
           try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(MengajarService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah Mengajar : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah Mengajar : '" +e+"'.");         
                    
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Ubah Mengajar : '" +e+"'.");
                   
                }
            }
        }
        
    }    
    
        
    public void delete(int MAPEL){
            PreparedStatement prepare = null;
    
            try{
                String sql = "DELETE From jdl_mengajar WHERE id = "+MAPEL+"";
                prepare = koneksi.prepareStatement(sql);
                
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
            
    public List<Mengajar> SelectAll(){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Mengajar> list = new ArrayList<>();
     try{
             String sql = "SELECT mj.*, kl.nama_kelas, gr.nama_guru, mp.nama_mapel FROM jdl_mengajar mj "
                     + "LEFT JOIN tbl_kelas kl ON kl.kd_kelas = mj.kode_kelas "
                     + "LEFT JOIN tbl_guru gr ON gr.nip = mj.kode_guru "
                     + "LEFT JOIN tbl_mapel mp ON mp.kd_mapel = mj.kode_mapel";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Mengajar ajar = new Mengajar();
                ajar.setKd_ajar(resultSet.getString("kode_mengajar"));
                ajar.setKd_guru(resultSet.getString("kode_guru"));
                ajar.setKd_mapel(resultSet.getString("kode_mapel"));
                ajar.setHari(resultSet.getString("hari"));
                ajar.setId(resultSet.getInt("id"));
                ajar.setJamMulai(resultSet.getTime("jamMulai"));
                ajar.setJamSelesai(resultSet.getTime("jamSelesai"));
                ajar.setKd_kelas(resultSet.getString("kode_kelas"));
                ajar.setTahunAjaran(resultSet.getString("tahunAjaran"));
                ajar.setNm_guru(resultSet.getString("nama_guru"));
                ajar.setNm_kelas(resultSet.getString("nama_kelas"));
                ajar.setNm_mapel(resultSet.getString("nama_mapel"));
               
                list.add(ajar);
                
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
    
    
    public List<Mengajar> SelectByKelasHari(String kls, String hari){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Mengajar> list = new ArrayList<>();
     try{
             String sql = "SELECT distinct mj.*, kl.nama_kelas, gr.nama_guru, mp.nama_mapel FROM jdl_mengajar mj "
                     + "LEFT JOIN tbl_kelas kl ON kl.kd_kelas = mj.kode_kelas "
                     + "LEFT JOIN tbl_guru gr ON gr.nip = mj.kode_guru "
                     + "LEFT JOIN tbl_mapel mp ON mp.kd_mapel = mj.kode_mapel "
                     + "WHERE kl.nama_kelas like '%"+kls+"%' AND mj.hari like '%"+hari+"%' "
                     + "order by mj.kode_mengajar ASC, mj.kode_kelas, mj.jamMulai ASC";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Mengajar ajar = new Mengajar();
                ajar.setKd_ajar(resultSet.getString("kode_mengajar"));
                ajar.setKd_guru(resultSet.getString("kode_guru"));
                ajar.setKd_mapel(resultSet.getString("kode_mapel"));
                ajar.setHari(resultSet.getString("hari"));
                ajar.setId(resultSet.getInt("id"));
                ajar.setJamMulai(resultSet.getTime("jamMulai"));
                ajar.setJamSelesai(resultSet.getTime("jamSelesai"));
                ajar.setKd_kelas(resultSet.getString("kode_kelas"));
                ajar.setTahunAjaran(resultSet.getString("tahunAjaran"));
                ajar.setNm_guru(resultSet.getString("nama_guru"));
                ajar.setNm_kelas(resultSet.getString("nama_kelas"));
                ajar.setNm_mapel(resultSet.getString("nama_mapel"));
                list.add(ajar);
                
            }
            
            return list;
            
        }catch(SQLException e){
              JFrame frame = new JFrame("JOptionPane showMessageDialog example");
              JOptionPane.showMessageDialog(frame, "Error selectByKlasHari Mengajar 1 : '" +e+"'.");
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error selectByKlasHari Mengajar 2 : '" +e+"'.");
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error selectByKlasHari Mengajar 3 : '" +ex+"'.");
                }
            }
        }
         
     }
    
    
    
}
