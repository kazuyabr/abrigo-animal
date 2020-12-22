package com.contazap.abrigo_animal.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.contazap.abrigo_animal.entity.Animal;
import com.contazap.abrigo_animal.service.AnimalService;
import com.contazap.abrigo_animal.util.enums.SaudeEnum;

@Component
@EnableScheduling
public class VerificaStatusAnimal {

	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;
	private final long DOISMINUTOS = MINUTO * 2;
//	private final long HORA = MINUTO * 60;

	@Autowired
	private AnimalService service;

	@Scheduled(fixedDelay = DOISMINUTOS)
	public void verificaPorHora() {

		Animal animal = service.updateStatus();

		Random rand = new Random();

		System.out.println("Animal Saude Atual: " + animal.toString());

		int result = rand.nextInt(2) + 1;

		if (animal.getSaude().equals(SaudeEnum.SAUDAVEL)) {

			animal.setSaude(SaudeEnum.DOENTE);

		} else if (animal.getSaude().equals(SaudeEnum.DOENTE)) {
			if (result == 1)
				animal.setSaude(SaudeEnum.SAUDAVEL);
			if (result == 2)
				animal.setSaude(SaudeEnum.MORTO);
		}

		System.out.println("Animal Saude Atualizada: " + animal.toString());

		service.save(animal);

	}

}
