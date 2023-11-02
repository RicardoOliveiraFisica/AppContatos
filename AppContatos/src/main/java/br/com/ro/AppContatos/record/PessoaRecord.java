package br.com.ro.AppContatos.record;

import br.com.ro.AppContatos.model.Pessoa;

public record PessoaRecord(Long id, String nome, String malaDireta) {
	public PessoaRecord(Pessoa pessoa) {
		this(pessoa.getId(), pessoa.getNome(),
				(pessoa.getEndereco() != null ? pessoa.getEndereco() : " ") + " - "
				 + (pessoa.getCep()!= null ? pessoa.getCep() : " ") + " - "
				 + (pessoa.getCidade()!= null ? pessoa.getCidade() : " ") 
				 + (pessoa.getUf()!= null ? "/" + pessoa.getUf() : " ")
			);
	}
	
}
