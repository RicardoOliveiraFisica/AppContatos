package br.com.ro.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ro.AppContatos.model.Contato;
import br.com.ro.AppContatos.repository.ContatoRepository;
import br.com.ro.AppContatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface {
	
	private ContatoRepository contatoRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository =  contatoRepository;
	}
	
	@Override
	public Contato save(Contato contato) {
		return this.contatoRepository.save(contato);
	}

	@Override
	public Optional<Contato> getById(Long id) {
		return this.contatoRepository.findById(id);
	}

	@Override
	public List<Contato> getAll() {
		return this.contatoRepository.findAll();
	}

	@Override
	public Contato update(Contato contato) {
		Long id = contato.getId();
		Optional<Contato> upContato = this.contatoRepository.findById(id);
		if (upContato.isPresent()) {
			Contato newContato = upContato.get();;
			newContato.setPessoa(contato.getPessoa());
			newContato.setTipoContato(contato.getTipoContato());
			newContato.setContato(contato.getContato());
		}
		return contato;
	}

	@Override
	public void delete(Long id) {
		this.contatoRepository.deleteById(id);
	}

}
