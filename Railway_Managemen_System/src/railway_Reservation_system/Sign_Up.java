package railway_Reservation_system;

import java.awt.Color;
import java.sql.*;
import java.util.Calendar;
import java.util.Random;
import javax.swing.*;

public class Sign_Up extends javax.swing.JFrame {
    
    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
 
    String a_d,a_nm,ps,nm,gn,add,cty,ste,sql,to;        
    int pc,err=0,randomCode;
    long ph;
    Admin_Home obval;
    audioplayer obsound = new audioplayer();
    
    public Sign_Up() {
        initComponents();                
        
        OTPf.setVisible(false);
        otpLabel.setVisible(false);
        verifyb_.setVisible(false);
        back_.setVisible(false);
        Log_out_.setVisible(false);
        User_nm_chk.setText(null);
        Pass_chk.setText(null);
                
        jLabel4.setText(null);
        Pass_chk.setText(null);
        jLabel8.setText(null);
        jLabel17.setText(null);
        jLabel18.setText(null);
        jLabel2.setText(null);
        a_id.setText(null);
                
        java.util.Date date=new java.util.Date();
                    
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();    
        calendar.add(Calendar.YEAR, -18);
        java.util.Date maxDate = calendar.getTime();
        db.setMaxSelectableDate(maxDate);
        
       
    }
        
