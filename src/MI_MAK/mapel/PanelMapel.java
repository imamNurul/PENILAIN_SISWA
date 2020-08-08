/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.mapel;

import MI_MAK.kelas.*;
import MI_MAK.dao.Mapel;
import MI_MAK.dao.Siswa;
import MI_MAK.service.MapelService;
import MI_MAK.siswa.UbahSiswa;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Imam-pc
 */
public class PanelMapel extends javax.swing.JPanel {

    private final DynamicTableModel<Mapel> tableModel;
    private Mapel mapel;
    
    public PanelMapel() {
        initComponents();
        
        tableModel = new DynamicTableModel<>(Mapel.class);
        tableMapel.setDynamicModel(tableModel);
        
        comboStatus.setSelectedItem("All");
        
    }
    
    private MapelService service = new MapelService();
    
    public void LoadMapel(){
        
        new SwingWorker<List<Mapel>, Object>(){

            @Override
            protected List<Mapel> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Mapel> list = service.SelectAll();

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Mapel jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelMapel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadMapelByFlag(int fg){
        
        new SwingWorker<List<Mapel>, Object>(){

            @Override
            protected List<Mapel> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Mapel> list = service.SelectAllByFlag(fg);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Mapel jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelMapel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMapel = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Data Mata Pelajaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Cari :");

        txtCari.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(tableMapel);

        jPanel1.setOpaque(false);

        btnTambah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah);

        btnUbah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah);

        btnHapus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Status :");

        comboStatus.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Active", "Non Active" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        
        TambahMapel tk = new TambahMapel();
        tk.tambahMapel();
        LoadMapel();
        comboStatus.setSelectedItem("All");
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        
        if(tableMapel.getSelectedRow() != -1){
            int index = tableMapel.convertRowIndexToModel(tableMapel.getSelectedRow());
            Mapel mp = tableModel.get(index);
            UbahMapel ubah = new UbahMapel();
            ubah.ubahMapel(mp);
            LoadMapel();
            comboStatus.setSelectedItem("All");
        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
                // TODO add your handling code here:
        
        if(tableMapel.getSelectedRow()!= -1){
            if(JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?", "Hapus Data Mapel",
                    JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
                    int index = tableMapel.convertRowIndexToModel(tableMapel.getSelectedRow());
                    Mapel mp = tableModel.get(index);
                    service.delete(mp.getId());
                    LoadMapel();
                    comboStatus.setSelectedItem("All");
            }
        }else{
            JOptionPane.showMessageDialog(this, "silakan seleksi satu baris");
        }
        
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        
        try{
            String cari = txtCari.getText();
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tableMapel.getRowSorter();
            sorter.setRowFilter(RowFilter.regexFilter(cari));
        }catch(PatternSyntaxException ex){
            
        }
        
    }//GEN-LAST:event_txtCariKeyPressed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
        switch (comboStatus.getSelectedIndex()) {
            case 0:
            LoadMapel();
            break;
            case 1:
            LoadMapelByFlag(1);
            break;
            default:
            LoadMapelByFlag(0);
            break;
        }
    }//GEN-LAST:event_comboStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.stripbandunk.jwidget.JDynamicTable tableMapel;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
