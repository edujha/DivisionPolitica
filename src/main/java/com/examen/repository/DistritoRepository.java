package com.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.model.Distrito;
import com.examen.model.DistritoPK;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, DistritoPK> {

	List<Distrito> findAllByCantonPkCodigoAndCantonPkCodigoProvincia(String codigoCanton, String codigoProvincia);

	List<Distrito> findAllByNombreContainingAndCantonPkCodigoAndCantonPkCodigoProvincia(String nombre,
			String codigoCanton, String codigoProvincia);

}
