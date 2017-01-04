/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindulu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author made
 */
public class Peminjaman extends javax.swing.JFrame {
    private Statement st;
    private Connection con;
    private ResultSet rsanggota;
    private ResultSet rspetugas;
    private ResultSet rsbuku;
    private ResultSet rspeminjaman;
    private ResultSet rs;
    private String tanggal="";
    private String sql="";
    /**
     * Creates new form Peminjaman
     */
    public Peminjaman() {
        initComponents();
        setTitle("peminjaman");
        koneksipeminjaman();
        hapus();
        pilihananggota();
        pilihanbuku();
        pilihanpetugas();
        tampilpeminjaman();
        waktu();
        prosestambah();
        txtnopeminjaman.requestFocus();
    }
    public void waktu(){
        Date tgl=new Date();
        tanggal1.setDate(tgl);
    }
    private void koneksipeminjaman(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan", "root", "123");
            st=con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
    }
    private void hapus(){
        txtnopeminjaman.setText("");
        comboanggota.setSelectedItem(null);
        txtnamaanggota.setText("");
        combopetugas.setSelectedItem(null);
        txtnamapetugas.setText("");
        combokodebuku.setSelectedItem(null);
        txtjudul.setText("");
        txtpenerbit.setText("");
        txttahunterbit.setText("");
        txtjumlahpinjam.setText("");
    }
    
    private void pilihananggota(){
        comboanggota.removeAllItems();
        comboanggota.addItem("pilih");
        try {
            String sql="select * from tbl_anggota";
            Statement st=con.createStatement();
            rsanggota=st.executeQuery(sql);
            while(rsanggota.next()){
                String aliaskode=rsanggota.getString("kd_anggota");
                comboanggota.addItem(aliaskode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void pilihanpetugas(){
        combopetugas.removeAllItems();
        combopetugas.addItem("pilih");
        try {
            String sql="select * from tbl_petugas";
            Statement st=con.createStatement();
            rsanggota=st.executeQuery(sql);
            while(rsanggota.next()){
                String aliaskode=rsanggota.getString("kd_petugas");
                combopetugas.addItem(aliaskode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void pilihanbuku(){
        combokodebuku.removeAllItems();
        combokodebuku.addItem("pilih");
        try {
            String sql="select * from tbl_buku";
            Statement st=con.createStatement();
            rsanggota=st.executeQuery(sql);
            while(rsanggota.next()){
                String aliaskode=rsanggota.getString("kode_buku");
                combokodebuku.addItem(aliaskode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void prosestambah(){
        DefaultTableModel grid =new DefaultTableModel();
         grid.addColumn("Kode Buku");
        grid.addColumn("Judul Buku");
        grid.addColumn("Penerbit");
        
        table.setModel(grid);
        try {
            DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
            String[]data=new String[3];
            data[0]=String.valueOf(combokodebuku.getSelectedItem());
            data[1]=txtjudul.getText();
            data[2]=txtpenerbit.getText();
            tableModel.addRow(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal"+e);
        }
    }
    private void total(){
        int jumlahbaris=table.getRowCount();
        int jlhpnjm=1,ttlpjn=1;
        
        TableModel tblmodel;
        tblmodel=table.getModel();
        for(int i=1;i<jumlahbaris;i++){
        ttlpjn*=jlhpnjm+i;
    }
        txtjumlahpinjam.setText(String.valueOf(ttlpjn));
    }
    private void simpandetail(){
        int jumlahbaris=table.getRowCount();
        if(jumlahbaris==0){
            JOptionPane.showMessageDialog(null, st);
        }else{
            try {
                int i=0;
                while(i<jumlahbaris){
                    st.executeUpdate("insert into tbl_detpeminjaman"
                    +"(kd_peminjaman,kode_buku,jumlah_pinjam"
                    +"values('"+txtnopeminjaman.getText()+"',"
                    +"'"+table.getValueAt(i, 0)+"',"
                    +"'"+txtjumlahpinjam.getText()+"')");
                    i++;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "gagal menyimpan"+e);
            }
            
        }
    }
    private void tampilpeminjaman(){
        DefaultTableModel grid=new DefaultTableModel();
        grid.addColumn("Kode Peminjaman");
        grid.addColumn("Tanggal");
        grid.addColumn("Kode Petugas");
        grid.addColumn("Kode Anggota");
        grid.addColumn("Jumlah Pinjam");
        
        tablepeminjaman.setModel(grid);
        try {
            rs=st.executeQuery("select * from tbl_peminjaman");
            while (rs.next()){
                grid.addRow(new Object[]{
                    rs.getString("kd_peminjaman"),
                    rs.getString("tgl_pinjam"),
                    rs.getString("kd_petugas"),
                    rs.getString("kd_anggota"),
                    rs.getString("jlh_pinjam"),
                });

            }
        } catch (Exception e) {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnopeminjaman = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tanggal1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnamaanggota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboanggota = new javax.swing.JComboBox<>();
        combopetugas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtjudul = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpenerbit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txttahunterbit = new javax.swing.JTextField();
        nambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtjumlahpinjam = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablepeminjaman = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtnamapetugas = new javax.swing.JTextField();
        combokodebuku = new javax.swing.JComboBox<>();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Peminjaman Buku");

        jLabel2.setText("No Peminjaman :");

        txtnopeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnopeminjamanActionPerformed(evt);
            }
        });

        jLabel3.setText("Tanggal :");

        tanggal1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggal1PropertyChange(evt);
            }
        });

        jLabel4.setText("Kode Anggota :");

        jLabel5.setText("Nama :");

        jLabel6.setText("Kode Petugas :");

        comboanggota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboanggota.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboanggotaItemStateChanged(evt);
            }
        });

        combopetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combopetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopetugasActionPerformed(evt);
            }
        });

        jLabel7.setText("Kode Buku :");

        jLabel8.setText("Judul :");

        jLabel9.setText("Penerbit :");

        jLabel10.setText("jLabel10");

        jLabel12.setText("Tahun Terbit :");

        nambah.setText("Tambah");
        nambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nambahActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        txtjumlahpinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahpinjamActionPerformed(evt);
            }
        });

