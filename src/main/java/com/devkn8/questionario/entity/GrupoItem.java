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
@Table(name = "gr_item")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class GrupoItem implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_gr_item")
	private Integer				codigoGrupo;

	@Column(name = "cd_qstn", nullable = false)
	private Integer				codigoQuestionario;

	@Column(name = "nr_ord_gr_item", nullable = false)
	private Integer				ordem				= 0;

	@Column(name = "nm_gr_item", nullable = false, length = 254)
	private String				nomeGrupo;

	@Column(name = "tx_ajd_gr_item", length = 1200)
	private String				ajuda;

	@Column(name = "in_utzo_gr_item", nullable = false, length = 1)
	private String				indicadorUso		= "S";

	@lombok.ToString.Exclude
	@lombok.EqualsAndHashCode.Exclude
	@OneToMany
	@JoinColumn(name = "cd_gr_item", updatable = false, insertable = false)
	private List<Item>			itens;

	public boolean isEmUso() {
		return "S".equalsIgnoreCase(indicadorUso);
	}

	public void setEmUso(boolean emUso) {
		indicadorUso = emUso ? "S" : "N";
	}
}
