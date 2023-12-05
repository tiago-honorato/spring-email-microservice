package com.ms.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.email.models.EmailModel;

								//<entidade gerenciada, tipo da chave primária dessa entidade>
public interface EmailRepository extends JpaRepository<EmailModel, Long> {

	//Permite usar os métodos CRUD básicos do JpaRepository para a entidade EmailModel
	
}
