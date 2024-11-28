package com.devkn8.questionario.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "gr_sitm_qstn")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class GrupoSubitem implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_gr_sitm")
	private Integer				codigoGrupoSubitem;

	@Column(name = "cd_item", nullable = false)
	private Integer				codigoItem;

	@Column(name = "nr_ord_gr_sitm", nullable = false)
	private Integer				ordem				= 0;

	@Column(name = "cd_tip_gr_sitm", nullable = false)
	private Integer				codigoTipoGrupoSubitem;

	@Column(name = "tx_gr_sitm", length = 254, nullable = false)
	private String				textoGrupoSubitem;

	@Column(name = "in_utzo_gr_sitm", length = 1, nullable = false)
	private String				indicadorUso		= "S";

	@lombok.ToString.Exclude
	@lombok.EqualsAndHashCode.Exclude
	@OneToMany
	@JoinColumn(name = "cd_gr_sitm", updatable = false, insertable = false)
	private List<Subitem>		subitens;

	public boolean isEmUso() {
		return "S".equalsIgnoreCase(indicadorUso);
	}

	public void setEmUso(boolean emUso) {
		indicadorUso = emUso ? "S" : "N";
	}
}
