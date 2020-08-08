/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.mengajar;

import MI_MAK.dao.Guru;
import MI_MAK.dao.Kelas;
import MI_MAK.dao.Mapel;
import MI_MAK.dao.Mengajar;
import MI_MAK.db.DatabaseUtilitas;
import MI_MAK.service.GuruService;
import MI_MAK.service.KelasService;
import MI_MAK.service.MapelService;
import MI_MAK.service.MengajarService;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Imam-pc
 */
public class TambahMengajar extends javax.swing.JDialog {

    private int thnFrom;
    private int thnTo;
    private Connection koneksi;
    private String mengajar;
    
    public TambahMengajar() {
        setModal(true);
        koneksi = DatabaseUtilitas.getkoneksi();
        initComponents();
        
        setGlassPane(jGlassPane1);
        getGlassPane().setVisible(true);
        
        jGlassPane1.addGlassPaneComponent(messageComponent1);
        
    }
    
    public void tambahMengajar(){
        
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(date.getTime());
        
        autonumber();
        
        thnFrom = date.getYear()+ 1900;
        thnTo = date.getYear()+ 1900;
        
        ChooseThnAjaranFrom.setValue(thnFrom - 1);
        ChooseThnAjaranTo.setValue(thnTo);
        
        
        LoadKelasCombo();
        LoadMapelCombo();
        setLocationRelativeTo(this);
        setVisible(true);
    }
    
    public void LoadKelasCombo(){
        KelasService ks = new KelasService();
        List<Kelas> list =  ks.selectKelas();
        comboKelas.removeAllItems();
        comboKelas.addItem("Pilih");
        list.stream().forEach((kelas) -> {
            comboKelas.addItem(kelas);
            System.out.println("load Kelas: "+kelas);
        });
    }
    
//    public void LoadGuruCombo(){
//        GuruService gs = new GuruService();
//        List<Guru> list =  gs.selectGuru();
//        
//        list.stream().forEach((guru) -> {
//            comboGuru.addItem(guru);
//        });
//    }
    
    public void LoadMapelCombo(){
        MapelService ms = new MapelService();
        List<Mapel> list =  ms.selectMapel();
        comboMapel.removeAllItems();
        comboMapel.addItem("Pilih");
        list.stream().forEach((mp) -> {
            comboMapel.addItem(mp);
        });
    }
    
    public void LoadGuruByMapelCombo(String id){
        GuruService vs = new GuruService();
        List<Guru> list =  vs.selectGuruByMapel(id);
        comboGuru.removeAllItems();
        comboGuru.addItem("Pilih");
        list.stream().forEach((sw) -> {
            comboGuru.addItem(sw);
            System.out.println("load Guru: "+sw);
        });
    }
    
    protected void autonumber() {
        try {
            String sql = "SELECT kode_mengajar FROM jdl_mengajar order by kode_mengajar asc";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtKodeMengajar.setText("JM0001");
            while (rs.next()) {
                String id_ceklis = rs.getString("kode_mengajar").substring(2);
                int AN = Integer.parseInt(id_ceklis) + 1;
                String Nol = "";
                if (AN < 10) {
                    Nol = "000";
                } else if (AN < 100) {
                    Nol = "00";
                } else if (AN < 1000) {
                    Nol = "0";
                } else if (AN < 10000) {
                    Nol = "";
                }
                txtKodeMengajar.setText("JM" + Nol + AN);
            }
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal" + e);
        }
    }
    
