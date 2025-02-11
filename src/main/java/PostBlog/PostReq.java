package PostBlog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostReq {
    private String category;
    private String titolo;
    private String cover;
    private String contenuto;
    private String tempoDiLettura;
}
