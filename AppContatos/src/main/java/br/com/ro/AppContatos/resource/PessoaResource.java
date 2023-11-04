package br.com.ro.AppContatos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ro.AppContatos.model.Contato;
import br.com.ro.AppContatos.model.Pessoa;
import br.com.ro.AppContatos.record.PessoaRecord;
import br.com.ro.AppContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoaResource {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@Operation(summary = "(Cria uma nova Pessoa e persiste no Banco de Dados)")
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa newPessoa = this.pessoaService.save(pessoa);
		if (newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);		
	}
	
	@Operation(summary = "(Retorna do Banco de Dados os dados de uma Pessoa por ID)")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id) {
		Optional<Pessoa> pessoa = this.pessoaService.getById(id);
		if (pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}
	
	@Operation(summary = "(Retorna do Banco de Dados os dados de uma Pessoa por ID para mala direta)")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<Optional<PessoaRecord>> getByIdMalaDireta(@PathVariable Long id) {
		Optional<PessoaRecord> pessoaDTO = this.pessoaService.getByIdMalaDireta(id);
		if (pessoaDTO == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoaDTO);
	}
			
	@Operation(summary = "(Lista todas as Pessoas armazenadas no Banco de Dados)")
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllPessoas() {
		List<Pessoa> pessoas = pessoaService.getAll();
		if (pessoas == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoas);
	}
		
	@Operation(summary = "(Atualiza no Banco de Dados os dados de uma Pessoa existente)")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa upPessoa = this.pessoaService.updateById(id, pessoa);
		if (upPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upPessoa);
	}
	
	@Operation(summary = "(Remove do Banco de Dados os dados de uma Pessoa por ID)")
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> delete(@PathVariable Long id) {
		this.pessoaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Operation(summary = "(Adiciona no Banco de Dados um novo Contato a uma Pessoa por ID da pessoa)")
	@PostMapping("/{id}/contatos")
	public ResponseEntity<Contato> saveContato(@PathVariable Long id, @RequestBody Contato contato) {
		Contato newContato = this.pessoaService.saveContatoByIdPessoa(id, contato);
		if (newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);	
	}
	
	@Operation(summary = "(Lista todos os Contatos do Banco de Dados de uma Pessoa por ID da pessoa)")
	@GetMapping("/{idPessoa}/contatos")
	public ResponseEntity<List<Contato>> getAllContatosByPessoa(@PathVariable Long idPessoa) {
		List<Contato> contatos = this.pessoaService.getAllContatosByIdPessoa(idPessoa);
		if (contatos == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contatos);	
	}
}
