package com.devkn8.questionario.enums;

import java.util.Arrays;

public enum TipoQuestionarioEnum {

	INDEFINIDO(0, "Indefinido"),
	PADRAO(1, "Padrão"),
	;

	public final Integer	codigo;
	public final String		nome;

	TipoQuestionarioEnum(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public static TipoQuestionarioEnum getByCodigo(Integer codigo) {
		return Arrays.stream(TipoQuestionarioEnum.values())
				.filter(t -> t.codigo.equals(codigo))
				.findFirst()
				.orElse(null);
	}
}
