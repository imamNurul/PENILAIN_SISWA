/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.mengajar;

import MI_MAK.dao.Kelas;
import MI_MAK.dao.Mengajar;
import MI_MAK.service.KelasService;
import MI_MAK.service.MengajarService;
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
public class PanelMengajar extends javax.swing.JPanel {

    private final DynamicTableModel<Mengajar> tableModel;
    private Mengajar ajar;
    
    public PanelMengajar() {
        initComponents();
        
        tableModel = new DynamicTableModel<>(Mengajar.class);
        tableMengajar.setDynamicModel(tableModel);
        
    }
    
    private final MengajarService service = new MengajarService();
    
    public void LoadMengajar(String kls, String hari){
        
        new SwingWorker<List<Mengajar>, Object>(){

            @Override
            protected List<Mengajar> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Mengajar> list = service.SelectByKelasHari(kls,hari);
                
                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Mengajar jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelMengajar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadKelasCombo(){
        KelasService ks = new KelasService();
        List<Kelas> list =  ks.selectKelas();
        comboKelas.removeAllItems();
        comboKelas.addItem("All");
        list.stream().forEach((kelas) -> {
            comboKelas.addItem(kelas);
            System.out.println("load Kelas: "+kelas);
        });
        comboHari.setSelectedItem("All");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKdKelas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMengajar = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboHari = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboKelas = new javax.swing.JComboBox();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Cari :");

        txtCari.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(tableMengajar);

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

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Kelas :");

        comboHari.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" }));
        comboHari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHariActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Hari :");

        comboKelas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboHari, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(comboHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        
        TambahMengajar tk = new TambahMengajar();
        tk.tambahMengajar();
        LoadMengajar("","");
        comboHari.setSelectedItem("All");
        LoadKelasCombo();
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        
        if(tableMengajar.getSelectedRow() != -1){
            int index = tableMengajar.convertRowIndexToModel(tableMengajar.getSelectedRow());
            Mengajar kls = tableModel.get(index);
            UbahMengajar ubah = new UbahMengajar();
            ubah.ubahMengajar(kls);
            LoadMengajar("","");
            comboHari.setSelectedItem("All");
            LoadKelasCombo();
        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        if(tableMengajar.getSelectedRow()!= -1){
            if(JOptionPane.showConfirmDialog(this, "Anda yakin ingin menghapus?", "Hapus Data Mengajar",
                    JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
                    int index = tableMengajar.convertRowIndexToModel(tableMengajar.getSelectedRow());
                    Mengajar kls = tableModel.get(index);
                    service.delete(kls.getId());
                    LoadMengajar("","");
                    comboHari.setSelectedItem("All");
                    LoadKelasCombo();
            }
        }else{
            JOptionPane.showMessageDialog(this, "silakan seleksi satu baris");
        }
        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        
        try{
            String cari = txtCari.getText();
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tableMengajar.getRowSorter();
            sorter.setRowFilter(RowFilter.regexFilter(cari));
        }catch(PatternSyntaxException ex){
            
        }
        
    }//GEN-LAST:event_txtCariKeyPressed

    private void comboHariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHariActionPerformed
        // TODO add your handling code here:
        
        if(comboHari.getSelectedIndex() == 0){
          
            if(comboKelas.getSelectedItem().equals("All")){
                LoadMengajar("", "");
            }else{
                LoadMengajar(lblKdKelas.getText(), "");
            }
            
        }else{
            if(comboKelas.getSelectedItem().equals("All")){
                LoadMengajar("", comboHari.getSelectedItem().toString());
            }else{
                LoadMengajar(lblKdKelas.getText(), comboHari.getSelectedItem().toString());
            }
        }
        
    }//GEN-LAST:event_comboHariActionPerformed

    private void comboKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelasActionPerformed
        // TODO add your handling code here:
        switch (comboKelas.getSelectedIndex()) {
            case -1:
            lblKdKelas.setText("");
            break;
            case 0:
            lblKdKelas.setText("");
            if(comboHari.getSelectedItem().equals("All")){
                LoadMengajar("", "");
            }else{
                LoadMengajar("", comboHari.getSelectedItem().toString());
            }
            break;
            default:
            String lblKodeKls;
            lblKodeKls = comboKelas.getSelectedItem().toString();
            System.out.println("combo kelas: "+lblKodeKls);
            String[] prt = lblKodeKls.split("-");
            String varStrKode = prt[0];
            String varStrNama = prt[1];
            System.out.println("split kode: "+varStrKode);
            System.out.println("split nama: "+varStrNama);
            lblKdKelas.setText(varStrNama);
            if(comboHari.getSelectedItem().equals("All")){
                LoadMengajar(lblKdKelas.getText(), "");
            }else{
                LoadMengajar(lblKdKelas.getText(), comboHari.getSelectedItem().toString());
            }
            
            break;
        }

    }//GEN-LAST:event_comboKelasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> comboHari;
    private javax.swing.JComboBox comboKelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKdKelas;
    private com.stripbandunk.jwidget.JDynamicTable tableMengajar;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
