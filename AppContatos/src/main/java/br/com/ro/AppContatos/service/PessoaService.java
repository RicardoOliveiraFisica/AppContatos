package br.com.ro.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ro.AppContatos.model.Pessoa;
import br.com.ro.AppContatos.repository.ContatoRepository;
import br.com.ro.AppContatos.repository.PessoaRepository;
import br.com.ro.AppContatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository, ContatoRepository contatoRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public Pessoa save(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	@Override
	public Optional<Pessoa> getById(Long id) {
		return this.pessoaRepository.findById(id);
	}

	@Override
	public List<Pessoa> getAll() {
		return this.pessoaRepository.findAll();
	}
	
	@Override
	public Pessoa updateById(Long id, Pessoa pessoa) {
		Optional<Pessoa> upPessoa = this.pessoaRepository.findById(id);
		if (upPessoa.isPresent()) {
			Pessoa newPessoa = upPessoa.get();
			if (pessoa.getNome() != null)
				newPessoa.setNome(pessoa.getNome());
			
			if (pessoa.getEndereco() != null)
				newPessoa.setEndereco(pessoa.getEndereco());
			
			if (pessoa.getCep() != null)
				newPessoa.setCep(pessoa.getCep());
			
			if (pessoa.getCidade() != null)
				newPessoa.setCidade(pessoa.getCidade());
			
			if (pessoa.getUf() != null)
				newPessoa.setUf(pessoa.getUf());
			
			return this.pessoaRepository.save(newPessoa);
		}		
		return pessoa;
	}

	@Override
	public void delete(Long id) {
		this.pessoaRepository.deleteById(id);
	}

}
