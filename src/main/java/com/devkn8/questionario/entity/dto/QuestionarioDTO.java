package com.devkn8.questionario.entity.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class QuestionarioDTO implements java.io.Serializable {

	private static final long						serialVersionUID	= 1L;

	private Integer									codigoQuestionario;
	private String									nomeQuestionario;
	private Integer									codigoTipoQuestionario;
	private Integer									codigoSituacao;
	private LocalDateTime							inicioValidade;
	private LocalDateTime							fimValidade;
	private String									objetivo;
	private String									ajuda;
	private LocalDate								dataRegistro;
	private String									nomeTipo;
	private String									nomeSituacao;
	private List<HistoricoSituacaoQuestionarioDTO>	situacoes;
	private List<GrupoItemDTO>						grupos;
}
