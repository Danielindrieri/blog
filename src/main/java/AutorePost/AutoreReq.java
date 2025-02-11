package AutorePost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreReq {
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;
}
