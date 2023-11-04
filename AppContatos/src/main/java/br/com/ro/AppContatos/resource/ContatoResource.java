package br.com.ro.AppContatos.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ro.AppContatos.model.Contato;
import br.com.ro.AppContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos") //http://localhost:8080/api/contatos
public class ContatoResource {
	private ContatoService contatoService;
		
	@Autowired
	public ContatoResource(ContatoService contatoService) {
		this.contatoService = contatoService;
	}
	
	@Operation(summary = "(Retorna do Banco de Dados os dados de um Contato por ID)")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id) {
		Optional<Contato> contato = this.contatoService.getById(id);
		if (contato== null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contato);
	}
	
	@Operation(summary = "(Atualiza no Banco de Dados um Contato existente por ID)")
	@PutMapping("/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato) {
		Contato upContato = this.contatoService.updateById(id, contato);
		if (upContato== null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upContato);
	}
	
	@Operation(summary = "(Remove do Banco de Dados um Contato por ID)")
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Contato>> delete(@PathVariable Long id) {
		this.contatoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
}
