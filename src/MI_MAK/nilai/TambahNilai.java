/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.nilai;

import MI_MAK.dao.Kelas;
import MI_MAK.dao.Mapel;
import MI_MAK.dao.Penilaian;
import MI_MAK.dao.PenilaianDetail;
import MI_MAK.db.DatabaseUtilitas;
import MI_MAK.service.KelasService;
import MI_MAK.service.MapelService;
import MI_MAK.service.PenilaianService;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Imam-pc
 */
public class TambahNilai extends javax.swing.JDialog {

    private final int thnFrom;
    private final int thnTo;
    private final DynamicTableModel<PenilaianDetail> tableModel;
    private PenilaianDetail pd;
    private Penilaian nilai;
    private final Connection konek;
    private String kode;
    private String idNilai;
    public TambahNilai() {
        setModal(true);
        konek = DatabaseUtilitas.getkoneksi();
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
        tableModel = new DynamicTableModel<>(PenilaianDetail.class);
        tableNilaiDetail.setDynamicModel(tableModel);
        
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(date.getTime());
        
        thnFrom = date.getYear()+ 1900;
        thnTo = date.getYear()+ 1900;
        
        ChooseThnAjaranFrom.setValue(thnFrom - 1);
        ChooseThnAjaranTo.setValue(thnTo);
        
    }
    
    public void tambahNilai(){
        
        
        setLocationRelativeTo(this);
        setVisible(true);
        
    }
    
    protected String validateKode(String id) {
        kode = null;
        try {
            String sql = "SELECT id_nilai FROM tbl_nilai_header where id_nilai = '"+id+"'";
            Statement st = konek.createStatement();
            ResultSet rs = st.executeQuery(sql);
          
            while (rs.next()) {
                kode = rs.getString("id_nilai");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "validate Kode gagal" + e);
        }
        
        return kode;
    }
    
    protected String validateDataNilai(String thn, String smstr, String kls, String mapel ) {
       
        try {
            String sql = "SELECT id_nilai, tahun_ajaran, semester, kd_kelas, kd_mapel FROM tbl_nilai_header where "
                    + "tahun_ajaran = '"+thn+"' AND "
                    + "semester = '"+smstr+"' AND "
                    + "kd_kelas = '"+kls+"' AND "
                    + "kd_mapel = '"+mapel+"' ";
            Statement st = konek.createStatement();
            ResultSet rs = st.executeQuery(sql);
          
            while (rs.next()) {
                idNilai = rs.getString("id_nilai");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "validate Data Nilai gagal" + e);
        }
        
        return idNilai;
        
    }
    
    public void LoadKelasCombo(String smtr, String thn){
        KelasService ks = new KelasService();
        List<Kelas> list =  ks.selectKelasNilai(smtr, thn);
        comboKls.removeAllItems();
        comboKls.addItem("Pilih");
        list.stream().forEach((kelas) -> {
            comboKls.addItem(kelas);
            System.out.println("load Kelas: "+kelas);
        });
    }
    
    public void LoadMapelCombo(String kl){
        MapelService ms = new MapelService();
        List<Mapel> list =  ms.selectMapelNilai(kl);
        comboMapel.removeAllItems();
        comboMapel.addItem("Pilih");
        list.stream().forEach((mp) -> {
            comboMapel.addItem(mp);
        });
    }
    
    private final PenilaianService service = new PenilaianService();
    
