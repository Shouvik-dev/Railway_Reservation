package railway_Reservation_system;

import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class Sign_In extends javax.swing.JFrame {
    
    //Databse connection variables
    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;
    String unm;
    
    audioplayer obsound;
    int randomCode=0;   
    
    public Sign_In() { //Constructor
        initComponents();
        
        send_email_.hide();
        check_otp_button.hide();
        back_.hide();
        
        audioplayer ob = new audioplayer(); // Audio class object
        obsound=ob;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_group = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        user_field = new javax.swing.JTextField();
        pass_field_ = new javax.swing.JPasswordField();
        pass_label_ = new javax.swing.JLabel();
        username_label_ = new javax.swing.JLabel();
        user_icon_ = new javax.swing.JLabel();
        key_icon_ = new javax.swing.JLabel();
        forgot_password_ = new javax.swing.JLabel();
        check_otp_button = new javax.swing.JButton();
        send_email_ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Submit_ = new javax.swing.JButton();
        Reset_ = new javax.swing.JButton();
        t5 = new javax.swing.JLabel();
        Sign_up = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        Admin_Radio = new javax.swing.JRadioButton();
        User_Radio = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        back_ = new javax.swing.JButton();
        Exit_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_field.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        user_field.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        user_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(user_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 190, 200, 30));

        pass_field_.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        pass_field_.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pass_field_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_field_ActionPerformed(evt);
            }
        });
        jPanel1.add(pass_field_, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 260, 200, 30));

        pass_label_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pass_label_.setForeground(new java.awt.Color(51, 51, 51));
        pass_label_.setText("Password :");
        jPanel1.add(pass_label_, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 100, 30));

        username_label_.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        username_label_.setForeground(new java.awt.Color(51, 51, 51));
        username_label_.setText("Username :");
        jPanel1.add(username_label_, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, 30));

        user_icon_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/First page/Administrator Male.png"))); // NOI18N
        jPanel1.add(user_icon_, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        key_icon_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/First page/Key.png"))); // NOI18N
        jPanel1.add(key_icon_, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        forgot_password_.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        forgot_password_.setForeground(new java.awt.Color(0, 0, 255));
        forgot_password_.setText("Forgot password");
        forgot_password_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgot_password_MouseClicked(evt);
            }
        });
        jPanel1.add(forgot_password_, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 100, 20));

        check_otp_button.setBackground(new java.awt.Color(0, 204, 255));
        check_otp_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        check_otp_button.setForeground(new java.awt.Color(255, 255, 255));
        check_otp_button.setText("Check");
        check_otp_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_otp_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(check_otp_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        send_email_.setBackground(new java.awt.Color(0, 204, 255));
        send_email_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        send_email_.setForeground(new java.awt.Color(255, 255, 255));
        send_email_.setText("Send");
        send_email_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_email_ActionPerformed(evt);
            }
        });
        jPanel1.add(send_email_, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 70, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Submit_.setBackground(new java.awt.Color(102, 204, 255));
        Submit_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Submit_.setForeground(new java.awt.Color(255, 255, 255));
        Submit_.setText("SUBMIT");
        Submit_.setBorder(null);
        Submit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_ActionPerformed(evt);
            }
        });

        Reset_.setBackground(new java.awt.Color(102, 204, 255));
        Reset_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Reset_.setForeground(new java.awt.Color(255, 255, 255));
        Reset_.setText("RESET");
        Reset_.setBorder(null);
        Reset_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reset_ActionPerformed(evt);
            }
        });

        t5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        t5.setForeground(new java.awt.Color(51, 51, 51));
        t5.setText("New user?");

        Sign_up.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Sign_up.setForeground(new java.awt.Color(0, 0, 255));
        Sign_up.setText("Sign Up");
        Sign_up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sign_upMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Submit_, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reset_, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(t5)
                        .addGap(6, 6, 6)
                        .addComponent(Sign_up, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Submit_, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Reset_, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sign_up, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 360, 120));

        t3.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        t3.setForeground(new java.awt.Color(51, 51, 51));
        t3.setText("Login as");
        jPanel1.add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 80, 40));

        login_group.add(Admin_Radio);
        Admin_Radio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Admin_Radio.setText("Admin");
        jPanel1.add(Admin_Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        login_group.add(User_Radio);
        User_Radio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        User_Radio.setText("User");
        jPanel1.add(User_Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("   Welcome to Railway Reservation System");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 400, 30));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("  LOGIN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 128, 38));

        back_.setBackground(new java.awt.Color(102, 204, 255));
        back_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_.setForeground(new java.awt.Color(255, 255, 255));
        back_.setText("BACK");
        back_.setBorder(null);
        back_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ActionPerformed(evt);
            }
        });
        jPanel1.add(back_, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 265, 34));

        Exit_.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Exit_.setText("X");
        Exit_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Exit_MouseClicked(evt);
            }
        });
        jPanel1.add(Exit_, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 20, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
      
    private void user_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_fieldActionPerformed
    
    }//GEN-LAST:event_user_fieldActionPerformed

    private void pass_field_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_field_ActionPerformed

    }//GEN-LAST:event_pass_field_ActionPerformed

    private void forgot_password_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgot_password_MouseClicked
        pass_label_.setText("OTP");
        forgot_password_.setText(null);
        back_.show();
        send_email_.show();
        check_otp_button.show();
        
        
        check_otp_button.hide();
        pass_field_.hide();
        pass_label_.hide();
        key_icon_.hide();
        user_icon_.hide();

        jPanel2.hide();
    }//GEN-LAST:event_forgot_password_MouseClicked

    private void check_otp_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_otp_buttonActionPerformed
        // TODO add your handling code here:

        if(Integer.parseInt(pass_field_.getText())==randomCode)
        {

            unm=user_field.getText();
            JOptionPane.showMessageDialog(null, "OTP is matched, WELCOME "+unm);

            if(Admin_Radio.isSelected())
            {
                Admin_Home ob =new Admin_Home();
                ob.logindata(unm);
                ob.show();
                this.dispose();

            }
            else if(User_Radio.isSelected())
            {
                User_Home ob =new User_Home();
                ob.logindata(unm);
                ob.show();
                this.dispose();
            }
            else
            {

            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "wrong OTP");
        }
    }//GEN-LAST:event_check_otp_buttonActionPerformed

    private void send_email_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_email_ActionPerformed

        String to; // Replace with the recipient's email address
        int cnt =0;
        try
        {
            String nm,pwd,sql;
            nm=user_field.getText();

            if(Admin_Radio.isSelected())
            {
                sql="select admin_name,name,password,email from admin where admin_name='"+nm+"'";
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);
                
                while(rs.next())
                {
                    System.out.print("Checking user"+nm);
                    if(nm.equals(rs.getString("admin_name")) ) //Searching for given user name
                    {
                        Random rand = new Random();
                        randomCode = rand.nextInt(999999);
                        cnt = 1;
                        String subject = "Forgot login password";
                        String message = " Hey "+rs.getString("name")+",\n\nTo complete your login process, please use the following One-Time Password (OTP):\n\nYour login OTP is " + randomCode +"\n\nPlease do not share this code with anyone.You can change your login username and password after login\nIf you did not request this verification, please ignore this email.\nThank you for choosing our service. We look forward to serving you.\n\nBest regards,\nRailway Management System Team";
                        to = rs.getString("Email");
                        
                        SendEmail ob = new SendEmail();
                        if(ob.send_email(to,subject ,message))
                        {
                            System.out.print("Email is sended Succesfully"+nm);
                            user_field.enable(false);
                            check_otp_button.show();
                            pass_field_.show();
                            pass_label_.show();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(rootPane, "Unable to send Email to"+nm);
                            System.out.println("Unable to send Email to"+nm);
                        }
                    }
                    else
                    {
                        System.out.println("Wrong!!!");
                        JOptionPane.showMessageDialog(rootPane, "wrong username or password ");
                    }
                }

                if(cnt==0)
                {
                    System.out.println("No Admin data found");
                    JOptionPane.showMessageDialog(rootPane, "No Admin data found");

                }
            }
            else if(User_Radio.isSelected())
            {
                sql="select user_name,name,user_password,Email from user where user_name='"+nm+"'";
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);

                while(rs.next())
                {
                    System.out.print("Checking user"+nm);
                    if(nm.equals(rs.getString("user_name")) ) //Searching for given user name
                    {
                        Random rand = new Random();
                        randomCode = rand.nextInt(999999);
                        cnt = 1;
                        String subject = "Forgot login password";
                        String message = " Hey "+rs.getString("name")+",\n\nTo complete your login process, please use the following One-Time Password (OTP):\n\nYour login OTP is " + randomCode +"\n\nPlease do not share this code with anyone.You can change your login username and password after login\nIf you did not request this verification, please ignore this email.\nThank you for choosing our service. We look forward to serving you.\n\nBest regards,\nRailway Management System Team";
                        to = rs.getString("Email");
                        
                        SendEmail ob = new SendEmail();
                        if(ob.send_email(to,subject ,message))
                        {
                            System.out.print("Email is sended Succesfully"+nm);
                            user_field.enable(false);
                            check_otp_button.show();
                            pass_field_.show();
                            pass_label_.show();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(rootPane, "Unable to send Email to"+nm);
                            System.out.println("Unable to send Email to"+nm);
                        }
                    }
                    else
                    {
                        System.out.println("Wrong!!!");
                        JOptionPane.showMessageDialog(rootPane, "wrong username or password ");
                    }
                }

                if(cnt==0)
                {
                    System.out.println("No User data found");
                    JOptionPane.showMessageDialog(rootPane, "No user data found");

                }
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Select login type");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Unable to send email\nError Occured");
        }

    }//GEN-LAST:event_send_email_ActionPerformed

    private void Submit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_ActionPerformed

    if(user_field.getText().length() ==0 || pass_field_.getText().length() ==0) 
    {
        
        obsound.play_audio();
        JOptionPane.showMessageDialog(rootPane, "Enter proper username and password ");
        
        
    }
    else        
    {    
        try
        {
            String nm,pwd,sql;
            nm=user_field.getText();
            pwd=pass_field_.getText();

            int cnt = 0;

            //Admin Login
            if(Admin_Radio.isSelected())
            {
                sql="select admin_name,name,password from admin where admin_name='"+user_field.getText()+"' and password='"+pass_field_.getText()+"'";
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);

                while(rs.next())
                {
                    if(nm.equals(rs.getString("admin_name")) && pwd.equals(rs.getString("password")))
                    {
                        //                                JOptionPane.showMessageDialog(rootPane, "Welcome "+rs.getString("name"));
                        System.out.println("Welcome"+rs.getString("name"));
                        cnt = 1;
                        username_label_.setText("");
                        pass_label_.setText("");
                        Admin_Home ob = new Admin_Home();
                        ob.logindata(nm);
                        ob.show();
                        this.hide();
                    }
                }
                if(cnt==0)
                {
                    System.out.println("No Admin data found");
                    JOptionPane.showMessageDialog(rootPane, "No Admin data found");
                }
            }
            
            // User Login
            else if(User_Radio.isSelected())
            {
                sql="select user_name,user_password, name from user where user_name='"+nm+"' and user_password='"+pwd+"'";
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    if(nm.equalsIgnoreCase(rs.getString("user_name")) && pwd.equals(rs.getString("user_password")))
                    {
                        //                                JOptionPane.showMessageDialog(rootPane, "Login Succesfull!!\n Welcome ");
                        username_label_.setText("");
                        pass_label_.setText("");
                        System.out.println("Welcome"+rs.getString("name"));
                        cnt=1;
                        User_Home obj = new User_Home();
                        obj.show();

                        this.hide();
                    }
                }

                if(cnt==0)
                {
                    System.out.println("No User data found");
                    JOptionPane.showMessageDialog(rootPane, "No Admin data found");
                }

            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Select login type");
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, "Login connection problem");
            System.out.println(e);
        }
    }  
    }//GEN-LAST:event_Submit_ActionPerformed

    private void Reset_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reset_ActionPerformed
        user_field.setText("");
        pass_field_.setText("");
    }//GEN-LAST:event_Reset_ActionPerformed

    private void Sign_upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sign_upMouseClicked
        Sign_Up obj = new Sign_Up();
        obj.show();
        this.hide();
    }//GEN-LAST:event_Sign_upMouseClicked

    private void back_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ActionPerformed
        pass_label_.setText("Password");
        forgot_password_.setText("Forgot password");
        back_.hide();
        send_email_.hide();
        check_otp_button.hide();
        
              
        pass_field_.show();
        pass_label_.show();
        key_icon_.show();
        user_icon_.show();

        jPanel2.show();
    }//GEN-LAST:event_back_ActionPerformed

    private void Exit_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Exit_MouseClicked
        this.dispose();
        
        System.exit(0);
    }//GEN-LAST:event_Exit_MouseClicked

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
            java.util.logging.Logger.getLogger(Sign_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_In().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Admin_Radio;
    private javax.swing.JLabel Exit_;
    private javax.swing.JButton Reset_;
    private javax.swing.JLabel Sign_up;
    private javax.swing.JButton Submit_;
    private javax.swing.JRadioButton User_Radio;
    private javax.swing.JButton back_;
    private javax.swing.JButton check_otp_button;
    private javax.swing.JLabel forgot_password_;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel key_icon_;
    private javax.swing.ButtonGroup login_group;
    private javax.swing.JPasswordField pass_field_;
    private javax.swing.JLabel pass_label_;
    private javax.swing.JButton send_email_;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t5;
    private javax.swing.JTextField user_field;
    private javax.swing.JLabel user_icon_;
    private javax.swing.JLabel username_label_;
    // End of variables declaration//GEN-END:variables
}