    protected String validateJadwalMengajar(String mapel, String kelas, String hari, Time jm, String thn) {
        mengajar = null;
        try {
            String sql = "SELECT kode_mengajar FROM jdl_mengajar where kode_mapel = '"+mapel+"' AND kode_kelas = '"+kelas+"' "
                    + "AND hari = '"+hari+"' AND jamMulai = '"+jm+"' AND tahunAjaran = '"+thn+"'";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
          
            while (rs.next()) {
                mengajar = rs.getString("kode_mengajar");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "validate NIP gagal" + e);
        }
        
        return mengajar;
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
        labelKodeKelas = new javax.swing.JLabel();
        labelNIP = new javax.swing.JLabel();
        labelMapel = new javax.swing.JLabel();
        panelImageBackground1 = new MI_MAK.widget.PanelImageBackground();
        jLabel1 = new javax.swing.JLabel();
        txtKodeMengajar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboKelas = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboGuru = new javax.swing.JComboBox();
        comboHari = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jamMulai = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jamSelesai = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        comboMapel = new javax.swing.JComboBox();
        ChooseThnAjaranFrom = new com.toedter.calendar.JYearChooser();
        jLabel19 = new javax.swing.JLabel();
        ChooseThnAjaranTo = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panelImageBackground1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tambah Jadwal Mengajar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Kode Mengajar");

        txtKodeMengajar.setEditable(false);
        txtKodeMengajar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Nama Mapel");

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

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Nama Kelas");

        comboKelas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Nama Guru");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Hari");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText(":");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText(":");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText(":");

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setText(":");

