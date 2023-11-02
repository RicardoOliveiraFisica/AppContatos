package br.com.ro.AppContatos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ro.AppContatos.model.Contato;
import br.com.ro.AppContatos.model.Pessoa;
import br.com.ro.AppContatos.record.PessoaRecord;
import br.com.ro.AppContatos.repository.ContatoRepository;
import br.com.ro.AppContatos.repository.PessoaRepository;
import br.com.ro.AppContatos.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {
	
	private PessoaRepository pessoaRepository;
	private ContatoRepository contatoRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository, ContatoRepository contatoRepository) {
		this.pessoaRepository = pessoaRepository;
		this.contatoRepository = contatoRepository;
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
	public Optional<PessoaRecord> getByIdMalaDireta(Long id) {
		Optional<Pessoa> pessoa = this.pessoaRepository.findById(id);
		PessoaRecord pessoaDTO = new PessoaRecord(pessoa.get());
		return Optional.of(pessoaDTO);
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
	public void deleteById(Long id) {
		List<Contato> contatos = getAllContatosByIdPessoa(id);
		for (Contato contato: contatos)
			this.contatoRepository.deleteById(contato.getId());
		this.pessoaRepository.deleteById(id);
	}
	
	@Override
	public Contato saveContatoByIdPessoa(Long idPessoa, Contato contato) {
		Optional<Pessoa> opPessoa = this.pessoaRepository.findById(idPessoa);
		if (opPessoa.isPresent()) {
			Pessoa pessoa = opPessoa.get();
			contato.setPessoa(pessoa);
			return this.contatoRepository.save(contato);
		}
		return contato;
	}
	

	@Override
	public List<Contato> getAllContatosByIdPessoa(Long idPessoa) {
		Optional<Pessoa> opPessoa = this.pessoaRepository.findById(idPessoa);
		List<Contato> contatos = new ArrayList<>();
		if (opPessoa.isPresent()) {
			Pessoa pessoa = opPessoa.get();
			List<Optional<Contato>> opContatos = this.contatoRepository.findAllByPessoa(pessoa);
			
			for (Optional<Contato> opContato: opContatos)
				contatos.add(opContato.get());					
		}
		return contatos;
	}

}
