package com.devkn8.questionario.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "qstn")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Questionario implements Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				codigoQuestionario;

	private String				nomeQuestionario;

	private Integer				codigoTipoQuestionario;

	private Integer				codigoSituacao;

	private String				objeto;

	private String				ajuda;

	private LocalDate			dataRegistro;
}
