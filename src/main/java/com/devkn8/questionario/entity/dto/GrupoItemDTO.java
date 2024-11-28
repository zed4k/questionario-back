package com.devkn8.questionario.entity.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class GrupoItemDTO implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				codigoGrupo;
	private Integer				codigoQuestionario;
	private Integer				ordem;
	private String				nomeGrupo;
	private String				ajuda;
	private boolean				emUso;
	private List<ItemDTO>		itens;
}
