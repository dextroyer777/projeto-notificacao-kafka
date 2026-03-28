package notificacao.controller;

import notificacao.dto.NotificacaoDTO;
import notificacao.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
public class NotificacaoController {
    private final KafkaProducerService producer;

    @PostMapping
    public String enviar(@RequestBody NotificacaoDTO dto) {
        producer.enviar(dto);
        return "Mensagem enviada!";
    }
}
