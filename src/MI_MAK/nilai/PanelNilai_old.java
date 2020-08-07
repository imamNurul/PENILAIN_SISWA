/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.nilai;

import MI_MAK.dao.Kelas;
import MI_MAK.dao.Mapel;
import MI_MAK.dao.Penilaian;
import MI_MAK.dao.PenilaianRangking;
import MI_MAK.dao.PenilaianRekap;
import MI_MAK.dao.Siswa;
import MI_MAK.service.KelasService;
import MI_MAK.service.MapelService;
import MI_MAK.service.PenilaianService;
import MI_MAK.service.SiswaService;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.util.Calendar;
import java.util.Date;
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
public final class PanelNilai_old extends javax.swing.JPanel {
    
    private final int thnFrom;
    private final int thnTo;
    private final DynamicTableModel<Penilaian> tableModel;
    private final DynamicTableModel<PenilaianRekap> tableModelRekap;
    private final DynamicTableModel<PenilaianRangking> tableModelRangking;

    public PanelNilai_old() {
        initComponents();
        
        
        tableModel = new DynamicTableModel<>(Penilaian.class);
        tableNilai.setDynamicModel(tableModel);
        
        tableModelRekap = new DynamicTableModel<>(PenilaianRekap.class);
        tabelNilaiRekap.setDynamicModel(tableModelRekap);
        
        tableModelRangking = new DynamicTableModel<>(PenilaianRangking.class);
        tableRangking.setDynamicModel(tableModelRangking);
        
        Date date = new Date();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(date.getTime());
        
        thnFrom = date.getYear()+ 1900;
        thnTo = date.getYear()+ 1900;
        
        ChooseThnAjaranFrom.setValue(thnFrom - 1);
        ChooseThnAjaranTo.setValue(thnTo);
        
        ChooseThnAjaranFromRekap.setValue(thnFrom - 1);
        ChooseThnAjaranToRekap.setValue(thnTo);
        
        ChooseThnAjaranFromRangking.setValue(thnFrom - 1);
        ChooseThnAjaranToRangking.setValue(thnTo);
        
        LoadPenilaian(String.valueOf(ChooseThnAjaranFrom.getValue())+"/"+String.valueOf(ChooseThnAjaranTo.getValue()));
        LoadPenilaianRekapAll(String.valueOf(ChooseThnAjaranFromRekap.getValue())+"/"+String.valueOf(ChooseThnAjaranToRekap.getValue()));
    }
    
