package com.ms.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;

// Marca a classe como um serviço gerenciado pelo Spring
@Service
public class EmailService {

	// Injeção de dependência do repositório de e-mails
	@Autowired
	EmailRepository emailRepository;
	
	// Injeção de dependência do sender de e-mails do Spring
	@Autowired
	private JavaMailSender emailSender;

	// Método para enviar e-mails
	@SuppressWarnings("finally")
	public EmailModel sendEmail(EmailModel emailModel) {
		
		// Define a data de envio com o horário atual
		emailModel.setSendDateEmail(LocalDateTime.now());
		
		try {
			// Configura as propriedades do e-mail
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			
			// Envia o e-mail usando o JavaMailSender
			emailSender.send(message);
			
			// Atualiza o status do e-mail para "SENT" se o envio for bem-sucedido
			emailModel.setStatusEmail(StatusEmail.SENT);
			
		}catch (MailException e) {
			
			// Se ocorrer uma exceção durante o envio, define o status do e-mail como "ERROR"
			emailModel.setStatusEmail(StatusEmail.ERROR);
			
		}finally {
			
			// Salva o objeto EmailModel no banco de dados e retorna(enviado ou com erro)
			return emailRepository.save(emailModel);
			
		}
		
	}	
	
}
