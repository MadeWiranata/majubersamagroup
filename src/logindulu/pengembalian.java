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
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
/**
 *
 * @author made
 */
public class pengembalian extends javax.swing.JFrame {
private Statement st;
    private Connection con;
    private ResultSet rs;
    private String tanggal="";
    private String sql="";
    private ResultSet rauser;
    
    public String kodekembali,nopinjam;
    public String lambat,denda;
    /**
     * Creates new form pengembalian
     */
    public pengembalian() {
        initComponents();
        hapus();
        koneksipengembalian();
        tampilkembali();
        tglditeks();
        tglsekarang();
    }
public void tglditeks(){
    Date tgl=new Date();
    tglkembali.setDate(tgl);
}
public void tglsekarang(){
    Date tgl=new Date();
    tglsekarang.setDate(tgl);
}
private void koneksipengembalian(){
    try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan", "root", "123");
            st=con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
}
private void hapus(){
    txtkodeanggota.setText("");
    txtkodekembali.setText("");
    tglsekarang.setDate(null);
    txtterlambatdenda.setText("");
    txtdenda.setText("");
    txtnopinjam.setText("");
    tglkembali.setDate(null);
    txtkodepetugas.setText("");
    txtkodeanggota.setText("");
    txtjumlahpinjam.setText("");
    txtkodekembali.requestFocus();
}
private void tampilkembali(){
    DefaultTableModel grid=new DefaultTableModel();
        grid.addColumn("Kode Kembali");
        grid.addColumn("Tanggal Kembali");
        grid.addColumn("Kode Pinjam");
        grid.addColumn("Keterlambatan");
        grid.addColumn("Denda");
        tabel.setModel(grid);
        try {
            rs=st.executeQuery("select * from tbl_pengembalian");
            while (rs.next()){
                grid.addRow(new Object[]{
                    rs.getString("kd_pengembalian"),
                    rs.getString("tgl_pengembalian"),
                    rs.getString("kd_peminjaman"),
                    rs.getString("keterlambatan"),
                    rs.getString("denda")
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnopinjam = new javax.swing.JTextField();
        txtkodepetugas = new javax.swing.JTextField();
        txtkodeanggota = new javax.swing.JTextField();
        txtjumlahpinjam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtkodekembali = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtterlambatdenda = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdenda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        tglsekarang = new com.toedter.calendar.JDateChooser();
        tglkembali = new com.toedter.calendar.JDateChooser();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Pengembalian");

        jLabel2.setText("No Pinjam :");

        jLabel3.setText("Tanggal Pinjam :");

        jLabel4.setText("Kode Petugas :");

        jLabel5.setText("Kode Anggota :");

        jLabel6.setText("Jumlah Pinjam :");

        txtnopinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnopinjamActionPerformed(evt);
            }
        });

        jLabel7.setText("Kode Kembali :");

        jLabel8.setText("Tanggal Kembali :");

        jLabel9.setText("Terlambat :");

        txtterlambatdenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtterlambatdendaActionPerformed(evt);
            }
        });

        jLabel10.setText("Denda :");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabel);

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

        btnkeluar.setText("keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        tglsekarang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglsekarangPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtdenda, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtterlambatdenda, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtkodekembali, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnsimpan)
                                .addGap(42, 42, 42))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tglsekarang, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnhapus)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnopinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtkodeanggota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addComponent(txtkodepetugas, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtjumlahpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnkeluar)
                    .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnopinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtkodekembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel8))
                            .addComponent(tglsekarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtkodepetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtkodeanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtterlambatdenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtjumlahpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtdenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsimpan)
                            .addComponent(btnhapus)
                            .addComponent(btnkeluar))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
         kodekembali=txtkodekembali.getText();
        nopinjam=txtnopinjam.getText();
        lambat=txtterlambatdenda.getText();
        denda=txtdenda.getText();
         
        try {
            st.executeUpdate("insert into tbl_pengembalian values ("
                 + "'" + kodekembali+"',"
                 + "'" + tanggal+"',"
                 + "'" + nopinjam+ "',"
                 + "'" + lambat+ "',"   
                 + "'" + denda+ "')"
                ); 
           
            
            hapus();
            tampilkembali();
        
            JOptionPane.showMessageDialog(null, "data disimpan");
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tglsekarangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglsekarangPropertyChange
        // TODO add your handling code here:
        if(tglsekarang.getDate()!=null){
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
            tanggal=format.format(tglsekarang.getDate());
        }
    }//GEN-LAST:event_tglsekarangPropertyChange

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         try {
            st.executeUpdate("delete from tbl_pengembalian where "
            + "kd_pengembalian='"+txtkodekembali.getText()+"'");
            hapus();
            tampilkembali();
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

    private void txtterlambatdendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtterlambatdendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtterlambatdendaActionPerformed

    private void txtnopinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnopinjamActionPerformed
        // TODO add your handling code here:
        String kode;
        kode=txtnopinjam.getText();
        try {
//melakukan pencarian data berdasarkan primary key pada tabel
rs=st.executeQuery("select * from tbl_peminjaman where "+ "kd_peminjaman='"+kode+"'");
while (rs.next()) {
        tglkembali.setDate(rs.getDate("tgl_pinjam"));
        txtkodepetugas.setText(rs.getString("kd_petugas"));
        txtkodeanggota.setText(rs.getString("kd_anggota"));
        txtjumlahpinjam.setText(rs.getString("jlh_pinjam"));
    }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_txtnopinjamActionPerformed

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
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tglkembali;
    private com.toedter.calendar.JDateChooser tglsekarang;
    private javax.swing.JTextField txtdenda;
    private javax.swing.JTextField txtjumlahpinjam;
    private javax.swing.JTextField txtkodeanggota;
    private javax.swing.JTextField txtkodekembali;
    private javax.swing.JTextField txtkodepetugas;
    private javax.swing.JTextField txtnopinjam;
    private javax.swing.JTextField txtterlambatdenda;
    // End of variables declaration//GEN-END:variables
}