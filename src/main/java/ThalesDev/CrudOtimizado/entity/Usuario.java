package ThalesDev.CrudOtimizado.entity;

// Importações necessárias para trabalhar com JPA (mapeamento objeto-relacional)
import jakarta.persistence.*;

@Entity // Indica que esta classe representa uma entidade no banco de dados
@Table(name = "usuario") // Define o nome da tabela no banco (caso queira diferente do nome da classe)
public class Usuario {

    @Id // Marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento (estratégia do banco)
    private int id;

    @Column(nullable = false) // Define a coluna "nome" e indica que ela não pode ser nula
    private String nome;

    @Column(nullable = false) // Define a coluna "email" e também exige valor
    private String email;

    // === Construtor vazio (obrigatório para JPA) ===
    public Usuario() {
    }

    // === Construtor com campos úteis ===
    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // === Getters e Setters ===
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    // === toString (opcional, útil para debug) ===
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
