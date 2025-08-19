package br.edu.iff.ccc.plataforma_mentoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import br.edu.iff.ccc.plataforma_mentoria.services.UsuarioService;

@SpringBootApplication
public class PlataformaMentoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlataformaMentoriaApplication.class, args);
	}
   
   // Cria usuário padrão se não existir
	@Bean
	public CommandLineRunner dataLoader(UsuarioService usuarioService) {
	   return args -> {
		   String email = "admin@exemplo.com";
		   if (!usuarioService.emailJaExiste(email)) {
			   usuarioService.criarUsuario(
				   "Admin",
				   email,
				   "admin",
				   "000000000",
				   "Usuário administrador",
				   br.edu.iff.ccc.plataforma_mentoria.entities.Usuario.TipoUsuario.MENTOR
			   );
		   }
	   };
   }

}
