/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package railway_Reservation_system;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.swing.*;

import java.awt.image.BufferedImage;
/**
 *
 * @author ADRIJA
 */
public class Payment extends javax.swing.JFrame {
    
    Train_Book obval1;
    audioplayer obsound;
    
    public Payment() {
        initComponents();
        audioplayer ob = new audioplayer();
        obsound=ob;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        clsL = new javax.swing.JLabel();
        amt = new javax.swing.JLabel();
        pcount = new javax.swing.JLabel();
        Succcess_ = new javax.swing.JButton();
        Cancel_ = new javax.swing.JButton();
        Background_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 210, 184));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("PAYMENT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 116, 31));

        jLabel4.setText("Scan this QR to complete your payment");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 218, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("class :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 40, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Total Amount Payble :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Total pasenger :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        clsL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clsL.setText("jLabel1");
        getContentPane().add(clsL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        amt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amt.setText("jLabel1");
        getContentPane().add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        pcount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pcount.setText("jLabel1");
        getContentPane().add(pcount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));

        Succcess_.setText("DONE");
        Succcess_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Succcess_ActionPerformed(evt);
            }
        });
        getContentPane().add(Succcess_, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 120, 30));

        Cancel_.setText("CANCEL");
        Cancel_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_ActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel_, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 120, 30));
        getContentPane().add(Background_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Succcess_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Succcess_ActionPerformed
             
             this.hide();
             this.dispose();
             obval1.payment_status(1);
    }//GEN-LAST:event_Succcess_ActionPerformed

    private void Cancel_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel_ActionPerformed
        obval1.payment_status(0);
        this.hide();
        this.dispose();
    }//GEN-LAST:event_Cancel_ActionPerformed

    public void generateQRCode( String text, int pascnt, String cls, int amount, Train_Book obval) {
        
        obval1=obval;
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter text to generate QR code", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            BufferedImage qrCodeImage = generateQRCodeImage(text);
            jLabel2.setIcon(new ImageIcon(qrCodeImage));
            
            amt.setText(String.valueOf(amount));
            pcount.setText(String.valueOf(pascnt));
            clsL.setText(cls);
        } catch (WriterException e) {
            obsound.play_audio();
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not generate QR code", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    private BufferedImage generateQRCodeImage(String barcodeText) throws WriterException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
    

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background_;
    private javax.swing.JButton Cancel_;
    private javax.swing.JButton Succcess_;
    private javax.swing.JLabel amt;
    private javax.swing.JLabel clsL;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel pcount;
    // End of variables declaration//GEN-END:variables
}
