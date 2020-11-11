package com.backend.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.demo.modelo.ImpactoDirecto;

public interface RImpactoDirecto extends CrudRepository<ImpactoDirecto, Integer> {
	@Query("SELECT r from ImpactoDirecto r WHERE r.id_propuesta_cambio = :id_propuestaCambio")
	List<ImpactoDirecto> findAllByid_propuestaCambio(Integer id_propuestaCambio);
	
	@Query("SELECT r from ImpactoDirecto r WHERE r.id_requerimiento = :id_requerimiento")
	List<ImpactoDirecto> findAllByid_requerimiento(Integer id_requerimiento);
	
}
