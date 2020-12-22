package com.contazap.abrigo_animal.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contazap.abrigo_animal.dto.AnimalDTO;
import com.contazap.abrigo_animal.entity.Animal;
import com.contazap.abrigo_animal.service.AnimalService;
import com.contazap.abrigo_animal.util.Response;
import com.contazap.abrigo_animal.util.enums.SaudeEnum;

@RestController
@RequestMapping("recepcao")
public class RecepcaoController {

	@Autowired
	private AnimalService service;

	@PostMapping()
	private ResponseEntity<Response<AnimalDTO>> addAnimal(@Valid @RequestBody AnimalDTO dto) {

		Response<AnimalDTO> response = new Response<AnimalDTO>();

		if (dto.getSaude().equals(SaudeEnum.MORTO)) {
			List<String> errs = new ArrayList<String>();
			errs.add("Um animal morto não pode ser adicionado ao abrigo");
			response.setErrors(errs);
			return ResponseEntity.ok().body(response);
		}

		LocalDateTime now = LocalDateTime.now();

		dto.setDataChegada(Timestamp.valueOf(now));

		Animal animal = service.addAnimal(dto);

		AnimalDTO convertedDTO = this.convertEntityToDto(animal);

		response.setData(convertedDTO);

		return ResponseEntity.ok().body(response);

	}

	private AnimalDTO convertEntityToDto(Animal a) {
		AnimalDTO dto = new AnimalDTO();
		dto.setId(a.getId());
		dto.setNome(a.getNome());
		dto.setTipo(a.getTipo());
		dto.setSaude(a.getSaude());
		dto.setDataChegada(a.getDataChegada());
		dto.setDataAdocao(a.getDataAdocao());

		return dto;
	}

}
