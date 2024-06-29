package railway_Reservation_system;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Admin_Home extends javax.swing.JFrame {
    audioplayer obsound = new audioplayer();
    String user_name, sql;
    
    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;

    public Admin_Home() {
        initComponents();
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");   
        Date_label.setText(String.valueOf(currentDate.format(dateFormatter)));
        
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Time_label.setText(currentTime.format(timeFormatter));
    }
    
    public void logindata(String x)
    {
        user_name =x;
        User_name_label.setText(user_name);
        
        try
        {
                       
            sql="select admin_id,admin_name,name,password from admin where admin_name='"+user_name+"'";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while(rs.next())
            {
                JOptionPane.showMessageDialog(rootPane, "Login succesfull!!\nwelcome "+rs.getString("name"));
                name_label.setText(rs.getString("name"));
                jLabel8.setText(rs.getString("admin_id"));
            }
        }
        
        catch(Exception e)
        {
            obsound.play_audio();
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Connection Problem for showing user name");   
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Left_Panel = new javax.swing.JPanel();
        USER_ICON = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        User_name_label = new javax.swing.JLabel();
        logout_ = new javax.swing.JButton();
        WelcomeTXT = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Date_label = new javax.swing.JLabel();
        Time_label = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        book_train_ = new javax.swing.JButton();
        Status_ = new javax.swing.JButton();
        sign_in_ = new javax.swing.JButton();
        edit_admin_ = new javax.swing.JButton();
        add_train_ = new javax.swing.JButton();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Railway Reservation System");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(326, 326, 326))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 60));

        Left_Panel.setBackground(new java.awt.Color(102, 153, 255, 210));
        Left_Panel.setForeground(new java.awt.Color(255, 255, 255));
        Left_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        USER_ICON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin_icon.png"))); // NOI18N
        Left_Panel.add(USER_ICON, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        name_label.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        name_label.setForeground(new java.awt.Color(255, 255, 255));
        name_label.setText("Example Name");
        Left_Panel.add(name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 240, 36));

        User_name_label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        User_name_label.setForeground(new java.awt.Color(255, 255, 255));
        User_name_label.setText("Example Name");
        Left_Panel.add(User_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 240, 36));

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
        Left_Panel.add(logout_, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 300, 40));

        WelcomeTXT.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        WelcomeTXT.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeTXT.setText("WELCOME");
        Left_Panel.add(WelcomeTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 180, 55));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("USER NAME :");
        Left_Panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("NAME :");
        Left_Panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 90, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DATE :");
        Left_Panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 80, -1));

        Date_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Date_label.setForeground(new java.awt.Color(255, 255, 255));
        Date_label.setText("DD/MM/YYYY");
        Left_Panel.add(Date_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 120, -1));

        Time_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Time_label.setForeground(new java.awt.Color(255, 255, 255));
        Time_label.setText("hh:mm a");
        Left_Panel.add(Time_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 120, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TIME :");
        Left_Panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 80, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("ID :");
        Left_Panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 102));
        jLabel8.setText("ID");
        Left_Panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 160, -1));

        getContentPane().add(Left_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 700));

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
        getContentPane().add(book_train_, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 270, 65));

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
        getContentPane().add(Status_, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 330, 65));

        sign_in_.setBackground(new java.awt.Color(102, 255, 255));
        sign_in_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        sign_in_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-administrator-30.png"))); // NOI18N
        sign_in_.setText("   ADD ADMIN / USER");
        sign_in_.setBorder(null);
        sign_in_.setBorderPainted(false);
        sign_in_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_in_ActionPerformed(evt);
            }
        });
        getContentPane().add(sign_in_, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 270, 65));

        edit_admin_.setBackground(new java.awt.Color(102, 255, 255));
        edit_admin_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        edit_admin_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit admin.png"))); // NOI18N
        edit_admin_.setText("  EDIT ADMIN / USER");
        edit_admin_.setBorder(null);
        edit_admin_.setBorderPainted(false);
        edit_admin_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_admin_ActionPerformed(evt);
            }
        });
        getContentPane().add(edit_admin_, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 260, 65));

        add_train_.setBackground(new java.awt.Color(102, 255, 255));
        add_train_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        add_train_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_train2.png"))); // NOI18N
        add_train_.setText("  ADD TRAIN");
        add_train_.setBorder(null);
        add_train_.setBorderPainted(false);
        add_train_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_train_ActionPerformed(evt);
            }
        });
        getContentPane().add(add_train_, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 420, 270, 65));

        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Train/vande bharat 2.jpg"))); // NOI18N
        getContentPane().add(BACKGROUND, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logout_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_ActionPerformed

            Sign_In obj = new Sign_In();  
            this.dispose();
            obj.show();
            JOptionPane.showMessageDialog(rootPane, "Log out succesfully");           
    }//GEN-LAST:event_logout_ActionPerformed

    private void sign_in_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_in_ActionPerformed

        Sign_Up obj = new Sign_Up();             
        obj.setVisible(true);
        obj.backdata(this);        
        this.setVisible(false);       
    }//GEN-LAST:event_sign_in_ActionPerformed

    private void edit_admin_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_admin_ActionPerformed

        Admin_User_Table obj = new Admin_User_Table();
        obj.setVisible(true);
        obj.backdata(this);       
        this.setVisible(false);
    }//GEN-LAST:event_edit_admin_ActionPerformed

    private void book_train_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_train_ActionPerformed
        
        Train_Search obj = new Train_Search();
        obj.setVisible(true);
        obj.backdata2(this,User_name_label.getText(),"Admin");
        
        this.setVisible(false);
    }//GEN-LAST:event_book_train_ActionPerformed

    private void add_train_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_train_ActionPerformed
     
        Train_Table ob = new Train_Table();
        ob.setVisible(true);
        ob.backdata(this);
        
        this.setVisible(false);
    }//GEN-LAST:event_add_train_ActionPerformed

    private void Status_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_ActionPerformed
        ticket_status obj = new ticket_status();
        
        obj.backdata(this,"%","Admin");
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Status_ActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Home().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JLabel Date_label;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left_Panel;
    private javax.swing.JButton Status_;
    private javax.swing.JLabel Time_label;
    private javax.swing.JLabel USER_ICON;
    private javax.swing.JLabel User_name_label;
    private javax.swing.JLabel WelcomeTXT;
    private javax.swing.JButton add_train_;
    private javax.swing.JButton book_train_;
    private javax.swing.JButton edit_admin_;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton logout_;
    private javax.swing.JLabel name_label;
    private javax.swing.JButton sign_in_;
    // End of variables declaration//GEN-END:variables
}