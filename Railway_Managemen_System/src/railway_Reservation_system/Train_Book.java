package railway_Reservation_system;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Train_Book extends javax.swing.JFrame {

    String tr_no,Login_nm;
    String seatval[] = {"0", "0", "0", "0", "0", "0", "0", "0"};
    String imageUrl = "src\\Logo\\train LOGO.png";
    int maxcnt =6,avl1=0;
            
    DatabaseConnection db_ob = new DatabaseConnection();
    Connection con=db_ob.connect_db();
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;
    
    Train_Search obval2;
    audioplayer obsound = new audioplayer();
    
    int passcnt = 0,amount=0;
    
    public String sql, sql2, tnm, sc, dt, Tclass;
    Random rand = new Random();
    int randompnr = rand.nextInt(9999999);
    
    public Train_Book() {
        initComponents();

        //Table transparent code
        ((DefaultTableCellRenderer) PT.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        PT.setOpaque(false);
        ((DefaultTableCellRenderer) PT.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        
        PT.setRowHeight(25);
        
        Tamt.setText(null);

    }
    
    public void datasend(Train_Search obval3) {
        obval2 = obval3;
    }
    
    public void download1() {
        try {
            sql = "select * from ticket where pnr_no='" + randompnr + "'";
            stmt = this.con.createStatement();
            rs = stmt.executeQuery(sql);

            // Move cursor to the first row
            if (rs.next()) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save PDF");
                fileChooser.setName("Ticket");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                // Show save dialog and get the user-selected file
                int userSelection = fileChooser.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    String filePath = fileToSave.getAbsolutePath();

                    // Ensure the file has a .pdf extension
                    if (!filePath.toLowerCase().endsWith(".pdf")) {
                        filePath += ".pdf";
                    }
                    
                    try {
                        // Ticket information
                        String pnr = Integer.toString(randompnr);
                        String trainNumber = trn.getText();                        
                        String dateOfJourney = Dep_date.getText();
                        String departureTime = Dep_Time.getText();                        
                        String ticketFare = Tamt.getText();
                        String St = rs.getString("Status");

                        // Create Document instance
                        Document document = new Document(PageSize.A4, 30, 30, 30, 30);

                        // Initialize PdfWriter
                        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

                        // Open the document
                        document.open();

                        // Add an image
                        Image img = Image.getInstance(imageUrl);
                        img.scaleToFit(200, 100); // Scale image to fit
                        img.setAlignment(Element.ALIGN_CENTER);
                        document.add(img);

                        // Set up fonts
                        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
                        Font subTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, BaseColor.WHITE);
                        Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
                        Font textFontD = FontFactory.getFont(FontFactory.TIMES_BOLD, 9, BaseColor.BLACK);
                        Font textFontR = FontFactory.getFont(FontFactory.TIMES_BOLD, 9, BaseColor.RED);
                        Font footerFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10, BaseColor.DARK_GRAY);

                        // Add title
                        Paragraph title = new Paragraph("RAILWAY TICKET", titleFont);
                        title.setAlignment(Element.ALIGN_CENTER);
                        document.add(title);

                        // Add a blank line
                        document.add(new Paragraph(" "));
                        
                        PdfPTable table2 = new PdfPTable(3);
                        table2.setWidthPercentage(100);
                        table2.setSpacingBefore(10f);
                        table2.setSpacingAfter(10f);
                        
                        
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell("FROM", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("  ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("TO", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell(srce1.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        table2.addCell(getCell("  ", PdfPCell.ALIGN_CENTER, textFont, false, BaseColor.WHITE));
                        table2.addCell(getCell(dest1.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell("TRAIN No.", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("TRAIN NAME", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("CLASS", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell(trainNumber, PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        table2.addCell(getCell(T_nm.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        table2.addCell(getCell(CLASS_LABEL.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell(" ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));                        
                        
                        table2.addCell(getCell("PNR No.", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("DISTANCE", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("BOOKING DATE", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell(pnr, PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        table2.addCell(getCell(dista_.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        table2.addCell(getCell(rs.getString("b_date"), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell("Depurture Date & Time", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("  ", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        table2.addCell(getCell("Arival Date & Time", PdfPCell.ALIGN_CENTER, textFontD, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell(Dep_date.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        table2.addCell(getCell("  ", PdfPCell.ALIGN_CENTER, textFont, false, BaseColor.WHITE));
                        table2.addCell(getCell(Arr_Date.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        
                        table2.addCell(getCell(Dep_Time.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        table2.addCell(getCell("  ", PdfPCell.ALIGN_CENTER, textFont, false, BaseColor.WHITE));
                        table2.addCell(getCell(Arr_Time.getText(), PdfPCell.ALIGN_CENTER, textFontR, false, BaseColor.WHITE));
                        
                        document.add(table2);

                        // Create a table for ticket details
                        PdfPTable table = new PdfPTable(5);
                        table.setWidthPercentage(100);
                        table.setSpacingBefore(10f);
                        table.setSpacingAfter(10f);
                        
                        table.addCell(getCell("Passenger Name", PdfPCell.ALIGN_MIDDLE, subTitleFont, false, BaseColor.LIGHT_GRAY));
                        table.addCell(getCell("Age", PdfPCell.ALIGN_MIDDLE, subTitleFont, false, BaseColor.LIGHT_GRAY));
                        table.addCell(getCell("Gender", PdfPCell.ALIGN_MIDDLE, subTitleFont, false, BaseColor.LIGHT_GRAY));
                        table.addCell(getCell("Seat Number", PdfPCell.ALIGN_MIDDLE, subTitleFont, false, BaseColor.LIGHT_GRAY));
                        table.addCell(getCell("Status", PdfPCell.ALIGN_MIDDLE, subTitleFont, false, BaseColor.LIGHT_GRAY));
                        
                        String pass_name, age, gen, S;
                        String qrCodeData = String.format("PNR: %s\nTrain Number: %s\nFrom Station: %s\nTo Station: %s\nDate of Journey: %s\nDeparture Time: %s\nDate of Arrival: %s\nArrival Time: %s\nTicket Fare: %s\nEmail: %s", pnr, trainNumber, srce1.getText(), dest1.getText(), dateOfJourney, departureTime, Arr_Date.getText(),Arr_Time.getText(), ticketFare,jTextField1.getText());
                        
                        for (int i = 0; i < PT.getRowCount(); i++) {
                            pass_name = PT.getValueAt(i, 0).toString();
                            age = PT.getValueAt(i, 1).toString();                            
                            gen = PT.getValueAt(i, 2).toString();
                            
                            table.addCell(getCell(pass_name, PdfPCell.ALIGN_LEFT, textFont, false, BaseColor.WHITE));
                            table.addCell(getCell(age, PdfPCell.ALIGN_LEFT, textFont, false, BaseColor.WHITE));
                            table.addCell(getCell(gen, PdfPCell.ALIGN_LEFT, textFont, false, BaseColor.WHITE));
                            table.addCell(getCell(seatval[i], PdfPCell.ALIGN_LEFT, textFont, false, BaseColor.WHITE));                            
                            table.addCell(getCell(rs.getString("Status"), PdfPCell.ALIGN_LEFT, textFont, false, BaseColor.WHITE));
                            
                            S = String.format("\n\n Pasenger %d Name: %s \n Age: %s \n Gender: %s \n Seat No.:%s \n Status: %s \n", (i + 1), pass_name, age, gen, seatval[i], rs.getString("Status"));
                            qrCodeData = qrCodeData.concat(S);
                        }

                        // Add table to document
                        document.add(table);

                        // Generate QR Code
                        BarcodeQRCode qrCode = new BarcodeQRCode(qrCodeData, 150, 150, null);
                        Image qrCodeImage = qrCode.getImage();
                        qrCodeImage.setAlignment(Element.ALIGN_RIGHT);

                        // Add QR Code to document
                        document.add(qrCodeImage);

                        // Add footer
                        Paragraph footer = new Paragraph("Thank you for choosing our railway service!", footerFont);
                        footer.setAlignment(Element.ALIGN_CENTER);
                        document.add(footer);

                        // Close the document
                        document.close();
                        
                        System.out.println("PDF created successfully at " + filePath);
                        JOptionPane.showMessageDialog(rootPane, "PDF created successfully at " + filePath);
                        SendEmail sc1 = new SendEmail();
                        sc1.send_email(jTextField1.getText(),"Bharat Railway Ticket Booking", qrCodeData+"\n Thank you for booking! Happy journey!! \n\nBharat Railway Management Team");
                        
                    } catch (Exception e) {
                        obsound.play_audio();
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error creating PDF: " + e.getMessage());
                    }
                } else {
                    System.out.println("Save command canceled by user.");
                }
            } else {
                System.out.println("No data found for the given PNR.");
                JOptionPane.showMessageDialog(null, "No data found for the given PNR.");
            }
        } catch (Exception e) {
            obsound.play_audio();
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "pdf creation probelm");
        }
    }
    
    private static PdfPCell getCell(String text, int alignment, Font font, boolean border, BaseColor backgroundColor) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(6);
        cell.setHorizontalAlignment(alignment);
        if (!border) {
            cell.setBorder(PdfPCell.NO_BORDER);
        }
        cell.setBackgroundColor(backgroundColor);
        return cell;
    }


     public void getdata(String x, String Tcls, int amt, int avl, String p) {
        tr_no = x;
        Tclass = Tcls;
        avl1 =avl;
        amount=amt;
        Login_nm=p;
        
        try {
            sql = "select * from train where train_no = '" + tr_no + "'";
            stmt = this.con.createStatement();
            rs = stmt.executeQuery(sql);
            
            rs.next();            
            trn.setText(rs.getString("TRAIN_NO"));            
            T_nm.setText(rs.getString("TRAIN_NAME"));            
            srce1.setText(rs.getString("SRCE"));            
            dest1.setText(rs.getString("DEST"));            
            Dep_date.setText(rs.getString("DEP_DATE"));
            Dep_Time.setText(rs.getString("DEP_TIME"));
            Arr_Date.setText(rs.getString("ARV_DATE"));
            Arr_Time.setText(rs.getString("ARV_TIME"));
            CLASS_LABEL.setText(Tclass);
            dista_.setText(rs.getString("Distance").concat(" Km"));

            Update_.setEnabled(false);
            Delete_.setEnabled(false);
        } 
        catch (Exception e) {
            obsound.play_audio();
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Connection Problem next page");
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        book_ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PT = new javax.swing.JTable();
        Log_out_ = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        trn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Dep_date = new javax.swing.JLabel();
        Dep_Time = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Arr_Date = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Arr_Time = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        T_nm = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        back_ = new javax.swing.JButton();
        dista_ = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        srce1 = new javax.swing.JLabel();
        dest1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnm1 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ag = new javax.swing.JTextField();
        gn = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        Add_ = new javax.swing.JButton();
        Update_ = new javax.swing.JButton();
        Delete_ = new javax.swing.JButton();
        Clear_ = new javax.swing.JButton();
        CLASS_LABEL = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Tamt = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        book_.setBackground(new java.awt.Color(102, 255, 255));
        book_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        book_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BOOK.png"))); // NOI18N
        book_.setText("BOOK");
        book_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_ActionPerformed(evt);
            }
        });
        getContentPane().add(book_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 470, 130, 42));

        PT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PT.setForeground(new java.awt.Color(255, 255, 255));
        PT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "AGE", "GENDER", "Phone no"
            }
        ));
        PT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PT);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 670, 200));

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
        getContentPane().add(Log_out_, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 130, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        trn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        trn.setForeground(new java.awt.Color(204, 255, 255));
        trn.setText("Example text");
        jPanel1.add(trn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setText("DEPURTURE DATE :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 140, 30));

        Dep_date.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Dep_date.setForeground(new java.awt.Color(204, 255, 255));
        Dep_date.setText("00-00-0000");
        jPanel1.add(Dep_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 90, 30));

        Dep_Time.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Dep_Time.setForeground(new java.awt.Color(204, 255, 255));
        Dep_Time.setText("00:00:00");
        jPanel1.add(Dep_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 255, 255));
        jLabel13.setText("ARRIVAL DATE :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 110, 30));

        Arr_Date.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Arr_Date.setForeground(new java.awt.Color(204, 255, 255));
        Arr_Date.setText("00 - 00 - 0000");
        jPanel1.add(Arr_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 110, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 255));
        jLabel12.setText("ARRIVAL TIME :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 110, 30));

        Arr_Time.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Arr_Time.setForeground(new java.awt.Color(204, 255, 255));
        Arr_Time.setText("00:00:0000");
        jPanel1.add(Arr_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 10, 80, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 255));
        jLabel11.setText("DEPURTURE TIME :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 140, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("TRAIN NAME :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 100, 30));

        T_nm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        T_nm.setForeground(new java.awt.Color(204, 255, 255));
        T_nm.setText("Example text");
        jPanel1.add(T_nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 120, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("TRAIN NO :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1380, 50));

        back_.setBackground(new java.awt.Color(102, 255, 255));
        back_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/65.png"))); // NOI18N
        back_.setText("BACK");
        back_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ActionPerformed(evt);
            }
        });
        getContentPane().add(back_, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 40));

        dista_.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        dista_.setForeground(new java.awt.Color(255, 255, 255));
        dista_.setText("00");
        getContentPane().add(dista_, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 470, 60, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EMAIL :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 120, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DISTANCE :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 110, 40));

        srce1.setFont(new java.awt.Font("Sitka Text", 1, 34)); // NOI18N
        srce1.setForeground(new java.awt.Color(255, 255, 255));
        srce1.setText("SOURCE");
        getContentPane().add(srce1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 420, 50));

        dest1.setFont(new java.awt.Font("Sitka Text", 1, 34)); // NOI18N
        dest1.setForeground(new java.awt.Color(255, 255, 255));
        dest1.setText("DESTINATION");
        getContentPane().add(dest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 490, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-right-arrow-100.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 110, 60));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PASSENGER NAME :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 190, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CLASS :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 120, 40));

        pnm1.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        getContentPane().add(pnm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 240, 40));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 240, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AGE :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 80, 40));

        ag.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        getContentPane().add(ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 240, 40));

        gn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female", "Others", " " }));
        gn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gnActionPerformed(evt);
            }
        });
        getContentPane().add(gn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 240, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("GENDER :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 94, 40));

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PHONE NO :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 130, 40));

        pn.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnActionPerformed(evt);
            }
        });
        getContentPane().add(pn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 240, 40));

        Add_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Add_.setText("ADD");
        Add_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ActionPerformed(evt);
            }
        });
        getContentPane().add(Add_, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        Update_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Update_.setText("UPDATE");
        Update_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ActionPerformed(evt);
            }
        });
        getContentPane().add(Update_, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, -1));

        Delete_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Delete_.setText("DELETE");
        Delete_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ActionPerformed(evt);
            }
        });
        getContentPane().add(Delete_, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, -1, -1));

        Clear_.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Clear_.setText("CLEAR");
        Clear_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_ActionPerformed(evt);
            }
        });
        getContentPane().add(Clear_, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 90, -1));

        CLASS_LABEL.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        CLASS_LABEL.setForeground(new java.awt.Color(255, 255, 255));
        CLASS_LABEL.setText("CLASS NAME");
        getContentPane().add(CLASS_LABEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 240, 40));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0, 80));
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 560, 420));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TOTAL FARE :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, -1, 40));

        Tamt.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Tamt.setForeground(new java.awt.Color(255, 255, 255));
        Tamt.setText("00");
        getContentPane().add(Tamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 470, 60, 40));

        Background.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        Background.setForeground(new java.awt.Color(255, 255, 255));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Train/final1.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Add_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ActionPerformed
        
        
            if (CLASS_LABEL.getText().length() <= 0 || ag.getText().length() <= 0 || String.valueOf(gn.getSelectedItem()).equals("Select Gender") || pn.getText().length() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Empty text field");
            } else {
                try {
                    System.out.println(CLASS_LABEL.getText().length());

                    DefaultTableModel ob = (DefaultTableModel) PT.getModel();
                    String x[] = {pnm1.getText().toUpperCase(), ag.getText(), String.valueOf(gn.getSelectedItem()).toUpperCase(), pn.getText()};
                    ob.addRow(x);
                    passcnt++;
                    
                    pnm1.setText(null);
                    ag.setText(null);
                    gn.setSelectedIndex(0);
                    pn.setText(null);
                    
                    Tamt.setText(String.valueOf(passcnt*amount));
                    System.out.println("pass count :"+passcnt+", class amount :"+amount+",\nTotal Amount :"+(passcnt*amount));
                } catch (Exception e) {
                    obsound.play_audio();
                    System.out.println(e);
                    JOptionPane.showMessageDialog(rootPane, "Connection Problem!!!");
                }
            }

        if(passcnt==maxcnt || avl1<=passcnt)
        {
            Add_.hide();
            JOptionPane.showMessageDialog(rootPane, "Maximum passener added");
        }

    }//GEN-LAST:event_Add_ActionPerformed

    private void Update_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ActionPerformed
        
        if (CLASS_LABEL.getText().length() <= 0 || ag.getText().length() <= 0 || String.valueOf(gn.getSelectedItem()).equals("Select Gender") || pn.getText().length() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Empty text field");
        } 
        else {
            try {
                System.out.println(CLASS_LABEL.getText().length());
                
                DefaultTableModel obj = (DefaultTableModel) PT.getModel();
                if (PT.getSelectedRowCount() == 1) {
                    obj.setValueAt(CLASS_LABEL.getText(), PT.getSelectedRow(), 0);
                    obj.setValueAt(ag.getText(), PT.getSelectedRow(), 1);
                    obj.setValueAt(String.valueOf(gn.getSelectedItem()).equals("Select Gender"), PT.getSelectedRow(), 2);
                    obj.setValueAt(pn.getText(), PT.getSelectedRow(), 3);
                }
                JOptionPane.showMessageDialog(rootPane, "Updated");
                pnm1.setText("");
                ag.setText("");
                gn.setSelectedIndex(0);
                pn.setText("");
            } 
            catch (Exception e) {
                obsound.play_audio();
                System.out.println(e);
                JOptionPane.showMessageDialog(rootPane, "Updation Problem!!!");
            }
        }
        Update_.hide();
        Delete_.hide();
    }//GEN-LAST:event_Update_ActionPerformed

    private void Delete_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ActionPerformed
        try {
            int rno = PT.getSelectedRow();
            DefaultTableModel ob = (DefaultTableModel) PT.getModel();
            ob.removeRow(rno);
            passcnt--;
            JOptionPane.showMessageDialog(rootPane, "Deleted succesfully");
            pnm1.setText("");
            ag.setText("");
            gn.setSelectedIndex(0);
            pn.setText("");
            
            Tamt.setText(String.valueOf(passcnt*amount));
        } 
        catch (Exception e) {
            obsound.play_audio();
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Deletion Problem!!!");
        }// TODO add your handling code here:
        
        Update_.hide();
        Delete_.hide();
        
        if(passcnt<maxcnt)
        {
            Add_.setEnabled(true);
            Add_.show(true);
        }
    }//GEN-LAST:event_Delete_ActionPerformed

    private void PTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PTMouseClicked
        PT.setSelectionForeground(Color.cyan);
        DefaultTableModel obj = (DefaultTableModel) PT.getModel();
        String nm1, ag1, gen1, pn1;
        
        nm1 = obj.getValueAt(PT.getSelectedRow(), 0).toString();        
        ag1 = obj.getValueAt(PT.getSelectedRow(), 1).toString();        
        gen1 = obj.getValueAt(PT.getSelectedRow(), 2).toString();
        pn1 = obj.getValueAt(PT.getSelectedRow(), 3).toString();
        
        pnm1.setText(nm1);
        ag.setText(ag1);
        
        if(gen1.equalsIgnoreCase("MALE"))
        {
            gn.setSelectedIndex(1);
        }
        else if(gen1.equalsIgnoreCase("FEMALE"))
        {
            gn.setSelectedIndex(2);
        }
        else if(gen1.equalsIgnoreCase("OTHERS"))
        {
            gn.setSelectedIndex(3);
        }
        else
        {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Wrong Gender");
            gn.setSelectedIndex(0);
            
        }
        
        pn.setText(pn1);
        
        Add_.setEnabled(false);
        Update_.setEnabled(true);
        Delete_.setEnabled(true);
        
        Update_.show();
        Delete_.show();
    }//GEN-LAST:event_PTMouseClicked
    
    public void payment_status(int st)
    {
      
                if(st==1)
            {    
                try {
                    int book_cnt = 0;

                    int x, x2;
                    String pass_name, gen, phno, age;
                    int age1;
                    String localsql;
                    sql = "insert into ticket values('" + randompnr + "','" + trn.getText() + "','" + T_nm.getText() + "','" + srce1.getText() + "','" + dest1.getText() + "',current_time(),current_date(),'" + Login_nm + "','" + 10 + "','" + 1000 + "','" + "confirm" + "')";
                    pst = this.con.prepareStatement(sql);
                    x = pst.executeUpdate();

                    System.out.println("Table row count " + PT.getRowCount());
                    for (int i = 0; i < PT.getRowCount(); i++) {
                        pass_name = PT.getValueAt(i, 0).toString();
                        System.out.println("Passenger name " + pass_name);
                        age = PT.getValueAt(i, 1).toString();
                        age1 = Integer.parseInt(age);
                        gen = PT.getValueAt(i, 2).toString();
                        phno = PT.getValueAt(i, 3).toString();

                        localsql = "select * from seat_data where Train_no = '" + trn.getText() + "'";
                        stmt = this.con.createStatement();
                        rs = stmt.executeQuery(localsql);

                        if (rs.next()) //Seat data retrive
                        {
                            if (CLASS_LABEL.getText().equals("General")) {
                                sql2 = "insert into pasenger values('" + randompnr + "','" + tr_no + "','" + pass_name + "','" + age1 + "','" + gen + "','" + phno + "','" + rs.getString("Gen_seat_cur") + "','" + CLASS_LABEL.getText() + "')";
                                seatval[i] = rs.getString("Gen_seat_cur");
                            } else if (CLASS_LABEL.getText().equals("Sleeper")) {
                                sql2 = "insert into pasenger values('" + randompnr + "','" + tr_no + "','" + pass_name + "','" + age1 + "','" + gen + "','" + phno + "','" + rs.getString("Sleep_seat_cur") + "','" + CLASS_LABEL.getText() + "')";
                                seatval[i] = rs.getString("Sleep_seat_cur");
                            } else if (CLASS_LABEL.getText().equals("AC Chair car")) {
                                sql2 = "insert into pasenger values('" + randompnr + "','" + tr_no + "','" + pass_name + "','" + age1 + "','" + gen + "','" + phno + "','" + rs.getString("AC_seat_cur") + "','" + CLASS_LABEL.getText() + "')";
                                seatval[i] = rs.getString("AC_seat_cur");
                            } 
                            else {
                                obsound.play_audio();
                                JOptionPane.showMessageDialog(rootPane, "Error!!");
                                System.out.println("Unable to decrese general seat no in train table");
        //                                    continue;
                            }

                            pst = this.con.prepareStatement(sql2);
                            x2 = pst.executeUpdate();

                            if (x == 1 && x2 == 1) {
                                book_cnt = 1;
                                String S;
                                int x4, x5;
                                if (CLASS_LABEL.getText().equals("General")) {
                                    S = "update train set GEN_SEAT_AV=GEN_SEAT_AV-1 WHERE TRAIN_NO='" + trn.getText() + "'";
                                    pst = this.con.prepareStatement(S);
                                    x4 = pst.executeUpdate();

                                    S = "update seat_data set Gen_seat_cur=Gen_seat_cur+1 WHERE TRAIN_NO='" + trn.getText() + "'";
                                    pst = this.con.prepareStatement(S);
                                    x5 = pst.executeUpdate();

                                    if (x4 == 1 && x5 == 1) {
                                        System.out.println("General seat decreased by 1");
                                    } 
                                    else {
                                        obsound.play_audio();
                                        JOptionPane.showMessageDialog(rootPane, "Error!!");
                                        System.out.println("Unable to decrease general seat no in train table");
                                    }
                                } 
                                
                                
                                else if (CLASS_LABEL.getText().equals("Sleeper")) {
                                    S = "update train set SLE_SEAT_AV=SLE_SEAT_AV-1 WHERE TRAIN_NO='" + trn.getText() + "'";
                                    pst = this.con.prepareStatement(S);
                                    x4 = pst.executeUpdate();

                                    S = "update seat_data set Sleep_seat_cur=Sleep_seat_cur+1 WHERE TRAIN_NO='" + trn.getText() + "'";
                                    pst = this.con.prepareStatement(S);
                                    x5 = pst.executeUpdate();

                                    if (x4 == 1 && x5 == 1) {
                                        System.out.println("Sleeper seat decreased by 1");
                                    } 
                                    else {
                                        obsound.play_audio();
                                        JOptionPane.showMessageDialog(rootPane, "Error!!");
                                        System.out.println("Unable to decrease sleeper seat no in train table");
                                    }
                                } 
                                
                                
                                else if (CLASS_LABEL.getText().equals("AC Chair car")) {
                                    S = "update train set AC_SEAT_AV=AC_SEAT_AV-1 WHERE TRAIN_NO='" + trn.getText() + "'";
                                    pst = this.con.prepareStatement(S);
                                    x4 = pst.executeUpdate();

                                    S = "update seat_data set AC_seat_cur=AC_seat_cur+1 WHERE TRAIN_NO='" + trn.getText() + "'";
                                    pst = this.con.prepareStatement(S);
                                    x5 = pst.executeUpdate();

                                    if (x4 == 1 && x5 == 1) {
                                        System.out.println("AC seat decreased by 1");
                                    } 
                                    else {
                                        obsound.play_audio();
                                        JOptionPane.showMessageDialog(rootPane, "Error!!");
                                        System.out.println("Unable to decrease AC seat no in train table");
                                    }
                                } 
                                else {
                                    obsound.play_audio();
                                    JOptionPane.showMessageDialog(rootPane, "Class type error");
                                    System.out.println("Class type error");
                                }
                            } else {//Insert query not done or error occured
                                obsound.play_audio();
                                JOptionPane.showMessageDialog(rootPane, "Unable to book");
                                book_cnt = 0;
                                break;
                            }
                        } else {//unable to Seat data retrive
                            obsound.play_audio();
                            JOptionPane.showMessageDialog(rootPane, "No seat data found for the specified train number");
                            book_cnt = 0;
                            break;
                        }
                    }

                    if (book_cnt == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Thank you for booking");

                        download1();
                        
                        this.dispose();
                        obval2.setVisible(true);
                    }

                } catch (Exception e) {
                    obsound.play_audio();
                    System.out.println(e);
                    JOptionPane.showMessageDialog(rootPane, "Connection problem IN BOOKING!!");
                }

            }

            else
            {
                JOptionPane.showMessageDialog(rootPane, "Payment cancelled");
            }
    }
    
    private void book_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_ActionPerformed
                                  
            Payment ob3 = new Payment();
            ob3.setVisible(true);            
            ob3.generateQRCode("upi://pay?pa=sarkarsucharita21@oksbi&pn=Sucharita%20Sarkar&am="+Tamt.getText()+"&cu=INR&aid=uGICAgIDDree9YQ", passcnt, CLASS_LABEL.getText(), Integer.parseInt(Tamt.getText()),this);            
                    
    }//GEN-LAST:event_book_ActionPerformed

    private void Log_out_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_out_ActionPerformed
        // TODO add your handling code here:
        try {
            
            Sign_In obj = new Sign_In();
            JOptionPane.showMessageDialog(rootPane, "Log out succesfully");
            this.dispose();
            obj.show();
            
        } 
        catch (Exception e) {
            obsound.play_audio();
            JOptionPane.showMessageDialog(rootPane, "Unable to log out");
            System.out.println("Log out error: " + e);
        }
    }//GEN-LAST:event_Log_out_ActionPerformed

    private void gnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gnActionPerformed

    private void pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnActionPerformed

    private void back_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ActionPerformed
        this.dispose();
        obval2.setVisible(true);
    }//GEN-LAST:event_back_ActionPerformed

    private void Clear_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_ActionPerformed
        pnm1.setText("");
        ag.setText("");
        gn.setSelectedIndex(0);
        pn.setText("");
    }//GEN-LAST:event_Clear_ActionPerformed

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
                new Train_Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_;
    private javax.swing.JLabel Arr_Date;
    private javax.swing.JLabel Arr_Time;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel CLASS_LABEL;
    private javax.swing.JButton Clear_;
    private javax.swing.JButton Delete_;
    private javax.swing.JLabel Dep_Time;
    private javax.swing.JLabel Dep_date;
    private javax.swing.JButton Log_out_;
    private javax.swing.JTable PT;
    private javax.swing.JLabel T_nm;
    private javax.swing.JLabel Tamt;
    private javax.swing.JButton Update_;
    private javax.swing.JTextField ag;
    private javax.swing.JButton back_;
    private javax.swing.JButton book_;
    private javax.swing.JLabel dest1;
    private javax.swing.JLabel dista_;
    private javax.swing.JComboBox<String> gn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField pn;
    private javax.swing.JTextField pnm1;
    private javax.swing.JLabel srce1;
    private javax.swing.JLabel trn;
    // End of variables declaration//GEN-END:variables
}
