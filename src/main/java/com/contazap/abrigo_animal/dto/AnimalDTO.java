package com.contazap.abrigo_animal.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.contazap.abrigo_animal.util.enums.SaudeEnum;
import com.contazap.abrigo_animal.util.enums.TipoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnimalDTO {

	private Long id;
	@NotNull(message = "É necessario selecionar o tipo de animal")
//	@Pattern(regexp = "^(CACHORRO|GATO)$", message = "Para o tipo somente são aceitos os valores CACHORRO ou GATO")
	private TipoEnum tipo;
	@NotNull
	@Length(min = 3, message = "O nome do animal deve conter no min 3 caracteres")
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataChegada;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataAdocao;
	@NotNull(message = "É necessario indicar a saude do animal!")
//	@Pattern(regexp = "^(SAUDAVEL|DOENTE)$", message = "Para o tipo somente são aceitos os valores SAUDAVEL ou DOENTE")
	private SaudeEnum saude;

	public AnimalDTO(@NotNull(message = "É necessario selecionar o tipo de animal") TipoEnum tipo,
			@NotNull @Length(min = 3, message = "O nome do animal deve conter no min 3 caracteres") String nome,
			@NotNull Date dataChegada, Date dataAdocao,
			@NotNull(message = "É necessario indicar a saude do animal!") SaudeEnum saude) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.dataChegada = dataChegada;
		this.dataAdocao = dataAdocao;
		this.saude = saude;
	}

	public AnimalDTO() {
		super();
	}

	public AnimalDTO(
			@NotNull(message = "É necessario selecionar o tipo de animal") @Pattern(regexp = "^(CACHORRO|GATO)$", message = "Para o tipo somente são aceitos os valores CACHORRO ou GATO") TipoEnum tipo) {
		super();
		this.tipo = tipo;
	}

}
