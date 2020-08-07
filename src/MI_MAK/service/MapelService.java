/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.Kelas;
import MI_MAK.dao.Mapel;
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
public class MapelService {
    
    private final Connection koneksi;
    
    public MapelService(){
        koneksi = DatabaseUtilitas.getkoneksi();
        
        try{
            koneksi.setAutoCommit(false);
            
            }catch (SQLException ex){
             Logger.getLogger(MapelService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    public void insert(Mapel mapel){
        
        PreparedStatement prepare = null;
        
        try{
            String sql = "INSERT INTO tbl_mapel(kd_mapel, nama_mapel, keterangan, flag, createdby, createddate) "
                    +"VALUES(?,?,?,?,?,?)";
            
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, mapel.getKd_mapel());
            prepare.setString(2, mapel.getNama_mapel());
            prepare.setString(3, mapel.getKeterangan());
            prepare.setInt(4, mapel.getFlag());
            prepare.setString(5, mapel.getCreatedby());
            prepare.setTimestamp(6, new java.sql.Timestamp(mapel.getCreateddate().getTime()));
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
        }catch(SQLException e){
             try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(MapelService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Mapel : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Mapel : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Mapel : '" +e+"'.");
                   
                }
            }
        }
        
     }
            
                 
    public void update(Mapel mapel){
        
        PreparedStatement prepare = null;
        
        try {
        String sql = "UPDATE tbl_mapel SET kd_mapel = ?, nama_mapel = ?, keterangan = ?, flag = ?, "
                + "updatedby = ?, updateddate = ? WHERE id = ?";
            
            prepare = koneksi.prepareStatement(sql);
        
            prepare.setString(1, mapel.getKd_mapel());
            prepare.setString(2, mapel.getNama_mapel());
            prepare.setString(3, mapel.getKeterangan());
            prepare.setInt(4, mapel.getFlag());
            prepare.setString(5, mapel.getUpdatedby());
            prepare.setTimestamp(6, new java.sql.Timestamp(mapel.getUpdateddate().getTime()));
            prepare.setInt(7, mapel.getId());
        
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
        
        }catch(SQLException e){
           try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(MapelService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Mapel : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Mapel : '" +e+"'.");         
                    
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Mapel : '" +e+"'.");
                   
                }
            }
        }
        
    }    
    
        
    public void delete(int MAPEL){
          PreparedStatement prepare = null;
         
         try{
             String sql = "UPDATE tbl_mapel SET  flag = ? WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
         Mapel mapel = new Mapel();  
           
            prepare.setInt(1, mapel.getFlag());
            prepare.setInt(2, MAPEL);
            
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
    public List<Mapel> SelectAll(){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Mapel> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_mapel";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Mapel mapel = new Mapel();
                mapel.setKd_mapel(resultSet.getString("kd_mapel"));
                mapel.setNama_mapel(resultSet.getString("nama_mapel"));
                mapel.setKeterangan(resultSet.getString("keterangan"));
                mapel.setId(resultSet.getInt("id"));
               
                list.add(mapel);
                
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
            
    public List<Mapel> SelectAllByFlag(int fg){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Mapel> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_mapel where flag = "+fg+"";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Mapel mapel = new Mapel();
                mapel.setKd_mapel(resultSet.getString("kd_mapel"));
                mapel.setNama_mapel(resultSet.getString("nama_mapel"));
                mapel.setKeterangan(resultSet.getString("keterangan"));
                mapel.setId(resultSet.getInt("id"));
               
                list.add(mapel);
                
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
    
    public List<Mapel> selectMapelNilai(String kd){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Mapel> list = new ArrayList<>();
        
        try{
            String sql = "select distinct mp.kd_mapel, mp.nama_mapel from tbl_mapel mp " +
                         "WHERE mp.kd_mapel not in ( " +
                         "    select n.kd_mapel from tbl_nilai_header n  " +
                         "    inner join tbl_kelas k on k.kd_kelas = n.kd_kelas" +
                         "    where k.kd_kelas = '"+kd+"' and n.kd_mapel in (" +
                         "    select kd_mapel from tbl_nilai_header " +
                         "    )) AND mp.flag = 1 order by nama_mapel ASC";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Mapel mpl = new Mapel();
                mpl.setKd_mapel(resultSet.getString("kd_mapel"));
                mpl.setNama_mapel(resultSet.getString("nama_mapel"));
                
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
    
    public List<Mapel> selectKelasNilaiSemesterThnAjaran(String smstr, String thn, String kls){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Mapel> list = new ArrayList<>();
        
        try{
            String sql = "select distinct mp.kd_mapel, mp.nama_mapel from tbl_mapel mp " +
                         "WHERE mp.kd_mapel not in ( " +
                         "    select n.kd_mapel from tbl_nilai_header n  " +
                         "    inner join tbl_kelas k on k.kd_kelas = n.kd_kelas" +
                         "    where n.tahun_ajaran = '"+thn+"' AND n.semester = '"+smstr+"' "+
                         "    AND k.kd_kelas = '"+kls+"' and n.kd_mapel in (" +
                         "    select kd_mapel from tbl_nilai_header " +
                         "    )) mp.flag = 1 order by nama_mapel ASC";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Mapel mpl = new Mapel();
                mpl.setKd_mapel(resultSet.getString("kd_mapel"));
                mpl.setNama_mapel(resultSet.getString("nama_mapel"));
                
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
    
    public List<Mapel> selectMapel(){
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Mapel> list = new ArrayList<>();
        
        try{
            String sql = "select distinct kd_mapel, nama_mapel from tbl_mapel where flag = 1 order by nama_mapel ASC ";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Mapel mpl = new Mapel();
                mpl.setKd_mapel(resultSet.getString("kd_mapel"));
                mpl.setNama_mapel(resultSet.getString("nama_mapel"));
                
                list.add(mpl);
                
            }
            
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
    
    
    
    
}
