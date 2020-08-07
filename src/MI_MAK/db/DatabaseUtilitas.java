/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.db;

import com.mysql.jdbc.Driver;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DatabaseUtilitas {
    private static Connection koneksi;
    
    
    public static Connection getkoneksi(){
        if(koneksi == null){
            try{
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);
                
                String url = "jdbc:mysql://localhost:3306/skripsi";
                String user = "root";
                String password = "";

                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Sukses");
                
            }catch(SQLException ex){
                JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                JOptionPane.showMessageDialog(frame, "Problem Connection : '" +ex+"'.");
                System.exit(0);
        }
        
    }
        return koneksi;
    
}
    
    
}
