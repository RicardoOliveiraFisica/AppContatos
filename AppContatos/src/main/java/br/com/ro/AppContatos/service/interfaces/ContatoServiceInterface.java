package br.com.ro.AppContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.ro.AppContatos.model.Contato;
import br.com.ro.AppContatos.model.Pessoa;

public interface ContatoServiceInterface {
	Contato save(Long idPessoa, Contato contato);
	Optional<Contato> getById(Long id);
	List<Contato> getAllByPessoa(Long idPessoa);
	Contato updateById(Long id, Contato contato);
	void delete(Long id);

}
