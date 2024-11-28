package com.devkn8.questionario.entity.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class ItemDTO implements java.io.Serializable {

	private static final long		serialVersionUID	= 1L;

	private Integer					codigoItem;
	private Integer					codigoGrupo;
	private Integer					ordem;
	private String					descricaoItem;
	private String					ajuda;
	private boolean					emUso;
	private List<GrupoSubitemDTO>	gruposSubitem;

}
