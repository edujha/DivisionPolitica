package com.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.dto.SelectDTO;
import com.examen.service.DivisionPoliticaService;
import com.examen.utils.ObjectMapperUtils;

@RestController
@RequestMapping("estructura")
public class DivisionPoliticaController {

	@Autowired
	private DivisionPoliticaService divisionPoliticaService;

	@GetMapping("provincias")
	public List<SelectDTO> provincias(@RequestParam(required = false) String search) {
		return ObjectMapperUtils.mapAll(divisionPoliticaService.getProvincias(search), SelectDTO.class);
	}

	@GetMapping("cantones")
	public List<SelectDTO> cantones(@RequestParam(required = false) String search,
			@RequestParam(required = false) String codProvincia) {
		return ObjectMapperUtils.mapAll(divisionPoliticaService.getCantones(search, codProvincia), SelectDTO.class);
	}

	@GetMapping("distritos")
	public List<SelectDTO> distritos(@RequestParam(required = false) String search,
			@RequestParam(required = false) String codProvincia, @RequestParam(required = false) String codCanton) {
		return ObjectMapperUtils.mapAll(divisionPoliticaService.getDistritos(search, codProvincia, codCanton), SelectDTO.class);
	}

}
