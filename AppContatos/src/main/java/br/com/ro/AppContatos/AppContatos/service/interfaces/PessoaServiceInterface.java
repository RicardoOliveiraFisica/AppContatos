package br.com.ro.AppContatos.AppContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.ro.AppContatos.AppContatos.model.Pessoa;

public interface PessoaServiceInterface {
	Pessoa save(Pessoa pessoa);
	Optional<Pessoa> getById(Long id);
	List<Pessoa> getAll();
	Pessoa update(Pessoa pessoa);
	void delete(Long id);
}
