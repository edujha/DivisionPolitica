package com.examen.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.model.Canton;
import com.examen.model.Distrito;
import com.examen.model.Provincia;
import com.examen.repository.CantonRepository;
import com.examen.repository.DistritoRepository;
import com.examen.repository.ProvinciaRepository;

@Service
public class DivisionPoliticaService {

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	private CantonRepository cantonRepository;

	@Autowired
	private DistritoRepository distritoRepository;

	public List<Provincia> getProvincias(String nombre) {
		if (StringUtils.isNotEmpty(nombre)) {
			return provinciaRepository.findAllByNombreContaining(nombre);
		} else {
			return provinciaRepository.findAll();
		}
	}

	public List<Canton> getCantones(String nombre, String codigoProvincia) {
		if (StringUtils.isNotEmpty(nombre)) {
			return cantonRepository.findAllByNombreContainingAndProvinciaCodigo(nombre, codigoProvincia);
		} else {
			return cantonRepository.findAllByProvinciaCodigo(codigoProvincia);
		}
	}

	public List<Distrito> getDistritos(String nombre, String codigoProvincia, String codigoCanton) {
		if (StringUtils.isNotEmpty(nombre)) {
			return distritoRepository.findAllByNombreContainingAndCantonPkCodigoAndCantonPkCodigoProvincia(nombre,
					codigoCanton, codigoProvincia);
		} else {
			return distritoRepository.findAllByCantonPkCodigoAndCantonPkCodigoProvincia(codigoCanton, codigoProvincia);
		}
	}

}
