package com.ms.email.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDto {// (Objeto de Transferência de Dados)

	@NotBlank // define como não nulo.
    private String ownerRef; // Referência do proprietário que enviou o e-mail.
	@NotBlank
	@Email // verifica se é um e-mail válido.
    private String emailFrom; // Endereço de e-mail do remetente.
	@NotBlank
	@Email
    private String emailTo; // Endereço de e-mail do destinatário.
	@NotBlank
    private String subject; // Título do e-mail.
	@NotBlank
    private String text; // Corpo do e-mail.
}
