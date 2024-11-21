package com.devkn8.questionario.entity;

import java.time.LocalDateTime;

@lombok.EqualsAndHashCode
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class HistoricoSituacaoQuestionarioID {

	private Integer			codigoQuestionario;

	private Integer			codigoSituacao;

	private LocalDateTime	inicio;
}
