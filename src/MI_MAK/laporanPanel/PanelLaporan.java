/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.laporanPanel;

import MI_MAK.dao.Guru;
import MI_MAK.dao.Kelas;
import MI_MAK.dao.Mapel;
import MI_MAK.dao.Siswa;
import MI_MAK.db.DatabaseUtilitas;
import MI_MAK.service.GuruService;
import MI_MAK.service.KelasService;
import MI_MAK.service.MapelService;
import MI_MAK.service.SiswaService;
import MI_MAK.widget.ProgressbarLoading;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Imam-pc
 */
public class PanelLaporan extends javax.swing.JPanel {

    private final int thnFrom;
    private final int thnTo;
    private final Connection koneksi;
    private final String varPathDataSiswa = "/MI_MAK/laporanReport/ReportDataSiswa.jrxml";
    private final String varPathDataGuru = "/MI_MAK/laporanReport/ReportDataGuru.jrxml";
    private final String varPathDataMapel = "/MI_MAK/laporanReport/ReportDataMapel.jrxml";
    private final String varPathDataKelas = "/MI_MAK/laporanReport/ReportDataKelas.jrxml";
    private final String varPathJdwlNgajar = "/MI_MAK/laporanReport/ReportJadwalMengajarGroup.jrxml";
    private final String varPathNilai = "/MI_MAK/laporanReport/ReportNilai.jrxml";
    private final String varPathNilaiRekap = "/MI_MAK/laporanReport/ReportNilaiRekap_new.jrxml";
    private final String varPathAbsensi = "/MI_MAK/laporanReport/ReportDataAbsen.jrxml";
    private final String varPathNilaiRapor = "/MI_MAK/laporanReport/ReportNilaiRapor.jrxml";
    public PanelLaporan() {
        koneksi = DatabaseUtilitas.getkoneksi();
        initComponents();
        
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(date.getTime());
        
        thnFrom = date.getYear()+ 1900;
        thnTo = date.getYear()+ 1900;
        
        CosThnMasukSiswa.setValue(thnFrom);
        CosThnMasukSiswa.setEnabled(false);
        
        ChooseThnAjaranFrom.setValue(thnFrom - 1);
        ChooseThnAjaranTo.setValue(thnTo);
        
        
    }
    
    public JasperPrint displayReport(Map<String,Object>param,String varParam){
        JasperPrint jasperPrint = null;
        Locale local = new Locale("id","ID");
        try {
            
            
            JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream(varParam));
            
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, koneksi);
            
           // JRXlsExporter xlsExporter = new JRXlsExporter();
           // xlsExporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, jasperPrint);
           // xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, param);
            