    private final PenilaianService service = new PenilaianService();
    public void LoadPenilaian(String thn){
        
        new SwingWorker<List<Penilaian>, Object>(){

            @Override
            protected List<Penilaian> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Penilaian> list = service.SelectAll(thn);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Penilaian jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelNilai_old.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    private void LoadPenilaianParam(String mapel, String kls, String thn, String smstr){
        
        new SwingWorker<List<Penilaian>, Object>(){

            @Override
            protected List<Penilaian> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<Penilaian> list = service.SelectNilaiByParam(mapel, kls, thn, smstr);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModel.clear();
                    for(Penilaian jsb : get()){
                    tableModel.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelNilai_old.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadPenilaianRekapAll(String kd){
        
        new SwingWorker<List<PenilaianRekap>, Object>(){

            @Override
            protected List<PenilaianRekap> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<PenilaianRekap> list = service.getNilaiRekapAll(kd);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModelRekap.clear();
                    for(PenilaianRekap jsb : get()){
                    tableModelRekap.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelNilai_old.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
    public void LoadPenilaianRekapParam(String sws, String kls, String thn, String smtr ){
        
        new SwingWorker<List<PenilaianRekap>, Object>(){

            @Override
            protected List<PenilaianRekap> doInBackground() throws Exception {
                
                Thread.sleep(1000);
                List<PenilaianRekap> list = service.getNilaiRekapParam(sws, kls, thn, smtr);

                return list;
            }

            @Override
            protected void done() {
                try {
                    tableModelRekap.clear();
                    for(PenilaianRekap jsb : get()){
                    tableModelRekap.add(jsb);
                }
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(PanelNilai_old.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
  
        }.execute();
        
    }
    
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
            comboKls.addItem(kelas);
            comboKlsRekap.addItem(kelas);
            comboKlsRanking.addItem(kelas);
            System.out.println("load Kelas: "+kelas);
        });
    }
    
    public void LoadSiswaByKelasCombo(String id){
        SiswaService vs = new SiswaService();
        List<Siswa> list =  vs.getSiswaByKelas(id);
        comboSiswaRekap.removeAllItems();
        comboSiswaRekap.addItem("All");
        list.stream().forEach((sw) -> {
            comboSiswaRekap.addItem(sw);
            System.out.println("load Siswa: "+sw);
        });
    }
    
    public void LoadMapelCombo(){
        MapelService ms = new MapelService();
        List<Mapel> list =  ms.selectMapel();
        
        list.stream().forEach((mp) -> {
            comboMapel.addItem(mp);
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

        labelKdMapel = new javax.swing.JLabel();
        labelNmMapel = new javax.swing.JLabel();
        labelKdKls = new javax.swing.JLabel();
        labelNmKls = new javax.swing.JLabel();
        jGlassPane1 = new com.stripbandunk.jglasspane.JGlassPane();
        messageComponent1 = new com.stripbandunk.jglasspane.component.MessageComponent();
        labelKdSiswa = new javax.swing.JLabel();
        labelNmSiswa = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabNilaiSiswa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNilai = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel2 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboMapel = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        comboKls = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboSmstr = new javax.swing.JComboBox();
        btnCari = new javax.swing.JButton();
        btnTmplknSmua = new javax.swing.JButton();
        ChooseThnAjaranFrom = new com.toedter.calendar.JYearChooser();
        jLabel10 = new javax.swing.JLabel();
        ChooseThnAjaranTo = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        tabRekap = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        comboKlsRekap = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        comboSmstrRekap = new javax.swing.JComboBox();
        btnCariRekap = new javax.swing.JButton();
        btnTmplknSmua1 = new javax.swing.JButton();
        ChooseThnAjaranFromRekap = new com.toedter.calendar.JYearChooser();
        jLabel19 = new javax.swing.JLabel();
        ChooseThnAjaranToRekap = new com.toedter.calendar.JYearChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        comboSiswaRekap = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelNilaiRekap = new com.stripbandunk.jwidget.JDynamicTable();
        tabRanking = new javax.swing.JPanel();
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

        labelKdMapel.setText("jLabel11");

        labelNmMapel.setText("jLabel12");

        labelKdKls.setText("jLabel13");

        labelNmKls.setText("jLabel14");

        javax.swing.GroupLayout messageComponent1Layout = new javax.swing.GroupLayout(messageComponent1);
        messageComponent1.setLayout(messageComponent1Layout);
        messageComponent1Layout.setHorizontalGroup(
            messageComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        messageComponent1Layout.setVerticalGroup(
            messageComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setOpaque(false);

        jTabbedPane1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        tabNilaiSiswa.setOpaque(false);

        tableNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableNilai);

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Filter By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setText("Mata Pelajaran ");

        comboMapel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboMapel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboMapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMapelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel3.setText("Kelas");

        comboKls.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKls.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboKls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKlsActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel5.setText(":");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel6.setText("Tahun Ajaran ");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("Semester");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel8.setText(":");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel9.setText(":");

        comboSmstr.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSmstr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Ganjil", "Genap" }));

        btnCari.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnTmplknSmua.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnTmplknSmua.setText("Tampilkan Semua");
        btnTmplknSmua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmplknSmuaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setText("/");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboMapel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboKls, 0, 204, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboSmstr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTmplknSmua))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(comboMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(comboKls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(comboSmstr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ChooseThnAjaranFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(ChooseThnAjaranTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTmplknSmua)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel1.setText("Cari :");

        txtCari.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout tabNilaiSiswaLayout = new javax.swing.GroupLayout(tabNilaiSiswa);
        tabNilaiSiswa.setLayout(tabNilaiSiswaLayout);
        tabNilaiSiswaLayout.setHorizontalGroup(
            tabNilaiSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNilaiSiswaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabNilaiSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tabNilaiSiswaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)))
                .addContainerGap())
        );
        tabNilaiSiswaLayout.setVerticalGroup(
            tabNilaiSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabNilaiSiswaLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabNilaiSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Penilaian Siswa", tabNilaiSiswa);

        tabRekap.setOpaque(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Filter By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel12.setText("Kelas");

        comboKlsRekap.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboKlsRekap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboKlsRekap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKlsRekapActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel14.setText(":");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel15.setText("Tahun Ajaran ");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel16.setText("Semester");

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel17.setText(":");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel18.setText(":");

        comboSmstrRekap.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSmstrRekap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Ganjil", "Genap" }));

        btnCariRekap.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCariRekap.setText("Cari");
        btnCariRekap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariRekapActionPerformed(evt);
            }
        });

        btnTmplknSmua1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnTmplknSmua1.setText("Tampilkan Semua");
        btnTmplknSmua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmplknSmua1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel19.setText("/");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel13.setText("Siswa");

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel20.setText(":");

        comboSiswaRekap.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        comboSiswaRekap.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        comboSiswaRekap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSiswaRekapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ChooseThnAjaranFromRekap, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChooseThnAjaranToRekap, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboKlsRekap, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSmstrRekap, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSiswaRekap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCariRekap, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTmplknSmua1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 103, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCariRekap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTmplknSmua1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel18))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)
                                .addComponent(comboSmstrRekap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ChooseThnAjaranFromRekap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(ChooseThnAjaranToRekap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(comboKlsRekap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20)
                            .addComponent(comboSiswaRekap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);

        jScrollPane2.setViewportView(tabelNilaiRekap);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tabRekapLayout = new javax.swing.GroupLayout(tabRekap);
        tabRekap.setLayout(tabRekapLayout);
        tabRekapLayout.setHorizontalGroup(
            tabRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRekapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabRekapLayout.setVerticalGroup(
            tabRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRekapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nilai Rekap", tabRekap);

        tabRanking.setOpaque(false);

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
                .addGap(0, 103, Short.MAX_VALUE))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tabRankingLayout = new javax.swing.GroupLayout(tabRanking);
        tabRanking.setLayout(tabRankingLayout);
        tabRankingLayout.setHorizontalGroup(
            tabRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRankingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tabRankingLayout.setVerticalGroup(
            tabRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabRankingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ranking", tabRanking);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        
        TambahNilai tambahNilai = new TambahNilai();
        tambahNilai.tambahNilai();
        LoadPenilaian(String.valueOf(ChooseThnAjaranFrom.getValue())+"/"+String.valueOf(ChooseThnAjaranTo.getValue()));
        LoadKelasCombo();
        LoadMapelCombo();
        
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        
        String varMapel;
        String varKls;
        String varSmstr;
        String varThn;
        
        String thF;
        String thT;
        if(comboMapel.getSelectedItem().equals("All")){
            varMapel = "";
        }else{
            varMapel = labelKdMapel.getText();
        }
        
        if(comboKls.getSelectedItem().equals("All")){
            varKls = "";
        }else{
            varKls = labelKdKls.getText();
        }
        
        if(comboSmstr.getSelectedItem().equals("All")){
            varSmstr = "";
        }else{
            varSmstr = comboSmstr.getSelectedItem().toString();
        }
        
        if(ChooseThnAjaranFrom.getValue() <= 0 || ChooseThnAjaranTo.getValue() <= 0){
            thF = "";
            thT = "";
            varThn = thF+"/"+thT;
        }else{
            thF = String.valueOf(ChooseThnAjaranFrom.getValue());
            thT = String.valueOf(ChooseThnAjaranTo.getValue());
            varThn = thF+"/"+thT;
        }
        
        System.out.println("param Nilai mapel All: "+ varMapel);
        System.out.println("param Nilai kelas All: "+ varKls);
        System.out.println("param Nilai thn All: "+ varThn);
        System.out.println("param Nilai smstr All: "+ varSmstr);
        
        
        LoadPenilaianParam(varMapel, varKls, varThn, varSmstr);
        
        
    }//GEN-LAST:event_btnCariActionPerformed

    private void comboMapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMapelActionPerformed
        // TODO add your handling code here:
        
         if(comboMapel.getSelectedItem().equals("All")){
            
            System.out.println("combo kelas index 1 : "+comboKls.getSelectedIndex());
            System.out.println("combo kelas item 1 : "+comboKls.getSelectedItem());
           // JFrame frame = new JFrame("Warning");
           // JOptionPane.showMessageDialog(frame, "All Kelas");
        }else if(comboMapel.getSelectedIndex()== -1){
            System.out.println("combo kelas index 2: "+comboKls.getSelectedIndex());
            System.out.println("combo kelas item 2: "+comboKls.getSelectedItem());
           // JFrame frame = new JFrame("Warning");
           // JOptionPane.showMessageDialog(frame, "All Kelas");
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
        }
        
       
        
    }//GEN-LAST:event_comboMapelActionPerformed

    private void comboKlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKlsActionPerformed
        // TODO add your handling code here:
        
        if(comboKls.getSelectedItem().equals("All")){
            
            System.out.println("combo kelas index 1 : "+comboKls.getSelectedIndex());
            System.out.println("combo kelas item 1 : "+comboKls.getSelectedItem());
           // JFrame frame = new JFrame("Warning");
           // JOptionPane.showMessageDialog(frame, "All Kelas");
        }else if(comboKls.getSelectedIndex()== -1){
            System.out.println("combo kelas index 2: "+comboKls.getSelectedIndex());
            System.out.println("combo kelas item 2: "+comboKls.getSelectedItem());
           // JFrame frame = new JFrame("Warning");
           // JOptionPane.showMessageDialog(frame, "All Kelas");
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
            
        }
        
        
       
        
    }//GEN-LAST:event_comboKlsActionPerformed

    private void btnTmplknSmuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmplknSmuaActionPerformed
        // TODO add your handling code here:
        
        LoadPenilaian(String.valueOf(ChooseThnAjaranFrom.getValue())+"/"+String.valueOf(ChooseThnAjaranTo.getValue()));
        comboKls.setSelectedItem("All");
        comboMapel.setSelectedItem("All");
        comboSmstr.setSelectedItem("All");
        ChooseThnAjaranFrom.setValue(thnFrom - 1);
        ChooseThnAjaranTo.setValue(thnTo);
        
    }//GEN-LAST:event_btnTmplknSmuaActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        
        if(tableNilai.getSelectedRow() != -1){
            int index = tableNilai.convertRowIndexToModel(tableNilai.getSelectedRow());
            Penilaian sw = tableModel.get(index);
            UbahNilai ubh = new UbahNilai();
            ubh.LoadNilaiDetailUbah(sw.getId_nilai());
            ubh.ubahNilai(sw);
            
            
        }else{
            JOptionPane.showMessageDialog(this, "silahkan seleksi satu baris");
        }
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped
        // TODO add your handling code here:
        
        try{
            String cari = txtCari.getText();
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tableNilai.getRowSorter();
            sorter.setRowFilter(RowFilter.regexFilter(cari));
        }catch(PatternSyntaxException ex){
            
        }
    }//GEN-LAST:event_txtCariKeyTyped

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        
        try{
            String cari = txtCari.getText();
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) tableNilai.getRowSorter();
            sorter.setRowFilter(RowFilter.regexFilter(cari));
        }catch(PatternSyntaxException ex){
            
        }
    }//GEN-LAST:event_txtCariKeyPressed

    private void tableNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNilaiMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount() == 2){
            int index = tableNilai.convertRowIndexToModel(tableNilai.getSelectedRow());
            Penilaian pn = tableModel.get(index);
            DetailNilai detailNilai = new DetailNilai();
            detailNilai.LoadNilaiDetailUbah(pn.getId_nilai());
            detailNilai.detailNilai(pn);
        }
        
    }//GEN-LAST:event_tableNilaiMouseClicked

    private void comboKlsRekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKlsRekapActionPerformed
        // TODO add your handling code here:
        
        if(comboKlsRekap.getSelectedItem().equals("All")){
            
            
            LoadSiswaByKelasCombo("");
            System.out.println("combo kelas index 1 : "+comboKlsRekap.getSelectedIndex());
            System.out.println("combo kelas item 1 : "+comboKlsRekap.getSelectedItem());
           // JFrame frame = new JFrame("Warning");
           // JOptionPane.showMessageDialog(frame, "All Kelas");
        }else if(comboKlsRekap.getSelectedIndex()== -1){
            System.out.println("combo kelas index 2: "+comboKlsRekap.getSelectedIndex());
            System.out.println("combo kelas item 2: "+comboKlsRekap.getSelectedItem());
           // JFrame frame = new JFrame("Warning");
           // JOptionPane.showMessageDialog(frame, "All Kelas");
        }else{
            
            String lblKodeKls;
            lblKodeKls = comboKlsRekap.getSelectedItem().toString();
            System.out.println("combo kelas: "+lblKodeKls);
            String[] prt = lblKodeKls.split("-");
            String varStrKode = prt[0];
            String varStrNama = prt[1];
            System.out.println("split kode: "+varStrKode);
            System.out.println("split nama: "+varStrNama);
            labelKdKls.setText(varStrKode);
            labelNmKls.setText(varStrNama);
            
            LoadSiswaByKelasCombo(labelKdKls.getText());
            
        }
        
    }//GEN-LAST:event_comboKlsRekapActionPerformed

