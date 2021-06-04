package br.org.serratec.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //dizendo que essa classe irá ser configurada/gerenciada pelo Spring
public class AplicationConfig { //essa classe faz a criptografia da senha 
	
	@Bean //para poder dizer pro Spring que esse método pode ser injetado, injetar é fazer o @Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder() { 
		return new BCryptPasswordEncoder();
	}
}
