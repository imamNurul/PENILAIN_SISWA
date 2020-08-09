/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.Kelas;
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
public class KelasService {
    
    private final Connection koneksi;
    
    public KelasService(){
        koneksi = DatabaseUtilitas.getkoneksi();
        
        try{
            koneksi.setAutoCommit(false);
            
            }catch (SQLException ex){
             Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    public void insert(Kelas kelas){
        
        PreparedStatement prepare = null;
        
        try{
            String sql = "INSERT INTO tbl_kelas(kd_kelas, nama_kelas, flag, createdby, createddate)"
                    +"VALUES(?,?,?,?,?)";
            
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, kelas.getKd_kelas());
            prepare.setString(2, kelas.getNama_kelas());
            prepare.setInt(3, kelas.getFlag());
            prepare.setString(4, kelas.getCreatedby());
            prepare.setTimestamp(5, new java.sql.Timestamp(kelas.getCreateddate().getTime()));
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
        }catch(SQLException e){
             try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Kelas : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Kelas : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Kelas : '" +e+"'.");
                   
                }
            }
        }
        
     }
            
                 
    public void update(Kelas kelas){
        
        PreparedStatement prepare = null;
        
        try {
        String sql = "UPDATE tbl_kelas SET kd_kelas = ?,nama_kelas = ?, flag = ?, updatedby = ?, updateddate = ? "  
                +"WHERE  id = ?";
            
        prepare = koneksi.prepareStatement(sql);
        
        prepare.setString(1, kelas.getKd_kelas());
        prepare.setString(2, kelas.getNama_kelas());
        prepare.setInt(3, kelas.getFlag());
        prepare.setString(4, kelas.getUpdatedby());
        prepare.setTimestamp(5, new java.sql.Timestamp(kelas.getUpdateddate().getTime()));
        prepare.setInt(6, kelas.getId());
        
        prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
        }catch(SQLException e){
                    
                    
        }
        
    }    
    
        
    public void delete(int KLS){
             PreparedStatement prepare = null;
         
         try{
             String sql = "UPDATE tbl_kelas SET  flag = ? WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            Kelas kelas = new Kelas();  
           
            prepare.setInt(1, kelas.getFlag());
            prepare.setInt(2, KLS);
            
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
            
    public List<Kelas> SelectAll(){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Kelas> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_kelas";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Kelas kelas = new Kelas();
                kelas.setKd_kelas(resultSet.getString("kd_kelas"));
                kelas.setNama_kelas(resultSet.getString("nama_kelas"));
                kelas.setId(resultSet.getInt("id"));
               
                
                
                list.add(kelas);
                
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
    
    public List<Kelas> SelectAllByFlag(int fg){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Kelas> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_kelas where flag = "+fg+"";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Kelas kelas = new Kelas();
                kelas.setKd_kelas(resultSet.getString("kd_kelas"));
                kelas.setNama_kelas(resultSet.getString("nama_kelas"));
                kelas.setId(resultSet.getInt("id"));
               
                
                
                list.add(kelas);
                
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
    
    public List<Kelas> selectKelas(){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Kelas> list = new ArrayList<>();
        
        try{
            String sql = "select distinct kd_kelas, nama_kelas from tbl_kelas where flag = 1 order by nama_kelas ASC";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Kelas kls = new Kelas();
                kls.setKd_kelas(resultSet.getString("kd_kelas"));
                kls.setNama_kelas(resultSet.getString("nama_kelas"));
                
                list.add(kls);
                
            }
            
            System.out.println("list kelas combo: "+list);
            
            return list;
            
        }catch(SQLException e){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 1 : '" +e+"'.");
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 2 : '" +e+"'.");
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 3 : '" +ex+"'.");
                }
            }
        }
    }
    
    public List<Kelas> selectKelasWali(){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Kelas> list = new ArrayList<>();
        
        try{
            String sql = "select kd_kelas, nama_kelas from tbl_kelas "
                    + "WHERE kd_kelas not in ( "
                    + "SELECT kd_kelas FROM tbl_guru where kd_kelas is not null) "
                    + "AND flag = 1 "
                    + "order by nama_kelas ASC";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Kelas kls = new Kelas();
                kls.setKd_kelas(resultSet.getString("kd_kelas"));
                kls.setNama_kelas(resultSet.getString("nama_kelas"));
                
                list.add(kls);
                
            }
            
            System.out.println("list kelas combo: "+list);
            
            return list;
            
        }catch(SQLException e){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 1 : '" +e+"'.");
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 2 : '" +e+"'.");
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 3 : '" +ex+"'.");
                }
            }
        }
    }
    
    public void getKelas(String id){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        Kelas kls = new Kelas();
        
        try{
            String sql = "select kd_kelas, nama_kelas from tbl_kelas"
                    + "WHERE kd_kelas = '"+id+"'";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            kls.setKd_kelas(resultSet.getString("kd_kelas"));
            kls.setNama_kelas(resultSet.getString("nama_kelas"));
                
            
            
            
        }catch(SQLException e){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 1 : '" +e+"'.");
           
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 2 : '" +e+"'.");
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load kelas 3 : '" +ex+"'.");
                }
            }
        }
    }
    
    public List<Kelas> selectKelasNilai(String smtr, String thn){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Kelas> list = new ArrayList<>();
        
        try{
            String sql = "select distinct mp.kd_kelas, mp.nama_kelas from tbl_kelas mp " +
                         "WHERE mp.kd_kelas not in ( " +
                         "  select kd_kelas from vcarikelasnilai where jmlhMapel = totalMapel "+
                         "  and semester = '"+smtr+"' and tahun_ajaran = '"+thn+"') "
                    + "And mp.flag = 1";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Kelas mpl = new Kelas();
                mpl.setKd_kelas(resultSet.getString("kd_kelas"));
                mpl.setNama_kelas(resultSet.getString("nama_kelas"));
                
                list.add(mpl);
                
            }
            
            return list;
            
        }catch(SQLException e){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load mapel 1 : '" +e+"'.");
            return list;
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load mapel 2 : '" +e+"'.");
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Show load mapel 3 : '" +ex+"'.");
                }
            }
        }
    }
    
    
}
