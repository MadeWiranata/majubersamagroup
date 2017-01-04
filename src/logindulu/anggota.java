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
public class anggota extends javax.swing.JFrame {
    private Statement st;
    private Connection con;
    private ResultSet rs;
    private String tanggal="";
    private String sql="";
    private String host;
    String kode,nama,jk,tgl,tmptlhr,almt,nohp;

    /**
     * Creates new form anggota
     */
    public anggota() {
        initComponents();
        setTitle("Data Anggota");
        koneksianggota();
        tampilanggota();
        hapus();
        waktu();
    }
private void koneksianggota(){
    try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_perpustakaan", "root", "123");
            st=con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
    }
}
public void waktu(){
    Date tgl=new Date();
    tanggallahir.setDate(tgl);
    
}
private void hapus(){
    txtkodeanggota.setText("");
    txtnamaanggota.setText("");
    cmbjk.setSelectedItem("Pilih");
    tanggallahir.setDate(null);
    txttempatlahir.setText("");
    txtalamat.setText("");
    txtnohp.setText("");
    txtkodeanggota.requestFocus();
}
private void tampilanggota(){
    DefaultTableModel grid=new DefaultTableModel();
        grid.addColumn("Kode");
        grid.addColumn("Nama");
        grid.addColumn("Jenis Kelamin");
        grid.addColumn("Tanggal Lahir");
        grid.addColumn("Tempat Lahir");
        grid.addColumn("Alamat");
        grid.addColumn("No HP");
        
        tabel.setModel(grid);
        try {
            rs=st.executeQuery("select * from tbl_anggota");
            while (rs.next()){
                grid.addRow(new Object[]{
                    rs.getString("kd_anggota"),
                    rs.getString("nama_anggota"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("tgl_lahir"),
                    rs.getString("tmp_lahir"),
                    rs.getString("alamat"),
                    rs.getString("no_hp")
                        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtkodeanggota = new javax.swing.JTextField();
        txtnamaanggota = new javax.swing.JTextField();
        cmbjk = new javax.swing.JComboBox<>();
        tanggallahir = new com.toedter.calendar.JDateChooser();
        txttempatlahir = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txtnohp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Data Anggota");

        jLabel2.setText("Kode Anggota :");

        jLabel3.setText("Nama Anggota :");

        jLabel4.setText("Jenis Kelamin :");

        jLabel5.setText("Tanggal Lahir :");

        jLabel6.setText("Tempat Lahir :");

        jLabel7.setText("Alamat :");

        jLabel8.setText("No.HP :");

        txtkodeanggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeanggotaActionPerformed(evt);
            }
        });
        txtkodeanggota.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtkodeanggotaPropertyChange(evt);
            }
        });

        cmbjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        tanggallahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggallahirPropertyChange(evt);
            }
        });

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
        jScrollPane1.setViewportView(tabel);

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnamaanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 320, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtkodeanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnohp, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tanggallahir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttempatlahir, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(txtalamat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnsimpan)
                                    .addComponent(btnubah, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnkeluar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnhapus, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(38, 38, 38)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkodeanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnamaanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggallahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttempatlahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnhapus)
                            .addComponent(btnsimpan))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnkeluar)
                        .addComponent(btnubah))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        kode=txtkodeanggota.getText();
        nama=txtnamaanggota.getText();
        jk=(String) cmbjk.getSelectedItem();
        almt=txtalamat.getText();
        nohp=txtnohp.getText();
        tmptlhr=txttempatlahir.getText();
         
        try {
            st.executeUpdate("insert into tbl_anggota values ("
                 + "'" + kode+"',"
                 + "'" + nama+"',"
                 + "'" + jk+ "',"
                 + "'" + tanggal+ "',"
                 + "'" + tmptlhr+ "',"
                 + "'" + almt+ "',"        
                 + "'" + nohp+ "')"
                ); 
           
            
            hapus();
            tampilanggota();
        
            JOptionPane.showMessageDialog(null, "data disimpan");
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tanggallahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggallahirPropertyChange
        // TODO add your handling code here:
        if(tanggallahir.getDate()!=null){
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
            tanggal=format.format(tanggallahir.getDate());
        }
    }//GEN-LAST:event_tanggallahirPropertyChange

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
         kode=txtkodeanggota.getText();
        nama=txtnamaanggota.getText();
        jk=(String) cmbjk.getSelectedItem();
        almt=txtalamat.getText();
        nohp=txtnohp.getText();
        tmptlhr=txttempatlahir.getText();
        try {
            sql="update tbl_anggota set nama_anggota='"+nama+"',"
                 +"jenis_kelamin='"+jk+"',tgl_lahir='"+tanggal+"',tmp_lahir='"+tmptlhr+"'," 
                    +"alamat='"+almt+"',no_hp='"+nohp+"'"
                    +"where kd_anggota='"+kode+"'";
            st=con.createStatement();
            st.execute(sql);
            hapus();
            tampilanggota();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil Diubah");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try {
            st.executeUpdate("delete from tbl_anggota where "
            + "kd_anggota='"+txtkodeanggota.getText()+"'");
            hapus();
            tampilanggota();
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

    private void txtkodeanggotaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtkodeanggotaPropertyChange
        // TODO add your handling code here:
             
    }//GEN-LAST:event_txtkodeanggotaPropertyChange

    private void txtkodeanggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeanggotaActionPerformed
        // TODO add your handling code here:
        kode=txtkodeanggota.getText();
        try {
//melakukan pencarian data berdasarkan primary key pada tabel
rs=st.executeQuery("select * from tbl_anggota where "+ "kd_anggota='"+kode+"'");
while (rs.next()) {
        txtnamaanggota.setText(rs.getString("nama_anggota"));
        cmbjk.setSelectedItem(rs.getString("jenis_kelamin"));
        tanggallahir.setDate(rs.getDate("tgl_lahir"));
        txttempatlahir.setText(rs.getString("tmp_lahir"));
        txtalamat.setText(rs.getString("alamat"));
        txtnohp.setText(rs.getString("no_hp"));
        
    }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_txtkodeanggotaActionPerformed

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
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new anggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> cmbjk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tanggallahir;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtkodeanggota;
    private javax.swing.JTextField txtnamaanggota;
    private javax.swing.JTextField txtnohp;
    private javax.swing.JTextField txttempatlahir;
    // End of variables declaration//GEN-END:variables
}
