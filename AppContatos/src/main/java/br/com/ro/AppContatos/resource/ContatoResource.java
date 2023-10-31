package br.com.ro.AppContatos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public ResponseEntity<List<Contato>> getAll() {
		List<Contato> contatos = this.contatoService.getAll();
		if (contatos == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contatos);
	}
}