    public void backdata(Admin_Home obval1)
    {
        obval = obval1;
        back_.setVisible(true);
        back_.show();
        Log_out_.setVisible(true);
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Type = new javax.swing.ButtonGroup();
        Background = new javax.swing.JPanel();
        REGISTER_ = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Log_out_ = new javax.swing.JButton();
        back_ = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cps = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        n = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        db = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        p_no = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        a_id = new javax.swing.JLabel();
        gen = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        addr = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        st = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        p_code = new javax.swing.JTextField();
        Id_Label = new javax.swing.JLabel();
        Admin = new javax.swing.JRadioButton();
        User = new javax.swing.JRadioButton();
        Id_Label1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        u_nm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        User_nm_chk = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailF = new javax.swing.JTextField();
        OTPf = new javax.swing.JTextField();
        otpLabel = new javax.swing.JLabel();
        verifyb_ = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        send_ = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Pass_chk = new javax.swing.JLabel();
        BG_LABEL1 = new javax.swing.JLabel();
        BG_LABEL2 = new javax.swing.JLabel();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        REGISTER_.setBackground(new java.awt.Color(102, 255, 255));
        REGISTER_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        REGISTER_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-administrator-30.png"))); // NOI18N
        REGISTER_.setText("REGISTER");
        REGISTER_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTER_ActionPerformed(evt);
            }
        });
        Background.add(REGISTER_, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 590, 150, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 204));
        jPanel3.setForeground(new java.awt.Color(0, 0, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Rockwell", 1, 26)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 255, 255));
        jLabel13.setText("  REGISTRATION PAGE");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 310, 60));

        Log_out_.setBackground(new java.awt.Color(102, 255, 255));
        Log_out_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Log_out_.setForeground(new java.awt.Color(51, 51, 51));
        Log_out_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log out.png"))); // NOI18N
        Log_out_.setText("LOG OUT");
        Log_out_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log_out_ActionPerformed(evt);
            }
        });
        jPanel3.add(Log_out_, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 140, 40));

        back_.setBackground(new java.awt.Color(102, 255, 255));
        back_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/65.png"))); // NOI18N
        back_.setText("BACK");
        back_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ActionPerformed(evt);
            }
        });
        jPanel3.add(back_, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        Background.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1030, 60));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NAME :");
        Background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 90, 30));

        cps.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        cps.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpsKeyReleased(evt);
            }
        });
        Background.add(cps, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 230, 30));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        Background.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, -1));

        n.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        n.setBorder(null);
        Background.add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 260, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DOB :");
        Background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 100, 30));
        Background.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 260, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PHONE NO :");
        Background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 120, 30));

        p_no.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        p_no.setBorder(null);
        p_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_noKeyReleased(evt);
            }
        });
        Background.add(p_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 260, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("GENDER :");
        Background.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 90, 30));

        a_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a_id.setForeground(new java.awt.Color(255, 255, 255));
        a_id.setText("ID NUMBER");
        Background.add(a_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 110, 30));

        gen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female", "Others" }));
        gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genActionPerformed(evt);
            }
        });
        Background.add(gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 260, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ADDRESS :");
        Background.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 100, 30));

        addr.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        addr.setBorder(null);
        Background.add(addr, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 260, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CITY :");
        Background.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 60, 20));

        city.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        city.setBorder(null);
        city.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cityKeyReleased(evt);
            }
        });
        Background.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, 260, 30));

        st.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        st.setBorder(null);
        st.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stKeyReleased(evt);
            }
        });
        Background.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 260, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("STATE :");
        Background.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 84, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PINCODE :");
        Background.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 115, 30));

        p_code.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        p_code.setBorder(null);
        p_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_codeKeyReleased(evt);
            }
        });
        Background.add(p_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 260, 30));

        Id_Label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Id_Label.setForeground(new java.awt.Color(255, 255, 255));
        Id_Label.setText("TYPE :");
        Background.add(Id_Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 60, -1));

        Type.add(Admin);
        Admin.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        Admin.setForeground(new java.awt.Color(0, 255, 255));
        Admin.setText("Admin");
        Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminActionPerformed(evt);
            }
        });
        Background.add(Admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        Type.add(User);
        User.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        User.setForeground(new java.awt.Color(0, 255, 255));
        User.setText("User");
        User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserActionPerformed(evt);
            }
        });
        Background.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        Id_Label1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Id_Label1.setForeground(new java.awt.Color(255, 255, 255));
        Id_Label1.setText("ID :");
        Background.add(Id_Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 40, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USER NAME :");
        Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 192, 120, 30));

        u_nm.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        u_nm.setBorder(null);
        u_nm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                u_nmKeyReleased(evt);
            }
        });
        Background.add(u_nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 260, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" PASSWORD :");
        Background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 140, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CONFIRME PASSWORD :");
        Background.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 230, 30));

        pass.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        pass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passKeyReleased(evt);
            }
        });
        Background.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 230, 30));

        User_nm_chk.setBackground(new java.awt.Color(204, 255, 204));
        User_nm_chk.setForeground(new java.awt.Color(204, 204, 255));
        User_nm_chk.setText("User Name check");
        Background.add(User_nm_chk, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 230, 20));

        jLabel9.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EMAIL ID :");
        Background.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 100, 30));

        emailF.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        emailF.setBorder(null);
        Background.add(emailF, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 260, 30));

        OTPf.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        OTPf.setBorder(null);
        Background.add(OTPf, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 260, 30));

        otpLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        otpLabel.setForeground(new java.awt.Color(255, 255, 255));
        otpLabel.setText("OTP :");
        Background.add(otpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 80, 30));

        verifyb_.setBackground(new java.awt.Color(204, 255, 255));
        verifyb_.setText("Verify");
        verifyb_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyb_ActionPerformed(evt);
            }
        });
        Background.add(verifyb_, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 90, 30));

        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Phone no check");
        Background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 230, 20));

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Password check");
        Background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 190, 30));

        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("State check");
        Background.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, 240, -1));

        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("City");
        Background.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, 240, -1));

        send_.setBackground(new java.awt.Color(204, 255, 255));
        send_.setText("SEND OTP");
        send_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_ActionPerformed(evt);
            }
        });
        Background.add(send_, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 100, 30));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Pincode");
        Background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 240, -1));

        Pass_chk.setText("Pass check");
        Background.add(Pass_chk, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 210, -1));

        BG_LABEL1.setBackground(new java.awt.Color(0, 0, 0, 80));
        BG_LABEL1.setOpaque(true);
        Background.add(BG_LABEL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 520, 490));

        BG_LABEL2.setBackground(new java.awt.Color(0, 0, 0, 80));
        BG_LABEL2.setOpaque(true);
        Background.add(BG_LABEL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 460, 490));

        BACKGROUND.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BACKGROUND.setForeground(new java.awt.Color(255, 255, 255));
        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Train/Sign_up back.jpg"))); // NOI18N
        Background.add(BACKGROUND, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1170, 700));

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void send_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_ActionPerformed
        // TODO add your handling code here:

        Random rand = new Random();
        randomCode = rand.nextInt(999999);

        to = emailF.getText(); // Replace with the recipient's email address
        String subject = "Railway Management System Login";
        String message = " Welcome to our Railway Management System!\n\nTo complete your registration and verify your email address, please use the following One-Time Password (OTP):\n\nYour login OTP is " + randomCode +"\n\nPlease do not share this code with anyone.\nIf you did not request this verification, please ignore this email.\nThank you for choosing our service. We look forward to serving you.\n\nBest regards,\nRailway Management System Team";
        SendEmail ob = new SendEmail();
        if(ob.send_email(to,subject ,message))
        {
            OTPf.show();
            otpLabel.show();
            verifyb_.show();
        }

    }//GEN-LAST:event_send_ActionPerformed

    private void verifyb_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyb_ActionPerformed
        // TODO add your handling code here:

        if(emailF.getText().equals(to))
        {
            if(Integer.parseInt(OTPf.getText())==randomCode)
            {
                JOptionPane.showMessageDialog(null, "Mail verification complete");
                emailF.disable();
                verifyb_.disable();
                send_.hide();
                verifyb_.hide();
                err = 0;
            }
            else
            {
                obsound.play_audio();
                JOptionPane.showMessageDialog(null, "wrong OTP");
                err = 1;
            }
        }
        else
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "given mail is changed");
        }

    }//GEN-LAST:event_verifyb_ActionPerformed

    private void u_nmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u_nmKeyReleased
        // TODO add your handling code here:

        
    if(u_nm.getText().length() ==0)
    {
        User_nm_chk.setText(null);
    }   
    else    
    {    
        if(Admin.isSelected())
        {
            try{
               String unm;
                int f = 0;

                unm=u_nm.getText();

                sql="select admin_name from admin ";
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);

                //User Name checking
                while(rs.next())
                if(unm.equals(rs.getString("admin_name")))
                {
                    //                 JOptionPane.showMessageDialog(rootPane, "User Name already exist ");
                    User_nm_chk.setText("User name not Available");
                    User_nm_chk.setForeground(Color.red);
                    f=1;
                    break;
                }
                if(f==0)
                {
                    User_nm_chk.setForeground(Color.green);
                    User_nm_chk.setText("User name Available");
                }
            }
            catch(SQLException e)
            {
                obsound.play_audio();
                System.out.println(e);
                JOptionPane.showMessageDialog(rootPane, "Connection problem");
            }
        }

        else if(User.isSelected())
        {
            try{
                String unm;
                int f = 0;

                unm=u_nm.getText();

                sql="select user_name from user ";
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);

                //User Name checking
                while(rs.next())
                if(unm.equals(rs.getString("user_name")))
                {
                    //                 JOptionPane.showMessageDialog(rootPane, "User Name already exist ");
                    User_nm_chk.setText("User name not Available");
                    User_nm_chk.setForeground(Color.red);
                    f=1;
                    break;
                }
                if(f==0)
                {

                    User_nm_chk.setText("User name Available");
                    User_nm_chk.setForeground(Color.green);
                }
            }
            catch(SQLException e)
            {
                obsound.play_audio();
                System.out.println(e);
                JOptionPane.showMessageDialog(rootPane, "connection problem");
            }
        }

        else
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Select login type");
            u_nm.setText("");
        }
    }
    
    }//GEN-LAST:event_u_nmKeyReleased

    private void genActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genActionPerformed

    private void back_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ActionPerformed
        this.dispose();
        obval.setVisible(true);
    }//GEN-LAST:event_back_ActionPerformed

    private void Log_out_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_out_ActionPerformed
        // TODO add your handling code here:
        try{

            Sign_In obj = new Sign_In();
            JOptionPane.showMessageDialog(rootPane, "Log out succesfully");
            this.dispose();
            obj.show();

        }
        catch(Exception e)
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Unable to log out");
            System.out.println("Log out error: "+e);
        }
    }//GEN-LAST:event_Log_out_ActionPerformed

    private void REGISTER_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTER_ActionPerformed
        // TODO add your handling code here:

        if(Admin.isSelected())
        {

            if(err==1)
            {
                JOptionPane.showMessageDialog(rootPane, "Kindly verify the Email address");
            }

            else{
                try {
                    a_d = "AD"+a_id.getText();
                    a_nm = u_nm.getText();
                    ps = pass.getText();
                    nm = n.getText();

                    String em1 = emailF.getText();

                    java.util.Date dob = db.getDate();
                    java.sql.Date sqlDate = new java.sql.Date(dob.getTime());// Convert Java Date to SQL Date

                    ph = Long.parseLong(p_no.getText());
                    gn = gen.getSelectedItem().toString();

                    add=addr.getText();
                    cty = city.getText();
                    ste = st.getText();
                    pc = Integer.parseInt(p_code.getText());

                    sql="insert into admin values('"+a_d+"','"+a_nm+"','"+ps+"','"+nm+"','"+em1+"','"+sqlDate+"','"+0+"','"+ph+"','"+gn+"','"+add+"','"+cty+"','"+ste+"','"+pc+"')";

                    pst=this.con.prepareStatement(sql);
                    int x=pst.executeUpdate();
                    if(x==1)
                    JOptionPane.showMessageDialog(rootPane, "Insert Succesfully!!!");
                    else
                    JOptionPane.showMessageDialog(rootPane, "Inserted UnSuccesfully!!!");

                    //Age update
                    try{
                        sql="update Admin set age = round((current_date()-DOB)/10000)";
                        //                sql="UPDATE Admin SET age = ROUND(DATEDIFF(CURRENT_DATE(), DOB) / 365.25)";
                        pst=this.con.prepareStatement(sql);
                        pst.executeUpdate();
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(rootPane, "Age updation problem: \n "+e);
                    }

                    this.dispose();
                    Sign_In obj1 = new Sign_In();
                    obj1.setVisible(true);

                }
                catch(Exception e) {
                    obsound.play_audio();
                    System.out.println(e);
                    JOptionPane.showMessageDialog(rootPane, "connection problem");
                }
            }
        }

        else if(User.isSelected())
        {
            if(err==1)
            {
                JOptionPane.showMessageDialog(rootPane, "Check the password field");
            }

            else{
                try {
                    a_d = "US"+a_id.getText();
                    a_nm = u_nm.getText();
                    ps = pass.getText();
                    nm = n.getText();

                    String em1 = emailF.getText();

                    java.util.Date dob = db.getDate();

                    // Convert Java Date to SQL Date
                    java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
                    ph = Long.parseLong(p_no.getText());
                    gn = gen.getSelectedItem().toString();

                    add=addr.getText();
                    cty = city.getText();
                    ste = st.getText();
                    pc = Integer.parseInt(p_code.getText());

                    sql="insert into user values('"+a_d+"','"+a_nm+"','"+ps+"','"+nm+"','"+em1+"','"+sqlDate+"','"+0+"','"+ph+"','"+gn+"','"+add+"','"+cty+"','"+ste+"','"+pc+"')";

                    pst=this.con.prepareStatement(sql);
                    int x=pst.executeUpdate();
                    if(x==1)
                    JOptionPane.showMessageDialog(rootPane, "Insert Succesfully!!!");
                    else
                    JOptionPane.showMessageDialog(rootPane, "Inserted UnSuccesfully!!!");

                    //Age update
                    sql="update user set age = round((current_date()-DOB)/10000)";
                    //                sql="UPDATE Admin SET age = ROUND(DATEDIFF(CURRENT_DATE(), DOB) / 365.25)";
                    pst=this.con.prepareStatement(sql);
                    pst.executeUpdate();

                    this.dispose();
                    Sign_In obj1 = new Sign_In();
                    obj1.setVisible(true);
                }
                catch(Exception e) {
                    obsound.play_audio();
                    System.out.println(e);
                    JOptionPane.showMessageDialog(rootPane, "connection problem");
                }
            }
        }

        else
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Select login type");
        }
        

    }//GEN-LAST:event_REGISTER_ActionPerformed

    private void p_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_codeKeyReleased
        String r = p_code.getText();
        int len = r.length();
        char c = evt.getKeyChar();
        
        if(c>='0' && c<='9')
        {
            jLabel2.setText(null);
        }
        else
        {
            jLabel2.setText("Not valid pincode!!");
        }
    }//GEN-LAST:event_p_codeKeyReleased

    private void passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyReleased
        
        String r = pass.getText();
        int len = r.length();
        char c = evt.getKeyChar();
        
        if(len>=6)
        {
            jLabel4.setText(null);
        }
        else
        {
            jLabel4.setText("password should 6 character or digit long");
        }
    }//GEN-LAST:event_passKeyReleased

    private void p_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_noKeyReleased
        
        String r = p_no.getText();
        int len = r.length();
        char c = evt.getKeyChar();
        
        if(c>='0' && c<='9' && len==10)
        {
            jLabel8.setText(null);
        }
        else
        {
            jLabel8.setText("Not valid phone number!!");
        }
    }//GEN-LAST:event_p_noKeyReleased

    private void cityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityKeyReleased
        String r = city.getText();
        
        char c = evt.getKeyChar();
        
        if( (c>='A' && c<='Z' ) || (c>='a' && c<='z'))
        {
            jLabel17.setText(null);
        }
        else
        {
            jLabel17.setText("not a valid state !! ");
        }
    }//GEN-LAST:event_cityKeyReleased

    private void stKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stKeyReleased
        
        String r = st.getText();        
        char c = evt.getKeyChar();
        
        if( (c>='A' && c<='Z' ) || (c>='a' && c<='z'))
        {
            jLabel18.setText(null);
        }
        else
        {
            jLabel18.setText("not a valid state !! ");
        }
    }//GEN-LAST:event_stKeyReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        
        if(jCheckBox1.isSelected())
        {
            pass.setEchoChar((char)0);
            cps.setEchoChar((char)0);
        }
        else
        {
            pass.setEchoChar('*');
            cps.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cpsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpsKeyReleased
        if(pass.getText().equals(cps.getText()))
        {
            Pass_chk.setText("Password Matched");
            Pass_chk.setForeground(Color.GREEN);
        }
        else
        {
            Pass_chk.setText("password not matched");
            Pass_chk.setForeground(Color.RED);
        }
    }//GEN-LAST:event_cpsKeyReleased

    private void AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminActionPerformed
        Random rand = new Random();
        randomCode = rand.nextInt(9999999);
        a_id.setText(String.valueOf(randomCode));
    }//GEN-LAST:event_AdminActionPerformed

    private void UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserActionPerformed
        Random rand = new Random();
        randomCode = rand.nextInt(9999999);
        a_id.setText(String.valueOf(randomCode));
    }//GEN-LAST:event_UserActionPerformed


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
                new Sign_Up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Admin;
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JLabel BG_LABEL1;
    private javax.swing.JLabel BG_LABEL2;
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Id_Label;
    private javax.swing.JLabel Id_Label1;
    private javax.swing.JButton Log_out_;
    private javax.swing.JTextField OTPf;
    private javax.swing.JLabel Pass_chk;
    private javax.swing.JButton REGISTER_;
    private javax.swing.ButtonGroup Type;
    private javax.swing.JRadioButton User;
    private javax.swing.JLabel User_nm_chk;
    private javax.swing.JLabel a_id;
    private javax.swing.JTextField addr;
    private javax.swing.JButton back_;
    private javax.swing.JTextField city;
    private javax.swing.JPasswordField cps;
    private com.toedter.calendar.JDateChooser db;
    private javax.swing.JTextField emailF;
    private javax.swing.JComboBox<String> gen;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField n;
    private javax.swing.JLabel otpLabel;
    private javax.swing.JTextField p_code;
    private javax.swing.JTextField p_no;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton send_;
    private javax.swing.JTextField st;
    private javax.swing.JTextField u_nm;
    private javax.swing.JButton verifyb_;
    // End of variables declaration//GEN-END:variables
}
