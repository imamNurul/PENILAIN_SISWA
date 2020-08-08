/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.siswa;

import MI_MAK.dao.Siswa;
import MI_MAK.service.SiswaService;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Imam-pc
 */
public class PanelSiswa extends javax.swing.JPanel {

    private final DynamicTableModel<Siswa> tableModel;
    private Siswa siswa;
    private ImageIcon nmSiswa;
    public PanelSiswa() {
        initComponents();
        
        tableModel = new DynamicTableModel<>(Siswa.class);
        tableSiswa.setDynamicModel(tableModel);
        
        tableSiswa.setAutoCreateColumnsFromModel(false);
        tableSiswa.getSelectionModel().addListSelectionListener(new SiswaImgSelection());
        
        
    }
    
    private SiswaService service = new SiswaService();
    
    public void LoadSiswa(){
        
        new SwingWorker<List<Siswa>, Object>(){

            @Override
            protected List<Siswa> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Siswa> list = service.selectAll();

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Siswa jsb : get()){
                    tableModel.add(jsb);
                }
                    comboStatus.setSelectedItem("All");
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelSiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadSiswaByFlag(int fg){
        
        new SwingWorker<List<Siswa>, Object>(){

            @Override
            protected List<Siswa> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Siswa> list = service.selectAllByFlag(fg);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Siswa jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelSiswa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    private class SiswaImgSelection implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(tableSiswa.getSelectedRow() >= 0){
                siswa = tableModel.get(tableSiswa.getSelectedRow());
                siswa = service.SelectImgByCode(siswa.getNomor_induk());
                
                loadImageSiswa();
            }
        }
        
    }
    
    private void loadImageSiswa(){
        int aBlob;
        if(siswa.getPhoto() != null){
            try{
              
                String imgPath = siswa.getPhoto();
                BufferedImage myImg = ImageIO.read(new File(imgPath));
                System.out.println("image path: "+imgPath);
                
                Image rImg = myImg.getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(), Image.SCALE_SMOOTH);
                
               // Graphics2D g = (Graphics2D) rImg.getGraphics();
               // g.setStroke(new BasicStroke(3));
                labelPhoto.setIcon(new ImageIcon(rImg));
                nmSiswa = (ImageIcon) labelPhoto.getIcon();
            }catch(IOException ex){
                labelPhoto.setIcon(null);
                nmSiswa = (ImageIcon) labelPhoto.getIcon();JFrame frame = new JFrame("Message Warning");
                JOptionPane.showMessageDialog(frame, "Photo tidak ditemukan");
                System.out.println("error load image font "+ex.getMessage() );
            }
        }else{
            labelPhoto.setIcon(null);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabInputSiswa = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSiswa = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel2 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        panel_Gambar1 = new MI_MAK.siswa.Panel_Gambar();
        labelPhoto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        tabInputSiswa.setOpaque(false);

        txtCari.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(tableSiswa);

        jPanel2.setOpaque(false);

        btnTambah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambah);

        btnUbah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel2.add(btnUbah);

        btnHapus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus);

        panel_Gambar1.setBackground(new java.awt.Color(255, 255, 255));

        labelPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MI_MAK/image/user-kosong.png"))); // NOI18N

        javax.swing.GroupLayout panel_Gambar1Layout = new javax.swing.GroupLayout(panel_Gambar1);
        panel_Gambar1.setLayout(panel_Gambar1Layout);
        panel_Gambar1Layout.setHorizontalGroup(
            panel_Gambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Gambar1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(labelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_Gambar1Layout.setVerticalGroup(
            panel_Gambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Gambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Cari :");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Status :");

        comboStatus.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Active", "Non Active" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabInputSiswaLayout = new javax.swing.GroupLayout(tabInputSiswa);
        tabInputSiswa.setLayout(tabInputSiswaLayout);
        tabInputSiswaLayout.setHorizontalGroup(
            tabInputSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabInputSiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabInputSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabInputSiswaLayout.createSequentialGroup()
                        .addGroup(tabInputSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabInputSiswaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(panel_Gambar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tabInputSiswaLayout.setVerticalGroup(
            tabInputSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabInputSiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabInputSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabInputSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addGroup(tabInputSiswaLayout.createSequentialGroup()
                        .addComponent(panel_Gambar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Data Siswa", tabInputSiswa);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Data Siswa");
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:

        if(tableSiswa.getSelectedRow() != -1){
            int index = tableSiswa.convertRowIndexToModel(tableSiswa.getSelectedRow());
            Siswa sw = tableModel.get(index);
            UbahSiswa us = new UbahSiswa();
            us.LoadKelasCombo();
            us.ubahSiswa(sw, (ImageIcon) labelPhoto.getIcon());

            LoadSiswa();
            comboStatus.setSelectedItem("All");
        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }

    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:

        TambahSiswa tbh = new TambahSiswa();
        tbh.tambahSiswa();
        tbh.LoadKelasCombo();
        LoadSiswa();
        comboStatus.setSelectedItem("All");
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:

        try{
            String cari = txtCari.getText();
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tableSiswa.getRowSorter();
            sorter.setRowFilter(RowFilter.regexFilter(cari));
        }catch(PatternSyntaxException ex){

        }

    }//GEN-LAST:event_txtCariKeyPressed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
            // TODO add your handling code here:
                // TODO add your handling code here:

        if(tableSiswa.getSelectedRow()!= -1){
            if(JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?", "Hapus Data Mengajar",
                JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
            int index = tableSiswa.convertRowIndexToModel(tableSiswa.getSelectedRow());
            Siswa kls = tableModel.get(index);
             service.delete(kls.getId());
            LoadSiswa();
            comboStatus.setSelectedItem("All");
        }
        
        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }
            
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
        switch (comboStatus.getSelectedIndex()) {
            case 0:
                LoadSiswa();
                break;
            case 1:
                LoadSiswaByFlag(1);
                break;
            default:
                LoadSiswaByFlag(0);
                break;
        }
        
    }//GEN-LAST:event_comboStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelPhoto;
    private MI_MAK.siswa.Panel_Gambar panel_Gambar1;
    private javax.swing.JPanel tabInputSiswa;
    private com.stripbandunk.jwidget.JDynamicTable tableSiswa;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