    public void LoadNilaiDetail(){
        
        new SwingWorker<List<PenilaianDetail>, Object>(){

            @Override
            protected List<PenilaianDetail> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<PenilaianDetail> list = service.getNilaiDetail(labelKdKls.getText());

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(PenilaianDetail jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(TambahNilai.class.getName()).log(Level.SEVERE, null, ex);
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

        labelKdMapel = new javax.swing.JLabel();
        labelNmMapel = new javax.swing.JLabel();
        labelKdKls = new javax.swing.JLabel();
        labelNmKls = new javax.swing.JLabel();
        jGlassPane1 = new com.stripbandunk.jglasspane.JGlassPane();
        messageComponent1 = new com.stripbandunk.jglasspane.component.MessageComponent();
        panelImageBackground1 = new MI_MAK.widget.PanelImageBackground();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ChooseThnAjaranFrom = new com.toedter.calendar.JYearChooser();
        jLabel19 = new javax.swing.JLabel();
        ChooseThnAjaranTo = new com.toedter.calendar.JYearChooser();
        jLabel9 = new javax.swing.JLabel();
        txtKodeNilai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        comboSmstr = new javax.swing.JComboBox();
        comboKls = new javax.swing.JComboBox();
        comboMapel = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNilaiDetail = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel3 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tambah Nilai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Form Input Header", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Tahun Ajaran");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Semester");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Mata Pelajaran");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText("Kelas");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText(":");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText(":");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText(":");

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel19.setText("/");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText("Kode Nilai");

        txtKodeNilai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText(":");

        comboSmstr.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSmstr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Ganjil", "Genap" }));
        comboSmstr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSmstrActionPerformed(evt);
            }
        });

        comboKls.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKls.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboKls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKlsActionPerformed(evt);
            }
        });

        comboMapel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboMapel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKodeNilai))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboSmstr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMapel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboKls, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(txtKodeNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))
                                    .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(comboSmstr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboKls, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(comboMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Form Input Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N
        jPanel2.setOpaque(false);

        jScrollPane1.setViewportView(tableNilaiDetail);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setOpaque(false);

        btnSimpan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan);

        btnBatal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel3.add(btnBatal);

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelImageBackground1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboKlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKlsActionPerformed
        // TODO add your handling code here:

        
        if(comboKls.getSelectedIndex() == -1){
            tableModel.clear();
        }else if(comboKls.getSelectedItem().equals("Pilih")){
            tableModel.clear();
        }else{
            
            String lblKodeKls;
            lblKodeKls = comboKls.getSelectedItem().toString();
            System.out.println("combo kelas: "+lblKodeKls);
            String[] prt = lblKodeKls.split("-");
            String varStrKode = prt[0];
            String varStrNama = prt[1];
            System.out.println("split kode: "+varStrKode);
            System.out.println("split nama: "+varStrNama);
            labelKdKls.setText(varStrKode);
            labelNmKls.setText(varStrNama);
            
            LoadNilaiDetail();
            LoadMapelCombo(labelKdKls.getText());
        }
        
        

    }//GEN-LAST:event_comboKlsActionPerformed

    private void comboMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapelActionPerformed
        // TODO add your handling code here:
        
        System.out.println("idex combo mapel: "+comboMapel.getSelectedIndex());
        System.out.println("count combo mapel: "+comboMapel.getItemCount());
        
        System.out.println("idex combo mapel: "+comboMapel.getSelectedIndex());
        System.out.println("count combo mapel: "+comboMapel.getItemCount());
        if(comboKls.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Kelas belum dipilih");
        }else if(comboMapel.getSelectedIndex() == -1){
            messageComponent1.showWarning("Pilih mapel");
        }else if(comboMapel.getSelectedIndex() == 0){
            messageComponent1.showWarning("Mapel belum dipilih");
        }else{
            String lblKodeMapel;
            lblKodeMapel = comboMapel.getSelectedItem().toString();
            System.out.println("combo mapel: "+lblKodeMapel);
            String[] prt = lblKodeMapel.split("-");
            String varStrKode = prt[0];
            String varStrNama = prt[1];
            System.out.println("split kode: "+varStrKode);
            System.out.println("split nama: "+varStrNama);
            labelKdMapel.setText(varStrKode);
            labelNmMapel.setText(varStrNama);
            
            System.out.println("combo mapel kd_mapel: "+labelKdMapel.getText());
            System.out.println("combo mapel nm_mapel: "+labelNmMapel.getText());
        }

        

    }//GEN-LAST:event_comboMapelActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        if(txtKodeNilai.getText().trim().isEmpty()){
            messageComponent1.showWarning("Kode Nilai Kosong");
        }else if(ChooseThnAjaranFrom.getValue() == 0 || ChooseThnAjaranFrom == null
                || ChooseThnAjaranTo.getValue() == 0 || ChooseThnAjaranTo == null){
            messageComponent1.showWarning("Tahun Ajaran kosong");
        }else if(comboSmstr.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Semester belum dipilih");
        }else if(comboMapel.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Mapel belum dipilih");
        }else if(comboKls.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Kelas belum dipilih");
        }else{
            
            validateKode(txtKodeNilai.getText());
            if(kode != null){
               messageComponent1.showWarning("Kode Nilai sudah ada"); 
            }else{
                
                validateDataNilai(String.valueOf(ChooseThnAjaranFrom.getValue())+"/"+String.valueOf(ChooseThnAjaranTo.getValue()), 
                        comboSmstr.getSelectedItem().toString(), labelKdKls.getText(), labelKdMapel.getText());
                
                if(idNilai != null){
                    messageComponent1.setMessageFont(new Font("Calibri", Font.BOLD, 15));
                    messageComponent1.showWarning("Data Nilai sudah ada dengan kode: "+idNilai, 7000); 
                }else{
                    
                    try {
                        Penilaian penilaian = new Penilaian();

                        penilaian.setCreatedBy("Admin");
                        penilaian.setCreatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
                        penilaian.setId_nilai(txtKodeNilai.getText());
                        penilaian.setKd_kelas(labelKdKls.getText());
                        penilaian.setKd_mapel(labelKdMapel.getText());
                        penilaian.setNm_kelas(labelNmKls.getText());
                        penilaian.setNm_mapel(labelNmMapel.getText());
                        penilaian.setSemester(comboSmstr.getSelectedItem().toString());
                        penilaian.setThnAjaran(String.valueOf(ChooseThnAjaranFrom.getValue())+"/"+String.valueOf(ChooseThnAjaranTo.getValue()));

                        PenilaianService service1 = new PenilaianService();

                        String sql2 = "INSERT INTO tbl_nilai_detail(id_nilai, kd_siswa, nama_siswa, "
                                + "UH, UTS, UAS) "
                                +"VALUES(?,?,?,?,?,?)";
                        PreparedStatement ps = konek.prepareStatement(sql2);

                        for(int i = 0; i < tableModel.getRowCount(); i++){
                            PenilaianDetail detail = tableModel.get(i);
                            ps.setString(1, txtKodeNilai.getText());
                            ps.setString(2, detail.getKd_siswa());
                            ps.setString(3, detail.getNm_siswa());
                            ps.setDouble(4, detail.getUH());
                            ps.setDouble(5, detail.getUTS());
                            ps.setDouble(6, detail.getUAS());

                            ps.executeUpdate();

                        }

                        service1.insert(penilaian);

                        dispose();                 
                    } catch (SQLException ex) {
                        Logger.getLogger(TambahNilai.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
                
                
                
            }
            
            
            
            
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

    private void comboSmstrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSmstrActionPerformed
        // TODO add your handling code here:
        
        if(comboSmstr.getSelectedItem().equals("Pilih")){
            tableModel.clear();
            comboKls.setSelectedItem("Pilih");
            comboMapel.setSelectedItem("Pilih");
        }else{
            
            LoadKelasCombo(comboSmstr.getSelectedItem().toString(), String.valueOf(ChooseThnAjaranFrom.getValue())+"/"+String.valueOf(ChooseThnAjaranTo.getValue()));
           
        }
        
    }//GEN-LAST:event_comboSmstrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ChooseThnAjaranFrom;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranTo;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox comboKls;
    private javax.swing.JComboBox comboMapel;
    private javax.swing.JComboBox comboSmstr;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelKdKls;
    private javax.swing.JLabel labelKdMapel;
    private javax.swing.JLabel labelNmKls;
    private javax.swing.JLabel labelNmMapel;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private MI_MAK.widget.PanelImageBackground panelImageBackground1;
    private com.stripbandunk.jwidget.JDynamicTable tableNilaiDetail;
    private javax.swing.JTextField txtKodeNilai;
    // End of variables declaration//GEN-END:variables
}
