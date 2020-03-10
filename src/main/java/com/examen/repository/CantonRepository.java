package com.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.model.Canton;
import com.examen.model.CantonPK;

@Repository
public interface CantonRepository extends JpaRepository<Canton, CantonPK> {
	List<Canton> findAllByProvinciaCodigo(String codigoProvincia);
	List<Canton> findAllByNombreContainingAndProvinciaCodigo(String nombre, String codigoProvincia);
}