            JasperViewer.viewReport(jasperPrint,false,local);
            
            
        } catch (JRException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jasperPrint;
    }
    
    public void LoadKelasCombo(){
        KelasService ks = new KelasService();
        List<Kelas> list =  ks.selectKelas();
        comboKelasNilai.removeAllItems();
        comboKelasNilai.addItem("All");
        comboKelasSiswa.removeAllItems();
        comboKelasSiswa.addItem("All");
        comboWaliKelasGuru.removeAllItems();
        comboWaliKelasGuru.addItem("All");
        comboKlsKelas.removeAllItems();
        comboKelasNgajar.removeAllItems();
        comboKelasNgajar.addItem("All");
        comboKlsKelas.addItem("All");
        list.stream().forEach((kelas) -> {
            comboKelasNilai.addItem(kelas);
            comboKelasSiswa.addItem(kelas);
            comboWaliKelasGuru.addItem(kelas);
            comboKlsKelas.addItem(kelas);
            comboKelasNgajar.addItem(kelas);
            
            System.out.println("load Kelas: "+kelas);
        });
    }
     
      public void LoadMapelCombo(){
        MapelService ms = new MapelService();
        List<Mapel> list =  ms.selectMapel();
        comboMapelGuru.removeAllItems();
        comboMapelGuru.addItem("All");
        comboMapelNilai.removeAllItems();
        comboMapelNilai.addItem("All");
        comboMapelMapel.removeAllItems();
        comboMapelMapel.addItem("All");
        comboMapelNgajar.removeAllItems();
        comboMapelNgajar.addItem("All");
        list.stream().forEach((mp) -> {
            comboMapelGuru.addItem(mp);
            comboMapelNilai.addItem(mp);
            comboMapelMapel.addItem(mp);
            comboMapelNgajar.addItem(mp);
        });
    }
      
      public void LoadSiswaByKelasComboSiswa(String id){
        SiswaService vs = new SiswaService();
        List<Siswa> list =  vs.getSiswaByKelas(id);
        comboSiswaSiswa.removeAllItems();
        comboSiswaSiswa.addItem("All");
        list.stream().forEach((sw) -> {
            comboSiswaSiswa.addItem(sw);
            System.out.println("load Siswa: "+sw);
        });
    }
      
      public void LoadSiswaByKelasComboNilai(String id){
        SiswaService vs = new SiswaService();
        List<Siswa> list =  vs.getSiswaByKelas(id);
        comboSiswaNilai.removeAllItems();
        comboSiswaNilai.addItem("All");
        list.stream().forEach((sw) -> {
            comboSiswaNilai.addItem(sw);
            System.out.println("load Siswa: "+sw);
        });
    }
      
      public void LoadGuruCombo(){
        GuruService gs = new GuruService();
        List<Guru> list =  gs.selectGuru();
        comboGuruGuru.removeAllItems();
        comboGuruGuru.addItem("All");
        comboGuruNgajar.removeAllItems();
        comboGuruNgajar.addItem("All");
        comboWaliKelasNilai.removeAllItems();
        comboWaliKelasNilai.addItem("All");
        list.stream().forEach((guru) -> {
            comboGuruGuru.addItem(guru);
            comboGuruNgajar.addItem(guru);
            comboWaliKelasNilai.addItem(guru);
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

        lblKd_kelas_siswa = new javax.swing.JLabel();
        lblNm_kelas_siswa = new javax.swing.JLabel();
        labelKdSiswaSiswa = new javax.swing.JLabel();
        labelNmSiswaSiswa = new javax.swing.JLabel();
        rbGroupSiswa = new javax.swing.ButtonGroup();
        lblKdGuru = new javax.swing.JLabel();
        lblNmGuru = new javax.swing.JLabel();
        lblKdWalikelas = new javax.swing.JLabel();
        lblNmWalikelas = new javax.swing.JLabel();
        lblKdMapelGuru = new javax.swing.JLabel();
        lblNmMapelGuru = new javax.swing.JLabel();
        lblKdKlsKelas = new javax.swing.JLabel();
        lblNmKelasKelas = new javax.swing.JLabel();
        lblKdMapelMapel = new javax.swing.JLabel();
        lblNmMapelMapel = new javax.swing.JLabel();
        lblMapeKdlNgajar = new javax.swing.JLabel();
        lblMapelNmNgajar = new javax.swing.JLabel();
        lblGuruKdNgajar = new javax.swing.JLabel();
        lblGuruNmNgajar = new javax.swing.JLabel();
        lblKlsKdNgajar = new javax.swing.JLabel();
        lblKlsNmNgajar = new javax.swing.JLabel();
        lblKdSiswaNilai = new javax.swing.JLabel();
        lblNmSiswaNilai = new javax.swing.JLabel();
        lblKdKelasNilai = new javax.swing.JLabel();
        lblNmKelasNilai = new javax.swing.JLabel();
        lblKdWaliKelasNilai = new javax.swing.JLabel();
        lblNmWaliKelasNilai = new javax.swing.JLabel();
        lblKdMapelNilai = new javax.swing.JLabel();
        lblNmMapelNilai = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboKelasSiswa = new javax.swing.JComboBox();
        btnLapSiswa = new javax.swing.JButton();
        comboSiswaSiswa = new javax.swing.JComboBox();
        rbAllSiswa = new javax.swing.JRadioButton();
        rbThnMsukSiswa = new javax.swing.JRadioButton();
        CosThnMasukSiswa = new com.toedter.calendar.JYearChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboKlsKelas = new javax.swing.JComboBox();
        comboMapelMapel = new javax.swing.JComboBox();
        btnLapMapel = new javax.swing.JButton();
        btnLapKelas = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        comboGuruGuru = new javax.swing.JComboBox();
        comboWaliKelasGuru = new javax.swing.JComboBox();
        comboMapelGuru = new javax.swing.JComboBox();
        btnLapGuru = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnLapNgajar = new javax.swing.JButton();
        ComboHari = new javax.swing.JComboBox();
        comboMapelNgajar = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboGuruNgajar = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        comboKelasNgajar = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        comboSiswaNilai = new javax.swing.JComboBox();
        comboKelasNilai = new javax.swing.JComboBox();
        btnLapNilai = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        comboSmstrNilai = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        comboWaliKelasNilai = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        comboMapelNilai = new javax.swing.JComboBox();
        btnLapRekap = new javax.swing.JButton();
        btnLapRapor = new javax.swing.JButton();
        btnLapAbsensi = new javax.swing.JButton();
        ChooseThnAjaranFrom = new com.toedter.calendar.JYearChooser();
        jLabel12 = new javax.swing.JLabel();
        ChooseThnAjaranTo = new com.toedter.calendar.JYearChooser();

        lblKd_kelas_siswa.setText("jLabel9");

        lblNm_kelas_siswa.setText("jLabel12");

        labelKdSiswaSiswa.setText("jLabel9");

        labelNmSiswaSiswa.setText("jLabel12");

        lblKdGuru.setText("jLabel9");

        lblNmGuru.setText("jLabel12");

        lblKdWalikelas.setText("jLabel9");

        lblNmWalikelas.setText("jLabel12");

        lblKdMapelGuru.setText("jLabel9");

        lblNmMapelGuru.setText("jLabel12");

        lblKdKlsKelas.setText("jLabel9");

        lblNmKelasKelas.setText("jLabel12");

        lblKdMapelMapel.setText("jLabel23");

        lblNmMapelMapel.setText("jLabel24");

        lblMapeKdlNgajar.setText("jLabel9");

        lblMapelNmNgajar.setText("jLabel12");

        lblGuruKdNgajar.setText("jLabel27");

        lblGuruNmNgajar.setText("jLabel28");

        lblKlsKdNgajar.setText("jLabel29");

        lblKlsNmNgajar.setText("jLabel30");

        lblKdSiswaNilai.setText("jLabel9");

        lblNmSiswaNilai.setText("jLabel12");

        lblKdKelasNilai.setText("jLabel9");

        lblNmKelasNilai.setText("jLabel12");

        lblKdWaliKelasNilai.setText("jLabel9");

        lblNmWaliKelasNilai.setText("jLabel27");

        lblKdMapelNilai.setText("jLabel9");

        lblNmMapelNilai.setText("jLabel27");

        setOpaque(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filter Laporan Data Siswa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Kelas");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Siswa");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Tahun Masuk");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText(":");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText(":");

        comboKelasSiswa.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKelasSiswa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboKelasSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelasSiswaActionPerformed(evt);
            }
        });

        btnLapSiswa.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapSiswa.setText("Tampilkan");
        btnLapSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapSiswaActionPerformed(evt);
            }
        });

        comboSiswaSiswa.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSiswaSiswa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboSiswaSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSiswaSiswaActionPerformed(evt);
            }
        });

        rbGroupSiswa.add(rbAllSiswa);
        rbAllSiswa.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        rbAllSiswa.setSelected(true);
        rbAllSiswa.setText("All");
        rbAllSiswa.setOpaque(false);
        rbAllSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAllSiswaActionPerformed(evt);
            }
        });

        rbGroupSiswa.add(rbThnMsukSiswa);
        rbThnMsukSiswa.setOpaque(false);
        rbThnMsukSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbThnMsukSiswaActionPerformed(evt);
            }
        });

        CosThnMasukSiswa.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbAllSiswa)
                                .addGap(18, 18, 18)
                                .addComponent(rbThnMsukSiswa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CosThnMasukSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboKelasSiswa, 0, 172, Short.MAX_VALUE)
                            .addComponent(comboSiswaSiswa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnLapSiswa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(comboKelasSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(comboSiswaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbThnMsukSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6)
                        .addComponent(rbAllSiswa))
                    .addComponent(CosThnMasukSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnLapSiswa)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filter Laporan Data Mapel & Kelas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("Kelas");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText("Mapel");

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel11.setText(":");

        comboKlsKelas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKlsKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboKlsKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKlsKelasActionPerformed(evt);
            }
        });

        comboMapelMapel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboMapelMapel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboMapelMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapelMapelActionPerformed(evt);
            }
        });

        btnLapMapel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapMapel.setText("Tampilkan Mapel");
        btnLapMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapMapelActionPerformed(evt);
            }
        });

        btnLapKelas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapKelas.setText("Tampilkan Kelas");
        btnLapKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapKelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboMapelMapel, javax.swing.GroupLayout.Alignment.LEADING, 0, 211, Short.MAX_VALUE)
                            .addComponent(comboKlsKelas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLapMapel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLapKelas)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(comboKlsKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(comboMapelMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLapMapel)
                    .addComponent(btnLapKelas))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filter Laporan Data Guru", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("Guru");

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText("Wali Kelas");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Mapel");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText(":");

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText(":");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText(":");

        comboGuruGuru.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboGuruGuru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboGuruGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGuruGuruActionPerformed(evt);
            }
        });

        comboWaliKelasGuru.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboWaliKelasGuru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboWaliKelasGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboWaliKelasGuruActionPerformed(evt);
            }
        });

        comboMapelGuru.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboMapelGuru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboMapelGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapelGuruActionPerformed(evt);
            }
        });

        btnLapGuru.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapGuru.setText("Tampilkan");
        btnLapGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapGuruActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Jadwal Mengajar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel19.setText("Hari");

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel20.setText("Mapel");

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel21.setText(":");

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel22.setText(":");

        btnLapNgajar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapNgajar.setText("Tampilkan");
        btnLapNgajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapNgajarActionPerformed(evt);
            }
        });

        ComboHari.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        ComboHari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" }));

        comboMapelNgajar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboMapelNgajar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboMapelNgajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapelNgajarActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel23.setText("Guru");

        jLabel24.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel24.setText(":");

        comboGuruNgajar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboGuruNgajar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboGuruNgajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGuruNgajarActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel25.setText(":");

        jLabel26.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel26.setText("Kelas");

        comboKelasNgajar.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKelasNgajar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboKelasNgajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelasNgajarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLapNgajar)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboHari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboMapelNgajar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboGuruNgajar, 0, 189, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboKelasNgajar, 0, 189, Short.MAX_VALUE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(ComboHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(comboMapelNgajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25)
                    .addComponent(comboGuruNgajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(comboKelasNgajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLapNgajar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLapGuru)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboWaliKelasGuru, javax.swing.GroupLayout.Alignment.LEADING, 0, 231, Short.MAX_VALUE)
                            .addComponent(comboGuruGuru, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboMapelGuru, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(comboGuruGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(comboWaliKelasGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18)
                    .addComponent(comboMapelGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLapGuru)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filter Laporan Data Nilai & Absen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel6.setOpaque(false);

        jLabel33.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel33.setText("Kelas");

        jLabel34.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel34.setText("Siswa");

        jLabel35.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel35.setText("Tahun Ajaran");

        jLabel36.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel36.setText(":");

        jLabel37.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel37.setText(":");

        jLabel38.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel38.setText(":");

        comboSiswaNilai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSiswaNilai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboSiswaNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSiswaNilaiActionPerformed(evt);
            }
        });

        comboKelasNilai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKelasNilai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboKelasNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelasNilaiActionPerformed(evt);
            }
        });

        btnLapNilai.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapNilai.setText("Tampilkan Nilai");
        btnLapNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapNilaiActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel39.setText(":");

        jLabel40.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel40.setText("Semester");

        comboSmstrNilai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSmstrNilai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Ganjil", "Genap" }));

        jLabel41.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel41.setText("Wali Kelas");

        jLabel42.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel42.setText(":");

        comboWaliKelasNilai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboWaliKelasNilai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboWaliKelasNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboWaliKelasNilaiActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel43.setText("Mata Pelajaran");

        jLabel44.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel44.setText(":");

        comboMapelNilai.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboMapelNilai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboMapelNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapelNilaiActionPerformed(evt);
            }
        });

        btnLapRekap.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapRekap.setText("Tampilkan Rekap");
        btnLapRekap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapRekapActionPerformed(evt);
            }
        });

        btnLapRapor.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapRapor.setText("Tampilkan Rapor");
        btnLapRapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapRaporActionPerformed(evt);
            }
        });

        btnLapAbsensi.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLapAbsensi.setText("Tampilkan Absensi");
        btnLapAbsensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapAbsensiActionPerformed(evt);
            }
        });

        ChooseThnAjaranFrom.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setText("/");

        ChooseThnAjaranTo.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboWaliKelasNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboKelasNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboSmstrNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSiswaNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMapelNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnLapNilai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLapRekap))
                    .addComponent(btnLapRapor, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLapAbsensi, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 156, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel36)
                    .addComponent(comboKelasNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel37)
                    .addComponent(comboSiswaNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(jLabel38)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)
                            .addComponent(comboSmstrNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(comboWaliKelasNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(comboMapelNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLapNilai)
                    .addComponent(btnLapRekap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLapRapor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLapAbsensi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboKelasSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelasSiswaActionPerformed
        // TODO add your handling code here:
        switch (comboKelasSiswa.getSelectedIndex()) {
            case -1:
                LoadSiswaByKelasComboSiswa("");
                System.out.println("combo kelas index 1 : "+comboKelasSiswa.getSelectedIndex());
                System.out.println("combo kelas item 1 : "+comboKelasSiswa.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo kelas index 2: "+comboKelasSiswa.getSelectedIndex());
                System.out.println("combo kelas item 2: "+comboKelasSiswa.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblKodeKls;
                lblKodeKls = comboKelasSiswa.getSelectedItem().toString();
                System.out.println("combo kelas: "+lblKodeKls);
                String[] prt = lblKodeKls.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKd_kelas_siswa.setText(varStrKode);
                lblNm_kelas_siswa.setText(varStrNama);
                LoadSiswaByKelasComboSiswa(lblKd_kelas_siswa.getText());
                break;
        }
        
    }//GEN-LAST:event_comboKelasSiswaActionPerformed

    private void comboSiswaSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSiswaSiswaActionPerformed
        // TODO add your handling code here:
        switch (comboSiswaSiswa.getSelectedIndex()) {
            case -1:
                System.out.println("combo siswa index 1 : "+comboSiswaSiswa.getSelectedIndex());
                System.out.println("combo siswa item 1 : "+comboSiswaSiswa.getSelectedItem());
                break;
            case 0:
                //  LoadPenilaianRekapAll(thnFrom-1+"/"+thnTo);
                System.out.println("combo siswa index 1 : "+comboSiswaSiswa.getSelectedIndex());
                System.out.println("combo siswa item 1 : "+comboSiswaSiswa.getSelectedItem());
                break;
            default:
                String lblKodeSws;
                lblKodeSws = comboSiswaSiswa.getSelectedItem().toString();
                System.out.println("combo Siswa: "+lblKodeSws);
                String[] prt = lblKodeSws.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                labelKdSiswaSiswa.setText(varStrKode);
                labelNmSiswaSiswa.setText(varStrNama);
                
                // LoadPenilaianRekap(labelKdSiswa.getText());
                break;
        }
    }//GEN-LAST:event_comboSiswaSiswaActionPerformed

    private void btnLapSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapSiswaActionPerformed
        String varKdKelas;
        String varKdSiswa;
        int varThnMsuk = 0;
        if(comboKelasSiswa.getSelectedItem().equals("All")){
            varKdKelas = "";
        }else{
            varKdKelas = lblKd_kelas_siswa.getText();
        }
        if(comboSiswaSiswa.getSelectedItem().equals("All")){
            varKdSiswa = "";
        }else{
            varKdSiswa = labelKdSiswaSiswa.getText();
        }
        if(rbAllSiswa.isSelected() ==true){
              varThnMsuk = 0;
            }else{
                if(CosThnMasukSiswa.getValue() == 0){
                    JFrame frame = new JFrame("Message Warning");
                    JOptionPane.showMessageDialog(frame, "Tahun Masuk Siswa tidak valid");
                }else{
                    varThnMsuk = CosThnMasukSiswa.getValue();
                }
            }
        
        InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
               
        
        Map<String, Object> param = new HashMap<>();
        param.put("kd_kelas", varKdKelas);
        param.put("kd_siswa", varKdSiswa);
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(rbAllSiswa.isSelected()==true){
            param.put("thn_masuk", "");
        }else{
            param.put("thn_masuk", varThnMsuk);
        }
        
        System.out.println("kd_kelas siswa :"+varKdKelas);
        System.out.println("kd_siswa siswa :"+varKdSiswa);
        System.out.println("thn_masuk siswa :"+varThnMsuk);
        
        final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
            
            @Override
            protected JasperPrint doInBackground() throws Exception {
                JasperPrint print;
                print = displayReport(param, varPathDataSiswa);
                
                return print;
            }
            
        };
        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
        ProgressbarLoading loding = new ProgressbarLoading();
        worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
            if (evt1.getPropertyName().equals("state")) {
                if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                    loding.dispose();
                }
            }
        });
        worker.execute();
        loding.pack();
        loding.setLocationRelativeTo(win);
        loding.setVisible(true);
        
        
        
    }//GEN-LAST:event_btnLapSiswaActionPerformed

    private void rbAllSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAllSiswaActionPerformed
        // TODO add your handling code here:
        if(rbAllSiswa.isSelected()==true){
            CosThnMasukSiswa.setEnabled(false);
            CosThnMasukSiswa.setValue(thnFrom);
        }else{
            CosThnMasukSiswa.setEnabled(true);
        }
        
    }//GEN-LAST:event_rbAllSiswaActionPerformed

    private void rbThnMsukSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbThnMsukSiswaActionPerformed
        // TODO add your handling code here:
        
        if(rbThnMsukSiswa.isSelected()==true){
            CosThnMasukSiswa.setEnabled(true);
        }else{
            CosThnMasukSiswa.setEnabled(false);
            CosThnMasukSiswa.setValue(thnFrom);
        }
        
    }//GEN-LAST:event_rbThnMsukSiswaActionPerformed

    private void btnLapGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapGuruActionPerformed
        // TODO add your handling code here:
        
        String varKdWaliKelas;
        String varKdGuru;
        String varKdMapel;
        
        if(comboGuruGuru.getSelectedItem().equals("All")){
            varKdGuru = "";
        }else{
            varKdGuru = lblKdGuru.getText();
        }
        if(comboWaliKelasGuru.getSelectedItem().equals("All")){
            varKdWaliKelas = "";
        }else{
            varKdWaliKelas = lblKdWalikelas.getText();
        }
        
        if(comboMapelGuru.getSelectedItem().equals("All")){
            varKdMapel = "";
        }else{
            varKdMapel = lblKdMapelGuru.getText();
        }
        
        
        InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
        
         Map<String, Object> param = new HashMap<>();
        param.put("kd_guru", varKdGuru);
        param.put("kd_kelas", varKdWaliKelas);
        param.put("kd_mapel", varKdMapel);
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("kd_guru guru :"+varKdGuru);
        System.out.println("kd_kelas guru :"+varKdWaliKelas);
        System.out.println("mapel guru siswa :"+varKdMapel);
        
        
        final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
            
            @Override
            protected JasperPrint doInBackground() throws Exception {
                JasperPrint print;
                print = displayReport(param, varPathDataGuru);
                
                return print;
            }
            
        };
        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
        ProgressbarLoading loding = new ProgressbarLoading();
        worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
            if (evt1.getPropertyName().equals("state")) {
                if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                    loding.dispose();
                }
            }
        });
        worker.execute();
        loding.pack();
        loding.setLocationRelativeTo(win);
        loding.setVisible(true);
        
                
        
        
    }//GEN-LAST:event_btnLapGuruActionPerformed

    private void comboGuruGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGuruGuruActionPerformed
        // TODO add your handling code here:
        switch (comboGuruGuru.getSelectedIndex()) {
            case -1:
                System.out.println("combo guru index 1 : "+comboGuruGuru.getSelectedIndex());
                System.out.println("combo guru item 1 : "+comboGuruGuru.getSelectedItem());
                break;
            case 0:
                //  LoadPenilaianRekapAll(thnFrom-1+"/"+thnTo);
                System.out.println("combo guru index 1 : "+comboGuruGuru.getSelectedIndex());
                System.out.println("combo guru item 1 : "+comboGuruGuru.getSelectedItem());
                break;
            default:
                String lblKodeGuru;
                lblKodeGuru = comboGuruGuru.getSelectedItem().toString();
                System.out.println("combo Siswa: "+lblKodeGuru);
                String[] prt = lblKodeGuru.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdGuru.setText(varStrKode);
                lblNmGuru.setText(varStrNama);
                
                // LoadPenilaianRekap(labelKdSiswa.getText());
                break;
        }
        
    }//GEN-LAST:event_comboGuruGuruActionPerformed

    private void comboWaliKelasGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboWaliKelasGuruActionPerformed
        // TODO add your handling code here:
        switch (comboWaliKelasGuru.getSelectedIndex()) {
            case -1:
                System.out.println("combo kelas index 1 : "+comboWaliKelasGuru.getSelectedIndex());
                System.out.println("combo kelas item 1 : "+comboWaliKelasGuru.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo kelas index 2: "+comboWaliKelasGuru.getSelectedIndex());
                System.out.println("combo kelas item 2: "+comboWaliKelasGuru.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblKodeWaliKls;
                lblKodeWaliKls = comboWaliKelasGuru.getSelectedItem().toString();
                System.out.println("combo wali kelas: "+lblKodeWaliKls);
                String[] prt = lblKodeWaliKls.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdWalikelas.setText(varStrKode);
                lblNmWalikelas.setText(varStrNama);
                break;
        }
        
    }//GEN-LAST:event_comboWaliKelasGuruActionPerformed

    private void comboMapelGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapelGuruActionPerformed
        // TODO add your handling code here:
        switch (comboMapelGuru.getSelectedIndex()) {
            case -1:
                System.out.println("combo mapel index 1 : "+comboMapelGuru.getSelectedIndex());
                System.out.println("combo mapel item 1 : "+comboMapelGuru.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo mapel index 2: "+comboMapelGuru.getSelectedIndex());
                System.out.println("combo mapel item 2: "+comboMapelGuru.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblMapelGuru;
                lblMapelGuru = comboMapelGuru.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblMapelGuru);
                String[] prt = lblMapelGuru.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdMapelGuru.setText(varStrKode);
                lblNmMapelGuru.setText(varStrNama);
                break;
        }
    }//GEN-LAST:event_comboMapelGuruActionPerformed

    private void btnLapMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapMapelActionPerformed
        // TODO add your handling code here:
        
        String varKdMapel;
        
        
        if(comboMapelMapel.getSelectedItem().equals("All")){
            varKdMapel = "";
        }else{
            varKdMapel = lblKdMapelMapel.getText();
        }
        
        
        
         Map<String, Object> param = new HashMap<>();
        param.put("kd_mapel", varKdMapel);
        System.out.println("mapel mapel :"+varKdMapel);
        InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
            
            @Override
            protected JasperPrint doInBackground() throws Exception {
                JasperPrint print;
                print = displayReport(param, varPathDataMapel);
                
                return print;
            }
            
        };
        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
        ProgressbarLoading loding = new ProgressbarLoading();
        worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
            if (evt1.getPropertyName().equals("state")) {
                if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                    loding.dispose();
                }
            }
        });
        worker.execute();
        loding.pack();
        loding.setLocationRelativeTo(win);
        loding.setVisible(true);
        
        
        
    }//GEN-LAST:event_btnLapMapelActionPerformed

    private void comboKlsKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKlsKelasActionPerformed
        // TODO add your handling code here:
        switch (comboKlsKelas.getSelectedIndex()) {
            case -1:
                System.out.println("combo mapel index 1 : "+comboKlsKelas.getSelectedIndex());
                System.out.println("combo mapel item 1 : "+comboKlsKelas.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo mapel index 2: "+comboKlsKelas.getSelectedIndex());
                System.out.println("combo mapel item 2: "+comboKlsKelas.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblKelasKelas;
                lblKelasKelas = comboKlsKelas.getSelectedItem().toString();
                System.out.println("combo kelas kelas: "+lblKelasKelas);
                String[] prt = lblKelasKelas.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdKlsKelas.setText(varStrKode);
                lblNmKelasKelas.setText(varStrNama);
                break;
        }
        
        
    }//GEN-LAST:event_comboKlsKelasActionPerformed

    private void comboMapelMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapelMapelActionPerformed
        // TODO add your handling code here:
        switch (comboMapelMapel.getSelectedIndex()) {
            case -1:
                System.out.println("combo mapel index 1 : "+comboMapelMapel.getSelectedIndex());
                System.out.println("combo mapel item 1 : "+comboMapelMapel.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo mapel index 2: "+comboMapelMapel.getSelectedIndex());
                System.out.println("combo mapel item 2: "+comboMapelMapel.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblMapelMapel;
                lblMapelMapel = comboMapelMapel.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblMapelMapel);
                String[] prt = lblMapelMapel.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdMapelMapel.setText(varStrKode);
                lblNmMapelMapel.setText(varStrNama);
                break;
        }
        
    }//GEN-LAST:event_comboMapelMapelActionPerformed

    private void btnLapKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapKelasActionPerformed
        // TODO add your handling code here:
        
        String varKdKls;
        
        
        if(comboKlsKelas.getSelectedItem().equals("All")){
            varKdKls = "";
        }else{
            varKdKls = lblKdKlsKelas.getText();
        }
        
        
         Map<String, Object> param = new HashMap<>();
        param.put("kd_kelas", varKdKls);
        System.out.println("kelas kelas :"+varKdKls);
        InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
            
            @Override
            protected JasperPrint doInBackground() throws Exception {
                JasperPrint print;
                print = displayReport(param, varPathDataKelas);
                
                return print;
            }
            
        };
        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
        ProgressbarLoading loding = new ProgressbarLoading();
        worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
            if (evt1.getPropertyName().equals("state")) {
                if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                    loding.dispose();
                }
            }
        });
        worker.execute();
        loding.pack();
        loding.setLocationRelativeTo(win);
        loding.setVisible(true);
        
    }//GEN-LAST:event_btnLapKelasActionPerformed

    private void comboMapelNgajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapelNgajarActionPerformed
        // TODO add your handling code here:
        switch (comboMapelNgajar.getSelectedIndex()) {
            case -1:
                System.out.println("combo mapel index 1 : "+comboMapelNgajar.getSelectedIndex());
                // System.out.println("combo mapel item 1 : "+comboMapelNgajar.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo mapel index 2: "+comboMapelNgajar.getSelectedIndex());
                System.out.println("combo mapel item 2: "+comboMapelNgajar.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblMapelNgajar;
                lblMapelNgajar = comboMapelNgajar.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblMapelNgajar);
                String[] prt = lblMapelNgajar.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblMapeKdlNgajar.setText(varStrKode);
                lblMapelNmNgajar.setText(varStrNama);
                break;
        }
        
    }//GEN-LAST:event_comboMapelNgajarActionPerformed

    private void comboGuruNgajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGuruNgajarActionPerformed
        // TODO add your handling code here:
        switch (comboGuruNgajar.getSelectedIndex()) {
            case -1:
                System.out.println("combo mapel index 1 : "+comboGuruNgajar.getSelectedIndex());
                //System.out.println("combo mapel item 1 : "+comboGuruNgajar.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo mapel index 2: "+comboGuruNgajar.getSelectedIndex());
                System.out.println("combo mapel item 2: "+comboGuruNgajar.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblGuruNgajar;
                lblGuruNgajar = comboGuruNgajar.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblGuruNgajar);
                String[] prt = lblGuruNgajar.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblGuruKdNgajar.setText(varStrKode);
                lblGuruNmNgajar.setText(varStrNama);
                break;
        }
    }//GEN-LAST:event_comboGuruNgajarActionPerformed

    private void comboKelasNgajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelasNgajarActionPerformed
        // TODO add your handling code here:
        switch (comboKelasNgajar.getSelectedIndex()) {
            case -1:
                System.out.println("combo mapel index 1 : "+comboKelasNgajar.getSelectedIndex());
                System.out.println("combo mapel item 1 : "+comboKelasNgajar.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo mapel index 2: "+comboKelasNgajar.getSelectedIndex());
                System.out.println("combo mapel item 2: "+comboKelasNgajar.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblKelasNgajar;
                lblKelasNgajar = comboKelasNgajar.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblKelasNgajar);
                String[] prt = lblKelasNgajar.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKlsKdNgajar.setText(varStrKode);
                lblKlsNmNgajar.setText(varStrNama);
                break;
        }
    }//GEN-LAST:event_comboKelasNgajarActionPerformed

    private void btnLapNgajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapNgajarActionPerformed
        // TODO add your handling code here:
        
        String varHari;
        String varKls;
        String varGuru;
        String varMapel;
        
        if(ComboHari.getSelectedItem().equals("All")){
            varHari = "";
        }else{
            varHari = ComboHari.getSelectedItem().toString();
        }
        if(comboGuruNgajar.getSelectedItem().equals("All")){
            varGuru = "";
        }else{
            varGuru = lblGuruKdNgajar.getText();
        }
        if(comboKelasNgajar.getSelectedItem().equals("All")){
            varKls = "";
        }else{
            varKls = lblKlsKdNgajar.getText();
        }
        if(comboMapelNgajar.getSelectedItem().equals("All")){
            varMapel = "";
        }else{
            varMapel = lblMapeKdlNgajar.getText();
        }
        
        Map<String, Object> param = new HashMap<>();
        param.put("kd_mapel", varMapel);
        param.put("kd_kelas", varKls);
        param.put("kd_guru", varGuru);
        param.put("hari", varHari);
        System.out.println("kelas ngajar :"+varKls);
        System.out.println("guru ngajar :"+varGuru);
        System.out.println("hari ngajar :"+varHari);
        System.out.println("mapel ngajar :"+varMapel);
        InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){
            
            @Override
            protected JasperPrint doInBackground() throws Exception {
                JasperPrint print;
                print = displayReport(param, varPathJdwlNgajar);
                
                return print;
            }
            
        };
        Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
        ProgressbarLoading loding = new ProgressbarLoading();
        worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
            if (evt1.getPropertyName().equals("state")) {
                if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                    loding.dispose();
                }
            }
        });
        worker.execute();
        loding.pack();
        loding.setLocationRelativeTo(win);
        loding.setVisible(true);
        
    }//GEN-LAST:event_btnLapNgajarActionPerformed

    private void btnLapNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapNilaiActionPerformed
        // TODO add your handling code here:
        
        String thn1 = String.valueOf(ChooseThnAjaranFrom.getValue());
        String thn2 = String.valueOf(ChooseThnAjaranTo.getValue());
        
         if(comboMapelNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Mapel Nilai belum dipilih");
        }else if(comboKelasNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Kelas Nilai belum dipilih");
        }else if(thn1.equals("") || thn2.equals("")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Tahun Ajaran tidak valid");
        }else if(comboSmstrNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Semester Nilai belum dipilih");
        }else{
            
            Map<String, Object> param = new HashMap<>();
            param.put("kd_mapel", lblKdMapelNilai.getText());
            param.put("kd_kelas", lblKdKelasNilai.getText());
            param.put("thn_ajaran", thn1+"/"+thn2);
            param.put("smester", comboSmstrNilai.getSelectedItem().toString());
            System.out.println("kd_mapel Nilai :"+lblKdMapelNilai.getText());
            System.out.println("kd_kelas Nilai :"+lblKdKelasNilai.getText());
            InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
            try {
                param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
            } catch (JRException | IOException ex) {
                Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
            }

            final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){

                @Override
                protected JasperPrint doInBackground() throws Exception {
                    JasperPrint print;
                    print = displayReport(param, varPathNilai);

                    return print;
                }

            };
            Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
            ProgressbarLoading loding = new ProgressbarLoading();
            worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                if (evt1.getPropertyName().equals("state")) {
                    if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                        loding.dispose();
                    }
                }
            });
            worker.execute();
            loding.pack();
            loding.setLocationRelativeTo(win);
            loding.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btnLapNilaiActionPerformed

    private void btnLapAbsensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapAbsensiActionPerformed
        // TODO add your handling code here:
        
       String varKdKelas;
        String varKdSiswa;
        
        if(comboKelasNilai.getSelectedItem().equals("All")){
            varKdKelas = "";
        }else{
            varKdKelas = lblKdKelasNilai.getText();
        }
        
        if(comboSiswaNilai.getSelectedItem().equals("All")){
            varKdSiswa = "";
        }else{
            varKdSiswa = lblKdSiswaNilai.getText();
        }
            System.out.println("kd_kelas absensi :"+varKdKelas);
            System.out.println("kd_siswa absensi :"+varKdSiswa);
            Map<String, Object> param = new HashMap<>();
            param.put("kd_kelas", varKdKelas);
            param.put("kd_siswa", varKdSiswa);
            
            InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }

            final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){

                @Override
                protected JasperPrint doInBackground() throws Exception {
                    JasperPrint print;
                    print = displayReport(param, varPathAbsensi);

                    return print;
                }

            };
            Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
            ProgressbarLoading loding = new ProgressbarLoading();
            worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                if (evt1.getPropertyName().equals("state")) {
                    if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                        loding.dispose();
                    }
                }
            });
            worker.execute();
            loding.pack();
            loding.setLocationRelativeTo(win);
            loding.setVisible(true);
            
        
        
    }//GEN-LAST:event_btnLapAbsensiActionPerformed

    private void comboSiswaNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSiswaNilaiActionPerformed
        // TODO add your handling code here:
        switch (comboSiswaNilai.getSelectedIndex()) {
            case -1:
                System.out.println("combo siswa index 1 : "+comboSiswaNilai.getSelectedIndex());
                //System.out.println("combo siswa item 1 : "+comboSiswaNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo siswa index 2: "+comboSiswaNilai.getSelectedIndex());
                System.out.println("combo siswa item 2: "+comboSiswaNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblkdSiswa;
                lblkdSiswa = comboSiswaNilai.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblkdSiswa);
                String[] prt = lblkdSiswa.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdSiswaNilai.setText(varStrKode);
                lblNmSiswaNilai.setText(varStrNama);
                break;
        }
        
    }//GEN-LAST:event_comboSiswaNilaiActionPerformed

    private void comboKelasNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelasNilaiActionPerformed
        // TODO add your handling code here:
        switch (comboKelasNilai.getSelectedIndex()) {
            case -1:
                LoadSiswaByKelasComboNilai("");
                System.out.println("combo kelas index 1 : "+comboKelasNilai.getSelectedIndex());
                // System.out.println("combo kelas item 1 : "+comboKelasNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                LoadSiswaByKelasComboNilai("");
                System.out.println("combo kelas index 2: "+comboKelasNilai.getSelectedIndex());
                System.out.println("combo kelas item 2: "+comboKelasNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblkdSiswa;
                lblkdSiswa = comboKelasNilai.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblkdSiswa);
                String[] prt = lblkdSiswa.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdKelasNilai.setText(varStrKode);
                lblNmKelasNilai.setText(varStrNama);
                LoadSiswaByKelasComboNilai(varStrKode);
                break;
        }
        
    }//GEN-LAST:event_comboKelasNilaiActionPerformed

    private void comboWaliKelasNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboWaliKelasNilaiActionPerformed
        // TODO add your handling code here:
        switch (comboWaliKelasNilai.getSelectedIndex()) {
            case -1:
                System.out.println("combo kelas index 1 : "+comboWaliKelasNilai.getSelectedIndex());
                System.out.println("combo kelas item 1 : "+comboWaliKelasNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo kelas index 2: "+comboWaliKelasNilai.getSelectedIndex());
                System.out.println("combo kelas item 2: "+comboWaliKelasNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblkdWlKls;
                lblkdWlKls = comboWaliKelasNilai.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblkdWlKls);
                String[] prt = lblkdWlKls.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdWaliKelasNilai.setText(varStrKode);
                lblNmWaliKelasNilai.setText(varStrNama);
                break;
        }
        
    }//GEN-LAST:event_comboWaliKelasNilaiActionPerformed

    private void comboMapelNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapelNilaiActionPerformed
        // TODO add your handling code here:
        switch (comboMapelNilai.getSelectedIndex()) {
            case -1:
                System.out.println("combo kelas index 1 : "+comboMapelNilai.getSelectedIndex());
                System.out.println("combo kelas item 1 : "+comboMapelNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            case 0:
                System.out.println("combo kelas index 2: "+comboMapelNilai.getSelectedIndex());
                System.out.println("combo kelas item 2: "+comboMapelNilai.getSelectedItem());
                // JFrame frame = new JFrame("Warning");
                // JOptionPane.showMessageDialog(frame, "All Kelas");
                break;
            default:
                String lblkdWlKls;
                lblkdWlKls = comboMapelNilai.getSelectedItem().toString();
                System.out.println("combo mapel guru: "+lblkdWlKls);
                String[] prt = lblkdWlKls.split("-");
                String varStrKode = prt[0];
                String varStrNama = prt[1];
                System.out.println("split kode: "+varStrKode);
                System.out.println("split nama: "+varStrNama);
                lblKdMapelNilai.setText(varStrKode);
                lblNmMapelNilai.setText(varStrNama);
                break;
        }
        
    }//GEN-LAST:event_comboMapelNilaiActionPerformed

    private void btnLapRekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapRekapActionPerformed
        // TODO add your handling code here:
        
        String thn1 = String.valueOf(ChooseThnAjaranFrom.getValue());
        String thn2 = String.valueOf(ChooseThnAjaranTo.getValue());
        
         if(comboSiswaNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Siswa Nilai belum dipilih");
        }else if(comboKelasNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Kelas Nilai belum dipilih");
        }else if(thn1.equals("") || thn2.equals("")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Tahun Ajaran tidak valid");
        }else if(comboSmstrNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Semester Nilai belum dipilih");
        }else{
            
            Map<String, Object> param = new HashMap<>();
            param.put("kd_siswa", lblKdSiswaNilai.getText());
            param.put("kd_kelas", lblKdKelasNilai.getText());
            param.put("thn_ajaran", thn1+"/"+thn2);
            param.put("smester", comboSmstrNilai.getSelectedItem().toString());
            System.out.println("kd_mapel Nilai :"+lblKdMapelNilai.getText());
            System.out.println("kd_kelas Nilai :"+lblKdKelasNilai.getText());
        InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }

            final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){

                @Override
                protected JasperPrint doInBackground() throws Exception {
                    JasperPrint print;
                    print = displayReport(param, varPathNilaiRekap);

                    return print;
                }

            };
            Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
            ProgressbarLoading loding = new ProgressbarLoading();
            worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                if (evt1.getPropertyName().equals("state")) {
                    if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                        loding.dispose();
                    }
                }
            });
            worker.execute();
            loding.pack();
            loding.setLocationRelativeTo(win);
            loding.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btnLapRekapActionPerformed

    private void btnLapRaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapRaporActionPerformed
        // TODO add your handling code here:
        
        String thn1 = String.valueOf(ChooseThnAjaranFrom.getValue());
        String thn2 = String.valueOf(ChooseThnAjaranTo.getValue());
        
         if(comboSiswaNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Siswa Nilai belum dipilih");
        }else if(thn1.equals("") || thn2.equals("")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Tahun Ajaran tidak valid");
        }else if(comboSmstrNilai.getSelectedItem().equals("All")){
            JFrame frame = new JFrame("Message Warning");
            JOptionPane.showMessageDialog(frame, "Semester Nilai belum dipilih");
        }else{
            
            Map<String, Object> param = new HashMap<>();
            param.put("kd_siswa", lblKdSiswaNilai.getText());
            param.put("thn_ajaran", thn1+"/"+thn2);
            param.put("smester", comboSmstrNilai.getSelectedItem().toString());

            InputStream logo = getClass().getResourceAsStream("/MI_MAK/image/logo_crope.png");
        try {
            param.put("logo", ImageIO.read(new ByteArrayInputStream(JRLoader.loadBytes(logo))));
        } catch (JRException | IOException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
            

            final SwingWorker<JasperPrint, String> worker = new SwingWorker<JasperPrint, String>(){

                @Override
                protected JasperPrint doInBackground() throws Exception {
                    JasperPrint print;
                    print = displayReport(param, varPathNilaiRapor);

                    return print;
                }

            };
            Window win = SwingUtilities.getWindowAncestor((AbstractButton)evt.getSource());
            ProgressbarLoading loding = new ProgressbarLoading();
            worker.addPropertyChangeListener((PropertyChangeEvent evt1) -> {
                if (evt1.getPropertyName().equals("state")) {
                    if (evt1.getNewValue() == SwingWorker.StateValue.DONE) {
                        loding.dispose();
                    }
                }
            });
            worker.execute();
            loding.pack();
            loding.setLocationRelativeTo(win);
            loding.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btnLapRaporActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ChooseThnAjaranFrom;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranTo;
    private javax.swing.JComboBox ComboHari;
    private com.toedter.calendar.JYearChooser CosThnMasukSiswa;
    private javax.swing.JButton btnLapAbsensi;
    private javax.swing.JButton btnLapGuru;
    private javax.swing.JButton btnLapKelas;
    private javax.swing.JButton btnLapMapel;
    private javax.swing.JButton btnLapNgajar;
    private javax.swing.JButton btnLapNilai;
    private javax.swing.JButton btnLapRapor;
    private javax.swing.JButton btnLapRekap;
    private javax.swing.JButton btnLapSiswa;
    private javax.swing.JComboBox comboGuruGuru;
    private javax.swing.JComboBox comboGuruNgajar;
    private javax.swing.JComboBox comboKelasNgajar;
    private javax.swing.JComboBox comboKelasNilai;
    private javax.swing.JComboBox comboKelasSiswa;
    private javax.swing.JComboBox comboKlsKelas;
    private javax.swing.JComboBox comboMapelGuru;
    private javax.swing.JComboBox comboMapelMapel;
    private javax.swing.JComboBox comboMapelNgajar;
    private javax.swing.JComboBox comboMapelNilai;
    private javax.swing.JComboBox comboSiswaNilai;
    private javax.swing.JComboBox comboSiswaSiswa;
    private javax.swing.JComboBox comboSmstrNilai;
    private javax.swing.JComboBox comboWaliKelasGuru;
    private javax.swing.JComboBox comboWaliKelasNilai;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelKdSiswaSiswa;
    private javax.swing.JLabel labelNmSiswaSiswa;
    private javax.swing.JLabel lblGuruKdNgajar;
    private javax.swing.JLabel lblGuruNmNgajar;
    private javax.swing.JLabel lblKdGuru;
    private javax.swing.JLabel lblKdKelasNilai;
    private javax.swing.JLabel lblKdKlsKelas;
    private javax.swing.JLabel lblKdMapelGuru;
    private javax.swing.JLabel lblKdMapelMapel;
    private javax.swing.JLabel lblKdMapelNilai;
    private javax.swing.JLabel lblKdSiswaNilai;
    private javax.swing.JLabel lblKdWaliKelasNilai;
    private javax.swing.JLabel lblKdWalikelas;
    private javax.swing.JLabel lblKd_kelas_siswa;
    private javax.swing.JLabel lblKlsKdNgajar;
    private javax.swing.JLabel lblKlsNmNgajar;
    private javax.swing.JLabel lblMapeKdlNgajar;
    private javax.swing.JLabel lblMapelNmNgajar;
    private javax.swing.JLabel lblNmGuru;
    private javax.swing.JLabel lblNmKelasKelas;
    private javax.swing.JLabel lblNmKelasNilai;
    private javax.swing.JLabel lblNmMapelGuru;
    private javax.swing.JLabel lblNmMapelMapel;
    private javax.swing.JLabel lblNmMapelNilai;
    private javax.swing.JLabel lblNmSiswaNilai;
    private javax.swing.JLabel lblNmWaliKelasNilai;
    private javax.swing.JLabel lblNmWalikelas;
    private javax.swing.JLabel lblNm_kelas_siswa;
    private javax.swing.JRadioButton rbAllSiswa;
    private javax.swing.ButtonGroup rbGroupSiswa;
    private javax.swing.JRadioButton rbThnMsukSiswa;
    // End of variables declaration//GEN-END:variables
}
