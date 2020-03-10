package com.examen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
public class Canton implements Serializable {

	private static final long serialVersionUID = 3173712570028171138L;

	@EmbeddedId
	protected CantonPK pk;

	@Column(length = 50)
	private String nombre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "canton", fetch = FetchType.LAZY)
	private List<Distrito> distritoList;

	@JoinColumn(name = "CODIGO_PROVINCIA", referencedColumnName = "CODIGO_PROVINCIA", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Provincia provincia;

	public Canton(CantonPK pk) {
		this.pk = pk;
	}

}
