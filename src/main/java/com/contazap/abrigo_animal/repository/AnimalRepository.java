package com.contazap.abrigo_animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.contazap.abrigo_animal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	@Query(value = "select * from animal where tipo = :tipo and saude = 'SAUDAVEL' and data_adocao is null order by data_chegada asc limit 1", nativeQuery = true)
	Animal findAdotavel(@Param("tipo") String tipo);

	@Query(value = "select * from animal where saude = 'SAUDAVEL' or saude = 'DOENTE' order by RANDOM() limit 1", nativeQuery = true)
	Animal selectRandom();

}
