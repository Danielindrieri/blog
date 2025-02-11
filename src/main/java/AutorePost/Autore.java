package AutorePost;

import PostBlog.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "autore")
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;

    @ManyToMany
    @JoinTable(
            name = "autore_post",
            joinColumns = @JoinColumn(name = "autore_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<Post> posts;
}
