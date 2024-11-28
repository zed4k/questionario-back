package com.devkn8.questionario.entity.dto;

import java.time.LocalDateTime;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class HistoricoSituacaoQuestionarioDTO implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				codigoQuestionario;
	private Integer				codigoSituacao;
	private LocalDateTime		inicio;
	private LocalDateTime		fim;
	private Integer				codigoUsuario;
	private String				nomeSituacao;

}
