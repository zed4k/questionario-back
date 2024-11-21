package com.devkn8.questionario.utils;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.ToString
@lombok.AllArgsConstructor
public class Envelope<T> {

	private T objeto;
	private String mensagem;
	private boolean ok = true;

	public Envelope(T objeto) {
		super();
		this.objeto = objeto;
	}

}
