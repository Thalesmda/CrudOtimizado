package ThalesDev.CrudOtimizado;

// Importa a classe responsável por iniciar a aplicação Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Anotação que marca esta classe como a principal da aplicação Spring Boot.
// Combina três anotações:
// @Configuration (define beans),
// @EnableAutoConfiguration (configuração automática de beans),
// @ComponentScan (procura por componentes, serviços, controllers, etc.)
@SpringBootApplication
public class CrudOtimizadoApplication {

	// Método principal (main) que é o ponto de entrada da aplicação Java
	public static void main(String[] args) {
		// Inicializa a aplicação Spring Boot, configurando todo o contexto
		SpringApplication.run(CrudOtimizadoApplication.class, args);

		// Exibe uma mensagem no console informando a URL base da API
		System.out.println("Servidor rodando em http://localhost:8080/usuarios");
	}

}
