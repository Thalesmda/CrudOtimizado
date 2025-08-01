package ThalesDev.CrudOtimizado.repository;



import ThalesDev.CrudOtimizado.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface que herda de JpaRepository e já possui todos os métodos básicos
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Não precisa escrever nada — métodos como save, findAll, deleteById já estão prontos
}
