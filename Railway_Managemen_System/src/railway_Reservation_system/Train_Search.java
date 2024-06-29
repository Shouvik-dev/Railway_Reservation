package railway_Reservation_system;

import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.util.Date;
import java.util.Calendar;

public class Train_Search extends javax.swing.JFrame {
    
    int gen_fare,sleep_fare,ac_fare, gen_avl, sleep_avl, AC_avl;
    String Login_nm,logintype="Null";
    
    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
    
    Admin_Home obval;
    User_Home obval2;
    audioplayer obsound = new audioplayer();;
 
    /**
     * Creates new form Train_Search
     */
    public Train_Search() {
        initComponents();
        show_train1();
        Date date=new Date();
        
        Destination_sug.hide();
        Dest_sug.hide();
        source_sug.hide();
        srce_sug.hide();
        
        
        dep_date.setMinSelectableDate(date);               
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();    
        calendar.add(Calendar.DAY_OF_YEAR, 90);
        Date maxDate = calendar.getTime();
        dep_date.setMaxSelectableDate(maxDate);
        
        //Table transparent code
        ((DefaultTableCellRenderer) T4.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        T4.setOpaque(false);
        ((DefaultTableCellRenderer) T4.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
        T4.setRowHeight(25);
        
        
    }

        public void backdata2(Admin_Home obval1, String x, String t)
    {
        logintype=t;
        Login_nm=x;
        obval = obval1;
    }
        
    public void backdata1(User_Home obval1, String x, String t)
    {
        logintype=t;
        Login_nm=x;
        obval2 = obval1;
    }
    
    protected void show_train1()
    {
        try
        {
            DefaultTableModel ob1=(DefaultTableModel)T4.getModel();
            ob1.setRowCount(0);

            int gs,ss,acs,tas,ts,dis,gen_fr,sl_fr,ac_fr;
            String tn,trn,soc,des,sql;
            Date depd,ard;
            
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
                DefaultTableModel ob=(DefaultTableModel)T4.getModel();
                ob.addRow(x);
            }
            
            stmt.close();
            rs.close();
        }
        catch(Exception e)
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Connection Problem in show train");
            System.out.print(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        T4 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ts = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        gen = new javax.swing.JComboBox<>();
        source_sug = new javax.swing.JScrollPane();
        srce_sug = new javax.swing.JList<>();
        srce_ = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Dest = new javax.swing.JLabel();
        where_ = new javax.swing.JTextField();
        Destination_sug = new javax.swing.JScrollPane();
        Dest_sug = new javax.swing.JList<>();
        Search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        back_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        book_ = new javax.swing.JButton();
        dep_date = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Background_ = new javax.swing.JLabel();

        jLabel8.setBackground(new java.awt.Color(0, 0, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/First page/search2.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        T4.setForeground(new java.awt.Color(255, 255, 255));
        T4.setModel(new javax.swing.table.DefaultTableModel(
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
        T4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T4MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(T4);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 1470, 250));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TRAIN NO :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 90, 30));

        tno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnoActionPerformed(evt);
            }
        });
        tno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tnoKeyReleased(evt);
            }
        });
        getContentPane().add(tno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 180, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTER ANY TRAIN DETAILS :");
        jLabel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, 210, 30));

        ts.setBorder(null);
        ts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tsKeyReleased(evt);
            }
        });
        getContentPane().add(ts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 110, 270, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATE :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 70, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CLASS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 70, 30));

        gen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Class", "General", "Sleeper", "AC Chair car", " " }));
        gen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genActionPerformed(evt);
            }
        });
        getContentPane().add(gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 190, 30));

        srce_sug.setBorder(null);
        srce_sug.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Source", "Suggestion", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        srce_sug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                srce_sugMouseClicked(evt);
            }
        });
        source_sug.setViewportView(srce_sug);

        getContentPane().add(source_sug, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 190, 70));

        srce_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srce_ActionPerformed(evt);
            }
        });
        srce_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srce_KeyReleased(evt);
            }
        });
        getContentPane().add(srce_, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 190, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SOURCE :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 80, 30));

        Dest.setBackground(new java.awt.Color(255, 255, 255));
        Dest.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Dest.setForeground(new java.awt.Color(255, 255, 255));
        Dest.setText("DESTINATION :");
        getContentPane().add(Dest, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 120, 30));

        where_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                where_ActionPerformed(evt);
            }
        });
        where_.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                where_KeyReleased(evt);
            }
        });
        getContentPane().add(where_, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 190, 30));

        Dest_sug.setBorder(null);
        Dest_sug.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Source", "Suggestion", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Dest_sug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dest_sugMouseClicked(evt);
            }
        });
        Destination_sug.setViewportView(Dest_sug);

        getContentPane().add(Destination_sug, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 190, 70));

        Search.setBackground(new java.awt.Color(102, 255, 255));
        Search.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/icons8-train-51.png"))); // NOI18N
        Search.setText("SEARCH");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 270, 40));

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_.setBackground(new java.awt.Color(102, 255, 255));
        back_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/65.png"))); // NOI18N
        back_.setText("BACK");
        back_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ActionPerformed(evt);
            }
        });
        jPanel2.add(back_, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("TRAIN SEARCH");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, -1, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1470, 60));

        book_.setBackground(new java.awt.Color(102, 255, 255));
        book_.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        book_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BOOK.png"))); // NOI18N
        book_.setText("BOOK");
        book_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_ActionPerformed(evt);
            }
        });
        getContentPane().add(book_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 690, 120, 40));
        getContentPane().add(dep_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 180, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0, 40));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 1470, 390));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0, 40));
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1470, 250));

        Background_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/First page/search page.jpg"))); // NOI18N
        getContentPane().add(Background_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void where_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_where_ActionPerformed
    }//GEN-LAST:event_where_ActionPerformed

    private void tsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tsKeyReleased
       
        try{
        DefaultTableModel ab=(DefaultTableModel)T4.getModel();
        
        TableRowSorter<DefaultTableModel>obj=new TableRowSorter<>(ab);
        T4.setRowSorter(obj);
        
        obj.setRowFilter(RowFilter.regexFilter(ts.getText()));
        }
       catch(Exception e)
       {
           obsound.play_audio();
         JOptionPane.showMessageDialog(rootPane, "Connection Problem TRAIN SEARCH");
         System.out.println(e);
       }

    }//GEN-LAST:event_tsKeyReleased

    private void tnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnoActionPerformed

    private void genActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genActionPerformed

    private void srce_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srce_KeyReleased
     
        DefaultListModel m = new DefaultListModel();
        if(srce_.getText().length()<=0)
            {
            source_sug.setVisible(false);
            srce_sug.setVisible(false);
            m.clear();

            }
        else
            {
            source_sug.setVisible(true);
            srce_sug.setVisible(true);
            

        try{
            String sql ="select distinct(SRCE) from train where SRCE like '%"+srce_.getText()+"%'";
                        stmt=this.con.createStatement();
                        rs=stmt.executeQuery(sql);
                        String litems;
                    //User Name checking
                    while(rs.next())
                    {
                        litems = rs.getString("SRCE");
                        m.addElement(litems);
                    }
                    srce_sug.setModel(m);

        }
        catch(Exception e1){
            obsound.play_audio();
             JOptionPane.showMessageDialog(rootPane, "source suggetion problem");
                    System.out.println("Suggetion problen: "+e1);
        }
            }
    }//GEN-LAST:event_srce_KeyReleased

    private void srce_sugMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_srce_sugMouseClicked
        // TODO add your handling code here:
        String val = srce_sug.getSelectedValue();
        srce_.setText(val);
        source_sug.setVisible(false);
        srce_sug.setVisible(false);
    }//GEN-LAST:event_srce_sugMouseClicked

    private void where_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_where_KeyReleased
        // TODO add your handling code here:
        
        DefaultListModel m1 = new DefaultListModel();
        if(where_.getText().length()<=0)
        {
             
             m1.clear();
             Dest_sug.setModel(m1);
        Destination_sug.setVisible(false);
        Dest_sug.setVisible(false); 
        }
        else{
                    Destination_sug.setVisible(true);
                    Dest_sug.setVisible(true); 
        }
       
        String text = where_.getText();

        

