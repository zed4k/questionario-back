package com.devkn8.questionario.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkn8.questionario.dao.repository.HistoricoSituacaoQuestionarioRepository;
import com.devkn8.questionario.dao.repository.QuestionarioRepository;
import com.devkn8.questionario.entity.HistoricoSituacaoQuestionario;
import com.devkn8.questionario.entity.Questionario;

@Repository
public class QuestionarioDAO {

	@Autowired
	private QuestionarioRepository questionarioRepository;
	
	@Autowired
	private HistoricoSituacaoQuestionarioRepository historicoSituacaoQuestionarioRepository;
	
	/**
	 * @return
	 */
	public List<Questionario> listarQuestionarios() {
		return questionarioRepository.findAll();
	}

	/**
	 * @param codigo
	 * @return
	 */
	public Questionario buscarQuestionario(Integer codigo) {
		return questionarioRepository.findById(codigo).orElse(null);
	}

	/**
	 * @param questionario
	 * @return
	 */
	public Questionario salvarQuestionario(Questionario questionario) {
		return questionarioRepository.save(questionario);
	}
	
	/**
	 * @param codigo
	 */
	public void deletarQuestionario(Integer codigo) {
		questionarioRepository.deleteById(codigo);
	};

	/**
	 * @param hst
	 * @return
	 */
	public HistoricoSituacaoQuestionario salvarSituacaoQuestionarioRepository(HistoricoSituacaoQuestionario hst) {
		return historicoSituacaoQuestionarioRepository.save(hst);
	}

}
