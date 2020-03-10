package com.examen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author edujh
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Provincia implements Serializable {

	private static final long serialVersionUID = -2846660404418038834L;

	@Id
	@Basic(optional = false)
	@Column(name = "CODIGO_PROVINCIA", nullable = false, length = 1)
	private String codigo;

	@Column(length = 50)
	private String nombre;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia", fetch = FetchType.LAZY)
	private List<Canton> cantonList;

	public Provincia(String codigo) {
		this.codigo = codigo;
	}

}
