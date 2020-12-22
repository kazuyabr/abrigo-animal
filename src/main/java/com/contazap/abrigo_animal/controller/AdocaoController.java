package com.contazap.abrigo_animal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contazap.abrigo_animal.dto.AdotarDTO;
import com.contazap.abrigo_animal.dto.AnimalDTO;
import com.contazap.abrigo_animal.entity.Animal;
import com.contazap.abrigo_animal.service.AnimalService;
import com.contazap.abrigo_animal.util.Response;

@RestController
@RequestMapping("adocao")
public class AdocaoController {

	@Autowired
	private AnimalService service;

	@PostMapping()
	private ResponseEntity<Response<AnimalDTO>> addAnimal(@Valid @RequestBody AdotarDTO dto, BindingResult result) {

		Response<AnimalDTO> response = new Response<AnimalDTO>();

		System.out.println("Response: " + result.toString());

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Animal animal = service.adoteAnimalOld(dto.getTipo());

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
