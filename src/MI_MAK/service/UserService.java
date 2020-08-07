/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.service;

import MI_MAK.dao.User;
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
public class UserService {
    
     private final Connection koneksi;
     
     public UserService(){
         koneksi = DatabaseUtilitas.getkoneksi();
         
         try{
             koneksi.setAutoCommit(false);
             
         }catch (SQLException ex){
             Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     
     public void insert(User user){
         
         PreparedStatement prepare = null;
         
         try{
             String sql = "INSERT INTO user(username, fullname, password, category, flag, createdby, createddate) "
                    + "VALUES(?,?,?,?,?,?,?)";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, user.getUsername());
            prepare.setString(2, user.getFullname());
            prepare.setString(3, user.getPassword());
            prepare.setString(4, user.getCategory());
            prepare.setInt(5, user.getFlag());
            prepare.setString(6, user.getCreatedby());
            prepare.setTimestamp(7, new java.sql.Timestamp(user.getCreateddate().getTime()));
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
         }catch(SQLException e){
             try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah1 User : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Tambah User : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Tambah User : '" +e+"'.");
                   
                }
            }
        }
        
     }
     
     public void update(User user){
         
         PreparedStatement prepare = null;
         
         try{
             String sql = "UPDATE user SET fullname = ?, password = ?, category = ?, updatedby = ?, updateddate = ? "
                    + "WHERE username = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, user.getFullname());
            prepare.setString(2, user.getPassword());
            prepare.setString(3, user.getCategory());
            prepare.setString(4, user.getUpdatedby());
            prepare.setTimestamp(5, new java.sql.Timestamp(user.getUpdateddate().getTime()));
            prepare.setString(6, user.getUsername());
            
            prepare.executeUpdate();
            
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
            
         }catch(SQLException e){
               try {
                koneksi.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah User : '" +ex+"'.");
            }
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Error Ubah User : '" +e+"'.");
         }finally{
            if(prepare != null){
                try{
                    prepare.close();
                }catch(SQLException e){
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame, "Error Ubah User : '" +e+"'.");
                   
                }
            }
        }
         
     }
     
     public void delete(int NIS){
         
       PreparedStatement prepare = null;
         
         try{
             String sql = "UPDATE user SET  flag = ? WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            User user = new User();  
           
            prepare.setInt(1, user.getFlag());
            prepare.setInt(2, NIS);
            
            prepare.executeUpdate();
            koneksi.commit();
            koneksi.setAutoCommit(true);
            
            }catch(SQLException e){
                    
                    
        }
         
     }
     
     public String MD5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
            return md5;
        }
     
     public List<User> selectAll(){
         
        PreparedStatement prepare = null;
        ResultSet resultSet = null;
        
        List<User> list = new ArrayList<>();
        
        try{
             String sql = "SELECT * FROM user where flag = 1";
            prepare = koneksi.prepareStatement(sql);
            
            resultSet = prepare.executeQuery();
            
            while(resultSet.next()){
                User user = new User();
                user.setCategory(resultSet.getString("category"));
                user.setFullname(resultSet.getString("fullname"));
                user.setPassword(MD5(resultSet.getString("password")));
                user.setUsername(resultSet.getString("username"));
                user.setId(resultSet.getInt("id"));
                
                list.add(user);
                
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
