package br.com.ro.AppContatos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ro.AppContatos.model.Contato;
import br.com.ro.AppContatos.model.Pessoa;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	List<Optional<Contato>> findAllByPessoa(Pessoa pessoa);
}
