package com.examen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author edujh
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class CantonPK implements Serializable {

	private static final long serialVersionUID = -3859323091065125484L;

	@Basic(optional = false)
	@Column(name = "CODIGO_CANTON", nullable = false, length = 2)
	private String codigo;

	@Basic(optional = false)
	@Column(name = "CODIGO_PROVINCIA", nullable = false, length = 1)
	private String codigoProvincia;

	public CantonPK(String codigo, String codigoProvincia) {
		this.codigo = codigo;
		this.codigoProvincia = codigoProvincia;
	}

}
