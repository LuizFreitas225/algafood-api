package com.freitas.luiz.algafoodapi.domain.repository;

import com.freitas.luiz.algafoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

	List<Estado> listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Estado estado);
	
}
