package br.com.jntcruz.servico.Email.controller;

import br.com.jntcruz.servico.Email.Dto.EmailDto;
import br.com.jntcruz.servico.Email.service.SendEmailService;
import br.com.jntcruz.servico.Email.entity.Email;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final SendEmailService service;

    public EmailController(SendEmailService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<Email> sendEmail(@Valid @RequestBody EmailDto emailDto) {

        Email email = new Email();
        email.setEmailFrom(emailDto.getFrom());
        email.setEmailTo(emailDto.getTo());
        email.setTitle(emailDto.getTitle());
        email.setText(emailDto.getText());

        Email emailSent = service.send(email);
        return ResponseEntity.ok(emailSent);
    }
}
