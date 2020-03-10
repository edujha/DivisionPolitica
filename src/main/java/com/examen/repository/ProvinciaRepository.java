package com.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, String> {

	 List<Provincia> findAllByNombreContaining(String nombre);
}
