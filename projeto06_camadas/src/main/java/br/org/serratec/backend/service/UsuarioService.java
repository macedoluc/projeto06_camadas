package br.org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.serratec.backend.config.MailConfig;
import br.org.serratec.backend.dto.UsuarioDTO;
import br.org.serratec.backend.dto.UsuarioInserirDTO;
import br.org.serratec.backend.exception.EmailException;
import br.org.serratec.backend.model.Usuario;
import br.org.serratec.backend.repositoy.UsuarioRepository;

@Service //outro componente que o Spring irá gerenciar, assim como o configuration
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MailConfig mailConfig;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; //esse cara que faz a criptografia
	
	public List<UsuarioDTO> listar() {
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario usuario : usuarios) {
			UsuarioDTO dto = new UsuarioDTO(usuario);
			usuarioDTOs.add(dto);
		}
		return usuarioDTOs;
	}
	
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException{
		Usuario u = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()); //irá fazer o Find para conferir se o email digitado já existe
		if (u != null) {
			throw new EmailException("Email já existente | Insira outro");
		}
		//setar as variáveis, a criptografia da senha e depois salvar os dados passados
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setPerfil("Usuário Padrão");
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		usuario =  usuarioRepository.save(usuario);
		mailConfig.enviarEmail(usuarioInserirDTO.getEmail(), "Cadastro de Usuário", usuario.toString());
		return new UsuarioDTO(usuario);
	}
}
