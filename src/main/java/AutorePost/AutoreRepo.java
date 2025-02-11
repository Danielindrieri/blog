package AutorePost;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutoreRepo extends JpaRepository<Autore, Long> {
    boolean existsByEmail(String email);
}