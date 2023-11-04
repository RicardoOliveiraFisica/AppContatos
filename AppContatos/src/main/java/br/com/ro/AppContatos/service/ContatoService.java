package br.com.ro.AppContatos.service;

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
	public Optional<Contato> getById(Long id) {
		return this.contatoRepository.findById(id);
	}

	@Override
	public Contato updateById(Long id, Contato contato) {
		Optional<Contato> upContato = this.contatoRepository.findById(id);
		if (upContato.isPresent()) {
			Contato newContato = upContato.get();
			//mantem relacionamento pessoa sem atualizar
			
			if(contato.getTipoContato() != null)
				newContato.setTipoContato(contato.getTipoContato());
			
			if(contato.getContato() != null)
				newContato.setContato(contato.getContato());
			
			return this.contatoRepository.save(newContato);
		}
		return contato;
	}

	@Override
	public void deleteById(Long id) {
		this.contatoRepository.deleteById(id);
	}

}
