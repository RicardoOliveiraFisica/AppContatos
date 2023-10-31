package br.com.ro.AppContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.ro.AppContatos.model.Pessoa;

public interface PessoaServiceInterface {
	Pessoa save(Pessoa pessoa);
	Optional<Pessoa> getById(Long id);
	List<Pessoa> getAll();
	Pessoa updateById(Long id, Pessoa pessoa);
	void delete(Long id);
}
