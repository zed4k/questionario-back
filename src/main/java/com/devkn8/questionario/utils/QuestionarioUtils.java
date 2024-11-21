package com.devkn8.questionario.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.devkn8.questionario.entity.Questionario;
import com.devkn8.questionario.entity.record.HistoricoSituacaoQuestionarioRecord;
import com.devkn8.questionario.entity.record.QuestionarioRecord;

@Component
public class QuestionarioUtils {

	/**
	 * @param qr
	 * @return
	 */
	public Questionario buildQuestionario(QuestionarioRecord qr) {
		Questionario q = new Questionario();
		q.setCodigoQuestionario(qr.codigoQuestionario());
		q.setNomeQuestionario(qr.nomeQuestionario());
		q.setCodigoTipoQuestionario(qr.codigoTipoQuestionario());
		q.setCodigoSituacao(qr.codigoSituacao());
		q.setObjeto(qr.objeto());
		q.setAjuda(qr.ajuda());
		q.setDataRegistro(qr.dataRegistro());
		return q;
	}

	/**
	 * @param q
	 * @return
	 */
	public QuestionarioRecord buildQuestionarioRecord(Questionario q) {
		String nomeTipo = q.getTipo() != null ? q.getTipo().getNome() : null;
		String nomeSituacao = q.getSituacao() != null ? q.getSituacao().getNome() : null;
		
		List<HistoricoSituacaoQuestionarioRecord> situacoes = q.getSituacoes().stream()
				.map(h -> new HistoricoSituacaoQuestionarioRecord(h.getCodigoQuestionario(),
						h.getCodigoSituacao(),
						h.getInicio(),
						h.getFim(),
						h.getCodigoUsuario(),
						h.getSituacao().getNome()))
				.collect(Collectors.toList());

		return new QuestionarioRecord(q.getCodigoQuestionario(),
				q.getNomeQuestionario(),
				q.getCodigoTipoQuestionario(),
				q.getCodigoSituacao(),
				q.getObjeto(),
				q.getAjuda(),
				q.getDataRegistro(),
				nomeTipo,
				nomeSituacao,
				situacoes);
	}
}
