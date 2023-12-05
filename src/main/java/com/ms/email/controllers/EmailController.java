package com.ms.email.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;

import jakarta.validation.Valid;

// Define a classe como um controller rest, que indica que os retornos dos métodos da classe devem ser usados diretamente como respostas HTTP
@RestController
public class EmailController {

	// Injeção de dependência do serviço EmailService
	@Autowired
	EmailService emailService;
	
	// Mapeia solicitações HTTP POST para "/sending-email"
	@PostMapping("/sending-email")
	// Método que processa solicitações de envio de e-mail
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){
		// Cria uma instância de EmailModel para armazenar os dados do e-mail
		EmailModel emailModel = new EmailModel();
		// Copia as propriedades do EmailDto para o EmailModel
		BeanUtils.copyProperties(emailDto, emailModel);
		// Chama o serviço para enviar o e-mail com base nos dados fornecidos
		emailService.sendEmail(emailModel);
		// Retorna uma resposta HTTP com o objeto EmailModel e status 201 (CREATED)
		return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
	}

}
