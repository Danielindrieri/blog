package PostBlog;

import AutorePost.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String category;
    private String titolo;
    private String cover;
    private String contenuto;
    private String tempoDiLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;
}
