/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.user;

import MI_MAK.dao.User;
import MI_MAK.service.UserService;
import javax.swing.JOptionPane;

/**
 *
 * @author Imam-pc
 */
public class TambahUser extends javax.swing.JDialog {

    /**
     * Creates new form TambahUser
     */
    public TambahUser() {
        setModal(true);
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
    }
    
    public void tambahUser(){
        setLocationRelativeTo(this);
        setVisible(true);
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
        panelImageBackground1 = new MI_MAK.widget.PanelImageBackground();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboCat = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtFullName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tambah User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Username :");

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Password :");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Kategori :");

        comboCat.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Admin", "Guru", "Siswa" }));

        jPanel1.setOpaque(false);

        btnSimpan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan);

        btnBatal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Full Name :");

        txtPass.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        txtFullName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelImageBackground1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        if(txtUsername.getText().trim().isEmpty()){
            messageComponent1.showWarning("Username kosong");
        }else if(txtPass.getText().trim().isEmpty()){
            messageComponent1.showWarning("Password kosong");
        }else if(txtFullName.getText().trim().isEmpty()){
            messageComponent1.showWarning("Full Name kosong");
        }else if(comboCat.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Kategori belum dipilih");
        }else {
            
            User user = new User();
            user.setCategory(comboCat.getSelectedItem().toString());
            user.setCreatedby("Admin");
            user.setCreateddate(new java.sql.Timestamp(new java.util.Date().getTime()));
            user.setFlag(1);
            user.setFullname(txtFullName.getText());
            user.setPassword(txtPass.getText());
            user.setUsername(txtUsername.getText());
            
            UserService service = new UserService();
            service.insert(user);
            dispose();
            
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        int closing;
            closing = JOptionPane.showConfirmDialog(this,
        "Apakah anda yakin, ingin batal?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (closing==0){
            dispose();
            
        }else{
            this.show();
        }
    }//GEN-LAST:event_btnBatalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox comboCat;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private MI_MAK.widget.PanelImageBackground panelImageBackground1;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}