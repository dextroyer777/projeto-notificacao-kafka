package notificacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoDTO implements Serializable {
    private String id;
    private String mensagem;
    private String destino;
}
