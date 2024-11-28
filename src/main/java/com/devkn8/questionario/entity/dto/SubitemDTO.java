package com.devkn8.questionario.entity.dto;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class SubitemDTO implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						codigoGrupoSubitem;
	Integer						codigoSubitem;
	Integer						ordem;
	String						textoSubitem;
	Integer						pontos;
}
