package railway_Reservation_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Train_Table extends javax.swing.JFrame {

int general_seat=0,sleeper_seat=0,ac1_seat=0;
Admin_Home obval; //class object variable
audioplayer obsound = new audioplayer();

 DatabaseConnection db_ob = new DatabaseConnection();
 Connection con=db_ob.connect_db();
 Statement stmt;
 ResultSet rs;
 PreparedStatement pst;

    public Train_Table() {
        
        initComponents();
        
        show_train1();
        
        audioplayer ob = new audioplayer();
        obsound=ob;
        
        gen_seat_avl.enable(false);
        SLE_seat_avl.enable(false);
        AC_seat_avl.enable(false);
        
        Train_TB.setRowHeight(20);
        gen_seat_value.setText(null);
        sleep_seat_value.setText(null);
        ac_seat_value.setText(null);
        
        Update_.hide();
        Delete_.hide();
        
        //Table transparent code
        ((DefaultTableCellRenderer) Train_TB.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        Train_TB.setOpaque(false);
        ((DefaultTableCellRenderer) Train_TB.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
//        Train_TB.setRowHeight(35);
                        
        

        timePicker1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Time selected"+timePicker1.getSelectedTime());
                D_time.setText(timePicker1.getSelectedTime());
            }
        });
        

        timePicker3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Time selected"+timePicker1.getSelectedTime());
                A_time.setText(timePicker1.getSelectedTime());
            }
        });
        
        
    }
    
    public void backdata(Admin_Home obval1)
    {
        obval = obval1;       
    }
    
    protected void show_train1()
    {
        try
        {
            DefaultTableModel ob1=(DefaultTableModel)Train_TB.getModel();
            ob1.setRowCount(0);
            Train_TB.setRowHeight(15);
            
            int gs,ss,acs,tas,ts,dis,gen_fr,sl_fr,ac_fr;
            String tn,trn,soc,des,sql;
            Date depd,ard;
            Time dept, art;
            sql="select * from train";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                gs=Integer.parseInt(rs.getString("GEN_SEAT_AV"));
                ss=Integer.parseInt(rs.getString("SLE_SEAT_AV"));
                acs=Integer.parseInt(rs.getString("AC_SEAT_AV"));
                tas=Integer.parseInt(rs.getString("TOTAL_AVV_SEAT"));
                ts=Integer.parseInt(rs.getString("TOTAL_SEAT"));
                dis=Integer.parseInt(rs.getString("distance"));
                
                gen_fr=Integer.parseInt(rs.getString("gen_fare"));
                sl_fr=Integer.parseInt(rs.getString("SLE_FARE"));
                ac_fr=Integer.parseInt(rs.getString("AC_FARE"));
                
                tn=rs.getString("TRAIN_NO");
                trn=rs.getString("TRAIN_NAME");

                soc=rs.getString("SRCE");
                depd=rs.getDate("DEP_DATE");
                SimpleDateFormat obj1 = new SimpleDateFormat("dd-MM-yyyy");                
                String depd1 = obj1.format(depd);               
                String dept1 = rs.getString("DEP_TIME");

                des=rs.getString("DEST");
                ard=rs.getDate("ARV_DATE");
                String ard1 = obj1.format(ard);                
                String art1 = rs.getString("ARV_TIME");



                
                String x[]={tn,trn,soc,depd1,dept1,des,ard1,art1,Integer.toString(gs),Integer.toString(gen_fr),Integer.toString(ss),Integer.toString(sl_fr),Integer.toString(acs),Integer.toString(ac_fr),Integer.toString(dis)};
                DefaultTableModel ob=(DefaultTableModel)Train_TB.getModel();
                ob.addRow(x);
                
            }
            stmt.close();
            rs.close();
        }
        catch(Exception e)
        {
            audioplayer ob = new audioplayer();
            ob.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Connection Problem");
            System.out.print(e);
        }
    }
    
    public void  cleartable()
    {
                                Train_no.setText(null);
                               Train_name.setText("");
                               Distance.setText("");
                               Source.setText("");
                               D_date.setDate(null);
                               D_time.setText("");
                               Destination.setText("");
                               A_date.setDate(null);
                               A_time.setText("");
                               Gen_seat_min.setText("");
                               Sleep_seat_min.setText("");

                               AC_Seat_min.setText("");
                               G_FARE.setText(null);
                               S_fare.setText(null);
                               A_Fare.setText(null);///clear JTextFields After update
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timePicker1 = new com.raven.swing.TimePicker();
        timePicker3 = new com.raven.swing.TimePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        Train_TB = new javax.swing.JTable();
        Train_no = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Train_name = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        Source = new javax.swing.JTextField();
        D_time = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Destination = new javax.swing.JTextField();
        A_time = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Gen_seat_min = new javax.swing.JTextField();
        Sleep_seat_min = new javax.swing.JTextField();
        AC_Seat_min = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        A_Fare = new javax.swing.JTextField();
        Distance = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        A_date = new com.toedter.calendar.JDateChooser();
        D_date = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        Update_ = new javax.swing.JButton();
        Add_ = new javax.swing.JButton();
        Delete_ = new javax.swing.JButton();
        gen_seat_avl = new javax.swing.JTextField();
        SLE_seat_avl = new javax.swing.JTextField();
        AC_seat_avl = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        S_fare = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        G_FARE = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Gen_seat_max = new javax.swing.JTextField();
        Sleep_seat_max = new javax.swing.JTextField();
        AC_Seat_max = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ac_seat_value = new javax.swing.JLabel();
        gen_seat_value = new javax.swing.JLabel();
        CHECK_SEAT = new javax.swing.JButton();
        sleep_seat_value = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Train_TB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Train_TB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Train_TB.setForeground(new java.awt.Color(255, 255, 255));
        Train_TB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TRAIN NO", "TRAIN NAME", "SOURCE", "DEPERTURE DATE", "DEPURTURE TIME", "DESTINATION", "ARIVAL DATE", "ARIVAL TIME", "GEN. SEAT AVL", "GEN. FARE", "SLE. SEAT  AVL", "SLE. FARE", "AC SEAT  AVL", "AC FARE", "DESTAINCE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Train_TB.setShowVerticalLines(true);
        Train_TB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Train_TBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Train_TB);
        if (Train_TB.getColumnModel().getColumnCount() > 0) {
            Train_TB.getColumnModel().getColumn(13).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 1580, 230));
        getContentPane().add(Train_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 180, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Train Name :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, 30));
        getContentPane().add(Train_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, 30));

        jButton3.setText("Set arrival time");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 140, -1));
        getContentPane().add(Source, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 150, 30));

        D_time.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                D_timeFocusGained(evt);
            }
        });
        D_time.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                D_timeMouseClicked(evt);
            }
        });
        D_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_timeActionPerformed(evt);
            }
        });
        getContentPane().add(D_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 150, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Depurture Time :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 130, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Depurture Date :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 130, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Source :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 70, 30));
        getContentPane().add(Destination, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 140, 30));

        A_time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_timeActionPerformed(evt);
            }
        });
        getContentPane().add(A_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 140, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Arival Time :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Arival Date :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, -1, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Destination :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 100, 30));

        jButton2.setText("Set depurture Time");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 150, -1));

        Gen_seat_min.setText("0");
        getContentPane().add(Gen_seat_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 60, 30));

        Sleep_seat_min.setText("0");
        getContentPane().add(Sleep_seat_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 60, 30));

        AC_Seat_min.setText("0");
        getContentPane().add(AC_Seat_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 60, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("AC Seat :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 80, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sleeper Seat :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 100, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("General Seat  :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 110, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fare :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 220, -1, 30));

        A_Fare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_FareActionPerformed(evt);
            }
        });
        getContentPane().add(A_Fare, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 220, 100, 30));
        getContentPane().add(Distance, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 70, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Distance :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 90, 30));
        getContentPane().add(A_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 140, 30));
        getContentPane().add(D_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 150, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Train No. :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 90, 30));

        Update_.setBackground(new java.awt.Color(102, 255, 255));
        Update_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Update_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-49.png"))); // NOI18N
        Update_.setText("UPDATE");
        Update_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ActionPerformed(evt);
            }
        });
        getContentPane().add(Update_, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 120, 40));

        Add_.setBackground(new java.awt.Color(102, 255, 255));
        Add_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Add_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ad.png"))); // NOI18N
        Add_.setText("ADD");
        Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ActionPerformed(evt);
            }
        });
        getContentPane().add(Add_, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 120, 40));

        Delete_.setBackground(new java.awt.Color(102, 255, 255));
        Delete_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Delete_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-50.png"))); // NOI18N
        Delete_.setText("DELETE");
        Delete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ActionPerformed(evt);
            }
        });
        getContentPane().add(Delete_, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, 120, 40));
        getContentPane().add(gen_seat_avl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 120, 70, 30));
        getContentPane().add(SLE_seat_avl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 170, 70, 30));
        getContentPane().add(AC_seat_avl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 220, 70, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("AC Seat available :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 220, 130, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Sleeper Seat available :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 170, 170, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("General Seat available :");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 120, 170, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fare :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 170, -1, 30));
        getContentPane().add(S_fare, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 170, 100, 30));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Fare :");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 120, -1, 30));
        getContentPane().add(G_FARE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 120, 100, 30));

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setBackground(new java.awt.Color(102, 255, 255));
        Logout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log out.png"))); // NOI18N
        Logout.setText("LOG OUT");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 10, 150, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("TRAIN TABLE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 230, 40));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/65.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1600, 60));

        Gen_seat_max.setText("0");
        getContentPane().add(Gen_seat_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 120, 60, 30));

        Sleep_seat_max.setText("0");
        getContentPane().add(Sleep_seat_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 60, 30));

        AC_Seat_max.setText("0");
        getContentPane().add(AC_Seat_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 220, 60, 30));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("    MAX");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 100, 60, 20));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("    MIN");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, 60, 20));

        ac_seat_value.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ac_seat_value.setForeground(new java.awt.Color(255, 0, 0));
        ac_seat_value.setText("Total AC seat : x");
        getContentPane().add(ac_seat_value, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, 110, 20));

        gen_seat_value.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        gen_seat_value.setForeground(new java.awt.Color(255, 0, 0));
        gen_seat_value.setText("Total general seat : x");
        getContentPane().add(gen_seat_value, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 150, 130, 20));

        CHECK_SEAT.setText("CHECK");
        CHECK_SEAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHECK_SEATActionPerformed(evt);
            }
        });
        getContentPane().add(CHECK_SEAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 280, 90, -1));

        sleep_seat_value.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sleep_seat_value.setForeground(new java.awt.Color(255, 0, 0));
        sleep_seat_value.setText("Total sleeper seat : x");
        getContentPane().add(sleep_seat_value, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 130, 20));

        background2.setBackground(new java.awt.Color(51, 51, 51, 70));
        background2.setOpaque(true);
        getContentPane().add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1600, 580));

        Background.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/aaaaaaaa.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
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
    }//GEN-LAST:event_LogoutActionPerformed

    private void A_FareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_FareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A_FareActionPerformed

    private void Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ActionPerformed
         try
         {
           int gs,ss,acs,gs1,ss1,acs1,dis,fr,fr1,fr2;          
            String tn,trn,soc,des,sql,dept, art;
            
            gs=Integer.parseInt(Gen_seat_min.getText());
            gs1=Integer.parseInt(Gen_seat_max.getText());
            
            ss=Integer.parseInt(Sleep_seat_min.getText());
            ss1=Integer.parseInt(Sleep_seat_max.getText());
            
            acs=Integer.parseInt(AC_Seat_min.getText());
            acs1=Integer.parseInt(AC_Seat_max.getText());
            
            dis=Integer.parseInt(Distance.getText());
            fr=Integer.parseInt(G_FARE.getText());
            fr1=Integer.parseInt(S_fare.getText());
            fr2=Integer.parseInt(A_Fare.getText());
            
            tn=Train_no.getText();
            trn=Train_name.getText();
            des=Destination.getText();
            soc=Source.getText();
            dept=D_time.getText();
            art=A_time.getText();
            
            java.util.Date dob=D_date.getDate();
            java.sql.Date sqlDate1 = new java.sql.Date(dob.getTime());
            java.util.Date aod=A_date.getDate();
            java.sql.Date sqldate2 = new java.sql.Date(aod.getTime());
            
            int gst=seatcount(Integer.parseInt(Gen_seat_max.getText()),Integer.parseInt(Gen_seat_min.getText()));
            int sst=seatcount(Integer.parseInt(Sleep_seat_max.getText()),Integer.parseInt(Sleep_seat_min.getText()));
            int acst=seatcount(Integer.parseInt(AC_Seat_max.getText()),Integer.parseInt(AC_Seat_min.getText()));
            
        sql="insert into train values('"+tn+"','"+trn+"','"+soc+"','"+sqlDate1+"','"+dept+"','"+des+"','"+sqldate2+"','"+art+"','"+gst+"','"+gst+"','"+fr+"','"+sst+"','"+sst+"','"+fr1+"','"+acst+"','"+acst+"','"+fr2+"','"+(gst+sst+acst)+"','"+(gst+sst+acst)+"','"+dis+"')";
        pst=this.con.prepareStatement(sql);
        int x=pst.executeUpdate();
        
        sql="insert into seat_data values('"+tn+"','"+trn+"','"+gs+"','"+gs+"','"+gs1+"','"+ss+"','"+ss+"','"+ss1+"','"+acs+"','"+acs+"','"+acs1+"')";        
        pst=this.con.prepareStatement(sql);
        int x2=pst.executeUpdate();
        
            if(x==1 && x2==1)
            {
                JOptionPane.showMessageDialog(rootPane, "Insert Successful!!!");
                show_train1();
               cleartable();
            }
            
            else
            {
                obsound.play_audio();
                JOptionPane.showMessageDialog(rootPane, "Insert UnSuccessful!!!");
            }
                
        }
        catch(Exception e)
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Connection problem!!!");
            System.out.print(e);
        }                                      
    }//GEN-LAST:event_Add_ActionPerformed

    private void D_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_timeActionPerformed
        
    }//GEN-LAST:event_D_timeActionPerformed
    
    private int seatcount(int e, int s)
    {
        if(s==0 && e==0)
        {
            return 0;
        }
 
        int cnt=0;
        for(int i=s;i<=e;i=i+1)
        {
            cnt=cnt+1;
        }
        return cnt;
    }
    
    private void Update_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ActionPerformed
    
        int rno=Train_TB.getSelectedRow();
        TableModel ob=(TableModel)Train_TB.getModel();
        try
        {
        
            String sql="select * from train where TRAIN_NO like '"+ob.getValueAt(rno, 0).toString()+"'";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            rs.next();
            int gs,ss,acs,dis,fr,fr1,fr2,gsb,ssb,asb;          
            String tn,trn,soc,des,dept, art;
            gs=seatcount(Integer.parseInt(Gen_seat_max.getText()),Integer.parseInt(Gen_seat_min.getText()));
            ss=seatcount(Integer.parseInt(Sleep_seat_max.getText()),Integer.parseInt(Sleep_seat_min.getText()));
            acs=seatcount(Integer.parseInt(AC_Seat_max.getText()),Integer.parseInt(AC_Seat_min.getText()));
         
            general_seat= Integer.parseInt(rs.getString("GEN_SEAT_AV"))+(gs-Integer.parseInt(rs.getString("GEL_SEAT")));
            sleeper_seat= Integer.parseInt(rs.getString("SLE_SEAT_AV"))+(ss-sleeper_seat);
            ac1_seat=Integer.parseInt(rs.getString("AC_SEAT_AV"))+(acs-ac1_seat);
            
            dis=Integer.parseInt(Distance.getText());
            
            fr=Integer.parseInt(G_FARE.getText());
            fr1=Integer.parseInt(S_fare.getText());
            fr2=Integer.parseInt(A_Fare.getText());
   
            tn=Train_no.getText();
            trn=Train_name.getText();
            des=Destination.getText();
            soc=Source.getText();
            
            dept=D_time.getText();
            art=A_time.getText();
            
            java.util.Date dob=D_date.getDate();
            java.sql.Date sqlDate1 = new java.sql.Date(dob.getTime());
            java.util.Date aod=A_date.getDate();
            java.sql.Date sqldate2 = new java.sql.Date(aod.getTime());
                                   
             String S="update train set TRAIN_NO='"+tn+"',TRAIN_NAME='"+trn+"',SRCE='"+soc+"',DEP_DATE='"+sqlDate1+"',DEP_TIME='"+dept+"',DEST='"+des+"',ARV_DATE='"+sqldate2+"',ARV_TIME='"+art+"',GEL_SEAT='"+gs+"',GEN_SEAT_AV='"+ general_seat+"',gen_fare='"+fr+"',SLE_SEAT='"+ss+"',SLE_SEAT_AV='"+sleeper_seat+"',SLE_FARE='"+fr1+"',AC_SEAT='"+acs+"',AC_SEAT_AV='"+ac1_seat+"',AC_FARE='"+fr2+"',TOTAL_AVV_SEAT='"+0+"',TOTAL_SEAT='"+0+"',Distance='"+dis+"' where TRAIN_NO='"+tn+"'";
             pst=this.con.prepareStatement(S);
             int x=pst.executeUpdate();                          
             
             S="update seat_data set Train_no='"+tn+"',Train_Name='"+trn+"',Gen_seat_start='"+Integer.parseInt(Gen_seat_min.getText())+"',Gen_seat_end='"+Integer.parseInt(Gen_seat_max.getText())+"',Sleep_seat_start='"+Integer.parseInt(Sleep_seat_min.getText())+"',Sleep_seat_end='"+Integer.parseInt(Sleep_seat_max.getText())+"',AC_seat_start ='"+Integer.parseInt(AC_Seat_min.getText())+"',AC_seat_end='"+Integer.parseInt(AC_Seat_max.getText())+"'";
             pst=this.con.prepareStatement(S);
             int x2=pst.executeUpdate();
                        
            if(x==1 && x2==1)
            {
            JOptionPane.showMessageDialog(rootPane, "Updated Successful!!!");               
            show_train1();
            cleartable();
           
            }
            else
            {
                obsound.play_audio();
                JOptionPane.showMessageDialog(rootPane, "Updated UnSuccessful!!!");
            }
                     
        }
        catch(Exception e)
                   {
                       obsound.play_audio();
                       JOptionPane.showMessageDialog(rootPane, "Updated connection problem!!!");
                       System.out.println("Update error"+e);
                       
                   }
    }//GEN-LAST:event_Update_ActionPerformed

    private void Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ActionPerformed
 try
                {
                    int rn=Train_TB.getSelectedRow();
                    System.out.print(rn);
                    String T,sql;
                    T=Train_no.getText();
                    sql="delete from train where TRAIN_NO='"+T+"'";
                    pst=this.con.prepareStatement(sql);
                    int x=pst.executeUpdate();
                    
                    sql="delete from seat_data where Train_no='"+T+"'";
                    pst=this.con.prepareStatement(sql);
                    int x2=pst.executeUpdate();
                    
                    if(x==1 && x2==1)
                        {
                            JOptionPane.showMessageDialog(rootPane, "Deleted Successfully!!!");
                            DefaultTableModel ob=(DefaultTableModel)Train_TB.getModel();
                            ob.removeRow(rn);
                            cleartable();
                        }
                    else
                    {
                        obsound.play_audio();
                        JOptionPane.showMessageDialog(rootPane, "Unable to delete");
                    }
                            
             
                pst.close();
             
         }
         catch(Exception e)
         {
             obsound.play_audio();
             JOptionPane.showMessageDialog(rootPane, "Deletion problem !!!");
             System.out.println("Deletion problem: "+e);
         }
              
    }//GEN-LAST:event_Delete_ActionPerformed

    private void Train_TBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Train_TBMouseClicked
        
        Train_TB.setSelectionForeground(Color.cyan);
        Update_.show();
        Delete_.show();
        int rno=Train_TB.getSelectedRow();
        TableModel ob=(TableModel)Train_TB.getModel();
                
        try{
        
            String sql="select * from seat_data where Train_no like '"+ob.getValueAt(rno, 0).toString()+"'";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            rs.next();
                
                Train_no.setText(ob.getValueAt(rno, 0).toString());
                Train_name.setText(ob.getValueAt(rno, 1).toString());                                 
                Source.setText(ob.getValueAt(rno, 2).toString());
                String d1 = ob.getValueAt(rno, 3).toString();
                SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy");
                
                try{
                    java.util.Date dob1=obj.parse(d1);
                    D_date.setDate(dob1);
                }
                catch (ParseException e){
                    obsound.play_audio();
                    JOptionPane.showMessageDialog(rootPane, "Date format error!!!");
                }
                D_time.setText(ob.getValueAt(rno, 4).toString());
                Destination.setText(ob.getValueAt(rno, 5).toString()); 
                String d2 = ob.getValueAt(rno, 6).toString();
                SimpleDateFormat obj2 = new SimpleDateFormat("dd-MM-yyyy");
                
                try{
                    java.util.Date dob1=obj.parse(d1);
                    A_date.setDate(dob1);
                }
                catch (ParseException e){
                    obsound.play_audio();
                    JOptionPane.showMessageDialog(rootPane, "Date format error!!!");
                }
                A_time.setText(ob.getValueAt(rno, 7).toString()); 
                Gen_seat_min.setText(rs.getString("Gen_seat_start")); 
                Gen_seat_max.setText(rs.getString("Gen_seat_end")); 
                G_FARE.setText(ob.getValueAt(rno, 9).toString()); 
                
                Sleep_seat_min.setText(rs.getString("Sleep_seat_start")); 
                Sleep_seat_max.setText(rs.getString("Sleep_seat_end")); 
                S_fare.setText(ob.getValueAt(rno, 11).toString()); 
                
                AC_Seat_min.setText(rs.getString("AC_seat_start")); 
                AC_Seat_max.setText(rs.getString("AC_seat_end"));
                A_Fare.setText(ob.getValueAt(rno, 13).toString());
                
                Distance.setText(ob.getValueAt(rno, 14).toString()); 
                
                gen_seat_avl.setText(ob.getValueAt(rno, 8).toString());
                SLE_seat_avl.setText(ob.getValueAt(rno, 10).toString());
                AC_seat_avl.setText(ob.getValueAt(rno, 12).toString());
                
                general_seat=Integer.parseInt(ob.getValueAt(rno, 12).toString());
                sleeper_seat=Integer.parseInt(ob.getValueAt(rno, 12).toString());
                ac1_seat=Integer.parseInt(ob.getValueAt(rno, 12).toString());
        }
        catch(Exception e)
        {
            obsound.play_audio();
            System.out.print("Error found!!!!!!!!!!"+e);
        }
    }//GEN-LAST:event_Train_TBMouseClicked

    private void A_timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_A_timeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

                this.dispose();
               obval.setVisible(true);
               
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CHECK_SEATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHECK_SEATActionPerformed

        gen_seat_value.setText("Total general seat : "+seatcount(Integer.parseInt(Gen_seat_max.getText()),Integer.parseInt(Gen_seat_min.getText())));
        sleep_seat_value.setText("Total sleeper seat : "+seatcount(Integer.parseInt(Sleep_seat_max.getText()),Integer.parseInt(Sleep_seat_min.getText())));
        ac_seat_value.setText("Total AC seat : "+seatcount(Integer.parseInt(AC_Seat_max.getText()),Integer.parseInt(AC_Seat_min.getText())));
    }//GEN-LAST:event_CHECK_SEATActionPerformed

    private void D_timeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_D_timeMouseClicked

    }//GEN-LAST:event_D_timeMouseClicked

    private void D_timeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_D_timeFocusGained
        
    }//GEN-LAST:event_D_timeFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        timePicker1.showPopup(this, 100,100);