        jLabel11.setText("Jumlah Pinjam :");

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        tablepeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablepeminjaman);

        jLabel13.setText("Nama :");

        combokodebuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combokodebuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokodebukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnopeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combopetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnamaanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtjudul, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpenerbit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttahunterbit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combokodebuku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(84, 84, 84)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnsimpan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtjumlahpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addComponent(txtnopeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(combokodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtnamaanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txttahunterbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combopetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnamapetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(nambah))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjumlahpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapus)
                        .addGap(22, 22, 22)
                        .addComponent(btnkeluar)
                        .addGap(121, 121, 121))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboanggotaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboanggotaItemStateChanged
        // TODO add your handling code here:
        String kode;
        kode=(String) comboanggota.getSelectedItem();
               try {
//melakukan pencarian data berdasarkan primary key pada tabel
rs=st.executeQuery("select * from tbl_anggota where "+ "kd_anggota='"+kode+"'");
while (rs.next()) {
        txtnamaanggota.setText(rs.getString(2));
    }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_comboanggotaItemStateChanged

    private void combopetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopetugasActionPerformed
        // TODO add your handling code here:
        String kode;
        kode=(String) combopetugas.getSelectedItem();
               try {
//melakukan pencarian data berdasarkan primary key pada tabel
rs=st.executeQuery("select * from tbl_petugas where "+ "kd_petugas='"+kode+"'");
while (rs.next()) {
        txtnamapetugas.setText(rs.getString(2));
    }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_combopetugasActionPerformed

    private void combokodebukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokodebukuActionPerformed
        // TODO add your handling code here:
        String kode;
        kode=(String) combokodebuku.getSelectedItem();
               try {
//melakukan pencarian data berdasarkan primary key pada tabel
rs=st.executeQuery("select * from tbl_buku where "+ "kode_buku='"+kode+"'");
while (rs.next()) {
        txtjudul.setText(rs.getString(2));
        txtpenerbit.setText(rs.getString(5));
        txttahunterbit.setText(rs.getString(6));
    }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_combokodebukuActionPerformed

    private void nambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nambahActionPerformed
        // TODO add your handling code here:
        prosestambah();
        total();
    }//GEN-LAST:event_nambahActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        int jumlahpinjam;
        String nopinjam,kodeanggota,kodepetugas;
        nopinjam=txtnopeminjaman.getText();
        kodepetugas=(String) combopetugas.getSelectedItem();
        kodeanggota=(String) comboanggota.getSelectedItem();
        jumlahpinjam=Integer.parseInt(txtjumlahpinjam.getText());
        
        try {
            st.executeUpdate("insert into tbl_peminjaman values ("
                 + "'" + nopinjam+"',"
                 + "'" + tanggal+ "',"
                 + "'" + kodepetugas+ "',"
                 + "'" + kodeanggota+ "',"       
                 + "'" + jumlahpinjam+ "')"
                ); 
           
            
            hapus();
            tampilpeminjaman();
            JOptionPane.showMessageDialog(null, "data disimpan");
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal"+e);
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tanggal1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggal1PropertyChange
        // TODO add your handling code here:
        if(tanggal1.getDate()!=null){
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
            tanggal=format.format(tanggal1.getDate());
        }
    }//GEN-LAST:event_tanggal1PropertyChange

    private void txtnopeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnopeminjamanActionPerformed
        // TODO add your handling code here:
        String kode;
        kode=txtnopeminjaman.getText();
        try {
//melakukan pencarian data berdasarkan primary key pada tabel
rs=st.executeQuery("select * from tbl_peminjaman where "+ "kd_peminjaman='"+kode+"'");
while (rs.next()) {
        tanggal1.setDate(rs.getDate("tgl_pinjam"));
        combopetugas.setSelectedItem(rs.getString("kd_petugas"));
        comboanggota.setSelectedItem(rs.getString("kd_anggota"));
        txtjumlahpinjam.setText(rs.getString("jlh_pinjam"));
    }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_txtnopeminjamanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        
        try {
            st.executeUpdate("delete from tbl_peminjaman where "
            + "kd_peminjaman='"+txtnopeminjaman.getText()+"'");
            hapus();
            tampilpeminjaman();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "pesan salah : "+e);
        }         
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
         int a=JOptionPane.showConfirmDialog(null, "Yakin mau Keluar?","",JOptionPane.YES_NO_OPTION);
        if(a==0){
            try {
                System.exit(0);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void txtjumlahpinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahpinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahpinjamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> comboanggota;
    private javax.swing.JComboBox<String> combokodebuku;
    private javax.swing.JComboBox<String> combopetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton nambah;
    private javax.swing.JTable table;
    private javax.swing.JTable tablepeminjaman;
    private com.toedter.calendar.JDateChooser tanggal1;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txtjumlahpinjam;
    private javax.swing.JTextField txtnamaanggota;
    private javax.swing.JTextField txtnamapetugas;
    private javax.swing.JTextField txtnopeminjaman;
    private javax.swing.JTextField txtpenerbit;
    private javax.swing.JTextField txttahunterbit;
    // End of variables declaration//GEN-END:variables
}
