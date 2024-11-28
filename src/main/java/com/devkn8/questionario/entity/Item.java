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
@Table(name = "item")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class Item implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_item")
	private Integer				codigoItem;

	@Column(name = "cd_gr_item", nullable = false)
	private Integer				codigoGrupo;

	@Column(name = "nr_ord_item", nullable = false)
	private Integer				ordem				= 0;

	@Column(name = "tx_item", nullable = false, length = 1200)
	private String				descricaoItem;

	@Column(name = "tx_ajd_item", length = 1200)
	private String				ajuda;

	@Column(name = "in_utzo_item", nullable = false, length = 1)
	private String				indicadorUso		= "S";

	@lombok.ToString.Exclude
	@lombok.EqualsAndHashCode.Exclude
	@OneToMany
	@JoinColumn(name = "cd_item", updatable = false, insertable = false)
	private List<GrupoSubitem>	gruposSubitem;

	public boolean isEmUso() {
		return "S".equalsIgnoreCase(indicadorUso);
	}

	public void setEmUso(boolean emUso) {
		indicadorUso = emUso ? "S" : "N";
	}
}
