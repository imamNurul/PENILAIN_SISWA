/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.Penilaian;
import MI_MAK.dao.PenilaianDetail;
import MI_MAK.dao.PenilaianRangking;
import MI_MAK.dao.PenilaianRekap;
import MI_MAK.db.DatabaseUtilitas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PenilaianService {
    
    private Connection koneksi;
    
    public PenilaianService(){
        koneksi = DatabaseUtilitas.getkoneksi();
        
        try{
            koneksi.setAutoCommit(false);
            
            }catch (SQLException ex){
             Logger.getLogger(PenilaianService.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    
    public void insert(Penilaian nilai){
        
        PreparedStatement prepare = null;
       // PreparedStatement prepare2 = null;
        
        
        try{
            String sql = "INSERT INTO tbl_nilai_header(id_nilai, kd_kelas, nama_kelas, "
                    + "kd_mapel, nama_mapel, semester, tahun_ajaran, createdby, createddate ) "
                    +"VALUES(?,?,?,?,?,?,?,?,?)";
            
            prepare = koneksi.prepareStatement(sql);
            
            
            prepare.setString(1, nilai.getId_nilai());
            prepare.setString(2, nilai.getKd_kelas());
            prepare.setString(3, nilai.getNm_kelas());
            prepare.setString(4, nilai.getKd_mapel());
            prepare.setString(5, nilai.getNm_mapel());
            prepare.setString(6, nilai.getSemester());
            prepare.setString(7, nilai.getThnAjaran());
            prepare.setString(8, nilai.getCreatedBy());
            prepare.setTimestamp(9, new java.sql.Timestamp(nilai.getCreatedDate().getTime()));
            prepare.executeUpdate();
            
//            String sql2 = "INSERT INTO tbl_nilai_detail(id_nilai, kd_siswa, nama_siswa, "
//                    + "UH, UTS, UAS) "
//                    +"VALUES(?,?,?,?,?,?)";
//            
//            prepare2 = koneksi.prepareStatement(sql2);
//            
//            
//            for(PenilaianDetail pd : detail){
//                
//                prepare2.setString(1, pd.getId_nilai());
//                prepare2.setString(2, pd.getKd_siswa());
//                prepare2.setString(3, pd.getNm_siswa());
//                prepare2.setDouble(4, pd.getUH());
//                prepare2.setDouble(5, pd.getUTS());
//                prepare2.setDouble(6, pd.getUAS());
//                
//                 prepare2.addBatch();
//            }
//            
//           prepare2.executeBatch();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
        }catch(SQLException e){
            try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Penilaian 1 : '" +ex+"'.");
            }
             JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Penilaian 2 : '" +e+"'.");
                
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Penilaian 3 : '" +e+"'.");
                   
                }
            }
//            if(prepare2 != null){
//                try{
//                    prepare2.close();
//                }catch(SQLException e){
//                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
//                    JOptionPane.showMessageDialog(frame, "Error Tambah Penilaian 4 : '" +e+"'.");
//                   
//                }
//            }
        }
        
     }
            
                 
    public void update(Penilaian nilai){
        
        PreparedStatement prepare = null;
        
        try {
        String sql = "UPDATE tbl_nilai_header SET id_nilai = ?, kd_kelas = ?, nama_kelas = ?, "
                + "kd_mapel = ?, nama_mapel = ?, semester = ?, tahun_ajaran = ?, "
                + "updatedBy = ?, updatedDate = ? WHERE id = ?";
            
            prepare = koneksi.prepareStatement(sql);
        
            prepare.setString(1, nilai.getId_nilai());
            prepare.setString(2, nilai.getKd_kelas());
            prepare.setString(3, nilai.getNm_kelas());
            prepare.setString(4, nilai.getKd_mapel());
            prepare.setString(5, nilai.getNm_mapel());
            prepare.setString(6, nilai.getSemester());
            prepare.setString(7, nilai.getThnAjaran());
            prepare.setString(8, nilai.getUpdateBy());
            prepare.setTimestamp(9, new java.sql.Timestamp(nilai.getUpdateDate().getTime()));
            prepare.setInt(10, nilai.getId());
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
        
        
        }catch(SQLException e){
            try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Penilaian 1 : '" +ex+"'.");
            }
           JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah Penilaian : '" +e+"'.");   
                      
                    
        }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah Penilaian : '" +e+"'.");
                   
                }
            }
        }
        
    }    
    
        
    public void delete(int id){
            PreparedStatement prepare = null;
    
            try{
                String sql = "DELETE From tbl_nilai_header WHERE id = "+id+"";
                prepare = koneksi.prepareStatement(sql);
                
                prepare.executeUpdate();
                koneksi.commit();
                koneksi.setAutoCommit(true);
            }catch(SQLException e){
                
            }finally{
                if(prepare != null)
                    try{
                        prepare.close();
                    }catch(SQLException e){
                        
                    }
            }
            
    }
    public void deleteDetail(String id){
            PreparedStatement prepare = null;
    
            try{
                String sql = "DELETE From tbl_nilai_detail WHERE id_nilai = '"+id+"'";
                prepare = koneksi.prepareStatement(sql);
                
                prepare.executeUpdate();
                koneksi.commit();
                koneksi.setAutoCommit(true);
            }catch(SQLException e){
                
            }finally{
                if(prepare != null)
                    try{
                        prepare.close();
                    }catch(SQLException e){
                        
                    }
            }
            
    }
            
    public List<Penilaian> SelectAll(String thn){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Penilaian> list = new ArrayList<>();
     try{
             String sql = "SELECT * FROM tbl_nilai_header where tahun_ajaran = '"+thn+"'";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Penilaian nilai = new Penilaian();
                nilai.setNm_kelas(resultSet.getString("nama_kelas"));
                nilai.setId(resultSet.getInt("id"));
                nilai.setId_nilai(resultSet.getString("id_nilai"));
                nilai.setKd_kelas(resultSet.getString("kd_kelas"));
                nilai.setKd_mapel(resultSet.getString("kd_mapel"));
                nilai.setNm_mapel(resultSet.getString("nama_mapel"));
                nilai.setSemester(resultSet.getString("semester"));
                nilai.setThnAjaran(resultSet.getString("tahun_ajaran"));
                
                list.add(nilai);
                
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
    
    public List<Penilaian> SelectNilaiByParam(String mapel, String kls, String thn, String smstr){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<Penilaian> list = new ArrayList<>();
        try{
            
            String sql = "SELECT * FROM tbl_nilai_header WHERE kd_mapel like '%"+mapel+"%' AND kd_kelas like '%"+kls+"%' "
                    + "AND tahun_ajaran like '%"+thn+"%' AND semester like '%"+smstr+"%'";

            prepare = koneksi.prepareStatement(sql);
           // prepare.setString(1, mapel);
           // prepare.setString(2, kls);
           // prepare.setString(3, thn);
          //  prepare.setString(4, smstr);

            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                Penilaian nilai = new Penilaian();
                
                nilai.setNm_kelas(resultSet.getString("nama_kelas"));
                nilai.setId(resultSet.getInt("id"));
                nilai.setId_nilai(resultSet.getString("id_nilai"));
                nilai.setKd_kelas(resultSet.getString("kd_kelas"));
                nilai.setKd_mapel(resultSet.getString("kd_mapel"));
                nilai.setNm_mapel(resultSet.getString("nama_mapel"));
                nilai.setSemester(resultSet.getString("semester"));
                nilai.setThnAjaran(resultSet.getString("tahun_ajaran"));
                
                list.add(nilai);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error select nilai all 1 "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close nilai all 2 "+ex.getMessage());
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
    
    public List<PenilaianDetail> getUbahNilaiDetail(String id){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<PenilaianDetail> list = new ArrayList<>();
        try{
            
            String sql = "select id_nilai, kd_siswa, nama_siswa, UH, UTS, UAS from tbl_nilai_detail "
                    + "WHERE id_nilai = ?";

            prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, id);

            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                PenilaianDetail nilai = new PenilaianDetail();
                
                nilai.setId_nilai(resultSet.getString("id_nilai"));
                nilai.setKd_siswa(resultSet.getString("kd_siswa"));
                nilai.setNm_siswa(resultSet.getString("nama_siswa"));
                nilai.setUH(resultSet.getDouble("UH"));
                nilai.setUTS(resultSet.getDouble("UTS"));
                nilai.setUAS(resultSet.getDouble("UAS"));
                
                list.add(nilai);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error select Nilai Detail "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Nilai Detail "+ex.getMessage());
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
    
    
    public List<PenilaianDetail> getNilaiDetail(String kls){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<PenilaianDetail> list = new ArrayList<>();
        try{
            
            String sql = "select ts.nomor_induk AS NIS, ts.nama_siswa, '' AS id_nilai, '' AS UH, "
                    + "'' AS UTS, '' AS UAS from tbl_siswa ts "
                    + "inner join tbl_kelas kl on kl.kd_kelas = ts.kode_kelas "
                    + "WHERE kl.kd_kelas = ? and ts.flag = 1";

            prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, kls);

            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                PenilaianDetail nilai = new PenilaianDetail();
                
                nilai.setId_nilai(resultSet.getString("id_nilai"));
                nilai.setKd_siswa(resultSet.getString("NIS"));
                nilai.setNm_siswa(resultSet.getString("nama_siswa"));
                nilai.setUH(resultSet.getDouble("UH"));
                nilai.setUTS(resultSet.getDouble("UTS"));
                nilai.setUAS(resultSet.getDouble("UAS"));
                
                list.add(nilai);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error select Nilai Detail "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Nilai Detail "+ex.getMessage());
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
    
    
    public List<PenilaianRekap> getNilaiRekapAll(String sws){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<PenilaianRekap> list = new ArrayList<>();
        try{
            
            String sql = "select nd.id_nilai, nd.kd_siswa, nd.nama_siswa, nh.tahun_ajaran, "
                    + "nh.kd_kelas, nh.nama_kelas, nh.kd_mapel, nh.nama_mapel, nd.UH, nd.UTS, "
                    + "nd.UAS, FORMAT((nd.UH + nd.UTS + nd.UAS)/3,2) AS rapor from tbl_nilai_header nh "
                    + "inner join tbl_nilai_detail nd on nd.id_nilai = nh.id_nilai "
                    + "where nh.tahun_ajaran like '%"+sws+"%'";

            prepare = koneksi.prepareStatement(sql);
           // prepare.setString(1, sws);

            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                PenilaianRekap nilai = new PenilaianRekap();
                
                nilai.setId_nilai(resultSet.getString("id_nilai"));
                nilai.setKd_mapel(resultSet.getString("kd_mapel"));
                nilai.setNm_mapel(resultSet.getString("nama_mapel"));
                nilai.setUH(resultSet.getDouble("UH"));
                nilai.setUTS(resultSet.getDouble("UTS"));
                nilai.setUAS(resultSet.getDouble("UAS"));
                nilai.setRapor(resultSet.getDouble("rapor"));
                
                list.add(nilai);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error select Nilai rekap All 1 "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Nilai Rekap all 1 "+ex.getMessage());
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
    
    public List<PenilaianRekap> getNilaiRekapParam(String sws, String kls, String thn, String smstr){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<PenilaianRekap> list = new ArrayList<>();
        try{
            
            String sql = "select nd.id_nilai, nd.kd_siswa, nd.nama_siswa, nh.tahun_ajaran, "
                    + "nh.kd_kelas, nh.nama_kelas, nh.kd_mapel, nh.nama_mapel, nd.UH, nd.UTS, "
                    + "nd.UAS, FORMAT((nd.UH + nd.UTS + nd.UAS)/3,2) AS rapor from tbl_nilai_header nh "
                    + "inner join tbl_nilai_detail nd on nd.id_nilai = nh.id_nilai "
                    + "where nd.kd_siswa like '%"+sws+"%' and nh.kd_kelas like '%"+kls+"%' "
                    + "and nh.tahun_ajaran like '%"+thn+"%' and nh.semester like '%"+smstr+"%'";

            prepare = koneksi.prepareStatement(sql);
          //  prepare.setString(1, sws);
           // prepare.setString(2, kls);
           // prepare.setString(3, thn);
           // prepare.setString(4, smstr);

            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                PenilaianRekap nilai = new PenilaianRekap();
                
                nilai.setId_nilai(resultSet.getString("id_nilai"));
                nilai.setKd_mapel(resultSet.getString("kd_mapel"));
                nilai.setNm_mapel(resultSet.getString("nama_mapel"));
                nilai.setUH(resultSet.getDouble("UH"));
                nilai.setUTS(resultSet.getDouble("UTS"));
                nilai.setUAS(resultSet.getDouble("UAS"));
                nilai.setRapor(resultSet.getDouble("rapor"));
                
                list.add(nilai);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error select Nilai Detail "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Nilai Detail "+ex.getMessage());
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
    
    
    public List<PenilaianRangking> getNilaiRangkingAll(String thn){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<PenilaianRangking> list = new ArrayList<>();
        try{
            
            String sql = "select nd.kd_siswa, nd.nama_siswa, "
                    + "FORMAT((sum(nd.UH) + sum(nd.UTS) + sum(nd.UAS))/3,2) AS rapor "
                    + "from tbl_nilai_detail nd "
                    + "inner join tbl_siswa sw on sw.nomor_induk = nd.kd_siswa "
                    + "inner join tbl_kelas kl on kl.kd_kelas = sw.kode_kelas "
                    + "left outer join tbl_nilai_header nh on nh.id_nilai = nd.id_nilai "
                    + "where nh.tahun_ajaran like '%"+thn+"%' "
                    + "group by nd.kd_siswa, nd.nama_siswa";

            prepare = koneksi.prepareStatement(sql);
           // prepare.setString(1, sws);

            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                PenilaianRangking nilai = new PenilaianRangking();
                
                nilai.setKd_siswa(resultSet.getString("kd_siswa"));
                nilai.setNm_siswa(resultSet.getString("nama_siswa"));
                nilai.setRataRata(resultSet.getDouble("rapor"));
                
                list.add(nilai);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error select Nilai rekap All 1 "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Nilai Rekap all 1 "+ex.getMessage());
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
    
    public List<PenilaianRangking> getNilaiRangkingParam(String thn, String kls, String smstr){
        
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<PenilaianRangking> list = new ArrayList<>();
        try{
            
            String sql = "select nd.kd_siswa, nd.nama_siswa, "
                    + "FORMAT((sum(nd.UH) + sum(nd.UTS) + sum(nd.UAS))/3,2) AS rapor "
                    + "from tbl_nilai_detail nd "
                    + "inner join tbl_siswa sw on sw.nomor_induk = nd.kd_siswa "
                    + "inner join tbl_kelas kl on kl.kd_kelas = sw.kode_kelas "
                    + "left outer join tbl_nilai_header nh on nh.id_nilai = nd.id_nilai "
                    + "where nh.tahun_ajaran like '%"+thn+"%' and kl.kd_kelas like '%"+kls+"%' and nh.semester like '%"+smstr+"%' "
                    + "group by nd.kd_siswa, nd.nama_siswa";
            

            prepare = koneksi.prepareStatement(sql);
           // prepare.setString(1, sws);

            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                PenilaianRangking nilai = new PenilaianRangking();
                
                 nilai.setKd_siswa(resultSet.getString("kd_siswa"));
                nilai.setNm_siswa(resultSet.getString("nama_siswa"));
                nilai.setRataRata(resultSet.getDouble("rapor"));
                
                list.add(nilai);
                
            }

            return list;
            
        }catch(SQLException e){
            System.out.println("Error select Nilai rekap All 1 "+e.getMessage());
             return list;
        }finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Error close Nilai Rekap all 1 "+ex.getMessage());
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
