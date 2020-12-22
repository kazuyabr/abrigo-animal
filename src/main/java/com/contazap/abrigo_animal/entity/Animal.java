package com.contazap.abrigo_animal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.contazap.abrigo_animal.util.enums.SaudeEnum;
import com.contazap.abrigo_animal.util.enums.TipoEnum;

import lombok.Data;

@Entity
@Data
@Table(name = "animal")
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1502953253710092729L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoEnum tipo;
	@NotNull
	private String nome;
	@NotNull
	@Column(name = "data_chegada")
	private Date dataChegada;
	@Column(name = "data_adocao")
	private Date dataAdocao;
	@NotNull
	@Enumerated(EnumType.STRING)
	private SaudeEnum saude;

	public Animal() {
		super();
	}

	public Animal(TipoEnum tipo) {
		super();
		this.tipo = tipo;
	}

	public Animal(TipoEnum tipo, String nome, Date dataChegada, Date dataAdocao, SaudeEnum saude) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.dataChegada = dataChegada;
		this.dataAdocao = dataAdocao;
		this.saude = saude;
	}

}
