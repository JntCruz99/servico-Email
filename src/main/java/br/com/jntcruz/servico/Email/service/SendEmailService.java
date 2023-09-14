package br.com.jntcruz.servico.Email.service;

import br.com.jntcruz.servico.Email.entity.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class SendEmailService {

    private final JavaMailSender javaMailSender;

    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public Email send(Email email) {
        log.info("Sending email");

        var message = new SimpleMailMessage();
        message.setTo(email.getEmailTo());
        message.setSubject(email.getTitle());
        message.setText(email.getText());


        javaMailSender.send(message);

        log.info("Email successfully sent!");
        email.setSend(true);
        email.setSendDate(LocalDateTime.now());
        return email;
    }
}
