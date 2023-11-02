package br.com.ro.AppContatos.service.interfaces;

import java.util.Optional;

import br.com.ro.AppContatos.model.Contato;

public interface ContatoServiceInterface {
	Optional<Contato> getById(Long id);
	Contato updateById(Long id, Contato contato);
	void deleteById(Long id);

}