//        timePicker1.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       timePicker3.showPopup(this, 100,100);
    }//GEN-LAST:event_jButton3ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new Train_Table().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AC_Seat_max;
    private javax.swing.JTextField AC_Seat_min;
    private javax.swing.JTextField AC_seat_avl;
    private javax.swing.JTextField A_Fare;
    private com.toedter.calendar.JDateChooser A_date;
    private javax.swing.JTextField A_time;
    private javax.swing.JButton Add_;
    private javax.swing.JLabel Background;
    private javax.swing.JButton CHECK_SEAT;
    private com.toedter.calendar.JDateChooser D_date;
    private javax.swing.JTextField D_time;
    private javax.swing.JButton Delete_;
    private javax.swing.JTextField Destination;
    private javax.swing.JTextField Distance;
    private javax.swing.JTextField G_FARE;
    private javax.swing.JTextField Gen_seat_max;
    private javax.swing.JTextField Gen_seat_min;
    private javax.swing.JButton Logout;
    private javax.swing.JTextField SLE_seat_avl;
    private javax.swing.JTextField S_fare;
    private javax.swing.JTextField Sleep_seat_max;
    private javax.swing.JTextField Sleep_seat_min;
    private javax.swing.JTextField Source;
    private javax.swing.JTable Train_TB;
    private javax.swing.JTextField Train_name;
    private javax.swing.JTextField Train_no;
    private javax.swing.JButton Update_;
    private javax.swing.JLabel ac_seat_value;
    private javax.swing.JLabel background2;
    private javax.swing.JTextField gen_seat_avl;
    private javax.swing.JLabel gen_seat_value;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sleep_seat_value;
    private com.raven.swing.TimePicker timePicker1;
    private com.raven.swing.TimePicker timePicker3;
    // End of variables declaration//GEN-END:variables
}
