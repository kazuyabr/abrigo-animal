package com.contazap.abrigo_animal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.contazap.abrigo_animal.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	@Query(value = "select * from animal where tipo = :tipo and saude = 'SAUDAVEL' and data_adocao is null order by data_chegada asc limit 1", nativeQuery = true)
	public Animal findAdotavel(@Param("tipo") String tipo);

	@Query(value = "select * from animal where saude = 'SAUDAVEL' or saude = 'DOENTE' order by RANDOM() limit 1", nativeQuery = true)
	public Animal selectRandom();

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update animal set saude = :saude where id = :id", nativeQuery = true)
	void updateStatusDb(@Param("id") Long id, @Param("saude") String saude);

}
