/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railway_Reservation_system;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.awt.HeadlessException;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author shoum
 */
public class SendEmail {
public boolean send_email(String to, String subject ,String message)// send_email(TO, SUBJECT,MESSAGE)
    {
        System.out.println("Sending Email to "+to);
        try {
            String host = "smtp.gmail.com";
            String user = "legend.avatar.2004@gmail.com";
            String pass1 = "qmvm mtsv zdac mcbi";                          

            Properties pros = new Properties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.host", host);
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.required", "true");

            Session mailSession = Session.getInstance(pros, new jakarta.mail.Authenticator() 
            {
                @Override
                protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() 
                {
//                    return new jakarta.mail.PasswordAuthentication(user, pass);
                    return new jakarta.mail.PasswordAuthentication(user, pass1);
                }
            });

            mailSession.setDebug(false);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(message.concat("\nFor any complaint(s), passengers may call on toll free no.1800111321."));

            Transport.send(msg);

            JOptionPane.showMessageDialog(null, "Mail sended succesfully\nCheck your email");
            return true;
        } 
        catch (jakarta.mail.SendFailedException e)
        {
            JOptionPane.showMessageDialog(null, "Invalid email address");
            System.out.println(e);
            return false;
        }
        catch (MessagingException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Email send problem occurred!!");
            System.out.println(e);
            return false;
        }
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Email send problem occurred!!");
            System.out.println(e);
            return false;
        }
    }



    public static void main(String ar[])
    {
       
    }
            
}
