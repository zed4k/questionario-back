package com.devkn8.questionario.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sitm_qstn")
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString
public class Subitem implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_sitm")
	private Integer				codigoSubitem;

	@Column(name = "cd_gr_sitm", nullable = false)
	private Integer				codigoGrupoSubitem;

	@Column(name = "nr_ord_sitm", nullable = false)
	private Integer				ordem				= 0;

	@Column(name = "tx_sitm", nullable = false, length = 254)
	private String				textoSubitem;

	@Column(name = "vl_inc_itvl_sitm")
	private double				valorInicial = 0d;

	@Column(name = "vl_fimc_itvl_sitm")
	private double				valorFinal = 0d;

	@Column(name = "qt_pto_sitm")
	private Integer				pontos = 0;

}
