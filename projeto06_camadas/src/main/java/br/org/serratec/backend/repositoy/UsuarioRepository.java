package br.org.serratec.backend.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.backend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email); //buscando todos os emails que estão no banco 
}
