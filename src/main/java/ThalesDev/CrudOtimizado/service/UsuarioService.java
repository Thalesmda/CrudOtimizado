// Pacote onde está localizada a classe (estrutura do projeto)
package ThalesDev.CrudOtimizado.service;

// Importa a classe Usuario que representa a entidade do banco de dados
import ThalesDev.CrudOtimizado.entity.Usuario;

// Importa o repositório JPA que fornece os métodos para acessar o banco
import ThalesDev.CrudOtimizado.repository.UsuarioRepository;

// Importa a anotação para injeção automática de dependência
import org.springframework.beans.factory.annotation.Autowired;

// Define que esta classe é um componente do tipo "Service" do Spring
import org.springframework.stereotype.Service;

// Importações de utilitários do Java
import java.util.List;
import java.util.Optional;

// Indica que essa classe é um "serviço" gerenciado pelo Spring,
// responsável pela lógica de negócio relacionada a "Usuario"
@Service
public class UsuarioService {

    // Injeção automática do repositório. O Spring cria uma instância da interface UsuarioRepository
    @Autowired
    private UsuarioRepository repository;

    // Retorna uma lista com todos os usuários do banco de dados
    public List<Usuario> listarTodos() {
        return repository.findAll(); // Método padrão do JpaRepository
    }

    // Cria e salva um novo usuário no banco de dados
    public Usuario criar(Usuario usuario) {
        return repository.save(usuario); // Também pode atualizar se o ID já existir
    }

    // Busca um usuário pelo ID. Retorna um Optional para tratar caso não exista
    public Optional<Usuario> buscarPorId(int id) {
        return repository.findById(id);
    }

    // Verifica se existe um usuário com o ID fornecido
    public boolean existePorId(int id) {
        return repository.existsById(id);
    }

    // Atualiza os dados de um usuário existente, garantindo que o ID da URL será usado
    public Usuario atualizar(int id, Usuario usuario) {
        usuario.setId(id); // Garante que o ID correto seja usado
        return repository.save(usuario); // Atualiza o usuário (save também serve para update)
    }

    // Exclui um usuário do banco com base no ID
    public void excluir(int id) {
        repository.deleteById(id);
    }
}
