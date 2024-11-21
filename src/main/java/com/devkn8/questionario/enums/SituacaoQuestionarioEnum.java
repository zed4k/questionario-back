package com.devkn8.questionario.enums;

import java.util.stream.Stream;

public enum SituacaoQuestionarioEnum {

	INDEFINIDO(0, "Indefinido"),
	EDICAO(1, "Edição"),
	REVISAO(2, "Revisão"),
	ATIVO(3, "Ativo"),
	DESATIVADO(4, "Desativado"),
	;
	
	public Integer codigo;
	public String nome;
	
	private SituacaoQuestionarioEnum(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public static SituacaoQuestionarioEnum getByCodigo(Integer codigo) {
		return Stream.of(SituacaoQuestionarioEnum.values())
				.filter(s -> s.codigo.equals(codigo))
				.findFirst()
				.orElse(null);
	}
}