try{
    String sql ="select distinct(DEST) from train where DEST like '%"+text+"%'";
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);
                String litems;
            //User Name checking
            while(rs.next())
            {
                litems = rs.getString("DEST");
                m1.addElement(litems);
            }

            Dest_sug.setModel(m1);
            
}
catch(Exception e1){
    obsound.play_audio();
     JOptionPane.showMessageDialog(rootPane, "Destination suggetion problem");
            System.out.println("Suggetion problen: "+e1);
}
       
    }//GEN-LAST:event_where_KeyReleased

    private void Dest_sugMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dest_sugMouseClicked
        // TODO add your handling code here:
        String val = Dest_sug.getSelectedValue();
        where_.setText(val);
    
        Destination_sug.setVisible(false);
        Dest_sug.setVisible(false);   
    }//GEN-LAST:event_Dest_sugMouseClicked

    private void jLabel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3AncestorAdded

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed

        String s=srce_.getText();
        String d=where_.getText();

        try
        {
            DefaultTableModel ob1=(DefaultTableModel)T4.getModel();
            ob1.setRowCount(0);

            int gs,ss,acs,tas,ts,dis,fr;
            String tn,trn,soc,des;
            String sql;
            java.sql.Date depd,ard;
                       
            java.util.Date dob = dep_date.getDate();
            java.sql.Date sqlDate = new java.sql.Date(dob.getTime());

            if(gen.getSelectedItem().toString().equalsIgnoreCase("General"))
            {
                sql="select * from train where SRCE ='"+s+"' and DEST ='"+d+"' and DEP_DATE >= '"+sqlDate+"' and GEN_SEAT_AV>=1 ";                               
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);
            }
            else if(String.valueOf(gen.getSelectedItem()).equalsIgnoreCase("Sleeper"))
            {
                sql="select * from train where SRCE ='"+s+"' and DEST ='"+d+"' and DEP_DATE >= '"+sqlDate+"' and SLE_SEAT_AV>=1 ";                               
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);
            }
            else if(String.valueOf(gen.getSelectedItem()).equalsIgnoreCase("AC Chair car"))
            {
                sql="select * from train where SRCE ='"+s+"' and DEST ='"+d+"' and DEP_DATE >= '"+sqlDate+"' and AC_SEAT_AV>=1 ";                               
                stmt=this.con.createStatement();
                rs=stmt.executeQuery(sql);
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Wrong class");

            
            while(rs.next())
            {
                gs=Integer.parseInt(rs.getString("GEN_SEAT_AV"));
                ss=Integer.parseInt(rs.getString("SLE_SEAT_AV"));
                acs=Integer.parseInt(rs.getString("AC_SEAT_AV"));
                tas=Integer.parseInt(rs.getString("TOTAL_AVV_SEAT"));
                ts=Integer.parseInt(rs.getString("TOTAL_SEAT"));
                dis=Integer.parseInt(rs.getString("distance"));
                
                int gen_fr=Integer.parseInt(rs.getString("gen_fare"));
                int sl_fr=Integer.parseInt(rs.getString("SLE_FARE"));
                int ac_fr=Integer.parseInt(rs.getString("AC_FARE"));
                
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
                DefaultTableModel ob=(DefaultTableModel)T4.getModel();
                ob.addRow(x);
            }
            
            stmt.close();
            rs.close();
        }
        catch(Exception e)
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Connection Problem 2 SHOW");
            System.out.println(e);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void book_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_ActionPerformed
                                
        try{            
            String Tclass;
            Tclass=String.valueOf(gen.getSelectedItem());
            System.out.println(Tclass);
            String t_num = tno.getText();
            Train_Book ob1 = new Train_Book();
            System.out.println("Train no "+t_num+" selected");
            
            
            
                    if(String.valueOf(gen.getSelectedItem()).equalsIgnoreCase("General"))
                    {
                        ob1.getdata(t_num, Tclass, gen_fare, gen_avl,Login_nm);
                        ob1.show();
                        ob1.datasend(this);
                        this.hide();
                    }
                    else if(String.valueOf(gen.getSelectedItem()).equalsIgnoreCase("Sleeper"))
                    {
                        ob1.getdata(t_num, Tclass, sleep_fare, sleep_avl,Login_nm);
                        ob1.show();
                        ob1.datasend(this);
                        this.hide();
                    }
                    else if(String.valueOf(gen.getSelectedItem()).equalsIgnoreCase("AC Chair car"))
                    {
                        ob1.getdata(t_num, Tclass, ac_fare, AC_avl,Login_nm);
                        ob1.show();
                        ob1.datasend(this);
                        this.hide();                        
                    }
                    else
                        JOptionPane.showMessageDialog(rootPane, "Wrong class\n Please select the class");
                         
            
        }
        
        catch(Exception e)
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Connection Problem book");
            System.out.println(e);
        }

    }//GEN-LAST:event_book_ActionPerformed

    private void T4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T4MouseClicked

        int rno=T4.getSelectedRow();
                TableModel ob=(TableModel)T4.getModel();
                tno.setText(ob.getValueAt(rno, 0).toString()); 
                tno.enable(false);
                
                gen_fare = Integer.parseInt(ob.getValueAt(rno, 9).toString());
                sleep_fare = Integer.parseInt(ob.getValueAt(rno, 11).toString());
                ac_fare = Integer.parseInt(ob.getValueAt(rno, 13).toString());
                
                gen_avl = Integer.parseInt(ob.getValueAt(rno, 8).toString());
                sleep_avl = Integer.parseInt(ob.getValueAt(rno, 10).toString());
                AC_avl = Integer.parseInt(ob.getValueAt(rno, 12).toString());
                
                
                 T4.setSelectionForeground(Color.cyan);
                
    }//GEN-LAST:event_T4MouseClicked

    private void tnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnoKeyReleased
     
        try
        {
            DefaultTableModel ob1=(DefaultTableModel)T4.getModel();
            ob1.setRowCount(0);
            
            int gs,ss,acs,dis,gen_fr,sl_fr,ac_fr;
            String tn,trn,soc,des,sql;
            Date depd,ard;
          
            sql="select * from train where TRAIN_NO like '%"+tno.getText()+"%'";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                gs=Integer.parseInt(rs.getString("GEN_SEAT_AV"));
                ss=Integer.parseInt(rs.getString("SLE_SEAT_AV"));
                acs=Integer.parseInt(rs.getString("AC_SEAT_AV"));
           
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
                DefaultTableModel ob=(DefaultTableModel)T4.getModel();
                ob.addRow(x);
            }
          
            stmt.close();
            rs.close();
        }
        catch(Exception e)
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Connection Problem");
            System.out.print(e);
        }
        
    }//GEN-LAST:event_tnoKeyReleased

    private void srce_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srce_ActionPerformed
      
    }//GEN-LAST:event_srce_ActionPerformed

    private void back_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ActionPerformed
        this.dispose();
        
        if(logintype.equals("Admin"))
         obval.setVisible(true);
        else if(logintype.equals("User"))
         obval2.setVisible(true);
        else
        {
            obsound.play_audio();
            System.out.println("wrong login type !!");
        }
         
        
    }//GEN-LAST:event_back_ActionPerformed

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
                new Train_Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background_;
    private javax.swing.JLabel Dest;
    private javax.swing.JList<String> Dest_sug;
    private javax.swing.JScrollPane Destination_sug;
    private javax.swing.JButton Search;
    private javax.swing.JTable T4;
    private javax.swing.JButton back_;
    private javax.swing.JButton book_;
    private com.toedter.calendar.JDateChooser dep_date;
    private javax.swing.JComboBox<String> gen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane source_sug;
    private javax.swing.JTextField srce_;
    private javax.swing.JList<String> srce_sug;
    private javax.swing.JTextField tno;
    private javax.swing.JTextField ts;
    private javax.swing.JTextField where_;
    // End of variables declaration//GEN-END:variables
}
