package com.devkn8.questionario.entity.dto;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class GrupoSubitemDTO implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private Integer				codigoGrupoSubitem;
	private Integer				codigoItem;
	private Integer				codigoTipoGrupoSubitem;
	private Integer				ordem;
	private boolean				emUso;
	private String				textoGrupoSubitem;
	private List<SubitemDTO>	subitens;
}
