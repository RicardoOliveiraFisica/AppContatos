package br.com.ro.AppContatos.resource;

import java.util.List;
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

@RestController
@RequestMapping("/api/contatos") //http://localhost:8080/api/contatos
public class ContatoResource {
	private ContatoService contatoService;
	
	
	@Autowired
	public ContatoResource(ContatoService contatoService) {
		this.contatoService = contatoService;
	}
	
	/*
	@GetMapping
	public ResponseEntity<List<Contato>> getAll() {
		List<Contato> contatos = this.contatoService.getAll();
		if (contatos == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contatos);
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id) {
		Optional<Contato> contato = this.contatoService.getById(id);
		if (contato== null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contato);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato) {
		Contato upContato = this.contatoService.updateById(id, contato);
		if (upContato== null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(upContato);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Contato>> delete(@PathVariable Long id) {
		this.contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
}