        comboGuru.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboGuru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGuruActionPerformed(evt);
            }
        });

        comboHari.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboHari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" }));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setText("Jam");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setText(":");

        jamMulai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jamMulai.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR_OF_DAY));
        jamMulai.setEditor(new javax.swing.JSpinner.DateEditor(jamMulai, "HH:mm:ss"));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setText("Tahun Ajaran");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setText(":");

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel17.setText("Mulai");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel18.setText("Selesai");

        jamSelesai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jamSelesai.setModel(new javax.swing.SpinnerDateModel());
        jamSelesai.setEditor(new javax.swing.JSpinner.DateEditor(jamSelesai, "HH:mm:ss"));
        jamSelesai.setValue(new java.util.Date());

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setText(":");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setText(":");

        comboMapel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboMapel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        comboMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapelActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel19.setText("/");

        javax.swing.GroupLayout panelImageBackground1Layout = new javax.swing.GroupLayout(panelImageBackground1);
        panelImageBackground1.setLayout(panelImageBackground1Layout);
        panelImageBackground1Layout.setHorizontalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImageBackground1Layout.createSequentialGroup()
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                    .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtKodeMengajar)
                                        .addComponent(comboKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboMapel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                    .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboGuru, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                            .addComponent(comboHari, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 175, Short.MAX_VALUE)))))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelImageBackground1Layout.setVerticalGroup(
            panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeMengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(comboMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(comboGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(comboHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(jamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14))
                    .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelImageBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelImageBackground1Layout.createSequentialGroup()
                            .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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
        
        if(txtKodeMengajar.getText().trim().isEmpty()){
            messageComponent1.showWarning("Kode Mengajar Kosong");
        }else if(comboMapel.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Mata Pelajaran kosong");
        }else if(comboGuru.getSelectedItem().equals("Pilih") || labelNIP.getText().equals("")){
            messageComponent1.showWarning("Nama Guru belum di pilih");
        }else if(comboHari.getSelectedItem().equals("Pilih")){
            messageComponent1.showWarning("Hari kosong");
        }else if(comboKelas.getSelectedItem().equals("Pilih") || labelKodeKelas.getText().equals("")){
            messageComponent1.showWarning("Nama Kelas kosong");
        }else if(ChooseThnAjaranFrom.getValue() == 0 || ChooseThnAjaranFrom.getValue() < thnFrom-1 
                || ChooseThnAjaranTo.getValue() == 0 || ChooseThnAjaranTo.getValue() < thnTo){
            messageComponent1.showWarning("Tahun Ajaran tidak valid");
        }else if(jamMulai.getValue() == null){
            messageComponent1.showWarning("Jam Mulai kosong");
        }else if(jamSelesai.getValue() == null){
            messageComponent1.showWarning("Jam Selesai kosong");
        }else{
            
            String thF = String.valueOf(ChooseThnAjaranFrom.getValue());
            String thT = String.valueOf(ChooseThnAjaranTo.getValue());
            
            
            
            validateJadwalMengajar(labelMapel.getText(), labelKodeKelas.getText(), 
                                    comboHari.getSelectedItem().toString(), new java.sql.Time(jamMulai.getValue().hashCode()), thF+"/"+thT);
            
            if(mengajar != null){
                System.out.println("");
                messageComponent1.setMessageFont(new Font("Calibri", Font.BOLD, 14));
                messageComponent1.showWarning("Jadwal Mengajar sudah ada dengan kode:"+mengajar, 6700);
            }else{
                Mengajar mj = new Mengajar();
                mj.setCreatedby("Admin");
                mj.setCreateddate(new java.sql.Timestamp(new java.util.Date().getTime()));
                mj.setFlag(1);
                mj.setKd_mapel(labelMapel.getText());
                mj.setKd_ajar(txtKodeMengajar.getText());
                mj.setKd_guru(labelNIP.getText());
                mj.setHari(comboHari.getSelectedItem().toString());
                mj.setJamMulai(new java.sql.Time(jamMulai.getValue().hashCode()));
                mj.setJamSelesai(new java.sql.Time(jamSelesai.getValue().hashCode()));
                mj.setKd_kelas(labelKodeKelas.getText());
                mj.setTahunAjaran(thF+"/"+thT);


                MengajarService service = new MengajarService();
                service.insert(mj);
                dispose();
            }
            
            
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void comboKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelasActionPerformed
        // TODO add your handling code here:
        switch (comboKelas.getSelectedIndex()) {
            case -1:
                labelKodeKelas.setText("");
                break;
            case 0:
                labelKodeKelas.setText("");
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
                labelKodeKelas.setText(varStrKode);
                break;
        }
        
        
        
    }//GEN-LAST:event_comboKelasActionPerformed

    private void comboGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGuruActionPerformed
        // TODO add your handling code here:
        switch (comboGuru.getSelectedIndex()) {
            case -1:
                labelNIP.setText("");
                break;
            case 0:
                labelNIP.setText("");
                break;
            default:
                String lblKodeGuru;
                lblKodeGuru = comboGuru.getSelectedItem().toString();
                System.out.println("combo guru: "+lblKodeGuru);
                String[] prt = lblKodeGuru.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                labelNIP.setText(varStrKode);
                break;
        }
        
        
        
    }//GEN-LAST:event_comboGuruActionPerformed

    private void comboMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapelActionPerformed
        // TODO add your handling code here:
        switch (comboMapel.getSelectedIndex()) {
            case -1:
                labelMapel.setText("");
                LoadGuruByMapelCombo("");
                break;
            case 0:
                labelMapel.setText("");
                LoadGuruByMapelCombo("");
                break;
            default:
                String lblKodeMapel;
                lblKodeMapel = comboMapel.getSelectedItem().toString();
                System.out.println("combo mapel: "+lblKodeMapel);
                String[] prt = lblKodeMapel.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                labelMapel.setText(varStrKode);
                LoadGuruByMapelCombo(labelMapel.getText());
                break;
        }
        
        
        
        
    }//GEN-LAST:event_comboMapelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ChooseThnAjaranFrom;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranTo;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox comboGuru;
    private javax.swing.JComboBox comboHari;
    private javax.swing.JComboBox comboKelas;
    private javax.swing.JComboBox comboMapel;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JSpinner jamMulai;
    private javax.swing.JSpinner jamSelesai;
    private javax.swing.JLabel labelKodeKelas;
    private javax.swing.JLabel labelMapel;
    private javax.swing.JLabel labelNIP;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private MI_MAK.widget.PanelImageBackground panelImageBackground1;
    private javax.swing.JTextField txtKodeMengajar;
    // End of variables declaration//GEN-END:variables
}
