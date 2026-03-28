package notificacao.service;

import notificacao.dto.NotificacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String TOPICO = "notificacoes-topic";

    public void enviar(NotificacaoDTO dto) {
        kafkaTemplate.send(TOPICO, dto);
    }
}
