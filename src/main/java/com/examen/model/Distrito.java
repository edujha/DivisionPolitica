package com.examen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
public class Distrito implements Serializable {

	private static final long serialVersionUID = 6789094262702066283L;

	@EmbeddedId
	protected DistritoPK pk;

	@Column(length = 100)
	private String nombre;

	@JoinColumns({
			@JoinColumn(name = "CODIGO_CANTON", referencedColumnName = "CODIGO_CANTON", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODIGO_PROVINCIA", referencedColumnName = "CODIGO_PROVINCIA", nullable = false, insertable = false, updatable = false) })
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Canton canton;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "distrito", fetch = FetchType.LAZY)
	private List<Padron> padronList;

	public Distrito(DistritoPK pk) {
		this.pk = pk;
	}
}
