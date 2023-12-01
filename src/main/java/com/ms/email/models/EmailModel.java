package com.ms.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ms.email.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marca a classe como uma entidade JPA, mapeando-a para uma tabela no banco de dados.
@Table(name = "TB_EMAIL") // Especifica o nome da tabela no banco de dados.
public class EmailModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // Marca o campo como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera automaticamente o valor da chave primária.
    private Long emailId; // Identificador único do e-mail na tabela.

    private String ownerRef; // Referência do proprietário que enviou o e-mail.
    private String emailFrom; // Endereço de e-mail do remetente.
    private String emailTo; // Endereço de e-mail do destinatário.
    private String subject; // Título do e-mail.

    // Define que o campo deve ser como um tipo de dado TEXT no banco de dados para suportar textos maiores.
    @Column(columnDefinition = "TEXT")
    private String text; // Corpo do e-mail.

    private LocalDateTime sendDateEmail; // Data e hora que o e-mail foi enviado.
    private StatusEmail statusEmail; // Status do e-mail (enviado ou com erro).

    // Construtores
    public EmailModel() {} // Construtor padrão vazio.
    public EmailModel(String ownerRef, String emailFrom, String emailTo, String subject, String text,
            LocalDateTime sendDateEmail, StatusEmail statusEmail) {
        // Construtor que recebe parâmetros para inicializar os campos da classe.
    	
        this.ownerRef = ownerRef;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }

    // Getters e setters
    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getOwnerRef() {
        return ownerRef;
    }

    public void setOwnerRef(String ownerRef) {
        this.ownerRef = ownerRef;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
