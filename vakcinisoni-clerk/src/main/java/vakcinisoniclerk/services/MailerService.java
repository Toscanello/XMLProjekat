package vakcinisoniclerk.services;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Properties;

@Service
public class MailerService {



    public static JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("baronimndjr@gmail.com");
        mailSender.setPassword("baroni123");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public static String sendAcceptedMail(String email, String name, String attachment) {

        MimeMessage message = getJavaMailSender().createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("baronimndjr@gmail.com");
            helper.setTo(email);
            helper.setSubject("Zahtev za izdavanje digitalnog sertifikata");
            helper.setText("Postovani " + name + ",\n\nVas zahtev za digitalni sertifikat je prihvacen! Ispod se nalazi " +
                    "vas digitalni sertifikat koji mozete da skinete.\n\nSrdacan pozdrav, \nVakcinisoni");
            FileSystemResource file = new FileSystemResource("/home/svetozar/Pictures/motor.jpg");
            helper.addAttachment(Objects.requireNonNull(file.getFilename()), file);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        getJavaMailSender().send(message);
        return "success";
    }

    public static String sendDeclineMail(String email, String name, String declineDescription) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("baronimndjr@gmail.com");
        message.setTo(email);
        message.setSubject("Zahtev za izdavanje digitalnog sertifikata");
        message.setText("Postovani " + name + ",\n\nNa zalost moramo da Vas obavestimo da je Vas zahtev za izdavanje " +
                "digitalnog sertifikata odbijen. Razlog odbijanja mozete videti u teksu ispod:\n\n" +
                "" + declineDescription + " \n\nSrdacan pozdrav, \nVakcinisoni");
        getJavaMailSender().send(message);
        return "success";
    }


}
