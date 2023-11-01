package br.com.ro.AppContatos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ro.AppContatos.model.Contato;
import br.com.ro.AppContatos.model.Pessoa;
import br.com.ro.AppContatos.repository.ContatoRepository;
import br.com.ro.AppContatos.repository.PessoaRepository;
import br.com.ro.AppContatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface {
	
	private ContatoRepository contatoRepository;
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository) {
		this.contatoRepository =  contatoRepository;
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public Contato save(Long idPessoa, Contato contato) {
		Optional<Pessoa> opPessoa = this.pessoaRepository.findById(idPessoa);
		if (opPessoa.isPresent()) {
			Pessoa pessoa = opPessoa.get();
			contato.setPessoa(pessoa);
			return this.contatoRepository.save(contato);
		}
		return contato;
	}

	@Override
	public Optional<Contato> getById(Long id) {
		return this.contatoRepository.findById(id);
	}


	@Override
	public List<Contato> getAllByPessoa(Long idPessoa) {
		Optional<Pessoa> opPessoa = this.pessoaRepository.findById(idPessoa);
		if (opPessoa.isPresent()) {
			Pessoa pessoa = opPessoa.get();
			List<Optional<Contato>> opContatos = this.contatoRepository.findAllByPessoa(pessoa);
			List<Contato> contatos = new ArrayList<>();
			for (Optional<Contato> opContato: opContatos)
				contatos.add(opContato.get());		
			return contatos;
		}
		return null;
	}


	@Override
	public Contato updateById(Long id, Contato contato) {
		Optional<Contato> upContato = this.contatoRepository.findById(id);
		if (upContato.isPresent()) {
			Contato newContato = upContato.get();
			//mantem pessoa do contato
			
			if(contato.getTipoContato() != null)
				newContato.setTipoContato(contato.getTipoContato());
			
			if(contato.getContato() != null)
				newContato.setContato(contato.getContato());
			
			return this.contatoRepository.save(newContato);
		}
		return contato;
	}

	@Override
	public void delete(Long id) {
		this.contatoRepository.deleteById(id);
	}

}
