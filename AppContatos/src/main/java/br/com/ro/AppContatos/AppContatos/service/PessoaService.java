package br.com.ro.AppContatos.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ro.AppContatos.AppContatos.model.Pessoa;
import br.com.ro.AppContatos.AppContatos.repository.PessoaRepository;
import br.com.ro.AppContatos.AppContatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
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
	public Pessoa update(Pessoa pessoa) {
		Long id = pessoa.getId();
		Optional<Pessoa> upPessoa = this.pessoaRepository.findById(id);
		if (upPessoa.isPresent()) {
			Pessoa newPessoa = upPessoa.get();
			newPessoa.setNome(pessoa.getNome());
			newPessoa.setEndereco(pessoa.getEndereco());
			newPessoa.setCep(pessoa.getCep());
			newPessoa.setCidade(pessoa.getCidade());
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