    private void comboSiswaRekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSiswaRekapActionPerformed
        // TODO add your handling code here:
        
        if(comboSiswaRekap.getSelectedIndex() == -1 ){
            System.out.println("combo siswa index 1 : "+comboSiswaRekap.getSelectedIndex());
            System.out.println("combo siswa item 1 : "+comboSiswaRekap.getSelectedItem());
        }else if(comboSiswaRekap.getSelectedItem().equals("All")){
          //  LoadPenilaianRekapAll(thnFrom-1+"/"+thnTo);
            System.out.println("combo siswa index 1 : "+comboSiswaRekap.getSelectedIndex());
            System.out.println("combo siswa item 1 : "+comboSiswaRekap.getSelectedItem());
        }else{
            
            String lblKodeSws;
            lblKodeSws = comboSiswaRekap.getSelectedItem().toString();
            System.out.println("combo Siswa: "+lblKodeSws);
            String[] prt = lblKodeSws.split("-");
            String varStrKode = prt[0];
            String varStrNama = prt[1];
            System.out.println("split kode: "+varStrKode);
            System.out.println("split nama: "+varStrNama);
            labelKdSiswa.setText(varStrKode);
            labelNmSiswa.setText(varStrNama);
            
           // LoadPenilaianRekap(labelKdSiswa.getText());
            
        }
        
        
        
    }//GEN-LAST:event_comboSiswaRekapActionPerformed

    private void btnCariRekapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariRekapActionPerformed
        // TODO add your handling code here:
        String varSiswa;
        String varKls;
        String varSmstr;
        String varThn;
        
        String thF;
        String thT;
        
        if(comboSiswaRekap.getSelectedItem().equals("All")){
            varSiswa = "";
        }else{
            varSiswa = labelKdSiswa.getText();
        }
        
        if(comboKlsRekap.getSelectedItem().equals("All")){
            varKls = "";
        }else{
            varKls = labelKdKls.getText();
        }
        
        if(comboSmstrRekap.getSelectedItem().equals("All")){
            varSmstr = "";
        }else{
            varSmstr = comboSmstrRekap.getSelectedItem().toString();
        }
        
        if(ChooseThnAjaranFromRekap.getValue() <= 0 || ChooseThnAjaranToRekap.getValue() <= 0){
            thF = "";
            thT = "";
            varThn = thF+"/"+thT;
        }else{
            thF = String.valueOf(ChooseThnAjaranFromRekap.getValue());
            thT = String.valueOf(ChooseThnAjaranToRekap.getValue());
            varThn = thF+"/"+thT;
        }
        
        LoadPenilaianRekapParam(varSiswa, varKls, varThn, varSmstr);
        
    }//GEN-LAST:event_btnCariRekapActionPerformed

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

    private void btnTmplknSmua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmplknSmua1ActionPerformed
        // TODO add your handling code here:
        LoadPenilaianRekapAll(String.valueOf(ChooseThnAjaranFromRekap.getValue())+"/"+String.valueOf(ChooseThnAjaranToRekap.getValue()));
        comboKlsRekap.setSelectedItem("All");
        comboSiswaRekap.setSelectedItem("All");
        comboSmstrRekap.setSelectedItem("All");
        
    }//GEN-LAST:event_btnTmplknSmua1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser ChooseThnAjaranFrom;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranFromRangking;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranFromRekap;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranTo;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranToRangking;
    private com.toedter.calendar.JYearChooser ChooseThnAjaranToRekap;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCariRangking;
    private javax.swing.JButton btnCariRekap;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTmplknSmua;
    private javax.swing.JButton btnTmplknSmua1;
    private javax.swing.JButton btnTmplknSmuaRangking;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox comboKls;
    private javax.swing.JComboBox comboKlsRanking;
    private javax.swing.JComboBox comboKlsRekap;
    private javax.swing.JComboBox comboMapel;
    private javax.swing.JComboBox comboSiswaRekap;
    private javax.swing.JComboBox comboSmstr;
    private javax.swing.JComboBox comboSmstrRanking;
    private javax.swing.JComboBox comboSmstrRekap;
    private com.stripbandunk.jglasspane.JGlassPane jGlassPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelKdKls;
    private javax.swing.JLabel labelKdMapel;
    private javax.swing.JLabel labelKdSiswa;
    private javax.swing.JLabel labelNmKls;
    private javax.swing.JLabel labelNmMapel;
    private javax.swing.JLabel labelNmSiswa;
    private com.stripbandunk.jglasspane.component.MessageComponent messageComponent1;
    private javax.swing.JPanel tabNilaiSiswa;
    private javax.swing.JPanel tabRanking;
    private javax.swing.JPanel tabRekap;
    private com.stripbandunk.jwidget.JDynamicTable tabelNilaiRekap;
    private com.stripbandunk.jwidget.JDynamicTable tableNilai;
    private com.stripbandunk.jwidget.JDynamicTable tableRangking;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
