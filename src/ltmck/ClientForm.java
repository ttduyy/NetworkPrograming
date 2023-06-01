/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmck;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ClientForm extends javax.swing.JFrame {

    /**
     * Creates new form ClientForm
     */
    public ClientForm() {
        initComponents();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hostField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(617, 547));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Connect to Server");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 42));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Connect to Server");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, 42));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel2.setText("Host");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 48, 20));

        hostField.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        hostField.setText("127.0.0.1");
        hostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostFieldActionPerformed(evt);
            }
        });
        getContentPane().add(hostField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 213, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Port");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 48, 20));

        portField.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        portField.setText("9876");
        getContentPane().add(portField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 213, -1));

        connectButton.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        connectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/link (1) (1).png"))); // NOI18N
        connectButton.setText(" Connect   ");
        connectButton.setBorder(null);
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(connectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        jButton2.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rejected.png"))); // NOI18N
        jButton2.setText("Cancel  ");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jLabel6.setFocusable(false);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 100, 110));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bgleft.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, -20, 790, 620));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bgyellow.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 320, 390));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg.jpg"))); // NOI18N
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -120, 860, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
        String host = hostField.getText();
        ConForm cn = new ConForm();
        int port = Integer.parseInt(portField.getText());
        cn.setPort(port);
        
        try {
            // Tạo một đối tượng InetAddress để lưu địa chỉ IP của host
            iphost = InetAddress.getByName(host);
//            System.out.println(iphost);
            cn.setIphost(iphost);

            // Tạo một đối tượng DatagramSocket để kết nối với Server
            socket = new DatagramSocket();
            cn.setSocket(socket);

            // Hiển thị thông báo kết nối thành công
            JOptionPane.showMessageDialog(null, "Connected to Server!");

            byte[] buffer = "Connected".getBytes();
            DatagramPacket connPacket = new DatagramPacket(buffer, buffer.length, iphost, port);
            socket.send(connPacket);
            socket.send(connPacket);
            socket.send(connPacket);

            DatagramPacket serverPacket = null;
            ByteArrayInputStream bis = null;
            ObjectInputStream ois = null;
            File f = null;
            try {
                byte[] buf = new byte[100000];
                serverPacket = new DatagramPacket(buf, buf.length);
                socket.receive(serverPacket);
                byte[] data = serverPacket.getData();
                bis = new ByteArrayInputStream(serverPacket.getData());
                ois = new ObjectInputStream(bis);
                f = (File) ois.readObject();

                cn.setF(f);
            } catch (IOException iOException) {
            } catch (ClassNotFoundException classNotFoundException) {
            }

            StudentManager stm = new StudentManager(cn);
            stm.setVisible(true);
            while (true) {
                socket.receive(serverPacket);
                bis = new ByteArrayInputStream(serverPacket.getData());
                ois = new ObjectInputStream(bis);
                f = (File) ois.readObject();
                
            }
//            stm.setVisible(true);
//            stm.readStudentsFromFile(f.getName());
//            stm.showData();
            // stm.set
//            stm.setListStu(st.stringToList(receivedData));
//            stm.showData(connJDBC.findAll());
            
        } catch (UnknownHostException ex) {
            // Hiển thị thông báo lỗi không tìm thấy host
            JOptionPane.showMessageDialog(null, "Unknown host: " + host);
        } catch (IOException ex) {
            // Hiển thị thông báo lỗi khi kết nối không thành công
//            JOptionPane.showMessageDialog(null, "Error connecting to Server: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void hostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hostFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm().setVisible(true);
            }
        });
    }

    DatagramSocket socket;
    InetAddress iphost;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JTextField hostField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField portField;
    // End of variables declaration//GEN-END:variables
}