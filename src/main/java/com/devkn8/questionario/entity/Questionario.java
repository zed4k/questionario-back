package com.devkn8.questionario.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.devkn8.questionario.enums.SituacaoQuestionarioEnum;
import com.devkn8.questionario.enums.TipoQuestionarioEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "qstn")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.ToString
public class Questionario implements Serializable {

	private static final long					serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_QSTN")
	private Integer								codigoQuestionario;

	@Column(name = "NM_QSTN", length = 254, nullable = false)
	private String								nomeQuestionario;

	@Column(name = "CD_TIP_QSTN", nullable = false)
	private Integer								codigoTipoQuestionario;

	@Column(name = "CD_EST_QSTN", nullable = false)
	private Integer								codigoSituacao;

	@Column(name = "TS_INC_VLDD_QSTN")
	private LocalDateTime						inicioValidade = LocalDateTime.now();

	@Column(name = "TS_FIM_VLDD_QSTN")
	private LocalDateTime						fimValidade;

	@Column(name = "TX_OBJT_QSTN", length = 1200)
	private String								objetivo;

	@Column(name = "TX_AJD_QSTN", length = 1200)
	private String								ajuda;

	@Column(name = "DT_REG_QSTN")
	private LocalDate							dataRegistro;

	@lombok.ToString.Exclude
	@lombok.EqualsAndHashCode.Exclude
	@OneToMany
	@JoinColumn(name = "CD_QSTN", updatable = false, insertable = false)
	private List<HistoricoSituacaoQuestionario>	situacoes;

	@lombok.ToString.Exclude
	@lombok.EqualsAndHashCode.Exclude
	@OneToMany
	@JoinColumn(name = "CD_QSTN", updatable = false, insertable = false)
	private List<GrupoItem>						gruposItem;

	public SituacaoQuestionarioEnum getSituacao() {
		return SituacaoQuestionarioEnum.getByCodigo(codigoSituacao);
	}

	public void setSituacao(SituacaoQuestionarioEnum situacao) {
		this.codigoSituacao = situacao != null ? situacao.codigo : SituacaoQuestionarioEnum.INDEFINIDO.codigo;
	}

	public TipoQuestionarioEnum getTipo() {
		return TipoQuestionarioEnum.getByCodigo(codigoTipoQuestionario);
	}

	public void setTipo(TipoQuestionarioEnum tipo) {
		this.codigoTipoQuestionario = tipo != null ? tipo.codigo : TipoQuestionarioEnum.INDEFINIDO.codigo;
	}
}
