package br.com.jntcruz.servico.Email.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {

    @NotBlank
    @Email
    private String from;

    @NotBlank
    @Email
    private String to;

    @NotBlank
    private String title;

    @NotBlank
    private String text;
}