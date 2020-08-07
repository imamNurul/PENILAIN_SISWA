/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sista
 */
public class Main {
 

    /**
     * @param args the command line arguments
     */
    
    private static Connection koneksi;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ProgressBar pb = new ProgressBar();
        pb.setVisible(true);
        for(int i=0;i<=100;i++){
            try {
                pb.getProgressBar().setValue(i);
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pb.dispose();
       /* try {
           UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null,ex);
        }*/
        
            
           // Registry registry = LocateRegistry.getRegistry("192.168.100.5",6789);
          //  registry.lookup("service");
            
           // final UserService Usservice = (UserService) registry.lookup("service");
           // final Tahap1Service service1 = (Tahap1Service) registry.lookup("service");
           // final Tahap2Service service2 = (Tahap2Service) registry.lookup("service");
            
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                   try {
                UIManager.setLookAndFeel(
                new com.jtattoo.plaf.mcwin.McWinLookAndFeel());
                
        Login tampilan = new Login();
                    Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
                    int lebar=(screen.width-tampilan.getSize().width)/2;
                    int tinggi=(screen.height-tampilan.getSize().height)/2;
                    // tampilan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    tampilan.setLocation(lebar,tinggi);
                    tampilan.setResizable(false);

                    tampilan.setVisible(true);
                
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                    
                    
                    
                }
            });
         
        

        

    }
}
