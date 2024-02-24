/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Random;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static java.lang.Math.abs;
import java.util.Base64;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import model.Customer;

public class SendEmail {

    public String getRandom() {
        int length = 6;
        Random rand = new Random();
        StringBuilder captchaStringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = abs(rand.nextInt()) % 62;
            int charNumber = 0;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            } else if (baseCharNumber < 52) {
                charNumber = 97 + (baseCharNumber - 26);
            } else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuilder.append((char) charNumber);
        }

        return captchaStringBuilder.toString();

    }

    public boolean sendEmail(Customer customer) {
        boolean test = false;
        String fromEmail = "thinhcche171897@fpt.edu.vn";
        String password = "npce woyb wuie ebtx";

        String toEmail = customer.getEmail();
        try {
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pr.put("mail.smtp.ssl.checkserveridentity", true);
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            mess.setSubject("User Email Verification");
            //    mess.setText("Succesfuly:   "+ customer.getCode());
            mess.setContent("không chia sẻ mã này cho bất cứ ai\nvui lòng nhập mã xác thực này vào ô mã xác thực:   " + customer.getCode(), "text/plain; charset=UTF-8");

            Transport.send(mess);

            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;

    }

    public void register(String toEmail, String CustomerID) {
        String fromEmail = "thinhcche171897@fpt.edu.vn";
        String password = "npce woyb wuie ebtx";

        try {
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pr.put("mail.smtp.ssl.checkserveridentity", true);
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

    // Tạo một phần tử MimeMessage
    Message mess = new MimeMessage(session);

    // Thiết lập người gửi, người nhận và tiêu đề email
    mess.setFrom(new InternetAddress(fromEmail));
    mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//    mess.setSubject("Mở khóa tài khoản ");
String emailTitle = MimeUtility.encodeText("Mở khóa tài khoản", "UTF-8", "B");
mess.setSubject(emailTitle);

    MimeMultipart multipart = new MimeMultipart();

    // Tạo một phần tử MimeBodyPart để chứa nội dung email
    MimeBodyPart messageBodyPart = new MimeBodyPart();

    // Thiết lập nội dung email với mã hóa UTF-8
    String resetLink = "http://localhost:9999/insurancecontract/ChangePasswordFirstTime.jsp?customerid=" + CustomerID;
    String emailContent = "Nhấp vào liên kết sau để thiết lập lại mật khẩu của bạn: " + resetLink;
    messageBodyPart.setText(emailContent, "UTF-8");

    // Thêm phần tử MimeBodyPart vào phần tử MimeMultipart
    multipart.addBodyPart(messageBodyPart);

    // Đặt phần tử MimeMultipart là nội dung của email
    mess.setContent(multipart);

    // Gửi email
    Transport.send(mess);

    System.out.println("Gửi email thiết lập mật khẩu thành công.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
