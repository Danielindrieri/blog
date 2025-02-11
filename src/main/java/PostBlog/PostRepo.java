package PostBlog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepo extends JpaRepository<Post, Long> {
    boolean existsByTitolo(String titolo);
}
