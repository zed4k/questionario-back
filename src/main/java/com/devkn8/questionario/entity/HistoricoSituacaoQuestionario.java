package com.devkn8.questionario.entity;

import java.time.LocalDateTime;

import com.devkn8.questionario.enums.SituacaoQuestionarioEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "est_qstn")
@IdClass(HistoricoSituacaoQuestionarioID.class)
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.ToString
@lombok.AllArgsConstructor
public class HistoricoSituacaoQuestionario {

	@Id
	@Column(name = "cd_qstn")
	private Integer			codigoQuestionario;

	@Id
	@Column(name = "cd_est_qstn")
	private Integer			codigoSituacao;

	@Id
	@Column(name = "dt_inc_est")
	private LocalDateTime	inicio;

	@Column(name = "dt_fim_est")
	private LocalDateTime	fim;

	@Column(name = "cd_usu_rsp_atl")
	private Integer			codigoUsuario;

	public SituacaoQuestionarioEnum getSituacao() {
		return SituacaoQuestionarioEnum.getByCodigo(codigoSituacao);
	}

	public void setSituacao(SituacaoQuestionarioEnum situacao) {
		this.codigoSituacao = situacao.codigo;
	}
}
