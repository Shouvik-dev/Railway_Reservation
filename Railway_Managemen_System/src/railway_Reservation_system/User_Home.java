package railway_Reservation_system;

import java.sql.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class User_Home extends javax.swing.JFrame {

    String user_name, sql;
    
    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;
    audioplayer obsound= new audioplayer();
    public User_Home() {
        initComponents();
        
        audioplayer ob = new audioplayer();
        obsound=ob;
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");   
        jLabel10.setText(String.valueOf(currentDate.format(dateFormatter)));
        
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        jLabel11.setText(currentTime.format(timeFormatter));
        
    }
    
    public void logindata(String x)
    {
        user_name =x;
        User_name_label.setText(user_name);
        
        try
        {
                     
            sql="select user_id,user_name,name,user_password from user where user_name='"+user_name+"'";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while(rs.next())
            {
                JOptionPane.showMessageDialog(rootPane, "welcome "+rs.getString("name"));
                name_label.setText(rs.getString("name"));
                jLabel8.setText(rs.getString("user_id"));
            }
        }
        
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Connection Problem for showing user name");   
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        book_train_ = new javax.swing.JButton();
        Status_ = new javax.swing.JButton();
        User_name_label = new javax.swing.JLabel();
        logout_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/USER.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Railway Reservation System");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 60));

        name_label.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        name_label.setForeground(new java.awt.Color(255, 255, 255));
        name_label.setText("Example Name");
        getContentPane().add(name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 240, 36));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 102));
        jLabel8.setText("ID");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 160, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("hh:mm a");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 100, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TIME :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 60, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DATE :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 60, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("NAME :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("USER NAME :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel2.setBackground(new java.awt.Color(51, 0, 255));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 60));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DD/MM/YYYY");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 100, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("WELCOME");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 180, 55));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("ID :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin_icon.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        book_train_.setBackground(new java.awt.Color(102, 255, 255));
        book_train_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        book_train_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/book train.png"))); // NOI18N
        book_train_.setText("  BOOK TRAIN");
        book_train_.setBorder(null);
        book_train_.setBorderPainted(false);
        book_train_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_train_ActionPerformed(evt);
            }
        });
        getContentPane().add(book_train_, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 480, 140));

        Status_.setBackground(new java.awt.Color(102, 255, 255));
        Status_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Status_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/book train.png"))); // NOI18N
        Status_.setText("BOOKING STATUS");
        Status_.setBorder(null);
        Status_.setBorderPainted(false);
        Status_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_ActionPerformed(evt);
            }
        });
        getContentPane().add(Status_, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 480, 140));

        User_name_label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        User_name_label.setForeground(new java.awt.Color(255, 255, 255));
        User_name_label.setText("Example Name");
        getContentPane().add(User_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 180, 30));

        logout_.setBackground(new java.awt.Color(102, 255, 255));
        logout_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        logout_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log out.png"))); // NOI18N
        logout_.setText("  LOG OUT");
        logout_.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_ActionPerformed(evt);
            }
        });
        getContentPane().add(logout_, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 220, 40));

        jLabel1.setBackground(new java.awt.Color(0, 204, 255));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 400, 540));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255, 70));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 680, 600));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/Background.jpg"))); // NOI18N
        Background.setText("jLabel1");
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1067, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logout_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_ActionPerformed

        Sign_In obj = new Sign_In();
        this.dispose();
        obj.show();
        JOptionPane.showMessageDialog(rootPane, "Log out succesfully");
    }//GEN-LAST:event_logout_ActionPerformed

    private void book_train_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_train_ActionPerformed
        // TODO add your handling code here:

        Train_Search obj = new Train_Search();
        obj.setVisible(true);
        obj.backdata1(this,User_name_label.getText(),"User");

        this.setVisible(false);
    }//GEN-LAST:event_book_train_ActionPerformed

    private void Status_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_ActionPerformed
        ticket_status obj = new ticket_status();

        obj.backdata1(this,User_name_label.getText(),"User");
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Status_ActionPerformed

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
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Status_;
    private javax.swing.JLabel User_name_label;
    private javax.swing.JButton book_train_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton logout_;
    private javax.swing.JLabel name_label;
    // End of variables declaration//GEN-END:variables
}
