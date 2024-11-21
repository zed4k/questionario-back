package com.devkn8.questionario.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkn8.questionario.dao.QuestionarioDAO;
import com.devkn8.questionario.entity.HistoricoSituacaoQuestionario;
import com.devkn8.questionario.entity.Questionario;
import com.devkn8.questionario.entity.record.QuestionarioRecord;
import com.devkn8.questionario.enums.SituacaoQuestionarioEnum;
import com.devkn8.questionario.utils.Envelope;
import com.devkn8.questionario.utils.QuestionarioUtils;

import jakarta.transaction.Transactional;

@Service
public class QuestionarioService {

	@Autowired
	private QuestionarioDAO		dao;

	@Autowired
	private QuestionarioUtils	utils;

	/**
	 * @return
	 */
	public Envelope<List<QuestionarioRecord>> listarQuestionarios() {
		List<Questionario> lista = dao.listarQuestionarios();

		if (lista == null || lista.isEmpty()) {
			return new Envelope<>(null, "Nenhum questionário encontrado", false);
		}

		List<QuestionarioRecord> records = lista.stream()
				.map(q -> utils.buildQuestionarioRecord(q))
				.toList();

		return new Envelope<>(records);
	}

	/**
	 * @param codigo
	 * @return
	 */
	public Envelope<QuestionarioRecord> buscarQuestionarioRecord(Integer codigo) {
		Questionario q = buscarQuestionarioEntity(codigo);

		if (q == null) {
			return new Envelope<>(null, "Questionário não encontrado com o código " + codigo, false);
		}

		return new Envelope<>(utils.buildQuestionarioRecord(q));
	}

	/**
	 * @param qr
	 * @return
	 */
	@Transactional
	public Envelope<Integer> incluirQuestionario(QuestionarioRecord qr) {
		Questionario q = utils.buildQuestionario(qr);
		q = dao.salvarQuestionario(q);

		incluirHistoricoSituacaoQuestionario(q.getCodigoQuestionario(), SituacaoQuestionarioEnum.EDICAO);
		return new Envelope<Integer>(q.getCodigoQuestionario());
	}

	/**
	 * @param codigoQuestionario
	 * @param situacao
	 */
	@Transactional
	public void incluirHistoricoSituacaoQuestionario(Integer codigoQuestionario,
			SituacaoQuestionarioEnum situacao) {
		HistoricoSituacaoQuestionario hst = new HistoricoSituacaoQuestionario();
		hst.setCodigoQuestionario(codigoQuestionario);
		hst.setCodigoSituacao(situacao != null ? situacao.codigo : SituacaoQuestionarioEnum.INDEFINIDO.codigo);
		hst.setInicio(LocalDateTime.now());
		hst.setCodigoUsuario(6666);
		dao.salvarSituacaoQuestionarioRepository(hst);
	}

	/**
	 * @param codigo
	 * @return
	 */
	public Questionario buscarQuestionarioEntity(Integer codigo) {
		return dao.buscarQuestionario(codigo);
	}
}
