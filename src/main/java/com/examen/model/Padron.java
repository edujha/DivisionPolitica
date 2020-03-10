package com.examen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edujh
 */
@Entity
public class Padron implements Serializable {

	private static final long serialVersionUID = 3976267515337390467L;

	@Getter
	@Setter
	@Id
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer cedula;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(nullable = false)
	private short sexo;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacaduc;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(nullable = false)
	private short junta;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(nullable = false, length = 50)
	private String nombre;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(nullable = false, length = 50)
	private String apellido1;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(nullable = false, length = 50)
	private String apellido2;

	@Getter
	@Setter
	@JoinColumns({ @JoinColumn(name = "CODIGO_DISTRITO", referencedColumnName = "CODIGO_DISTRITO", nullable = false),
			@JoinColumn(name = "CODIGO_CANTON", referencedColumnName = "CODIGO_CANTON", nullable = false),
			@JoinColumn(name = "CODIGO_PROVINCIA", referencedColumnName = "CODIGO_PROVINCIA", nullable = false) })
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Distrito distrito;

	public Padron() {
	}

	public Padron(Integer cedula) {
		this.cedula = cedula;
	}

	public Padron(Integer cedula, short sexo, Date fechacaduc, short junta, String nombre, String apellido1,
			String apellido2) {
		this.cedula = cedula;
		this.sexo = sexo;
		this.fechacaduc = fechacaduc;
		this.junta = junta;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
}
