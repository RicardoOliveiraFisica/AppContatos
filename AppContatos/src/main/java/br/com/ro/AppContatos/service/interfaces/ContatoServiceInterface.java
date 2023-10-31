package br.com.ro.AppContatos.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.ro.AppContatos.model.Contato;

public interface ContatoServiceInterface {
	Contato save (Contato contato);
	Optional<Contato> getById(Long id);
	List<Contato> getAll();
	Contato update(Contato contato);
	void delete(Long id);

}
