package com.devkn8.questionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devkn8.questionario.entity.Questionario;
import com.devkn8.questionario.entity.record.QuestionarioRecord;
import com.devkn8.questionario.service.QuestionarioService;
import com.devkn8.questionario.utils.Envelope;

@RestController
//@RequestMapping("/questionario")
public class QuestionarioController {

	@Autowired
	private QuestionarioService service;
	
	protected Questionario buscarQuestionario(Integer codigoQuestionario) {
		return service.buscarQuestionarioEntity(codigoQuestionario);
	}
	
	@GetMapping("/{codigoQuestionario}")
	public Envelope<QuestionarioRecord> buscarQuestionarioRecord(@PathVariable Integer codigoQuestionario) {
		return service.buscarQuestionarioRecord(codigoQuestionario);
	}
	
	@GetMapping("/listar")
	public Envelope<List<QuestionarioRecord>> listarQuestionarios() {
		return service.listarQuestionarios();
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
}
