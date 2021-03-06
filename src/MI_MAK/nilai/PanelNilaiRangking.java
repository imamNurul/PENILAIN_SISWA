/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.nilai;

import MI_MAK.dao.Kelas;
import MI_MAK.dao.PenilaianRangking;
import MI_MAK.service.KelasService;
import MI_MAK.service.PenilaianService;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Imam-pc
 */
public final class PanelNilaiRangking extends javax.swing.JPanel {

    
    private final int thnFrom;
    private final int thnTo;
    private final DynamicTableModel<PenilaianRangking> tableModelRangking;
    public PanelNilaiRangking() {
        initComponents();
        
        tableModelRangking = new DynamicTableModel<>(PenilaianRangking.class);
        tableRangking.setDynamicModel(tableModelRangking);
        
          Date date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(date.getTime());
        
        thnFrom = date.getYear()+ 1900;
        thnTo = date.getYear()+ 1900;
        
        ChooseThnAjaranFromRangking.setValue(thnFrom - 1);
        ChooseThnAjaranToRangking.setValue(thnTo);
        
        LoadPenilaianRangkingAll(String.valueOf(ChooseThnAjaranFromRangking.getValue())+"/"+String.valueOf(ChooseThnAjaranToRangking.getValue()));
    }
    private final PenilaianService service = new PenilaianService();
    public void LoadPenilaianRangkingAll(String kd){
        
        new SwingWorker<List<PenilaianRangking>, Object>(){

            @Override
            protected List<PenilaianRangking> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<PenilaianRangking> list = service.getNilaiRangkingAll(kd);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModelRangking.clear();
                    for(PenilaianRangking jsb : get()){
                    tableModelRangking.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelNilai_old.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadPenilaianRangkingParam(String thn, String kls, String smt){
        
        new SwingWorker<List<PenilaianRangking>, Object>(){

            @Override
            protected List<PenilaianRangking> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<PenilaianRangking> list = service.getNilaiRangkingParam(thn, kls, smt);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModelRangking.clear();
                    for(PenilaianRangking jsb : get()){
                    tableModelRangking.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelNilai_old.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadKelasCombo(){
        KelasService ks = new KelasService();
        List<Kelas> list =  ks.selectKelas();
        
        list.stream().forEach((kelas) -> {
            comboKlsRanking.addItem(kelas);
            System.out.println("load Kelas: "+kelas);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelKdKls = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        comboKlsRanking = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        comboSmstrRanking = new javax.swing.JComboBox();
        btnCariRangking = new javax.swing.JButton();
        btnTmplknSmuaRangking = new javax.swing.JButton();
        ChooseThnAjaranFromRangking = new com.toedter.calendar.JYearChooser();
        jLabel27 = new javax.swing.JLabel();
        ChooseThnAjaranToRangking = new com.toedter.calendar.JYearChooser();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRangking = new com.stripbandunk.jwidget.JDynamicTable();

        labelKdKls.setText("jLabel1");

        setOpaque(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Filter By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel5.setOpaque(false);

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel21.setText("Kelas");

        comboKlsRanking.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKlsRanking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel22.setText(":");

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel23.setText("Tahun Ajaran ");

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel24.setText("Semester");

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel25.setText(":");

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel26.setText(":");

        comboSmstrRanking.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSmstrRanking.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Ganjil", "Genap" }));

        btnCariRangking.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCariRangking.setText("Cari");
        btnCariRangking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariRangkingActionPerformed(evt);
            }
        });

        btnTmplknSmuaRangking.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnTmplknSmuaRangking.setText("Tampilkan Semua");
        btnTmplknSmuaRangking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmplknSmuaRangkingActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel27.setText("/");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ChooseThnAjaranFromRangking, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChooseThnAjaranToRangking, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboKlsRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSmstrRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCariRangking, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTmplknSmuaRangking, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 137, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnCariRangking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTmplknSmuaRangking))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(jLabel26))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jLabel25)
                                .addComponent(comboSmstrRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ChooseThnAjaranFromRangking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(ChooseThnAjaranToRangking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(comboKlsRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setOpaque(false);

        jScrollPane3.setViewportView(tableRangking);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariRangkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariRangkingActionPerformed
        // TODO add your handling code here:

        String varKls;
        String varSmstr;
        String varThn;

        String thF;
        String thT;

        if(comboKlsRanking.getSelectedItem().equals("All")){
            varKls = "";
        }else{
            varKls = labelKdKls.getText();
        }

        if(comboSmstrRanking.getSelectedItem().equals("All")){
            varSmstr = "";
        }else{
            varSmstr = comboSmstrRanking.getSelectedItem().toString();
        }

        if(ChooseThnAjaranFromRangking.getValue() <= 0 || ChooseThnAjaranToRangking.getValue() <= 0){
            thF = "";
            thT = "";
            varThn = thF+"/"+thT;
        }else{
            thF = String.valueOf(ChooseThnAjaranFromRangking.getValue());
            thT = String.valueOf(ChooseThnAjaranToRangking.getValue());
            varThn = thF+"/"+thT;
        }

        LoadPenilaianRangkingParam(varThn, varKls, varSmstr);

    }//GEN-LAST:event_btnCariRangkingActionPerformed

    private void btnTmplknSmuaRangkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmplknSmuaRangkingActionPerformed
        // TODO add your handling code here:
        LoadPenilaianRangkingAll(String.valueOf(ChooseThnAjaranFromRangking.getValue())+"/"+String.valueOf(ChooseThnAjaranToRangking.getValue()));
        comboKlsRanking.setSelectedItem("All");
        comboSmstrRanking.setSelectedItem("All");

    }//GEN-LAST:event_btnTmplknSmuaRangkingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ChooseThnAjaranFromRangking;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranToRangking;
    private javax.swing.JButton btnCariRangking;
    private javax.swing.JButton btnTmplknSmuaRangking;
    private javax.swing.JComboBox comboKlsRanking;
    private javax.swing.JComboBox comboSmstrRanking;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelKdKls;
    private com.stripbandunk.jwidget.JDynamicTable tableRangking;
    // End of variables declaration//GEN-END:variables
}
