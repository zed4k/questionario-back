package com.devkn8.questionario.entity.record;

import java.time.LocalDate;
import java.util.List;

public record QuestionarioRecord(Integer codigoQuestionario,
		String nomeQuestionario,
		Integer codigoTipoQuestionario,
		Integer codigoSituacao,
		String objeto,
		String ajuda,
		LocalDate dataRegistro,
		String nomeTipo,
		String nomeSituacao,
		List<HistoricoSituacaoQuestionarioRecord> situacoes) {

	/**
	 * @param codigoQuestionario
	 * @param nomeQuestionario
	 * @param codigoTipoQuestionario
	 * @param codigoSituacao
	 * @param objeto
	 * @param ajuda
	 */
	public QuestionarioRecord(Integer codigoQuestionario,
			String nomeQuestionario,
			Integer codigoTipoQuestionario,
			Integer codigoSituacao,
			String objeto,
			String ajuda) {

		this(codigoQuestionario, nomeQuestionario, codigoTipoQuestionario, codigoSituacao, objeto, ajuda, null, null,
				null, null);
	}
}
