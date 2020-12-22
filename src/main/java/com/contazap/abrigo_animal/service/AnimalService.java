package com.contazap.abrigo_animal.service;

import com.contazap.abrigo_animal.dto.AnimalDTO;
import com.contazap.abrigo_animal.entity.Animal;
import com.contazap.abrigo_animal.util.enums.TipoEnum;

public interface AnimalService {

	Animal save(Animal a);

	Animal addAnimal(AnimalDTO dto);

	Animal adoteAnimalOld(TipoEnum tipo);

	Animal updateStatus();

}
