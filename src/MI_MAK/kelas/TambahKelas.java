/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.kelas;

import MI_MAK.dao.Kelas;
import MI_MAK.db.DatabaseUtilitas;
import MI_MAK.service.KelasService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Imam-pc
 */
public class TambahKelas extends javax.swing.JDialog {

    /**
     * Creates new form TambahKelas
     */
    private Connection koneksi;
    private String kode;
    public TambahKelas() {
        setModal(true);
        koneksi = DatabaseUtilitas.getkoneksi();
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
    }
    
    public void tambahKelas(){
        
        setLocationRelativeTo(this);
        setVisible(true);
    }
    
    protected String validateKode(String id) {
        kode = null;
        try {
            String sql = "SELECT kd_kelas FROM tbl_kelas where kd_kelas = '"+id+"'";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
          
            while (rs.next()) {
                kode = rs.getString("kd_kelas");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "validate Kode gagal" + e);
        }
        
        return kode;
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
        txtKodeKelas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNamaKelas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tambah Kelas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Kode Kelas :");

        txtKodeKelas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtKodeKelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKodeKelasKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Nama Kelas :");

        txtNamaKelas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtNamaKelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNamaKelasKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKodeKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamaKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelImageBackground1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        if(txtKodeKelas.getText().trim().isEmpty()){
            messageComponent1.showWarning("Kode Kelas Kosong");
        }else if(txtNamaKelas.getText().trim().isEmpty()){
            messageComponent1.showWarning("Nama Kelas kosong");
        }else{
            
            validateKode(txtKodeKelas.getText());
            if(kode != null){
                messageComponent1.showWarning("Kode Kelas sudah ada");
            }else{
                Kelas kl = new Kelas();
                kl.setCreatedby("Admin");
                kl.setCreateddate(new java.sql.Timestamp(new java.util.Date().getTime()));
                kl.setKd_kelas(txtKodeKelas.getText());
                kl.setFlag(1);
                kl.setNama_kelas(txtNamaKelas.getText());

                KelasService service = new KelasService();
                service.insert(kl);
                dispose();
            }
            
            
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtKodeKelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeKelasKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();

        if(Character.isLetter(c) || Character.isISOControl(c) || Character.isDigit(c))
        {
            evt = evt;
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txtKodeKelasKeyTyped

    private void txtNamaKelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKelasKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();

        if(Character.isLetter(c) || Character.isISOControl(c) || Character.isDigit(c) || Character.isSpaceChar(c))
        {
            evt = evt;
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txtNamaKelasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private MI_MAK.widget.PanelImageBackground panelImageBackground1;
    private javax.swing.JTextField txtKodeKelas;
    private javax.swing.JTextField txtNamaKelas;
    // End of variables declaration//GEN-END:variables
}
