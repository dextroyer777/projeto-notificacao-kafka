package notificacao.controller;

import lombok.RequiredArgsConstructor;
import notificacao.dto.NotificacaoDTO;
import notificacao.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
public class NotificacaoController {

    private final KafkaProducerService producerService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> enviar(@RequestBody NotificacaoDTO dto) {
        producerService.enviar(dto);
        return ResponseEntity.accepted().body("Mensagem enviada!");
    }
}
