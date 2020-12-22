package com.contazap.abrigo_animal.dto;

import javax.validation.constraints.NotNull;

import com.contazap.abrigo_animal.util.enums.TipoEnum;

import lombok.Data;

@Data
public class AdotarDTO {

	@NotNull(message = "É necessario selecionar o tipo de animal")
//	@Pattern(regexp = "^(CACHORRO|GATO)$", message = "Para o tipo somente são aceitos os valores CACHORRO ou GATO")
	private TipoEnum tipo;

}
