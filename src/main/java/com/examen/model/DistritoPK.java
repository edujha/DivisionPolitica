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
public class DistritoPK implements Serializable {

	private static final long serialVersionUID = 5068244181400422879L;

	@Basic(optional = false)
	@Column(name = "CODIGO_DISTRITO", nullable = false, length = 3)
	private String codigo;

	@Basic(optional = false)
	@Column(name = "CODIGO_CANTON", nullable = false, length = 2)
	private String codigoCanton;

	@Basic(optional = false)
	@Column(name = "CODIGO_PROVINCIA", nullable = false, length = 1)
	private String codigoProvincia;

	public DistritoPK(String codigo, String codigoCanton, String codigoProvincia) {
		this.codigo = codigo;
		this.codigoCanton = codigoCanton;
		this.codigoProvincia = codigoProvincia;
	}
}
