/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.guru;

import MI_MAK.dao.Guru;
import MI_MAK.service.GuruService;
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
public class PanelGuru extends javax.swing.JPanel {

    private final DynamicTableModel<Guru> tableModel;
    private Guru guru;
    private ImageIcon nmGuru;
    public PanelGuru() {
        initComponents();
        
        tableModel = new DynamicTableModel<>(Guru.class);
        tableGuru.setDynamicModel(tableModel);
        
        
        tableGuru.setAutoCreateColumnsFromModel(false);
        tableGuru.getSelectionModel().addListSelectionListener(new PanelGuru.GuruImgSelection());
        
        comboStatus.setSelectedItem("All");
        
    }
    
     private GuruService service = new GuruService();
    
    private class GuruImgSelection implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(tableGuru.getSelectedRow() >= 0){
                guru = tableModel.get(tableGuru.getSelectedRow());
                guru = service.SelectImgByCode(guru.getNip());
                loadImageGuru();
            }
        }
        
    }
    
    public void LoadGuru(){
        
        new SwingWorker<List<Guru>, Object>(){

            @Override
            protected List<Guru> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Guru> list = service.SelectAll();

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Guru jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelGuru.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadGuruByFlag(int fg){
        
        new SwingWorker<List<Guru>, Object>(){

            @Override
            protected List<Guru> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Guru> list = service.SelectAllByFlag(fg);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Guru jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelGuru.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    private void loadImageGuru(){
        int aBlob;
        if(guru.getPhoto() != null){
            try{
              
                String imgPath = guru.getPhoto();
                System.out.println("load image table "+imgPath);
                BufferedImage myImg =ImageIO.read(new File(imgPath));
                System.out.println("image path: "+imgPath);
                Image rImg = myImg.getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(), Image.SCALE_SMOOTH);
                
                labelPhoto.setIcon(new ImageIcon(rImg));
                nmGuru = (ImageIcon) labelPhoto.getIcon();
                System.out.println("load image tableeeeeeeee okeeeee"+nmGuru);
            }catch(IOException ex){
                labelPhoto.setIcon(null);
                nmGuru = (ImageIcon) labelPhoto.getIcon();
                System.out.println("load image tableeeeeeeee noooooo"+nmGuru);
                JFrame frame = new JFrame("Message Warning");
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

        jLabel5 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGuru = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel2 = new javax.swing.JPanel();
        btnTambahGuru = new javax.swing.JButton();
        btnUbahGuru = new javax.swing.JButton();
        btnLihat = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        panel_Gambar2 = new MI_MAK.siswa.Panel_Gambar();
        labelPhoto = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Cari :");

        txtCari.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(tableGuru);

        jPanel2.setOpaque(false);

        btnTambahGuru.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnTambahGuru.setText("Tambah");
        btnTambahGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahGuruActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambahGuru);

        btnUbahGuru.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnUbahGuru.setText("Ubah");
        btnUbahGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahGuruActionPerformed(evt);
            }
        });
        jPanel2.add(btnUbahGuru);

        btnLihat.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLihat.setText("Lihat");
        jPanel2.add(btnLihat);

        btnHapus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus);

        panel_Gambar2.setBackground(new java.awt.Color(255, 255, 255));

        labelPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MI_MAK/image/user-kosong.png"))); // NOI18N

        javax.swing.GroupLayout panel_Gambar2Layout = new javax.swing.GroupLayout(panel_Gambar2);
        panel_Gambar2.setLayout(panel_Gambar2Layout);
        panel_Gambar2Layout.setHorizontalGroup(
            panel_Gambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Gambar2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_Gambar2Layout.setVerticalGroup(
            panel_Gambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Gambar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboStatus.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Active", "Non Active" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Status :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Gambar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(panel_Gambar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:

        try{
            String cari = txtCari.getText();
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tableGuru.getRowSorter();
            sorter.setRowFilter(RowFilter.regexFilter(cari));
        }catch(PatternSyntaxException ex){

        }

    }//GEN-LAST:event_txtCariKeyPressed

    private void btnTambahGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahGuruActionPerformed
        // TODO add your handling code here:

        TambahGuru tbh = new TambahGuru();
        tbh.tambahGuru();
        LoadGuru();
        comboStatus.setSelectedItem("All");

    }//GEN-LAST:event_btnTambahGuruActionPerformed

    private void btnUbahGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahGuruActionPerformed
        // TODO add your handling code here:

        if(tableGuru.getSelectedRow() != -1){
            int index = tableGuru.convertRowIndexToModel(tableGuru.getSelectedRow());
            Guru sw = tableModel.get(index);
            UbahGuru ubh = new UbahGuru();
            ubh.ubahGuru(sw, (ImageIcon) labelPhoto.getIcon());
            LoadGuru();
            comboStatus.setSelectedItem("All");
        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }

    }//GEN-LAST:event_btnUbahGuruActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
       if(tableGuru.getSelectedRow()!= -1){
            if(JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?", "Hapus Data Guru",
                JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
            int index = tableGuru.convertRowIndexToModel(tableGuru.getSelectedRow());
            Guru kls = tableModel.get(index);
             service.delete(kls.getId());
            LoadGuru();
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
            LoadGuru();
            break;
            case 1:
            LoadGuruByFlag(1);
            break;
            default:
            LoadGuruByFlag(0);
            break;
        }

    }//GEN-LAST:event_comboStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLihat;
    private javax.swing.JButton btnTambahGuru;
    private javax.swing.JButton btnUbahGuru;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPhoto;
    private MI_MAK.siswa.Panel_Gambar panel_Gambar2;
    private com.stripbandunk.jwidget.JDynamicTable tableGuru;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
