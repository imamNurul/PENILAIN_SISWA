/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK;

import MI_MAK.dao.User;
import MI_MAK.db.DatabaseUtilitas;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Imam-pc
 */
public class Login extends javax.swing.JDialog {

    private final Connection koneksi;
    private PreparedStatement prepare;
    private ResultSet rs;
    private User user;
    public Login() {
        koneksi = DatabaseUtilitas.getkoneksi();
        setModal(true);
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jGlassPane1 = new com.stripbandunk.jglasspane.JGlassPane();
        messageComponent1 = new com.stripbandunk.jglasspane.component.MessageComponent();
        jPanel1 = new javax.swing.JPanel();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnLogin = new usu.widget.glass.ButtonImageReflection();
        btnCancel = new usu.widget.glass.ButtonImageReflection();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonImageReflection1.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MI_MAK/image/avatarLoginHijab2 - Copy.png"))); // NOI18N
        buttonImageReflection1.setText("LOGIN");
        buttonImageReflection1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("USERNAME   :");

        txtUser.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txtPass.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("PASSWORD  :");

        jPanel2.setOpaque(false);

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MI_MAK/image/ok-icon.png"))); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MI_MAK/image/Button-Close-icon.png"))); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonImageReflection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPass))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonImageReflection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
        try
        {
            
        String id = txtUser.getText();
       //String sandi = new MD5(new String(txtPass.getPassword())).asHex();
        String sandi = txtPass.getText();

        String sql     = "SELECT * FROM user WHERE username = '"+id+"' and password = '"+sandi+"'";
        prepare = koneksi.prepareStatement(sql);
        rs = prepare.executeQuery();
        
        if(rs.next())
        {
            String userName = rs.getString("username");
            String fullName = rs.getString(("fullName"));
            String Kategori = rs.getString("category");
            //String Password = rs.getString("password");
           JOptionPane.showMessageDialog(null,"Selamat Datang "+Kategori+"\n"+fullName);
           
           user = new User();
           user.setUsername(userName);
           user.setFullname(fullName);
           user.setCategory(Kategori);
           
           
            MenuUtama formUtama = new MenuUtama();
            formUtama.getUser(user);
            formUtama.setLocationRelativeTo(this);
            formUtama.setVisible(true);
            
            dispose();
           
        }else{
            txtUser.setText("");
            txtPass.setText("");
               JOptionPane.showMessageDialog(this, "pengguna dengan Username atau Password tidak dapat ditemukan");
           }
        }catch(SQLException | HeadlessException e) 
        {
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        
        int closing;
            closing = JOptionPane.showConfirmDialog(this,
        "Apakah anda yakin, ingin keluar dari Aplikasi ini...?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (closing==0){
            System.exit(0);
            
        }else{
            this.show();
        }
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.glass.ButtonImageReflection btnCancel;
    private usu.widget.glass.ButtonImageReflection btnLogin;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection1;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
