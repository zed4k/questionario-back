package com.devkn8.questionario.entity.record;

import java.time.LocalDateTime;

public record HistoricoSituacaoQuestionarioRecord(Integer codigoQuestionario,
		Integer codigoSituacao,
		LocalDateTime inicio,
		LocalDateTime fim,
		Integer codigoUsuario,
		String nomeSituacao) {

}
