package br.com.jntcruz.servico.Email.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Email {

    private String emailTo;
    private String emailFrom;
    private String title;
    private String text;
    private boolean send;
    private LocalDateTime sendDate;
}