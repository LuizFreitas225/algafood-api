package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.freitas.luiz.algafoodapi.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();
	Permissao buscar(Long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);
	
}
