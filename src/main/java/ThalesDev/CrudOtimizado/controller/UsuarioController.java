// Pacote onde está a classe controller
package ThalesDev.CrudOtimizado.controller;

// Importa a classe de serviço responsável pela lógica de negócio
import ThalesDev.CrudOtimizado.service.UsuarioService;

// Importa a entidade que representa o usuário no banco
import ThalesDev.CrudOtimizado.entity.Usuario;

// Anotações do Spring Web para criar a API REST
import org.springframework.web.bind.annotation.*;

// Classes para manipular as respostas HTTP
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

// Importações utilitárias do Java
import java.util.List;
import java.util.Optional;

// Define que essa classe é um controller REST (retorna JSON ao invés de páginas HTML)
@RestController

// Define o caminho base da API. Ex: localhost:8080/usuarios
@RequestMapping("/usuarios")

// Permite requisições de qualquer origem (evita problemas com CORS em front-ends separados)
@CrossOrigin(origins = "*")
public class UsuarioController {

    // Declara uma dependência do service, que será injetada pelo Spring via construtor
    private final UsuarioService service;

    // Construtor com injeção de dependência automática do Spring
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Endpoint GET /usuarios → lista todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        // Chama o service para buscar todos os usuários e retorna no corpo da resposta
        return ResponseEntity.ok(service.listarTodos());
    }

    // Endpoint POST /usuarios → cria um novo usuário
    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Usuario usuario) {
        // Recebe o JSON do corpo da requisição e envia para o service
        service.criar(usuario);
        // Retorna status 201 (Created) com mensagem
        return new ResponseEntity<>("Usuário criado.", HttpStatus.CREATED);
    }

    // Endpoint PUT /usuarios/{id} → atualiza um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Usuario usuario) {
        // Verifica se o usuário existe
        if (!service.existePorId(id)) {
            // Se não existir, retorna 404 (Not Found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        // Atualiza o usuário com o ID informado
        service.atualizar(id, usuario);
        // Retorna status 200 (OK) com mensagem de sucesso
        return ResponseEntity.ok("Usuário atualizado");
    }

    // Endpoint DELETE /usuarios/{id} → exclui um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        // Verifica se o usuário existe
        if (!service.existePorId(id)) {
            // Se não existir, retorna 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        // Se existir, exclui o usuário
        service.excluir(id);
        // Retorna 200 OK com mensagem de sucesso
        return ResponseEntity.ok("Usuário excluído");
    }

    // Endpoint GET /usuarios/{id} → busca usuário específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        // Busca o usuário usando Optional para tratar ausência
        Optional<Usuario> usuario = service.buscarPorId(id);

        // Se encontrado, retorna 200 OK com o objeto
        // Se não encontrado, retorna 404 com mensagem
        return usuario.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado"));
    }
}
