package com.freitas.luiz.algafoodapi.jpa;

import com.algaworks.algafood.domain.repository.PermissaoRepository;
import com.freitas.luiz.algafoodapi.AlgafoodApiApplication;
import com.freitas.luiz.algafoodapi.domain.model.Permissao;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaPermissaoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		List<Permissao> todasPermissoes = permissaoRepository.listar();
		
		for (Permissao permissao : todasPermissoes) {
			System.out.printf("%s - %s\n", permissao.getNome(), permissao.getDescricao());
		}
	}
	
}
