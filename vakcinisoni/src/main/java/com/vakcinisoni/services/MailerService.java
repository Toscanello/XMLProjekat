package com.vakcinisoni.services;

import com.vakcinisoni.models.Term;
import com.vakcinisoni.models.VaccineCandidate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailerService {

    public static JavaMailSender getJavaMailSender(){
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

    public static void sendConfirmationEmailToVaccineCandidate(VaccineCandidate candidate, Term term, String attachment){
        MimeMessage message = getJavaMailSender().createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("baronimndjr@gmail.com");
            helper.setTo(candidate.getEmail());
            helper.setSubject("Interesovanje za vakcinu");
            helper.setText("Postovani " + candidate.getName() + "\n\nPodneli ste prijavu za vakcinaciju.\n\nNa pukntu za vakcinaciju" +
                    " se mozete pojaviti u navedenom terminu na mestu za vrsenje imunizacije u " + candidate.getLocation() +
                    "\nVase informacije\n" + candidate.toString() + "\n\n" + term.toString());
        }catch (MessagingException e){
            e.printStackTrace();
        }
        getJavaMailSender().send(message);
    }

    public static void sendEmailForNewTerm(Term term, String email, String name){
        MimeMessage message = getJavaMailSender().createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("baronimndjr@gmail.com");
            helper.setTo(email);
            helper.setSubject("Novi termin za sledeću vakcinaciju");
            helper.setText("Postovani " + name + "\n\nVaš novi termin za vakcinaciju je" + term.toString());
        }catch (MessagingException e){
            e.printStackTrace();
        }
        getJavaMailSender().send(message);
    }
}
