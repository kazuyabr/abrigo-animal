package com.contazap.abrigo_animal.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contazap.abrigo_animal.dto.AnimalDTO;
import com.contazap.abrigo_animal.entity.Animal;
import com.contazap.abrigo_animal.repository.AnimalRepository;
import com.contazap.abrigo_animal.service.AnimalService;
import com.contazap.abrigo_animal.util.enums.TipoEnum;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	AnimalRepository repository;

	@Override
	public Animal addAnimal(AnimalDTO dto) {

		Animal animal = new Animal(dto.getTipo(), dto.getNome(), new Date(), null, dto.getSaude());

		return repository.save(animal);
	}

	@Override
	public Animal adoteAnimalOld(TipoEnum tipo) {

		Animal animal = repository.findAdotavel(tipo.getValue().toString().toUpperCase());

		LocalDateTime now = LocalDateTime.now();

		animal.setDataAdocao(Timestamp.valueOf(now));

		repository.save(animal);

		return animal;
	}

	@Override
	public Animal updateStatus() {

		Animal animal = repository.selectRandom();

		return animal;
	}

	@Override
	public Animal save(Animal a) {
		return repository.save(a);
	}

}
