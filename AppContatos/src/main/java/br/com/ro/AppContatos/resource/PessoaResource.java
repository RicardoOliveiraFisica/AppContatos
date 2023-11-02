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
import br.com.ro.AppContatos.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas") //http://localhost:8080/api/pessoas
public class PessoaResource {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	//@Operation(summary = “explicação do endpoint aqui!”)
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa newPessoa = this.pessoaService.save(pessoa);
		if (newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id) {
		Optional<Pessoa> pessoa = this.pessoaService.getById(id);
		if (pessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
	}
	
	//GET /api/pessoas/maladireta/{id}
			
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllPessoas() {
		List<Pessoa> pessoas = pessoaService.getAll();
		if (pessoas == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoas);
	}
		
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa upPessoa = this.pessoaService.updateById(id, pessoa);
		if (upPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upPessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> delete(@PathVariable Long id) {
		this.pessoaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/{id}/contatos")
	public ResponseEntity<Contato> saveContato(@PathVariable Long id, @RequestBody Contato contato) {
		Contato newContato = this.pessoaService.saveContatoByIdPessoa(id, contato);
		if (newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);	
	}
	
	@GetMapping("/{id}/contatos")
	public ResponseEntity<List<Contato>> getAllContatosByPessoa(@PathVariable Long id) {
		List<Contato> contatos = this.pessoaService.getAllContatosByIdPessoa(id);
		if (contatos == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contatos);	
	}
}
