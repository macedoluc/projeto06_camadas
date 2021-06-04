package br.org.serratec.backend.dto;

import br.org.serratec.backend.model.Usuario;

public class UsuarioDTO { //essa classe serve para selecionar quais informações serão mostradas ao usuário, por exemplo, não é interessante que se mostre a senha e o perfil da pessoa cadastrada
	//os campos definidos abaixo são os que serão mostrado ao usuário
	private Long id;
	private String nome;
	private String email;
	
	//precisa fazer uma sobrecarga (3 construtres juntos)
	
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDTO(Usuario usuario) { //esse construtor serve para pegar os dados do usuario que quer mostrar na tela
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
