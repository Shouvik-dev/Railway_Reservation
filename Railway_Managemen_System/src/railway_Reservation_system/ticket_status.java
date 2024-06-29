package railway_Reservation_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author shoum
 */
public class ticket_status extends javax.swing.JFrame {
    String book_by="%",logintype="Null";
    
    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
    String sta;
    Admin_Home obval;
    User_Home obval2;
    audioplayer obsound; 
    
    public ticket_status() {
        initComponents();
            
        Confirm_.hide();
        Cancel_.hide();
        Delete_.hide();
        
        //Table transparent code
        ((DefaultTableCellRenderer) TicketTB.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        TicketTB.setOpaque(false);
        ((DefaultTableCellRenderer) TicketTB.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
        TicketTB.setRowHeight(25);
        
        audioplayer ob = new audioplayer();
        obsound=ob;
    }
    
    public void backdata(Admin_Home obval1, String p, String t)
    {
        logintype=t;
        obval = obval1;
        book_by=p;
        show_ticketTB();
    }
    
        public void backdata1(User_Home obval1, String p, String t)
    {
        logintype=t;
        obval2 = obval1;
        book_by=p;
        show_ticketTB();
    }
    
    protected void show_ticketTB()
    {
        try
        {
            DefaultTableModel ob1=(DefaultTableModel)TicketTB.getModel();
            ob1.setRowCount(0);
                       
            int PNR,sno,dist,fre;
            String trno,trnm,pnm,cls,srce,dest,bby,st,sql;
            Date bd;
            Time bt;
            
            sql="select t.pnr_no, t.tr_no, t.t_name, t.source, t.destination, t.b_time, t.b_date, t.booked_by, t.Distance, t.fare, t.Status, p.PNR_No, p.Train_no, p.Pasenger_Name, p.Age, p.Gender, p.Phone_no, p.Seat_no, p.Class from ticket t, pasenger p where t.pnr_no=p.PNR_No and t.booked_by like '"+book_by+"'";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                PNR=Integer.parseInt(rs.getString("t.pnr_no"));
                trno=rs.getString("t.tr_no");
                trnm=rs.getString("t.t_name");
                pnm=rs.getString("p.Pasenger_Name");
                sno=Integer.parseInt(rs.getString("p.Seat_no"));
                cls=rs.getString("p.Class");
                srce=rs.getString("t.source");
                dest=rs.getString("t.destination");

                bby=rs.getString("t.booked_by");
                st=rs.getString("t.Status");

                
                fre=Integer.parseInt(rs.getString("t.fare"));


                SimpleDateFormat obj1 = new SimpleDateFormat("dd-MM-yyyy");
                bd=rs.getDate("t.b_date");
                String bd1 = obj1.format(bd);
                
                SimpleDateFormat obj2 = new SimpleDateFormat("hh:mm:ss");           
                bt=rs.getTime("t.b_time");
                String bt1 = obj2.format(bt);
            
                String x[]={Integer.toString(PNR),trno,trnm,pnm,Integer.toString(sno),cls,srce,dest,bd1,bt1,Integer.toString(fre),st};
                DefaultTableModel ob=(DefaultTableModel)TicketTB.getModel();
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TicketTB = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        PNR_FIELD = new javax.swing.JTextField();
        Confirm_ = new javax.swing.JButton();
        Delete_ = new javax.swing.JButton();
        Cancel_ = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        back_ = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Background_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TicketTB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TicketTB.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TicketTB.setForeground(new java.awt.Color(255, 255, 255));
        TicketTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PNR No", "TRAIN NO", "TRAIN NAME", "PASENGER NAME", "SEAT NO", "CLASS", "SOURCE", "DESTINATION", "BOOKING DATE", "BOOKING TIME", "FARE", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TicketTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketTBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TicketTB);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1250, 300));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter PNR No");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, 30));

        PNR_FIELD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PNR_FIELDKeyReleased(evt);
            }
        });
        getContentPane().add(PNR_FIELD, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 190, 30));

        Confirm_.setBackground(new java.awt.Color(102, 255, 255));
        Confirm_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Confirm_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pp.png"))); // NOI18N
        Confirm_.setText("CONFIRM");
        Confirm_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirm_ActionPerformed(evt);
            }
        });
        getContentPane().add(Confirm_, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 130, 40));

        Delete_.setBackground(new java.awt.Color(102, 255, 255));
        Delete_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Delete_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-delete-50.png"))); // NOI18N
        Delete_.setText("DELETE");
        Delete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ActionPerformed(evt);
            }
        });
        getContentPane().add(Delete_, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, 130, 40));

        Cancel_.setBackground(new java.awt.Color(102, 255, 255));
        Cancel_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Cancel_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancelpp.png"))); // NOI18N
        Cancel_.setText("CANCEL");
        Cancel_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_ActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel_, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 130, 40));

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     TICKET STATUS ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 260, 60));

        logout.setBackground(new java.awt.Color(102, 255, 255));
        logout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/log out.png"))); // NOI18N
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 130, 40));

        back_.setBackground(new java.awt.Color(102, 255, 255));
        back_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/65.png"))); // NOI18N
        back_.setText("BACK");
        back_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ActionPerformed(evt);
            }
        });
        jPanel1.add(back_, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1260, 60));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0, 80));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1290, 470));

        Background_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Background_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Train/Train Status 1.jpg"))); // NOI18N
        getContentPane().add(Background_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

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

    }//GEN-LAST:event_logoutActionPerformed

    private void TicketTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketTBMouseClicked

                int rno=TicketTB.getSelectedRow();
                TableModel ob=(TableModel)TicketTB.getModel();
                
                PNR_FIELD.setText(ob.getValueAt(rno, 0).toString());
                sta = ob.getValueAt(rno, 11).toString();
                
                if(logintype.equalsIgnoreCase("Admin"))
                {
                    if(sta.equalsIgnoreCase("Confirm"))
                    {
                        Confirm_.hide();
                        Cancel_.show();
                        Delete_.hide();
                    }
                    else if(sta.equals("Cancel"))
                    {
                        Confirm_.show();
                        Cancel_.hide();
                        Delete_.show();
                    }
                    else if(sta.equals("Wainting"))
                    {
                         Confirm_.show();
                         Cancel_.show();
                         Delete_.show();
                    }
                    else
                    {
                        Confirm_.show();
                         Cancel_.show();
                         Delete_.show();
                         JOptionPane.showMessageDialog(rootPane, "Status is not Correct!! Database error");
                         System.out.println("Status is not Correct!! Database error");
                    }
                }
                else
                {
                    Delete_.show();
                }
                TicketTB.setSelectionForeground(Color.cyan);
    }//GEN-LAST:event_TicketTBMouseClicked

    private void Confirm_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirm_ActionPerformed

        try
        {
           
             int no = Integer.parseInt(PNR_FIELD.getText());
            String S="update ticket set Status='Confirm' where pnr_no = '"+no+"'";
            pst=this.con.prepareStatement(S);
            int x=pst.executeUpdate();
            if(x==1)
            {
                        JOptionPane.showMessageDialog(rootPane, "Updated Successful!!!");
                        int rno=TicketTB.getSelectedRow();
                        System.out.print(rno);
                        show_ticketTB();
                        PNR_FIELD.setText(null);     
                        
                        Confirm_.hide();
                        Cancel_.hide();
                        Delete_.hide();
            }
            else
            {
                obsound.play_audio();
                JOptionPane.showMessageDialog(rootPane, "Not able update status");
            }
                         
        }
        catch(Exception e)
                   {
                       obsound.play_audio();
                       JOptionPane.showMessageDialog(rootPane, "Updated connection problem!!!");
                       System.out.println("Update error"+e);
                       
                   }
    }//GEN-LAST:event_Confirm_ActionPerformed

    private void Cancel_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel_ActionPerformed
      
        try
        {
        
            int no = Integer.parseInt(PNR_FIELD.getText());
            String S="update ticket set Status='Cancel' where pnr_no = '"+no+"'";
            pst=this.con.prepareStatement(S);
            int x=pst.executeUpdate();
            if(x==1)
            {
                        JOptionPane.showMessageDialog(rootPane, "Updated Successful!!!");
                        int rno=TicketTB.getSelectedRow();
                        System.out.print(rno);
                        show_ticketTB();
                        PNR_FIELD.setText(null);     
                        
                        Confirm_.hide();
                        Cancel_.hide();
                        Delete_.hide();
            }
            else
            {
                obsound.play_audio();
                JOptionPane.showMessageDialog(rootPane, "Not able update status");
            }
                         

        }
        catch(Exception e)
                   {
                       obsound.play_audio();
                       JOptionPane.showMessageDialog(rootPane, "Updated connection problem!!!");
                       System.out.println("Update error"+e);                       
                   }
    }//GEN-LAST:event_Cancel_ActionPerformed

    private void Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ActionPerformed
       
         try
                {
                    int rn=TicketTB.getSelectedRow();
                    System.out.print(rn);
                    String T,sql;
                    
                    int rno=TicketTB.getSelectedRow();
                    TableModel ob=(TableModel)TicketTB.getModel();
                
                     int no = Integer.parseInt(PNR_FIELD.getText());               
                    T=ob.getValueAt(rno, 0).toString();
                    sql="delete from ticket where pnr_no = '"+no+"'";
                    pst=this.con.prepareStatement(sql);
                    int x=pst.executeUpdate();
                    
                    sql="delete from pasenger where PNR_No = '"+no+"'";
                    pst=this.con.prepareStatement(sql);
                    int x2=pst.executeUpdate();
                    
                    if(x==1 && x2==1)
                        {
                            JOptionPane.showMessageDialog(rootPane, "Deleted Successfully!!!");
                            DefaultTableModel obj=(DefaultTableModel)TicketTB.getModel();
                            obj.removeRow(rn);
                            
                            Confirm_.hide();
                            Cancel_.hide();
                            Delete_.hide();
                                
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

    private void PNR_FIELDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PNR_FIELDKeyReleased
        try
        {
            DefaultTableModel ob1=(DefaultTableModel)TicketTB.getModel();
            ob1.setRowCount(0);
                       
            int PNR,sno,dist,fre;
            String trno,trnm,pnm,cls,srce,dest,bby,st,sql;
            Date bd;
            Time bt;
            
            sql="select t.pnr_no, t.tr_no, t.t_name, t.source, t.destination, t.b_time, t.b_date, t.booked_by, t.Distance, t.fare, t.Status, p.PNR_No, p.Train_no, p.Pasenger_Name, p.Age, p.Gender, p.Phone_no, p.Seat_no, p.Class from ticket t, pasenger p where t.pnr_no=p.PNR_No and t.booked_by like '"+book_by+"' and t.pnr_no like '"+PNR_FIELD.getText()+"%'";
            stmt=this.con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                PNR=Integer.parseInt(rs.getString("t.pnr_no"));
                trno=rs.getString("t.tr_no");
                trnm=rs.getString("t.t_name");
                pnm=rs.getString("p.Pasenger_Name");
                sno=Integer.parseInt(rs.getString("p.Seat_no"));
                cls=rs.getString("p.Class");
                srce=rs.getString("t.source");
                dest=rs.getString("t.destination");

                bby=rs.getString("t.booked_by");
                st=rs.getString("t.Status");

                
                fre=Integer.parseInt(rs.getString("t.fare"));


                SimpleDateFormat obj1 = new SimpleDateFormat("dd-MM-yyyy");
                bd=rs.getDate("t.b_date");
                String bd1 = obj1.format(bd);
                
                SimpleDateFormat obj2 = new SimpleDateFormat("hh:mm:ss");           
                bt=rs.getTime("t.b_time");
                String bt1 = obj2.format(bt);
            
                String x[]={Integer.toString(PNR),trno,trnm,pnm,Integer.toString(sno),cls,srce,dest,bd1,bt1,Integer.toString(fre),st};
                DefaultTableModel ob=(DefaultTableModel)TicketTB.getModel();
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
    }//GEN-LAST:event_PNR_FIELDKeyReleased

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
                new ticket_status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background_;
    private javax.swing.JButton Cancel_;
    private javax.swing.JButton Confirm_;
    private javax.swing.JButton Delete_;
    private javax.swing.JTextField PNR_FIELD;
    private javax.swing.JTable TicketTB;
    private javax.swing.JButton back_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
