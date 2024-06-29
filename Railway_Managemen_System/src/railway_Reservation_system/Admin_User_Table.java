package railway_Reservation_system;

import java.awt.Color;
import javax.swing.*;

import java.text.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Admin_User_Table extends javax.swing.JFrame {
    audioplayer obsound= new audioplayer();

    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
    
    Admin_Home obval;
    String id,a_nm,ps,nm,em,add,cty,ste,sql,r, user_nm1;
    String em_chk=null;//for email check
    int pc,err=0,ag;
    long ph;
    
    public Admin_User_Table() //Constructor
    {
        initComponents();

        //Table transparent code
        ((DefaultTableCellRenderer) Table1.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        Table1.setOpaque(false);
        ((DefaultTableCellRenderer) Table1.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
        Table1.setRowHeight(25);
        
        //Date set
        java.util.Date date=new java.util.Date();                    
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentDate = calendar.getTime();    
        calendar.add(Calendar.YEAR, -18);
        java.util.Date maxDate = calendar.getTime();
        db1.setMaxSelectableDate(maxDate);
        
        a_id.enable(false);
        u_nm.enable(false);
        pass.enable(false);
        n.enable(false);
        db1.enable(false);
        a.enable(false);
        p_no.enable(false);
        addr.enable(false);
        city1.enable(false);
        st.enable(false);
        p_code.enable(false);
        eml.enable(false);
        otp_f.enable(false);
        
        jLabel16.setText(null);
        jLabel3.setText(null);
        jLabel15.setText(null);
        jLabel14.setText(null);
        jLabel4.setText(null);
        
        get_otp_.hide();
        verifyb_.hide();
        otp_f.hide();
        jLabel23.hide();
        User_nm_chk.setText(null);
        
        audioplayer ob = new audioplayer();
        obsound=ob;
    }
        public void backdata(Admin_Home obval1)
    {
        obval = obval1;
        back_.setVisible(true);
        Log_out_.setVisible(true);
    }
    public void en() //For enable JTextFields
    {
        a_id.enable(true);
        u_nm.enable(true);
        pass.enable(true);
        n.enable(true);
        db1.enable(true);
        a.enable(true);
        p_no.enable(true);
        addr.enable(true);
        city1.enable(true);
        st.enable(true);
        p_code.enable(true);
        
        eml.enable(true);           
   }
    
    public void show_admin() //Show admin data in table
    {
        try
        {
            DefaultTableModel ob1=(DefaultTableModel)Table1.getModel();
            ob1.setRowCount(0);
            sql="select * from admin";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {

                id=rs.getString("admin_id");
                a_nm=rs.getString("admin_name");
                ps=rs.getString("Password");
                nm = rs.getString("name");
                em = rs.getString("Email");
               java.util.Date dob=rs.getDate("DOB");
               
               
                ag=Integer.parseInt(rs.getString("age"));
                ph=Long.parseLong(rs.getString("ph_number"));

                add=rs.getString("address");
                cty=rs.getString("city");
                ste=rs.getString("sate");
                pc=Integer.parseInt(rs.getString("pincode"));

                SimpleDateFormat obj = new SimpleDateFormat("dd-MM-YYYY");
                String pat = obj.format(dob);
        
                r=String.valueOf(id);
                String x[]={id,a_nm,ps,nm,em,pat,Integer.toString(ag),Long.toString(ph),add,cty,ste,Integer.toString(pc)};
                DefaultTableModel ob=(DefaultTableModel)Table1.getModel();
                ob.addRow(x);
            }
            
            stmt.close();
            rs.close();

        }
        catch(Exception e)
        {
            obsound.play_audio();
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane,"Connection Problem");
        }
    }
    
    public void show_user() //Show user data in table
    {
        try
        {
            DefaultTableModel ob1=(DefaultTableModel)Table1.getModel();
            ob1.setRowCount(0);

            sql="select * from user";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                id=rs.getString("user_id");
                a_nm=rs.getString("user_name");
                ps=rs.getString("user_password");
                nm = rs.getString("name");
                em = rs.getString("Email");
                java.util.Date dob=rs.getDate("DOB");

                ag=Integer.parseInt(rs.getString("age"));
                ph=Long.parseLong(rs.getString("ph_no"));

                add=rs.getString("address");
                cty=rs.getString("city");
                ste=rs.getString("state");
                pc=Integer.parseInt(rs.getString("pin_code"));
                               
                SimpleDateFormat obj = new SimpleDateFormat("dd-MM-YYYY");
                String pat = obj.format(dob);

                r=String.valueOf(id);
                String x[]={id,a_nm,ps,nm,em,pat,Integer.toString(ag),Long.toString(ph),add,cty,ste,Integer.toString(pc)};
                DefaultTableModel ob=(DefaultTableModel)Table1.getModel();
                ob.addRow(x);
            }
                        
            stmt.close();
            rs.close();
        }
        catch(Exception e)
        {
            obsound.play_audio();
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane,"Connection Problem");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Type = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        n = new javax.swing.JTextField();
        db1 = new com.toedter.calendar.JDateChooser();
        delete_ = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        REGISTER_ = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        User_nm_chk = new javax.swing.JLabel();
        u_nm = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        a_id = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        p_code = new javax.swing.JTextField();
        id_label = new javax.swing.JLabel();
        admin_radio = new javax.swing.JRadioButton();
        User_radio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        p_no = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        addr = new javax.swing.JTextField();
        city1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        st = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        update_1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        n1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        eml = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        otp_f = new javax.swing.JTextField();
        get_otp_ = new javax.swing.JButton();
        verifyb_ = new javax.swing.JButton();
        Heading_Panel = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        Log_out_ = new javax.swing.JButton();
        back_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BACKGROUND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CITY");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 240, 91, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("AGE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 100, 45));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("USER NAME");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 110, -1));
        getContentPane().add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 260, 39));

        db1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(db1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 260, 34));

        delete_.setBackground(new java.awt.Color(102, 255, 255));
        delete_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete_.setForeground(new java.awt.Color(51, 51, 51));
        delete_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete admin.png"))); // NOI18N
        delete_.setText("Delete");
        delete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_ActionPerformed(evt);
            }
        });
        getContentPane().add(delete_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 460, 130, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DOB");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 66, 40));
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 260, 39));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADDRESS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 190, 91, 40));

        REGISTER_.setBackground(new java.awt.Color(102, 255, 255));
        REGISTER_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        REGISTER_.setForeground(new java.awt.Color(51, 51, 51));
        REGISTER_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-administrator-30.png"))); // NOI18N
        REGISTER_.setText("REGISTER");
        REGISTER_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTER_ActionPerformed(evt);
            }
        });
        getContentPane().add(REGISTER_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NAME");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 58, 40));

        User_nm_chk.setBackground(new java.awt.Color(204, 255, 204));
        User_nm_chk.setForeground(new java.awt.Color(204, 204, 255));
        User_nm_chk.setText("User Name checking");
        getContentPane().add(User_nm_chk, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 230, 20));

        u_nm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                u_nmKeyReleased(evt);
            }
        });
        getContentPane().add(u_nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 240, 40));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("STATE");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 84, 40));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("EMAIL");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 70, 30));
        getContentPane().add(a_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 240, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PINCODE");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 360, 91, 40));

        p_code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_codeKeyReleased(evt);
            }
        });
        getContentPane().add(p_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 360, 260, 39));

        id_label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        id_label.setForeground(new java.awt.Color(255, 255, 255));
        id_label.setText("ADMIN ID");
        getContentPane().add(id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 94, -1));

        Type.add(admin_radio);
        admin_radio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        admin_radio.setText("Admin");
        admin_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_radioActionPerformed(evt);
            }
        });
        getContentPane().add(admin_radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        Type.add(User_radio);
        User_radio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        User_radio.setText("User");
        User_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_radioActionPerformed(evt);
            }
        });
        getContentPane().add(User_radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel2.setText("Type");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 60, 30));

        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passKeyReleased(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 241, 40));

        p_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_noActionPerformed(evt);
            }
        });
        p_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_noKeyReleased(evt);
            }
        });
        getContentPane().add(p_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 260, 39));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PHONE NO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 130, 45));
        getContentPane().add(addr, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 190, 260, 39));

        city1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                city1KeyReleased(evt);
            }
        });
        getContentPane().add(city1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, 260, 39));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("City");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 280, 240, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("State");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 340, 240, -1));

        st.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stKeyReleased(evt);
            }
        });
        getContentPane().add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 300, 260, 39));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Pincode ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 400, 240, -1));

        Table1.setAutoCreateRowSorter(true);
        Table1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Table1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Table1.setForeground(new java.awt.Color(255, 255, 255));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin ID", "Admin Name", "Password", "Name", "Email", "Date of Birth", "Age", "Phone Number", "Address", "City", "State", "pincode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.setShowGrid(false);
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 1420, 220));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Password check");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 220, -1));

        update_1.setBackground(new java.awt.Color(102, 255, 255));
        update_1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update_1.setForeground(new java.awt.Color(51, 51, 51));
        update_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update admin user.png"))); // NOI18N
        update_1.setText("Update");
        update_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_1ActionPerformed(evt);
            }
        });
        getContentPane().add(update_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, 130, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter any data");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 140, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Phone number check");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 240, -1));

        n1.setBorder(null);
        getContentPane().add(n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 120, 240, 30));

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText(" PASSWORD");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 130, 30));

        eml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emlActionPerformed(evt);
            }
        });
        eml.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emlKeyReleased(evt);
            }
        });
        getContentPane().add(eml, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 240, 40));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("OTP");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 70, 30));
        getContentPane().add(otp_f, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 240, 40));

        get_otp_.setText("GET OTP");
        get_otp_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_otp_ActionPerformed(evt);
            }
        });
        getContentPane().add(get_otp_, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, -1));

        verifyb_.setText("Verify");
        getContentPane().add(verifyb_, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        Heading_Panel.setBackground(new java.awt.Color(0, 0, 204));
        Heading_Panel.setForeground(new java.awt.Color(0, 0, 204));
        Heading_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading.setBackground(new java.awt.Color(0, 0, 0, 90));
        heading.setFont(new java.awt.Font("Rockwell", 1, 28)); // NOI18N
        heading.setForeground(new java.awt.Color(204, 255, 255));
        heading.setText("ADMIN AND USER TABLE");
        Heading_Panel.add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, 40));

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
        Heading_Panel.add(Log_out_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 130, -1));

        back_.setBackground(new java.awt.Color(102, 255, 255));
        back_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/65.png"))); // NOI18N
        back_.setText("BACK");
        back_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ActionPerformed(evt);
            }
        });
        Heading_Panel.add(back_, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        getContentPane().add(Heading_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1450, 60));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0, 40));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1450, 660));

        BACKGROUND.setBackground(new java.awt.Color(102, 255, 255));
        BACKGROUND.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BACKGROUND.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Train/balazs-busznyak-El5zuQAtfeo-unsplash (1).jpg"))); // NOI18N
        getContentPane().add(BACKGROUND, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -70, 1490, 850));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void u_nmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u_nmKeyReleased
       
        
    if(u_nm.getText().length() ==0)
    {
        User_nm_chk.setText(null);
    }   
    else    
    {    
        if(admin_radio.isSelected())
        {
            if(user_nm1.equals(u_nm.getText())) //If admin name is same as its own
            {
                        User_nm_chk.setText(null);
            }
            else
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
                          //JOptionPane.showMessageDialog(rootPane, "User Name already exist ");
                            User_nm_chk.setText("User name not Available");
                            User_nm_chk.setForeground(Color.red);
                            f=1;
                            break;
                        }
                        if(f==0)
                        {
                            obsound.play_audio();
                            User_nm_chk.setText("User name Available");
                            User_nm_chk.setForeground(Color.green);
                        }
                    }
                    catch(SQLException e)
                    {
                        obsound.play_audio();
                        System.out.println(e);
                    }
            }
        }

        else if(User_radio.isSelected())
        {
            
            if(user_nm1.equals(u_nm.getText())) //If admin name is same as its own
            {
                        User_nm_chk.setText(null);
            }
            else
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
                if(unm.equals(rs.getString("user_name")) )
                {
 //                 JOptionPane.showMessageDialog(rootPane, "User Name already exist ");
                    User_nm_chk.setText("User name not Available");
                    User_nm_chk.setForeground(Color.red);
                    f=1;
                    break;
                }
                if(f==0)
                {
                    if(user_nm1.equals(u_nm.getText()))
                    {
                        User_nm_chk.setText(null);
                    }
                    else
                    {
                    User_nm_chk.setText("User name Available");
                    User_nm_chk.setForeground(Color.green);
                    }
                }
            }
            catch(SQLException e)
            {
                obsound.play_audio();
                System.out.println(e);
            }
        }
        }
        else
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Select login type");
            u_nm.setText("");
        }
    }//GEN-LAST:event_u_nmKeyReleased
    }
  
    public void clear1() //clear JTextFields 
    {
        a_id.setText(null);
        u_nm.setText("");
        pass.setText("");
        n.setText("");
        db1.setDate(null);
        a.setText("");
        p_no.setText("");
        addr.setText("");
        city1.setText("");
        st.setText("");
        p_code.setText("");
        
        eml.setText("");
        otp_f.setText(null);
    }
    
    private void REGISTER_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTER_ActionPerformed
                this.hide();
                Sign_Up ar = new Sign_Up();
                ar.show();
    }//GEN-LAST:event_REGISTER_ActionPerformed

    private void delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_ActionPerformed
         
        
    if(admin_radio.isSelected())
      {
            
            try
                {
                    int rno=Table1.getSelectedRow();
                    System.out.print(rno);
                    String ad_id;
                    ad_id=a_id.getText();
                    sql="delete from admin where admin_id='"+ad_id+"'";
                    pst=this.con.prepareStatement(sql);
                    int x=pst.executeUpdate();
                    
                    if(x==1)
                        {
                            JOptionPane.showMessageDialog(rootPane, "Deleted Successfully!!!");
                            DefaultTableModel ob=(DefaultTableModel)Table1.getModel();
                            ob.removeRow(rno);
                            clear1(); ///clear JTextFields After update
                        }
                    else
                    {
                        obsound.play_audio();
                        JOptionPane.showMessageDialog(rootPane, "Unale to delete");
                        
                    }
                            
             
                
                pst.close();
             
         }
            
         catch(Exception e)
         {
             obsound.play_audio();
             JOptionPane.showMessageDialog(rootPane, "Deletion problem !!!");
             System.out.println("Deletion problem: "+e);
         }
      }
        
    
        else if(User_radio.isSelected())
        {
                    try
                    {
                        int rno=Table1.getSelectedRow();
                        System.out.print(rno);
           
                        String ad_id;
                        ad_id=a_id.getText();
                        sql="delete from user where user_id='"+ad_id+"'";
                        pst=this.con.prepareStatement(sql);
                        int x=pst.executeUpdate();
                             if(x==1)
                        {
                            JOptionPane.showMessageDialog(rootPane, "Deleted Successfully!!!");
                            DefaultTableModel ob=(DefaultTableModel)Table1.getModel();
                            ob.removeRow(rno);
                            clear1();//For clear JTextFields
                        }
                            else
                             {  obsound.play_audio();
                                JOptionPane.showMessageDialog(rootPane, "Unable to delete!!!");
                             }
                    }
                        catch(Exception e)
                         {
                             obsound.play_audio();
                             System.out.println(e);
                            JOptionPane.showMessageDialog(rootPane,"Connection Problem");
                         }
                }
                
        
      else
    {
        JOptionPane.showMessageDialog(rootPane,"Choose the type first");
    }
          
    }//GEN-LAST:event_delete_ActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
                Table1.setSelectionForeground(Color.cyan);
                
                en();
                int rno=Table1.getSelectedRow();
                TableModel ob=(TableModel)Table1.getModel();
                
                a_id.setText(ob.getValueAt(rno, 0).toString()); 
                a_id.enable(false);
                
                u_nm.setText(ob.getValueAt(rno, 1).toString());
                pass.setText(ob.getValueAt(rno, 2).toString());
                n.setText(ob.getValueAt(rno, 3).toString());
                
                eml.setText(ob.getValueAt(rno, 4).toString());
                em_chk = eml.getText();
                String d1 = ob.getValueAt(rno, 5).toString();
                SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy");
                
                try{
                    java.util.Date dob1=obj.parse(d1);
                    db1.setDate(dob1);
                }
                catch (ParseException e){
                    obsound.play_audio();
                    JOptionPane.showMessageDialog(rootPane, "Date format error!!!");
                }
                
                
                a.setText(ob.getValueAt(rno, 6).toString());
                a.enable(false);
                
                p_no.setText(ob.getValueAt(rno, 7).toString());
                addr.setText(ob.getValueAt(rno, 8).toString());
                city1.setText(ob.getValueAt(rno, 9).toString());
                st.setText(ob.getValueAt(rno, 10).toString());
                p_code.setText(ob.getValueAt(rno, 11).toString());
                
                user_nm1=u_nm.getText();
             
    }//GEN-LAST:event_Table1MouseClicked

    private void p_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_noActionPerformed

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

    private void admin_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_radioActionPerformed

        clear1();
        show_admin();
        id_label.setText("Admin ID");
        heading.setText("ADMIN TABLE");
    }//GEN-LAST:event_admin_radioActionPerformed

    private void User_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_User_radioActionPerformed

        clear1();
        show_user();
        id_label.setText("User ID");
        heading.setText("USER TABLE");
    }//GEN-LAST:event_User_radioActionPerformed

    private void update_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_1ActionPerformed
       
        if(admin_radio.isSelected())
        {
                 try
                    {                       
                        String unm,pwd;
                        
                        
                        id=a_id.getText();
                        unm=u_nm.getText();
                        pwd=pass.getText();
                        
                        nm = n.getText();
                        
                        String aeml;
                        aeml = eml.getText();
                        java.util.Date dob=db1.getDate();
                        java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
                        
                        ph = Long.parseLong(p_no.getText());
                        
                        add = addr.getText();
                        cty = city1.getText();
                        ste = st.getText();
                        pc = Integer.parseInt(p_code.getText());
                        
                        
                        sql="update admin set admin_name='"+unm+"',password='"+pwd+"',name='"+nm+"',Email='"+aeml+"',DOB='"+sqlDate+"',ph_number='"+ph+"',address='"+add+"',city='"+cty+"',sate='"+ste+"',pincode='"+pc+"' where admin_id='"+id+"'";
                        pst=this.con.prepareStatement(sql);
                        int x=pst.executeUpdate();
                        if(x==1)
                        {
                            JOptionPane.showMessageDialog(rootPane, "Updated Successful!!!");
               
                            clear1();
                                                       
                            sql="update Admin set age = round((current_date()-DOB)/10000)";
                            pst=this.con.prepareStatement(sql);
                            pst.executeUpdate();
                            
                            get_otp_.hide();
                            verifyb_.hide();
                            otp_f.hide();
                            jLabel23.hide();
                            show_admin();
                        }
                        else
                        {
                            obsound.play_audio();
                            JOptionPane.showMessageDialog(rootPane, "Updated unsuccessful!!!");
                        }
                    }
                catch(Exception e)
                {
                obsound.play_audio();
                JOptionPane.showMessageDialog(rootPane, "Updated problem");
                System.out.println("Updated Problem: "+e);
                }
                            
            }
        
        
        
        else if(User_radio.isSelected())
        {
            try
                {
                    String unm,pwd;

                    id=a_id.getText();
                    unm=u_nm.getText();
                    pwd=pass.getText();

                    nm = n.getText();
                    String aeml = eml.getText();
                    
                    java.util.Date dob=db1.getDate();
                    java.sql.Date sqlDate = new java.sql.Date(dob.getDate());

                    ph = Long.parseLong(p_no.getText());

                    add = addr.getText();
                    cty = city1.getText();
                    ste = st.getText();
                    pc = Integer.parseInt(p_code.getText());

                    sql="update user set user_name='"+unm+"',user_password='"+pwd+"',name='"+nm+"',Email='"+aeml+"',DOB='"+sqlDate+"',ph_no='"+ph+"',address='"+add+"',city='"+cty+"',state='"+ste+"',pin_code='"+pc+"' where user_id='"+id+"'";
                    pst=this.con.prepareStatement(sql);
                    int x=pst.executeUpdate();
                    
                    if(x==1)
                        {
                            JOptionPane.showMessageDialog(rootPane, "Updated Successful!!!");
                            
                            sql="update user set age = round((current_date()-DOB)/10000)";
                            pst=this.con.prepareStatement(sql);
                            pst.executeUpdate();
                            
                            a_id.setText("");
                            u_nm.setText("");
                            pass.setText("");
                            n.setText("");
                            db1.setDate(null);
                            a.setText("");
                            p_no.setText("");
                            addr.setText("");
                            city1.setText("");
                            st.setText("");
                            p_code.setText("");                                                        
                            
                            show_user();
                        }
            
                        else
                        {
                            obsound.play_audio();
                            JOptionPane.showMessageDialog(rootPane, "Unable to update !!");
                       
                        }
                        

                }
                catch(Exception e)
                    {
                        obsound.play_audio();
                        System.out.println(e);
                        JOptionPane.showMessageDialog(rootPane,"Connection Problem");
                    }
                }
        
        
       else//if type button unselected
      {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Error!! Select type first");
            System.out.println("Error!! Select type first");
      }
    }//GEN-LAST:event_update_1ActionPerformed

    private void emlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emlActionPerformed

    private void emlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emlKeyReleased
        // TODO add your handling code here:
        
        if(eml.getText().equals(em_chk))
        {
            System.out.println("Email is same, no verification required");
            get_otp_.hide();
            verifyb_.hide();
            otp_f.hide();
            jLabel23.hide();
        }
        else
        {
            System.out.println("Email is changed, verification required");
            get_otp_.show();
            verifyb_.show();
            otp_f.show();
            jLabel23.show();
        }
    }//GEN-LAST:event_emlKeyReleased

    private void get_otp_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_otp_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_get_otp_ActionPerformed

    private void back_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ActionPerformed
        this.dispose();
        obval.setVisible(true);
    }//GEN-LAST:event_back_ActionPerformed

    private void passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyReleased
        
        String r = pass.getText();
        int len = r.length();
        char c = evt.getKeyChar();
        
        if(len>=6)
        {
            jLabel16.setText(null);
        }
        else
        {
            jLabel16.setText("password should 6 character or digit long");
        }
    }//GEN-LAST:event_passKeyReleased

    private void p_noKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_noKeyReleased
        
        String r = p_no.getText();
        int len = r.length();
        char c = evt.getKeyChar();
        
        if(c>='0' && c<='9' && len==10)
        {
            jLabel3.setText(null);
        }
        else
        {
            jLabel3.setText("Not valid phone number!!");
        }
    }//GEN-LAST:event_p_noKeyReleased

    private void city1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_city1KeyReleased
        
        String r = city1.getText();
        
        char c = evt.getKeyChar();
        
        if( (c>='A' && c<='Z' ) || (c>='a' && c<='z'))
        {
            jLabel15.setText(null);
        }
        else
        {
            jLabel15.setText("not a valid state !! ");
        }
    }//GEN-LAST:event_city1KeyReleased

    private void stKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stKeyReleased
        String r = st.getText();        
        char c = evt.getKeyChar();
        
        if( (c>='A' && c<='Z' ) || (c>='a' && c<='z'))
        {
            jLabel14.setText(null);
        }
        else
        {
            jLabel14.setText("not a valid state !! ");
        }
    }//GEN-LAST:event_stKeyReleased

    private void p_codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_codeKeyReleased
        
        String r = p_code.getText();
        int len = r.length();
        char c = evt.getKeyChar();
        
        if(c>='0' && c<='9')
        {
            jLabel4.setText(null);
        }
        else
        {
            jLabel4.setText("Not valid pincode!!");
        }
    }//GEN-LAST:event_p_codeKeyReleased

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
            java.util.logging.Logger.getLogger(Admin_User_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_User_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_User_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_User_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_User_Table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKGROUND;
    private javax.swing.JPanel Heading_Panel;
    private javax.swing.JButton Log_out_;
    private javax.swing.JButton REGISTER_;
    private javax.swing.JTable Table1;
    private javax.swing.ButtonGroup Type;
    private javax.swing.JLabel User_nm_chk;
    private javax.swing.JRadioButton User_radio;
    private javax.swing.JTextField a;
    private javax.swing.JTextField a_id;
    private javax.swing.JTextField addr;
    private javax.swing.JRadioButton admin_radio;
    private javax.swing.JButton back_;
    private javax.swing.JTextField city1;
    private com.toedter.calendar.JDateChooser db1;
    private javax.swing.JButton delete_;
    private javax.swing.JTextField eml;
    private javax.swing.JButton get_otp_;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField n;
    private javax.swing.JTextField n1;
    private javax.swing.JTextField otp_f;
    private javax.swing.JTextField p_code;
    private javax.swing.JTextField p_no;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField st;
    private javax.swing.JTextField u_nm;
    private javax.swing.JButton update_1;
    private javax.swing.JButton verifyb_;
    // End of variables declaration//GEN-END:variables
}
