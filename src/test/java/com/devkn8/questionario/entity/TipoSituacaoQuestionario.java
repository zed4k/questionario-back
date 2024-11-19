package com.devkn8.questionario.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tip_est_qstn")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TipoSituacaoQuestionario implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				codigoTipoSituacao;

	private String				codigoNomeSituacao;

}
