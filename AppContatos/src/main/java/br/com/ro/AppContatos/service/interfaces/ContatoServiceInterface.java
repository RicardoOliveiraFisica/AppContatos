package br.com.ro.AppContatos.service.interfaces;

import java.util.Optional;

import br.com.ro.AppContatos.model.Contato;

public interface ContatoServiceInterface {
	Contato save(Contato contato);
	Optional<Contato> getById(Long id);
	//List<Contato> getAllByIdPessoa(Pessoa pessoa);
	Contato updateById(Long id, Contato contato);
	void delete(Long id);

}
