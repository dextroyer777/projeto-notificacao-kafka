package notificacao.service;

import notificacao.dto.NotificacaoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final StringRedisTemplate redisTemplate;

    @KafkaListener(topics = "notificacoes-topic", groupId = "notificacao-group")
    public void consumir(NotificacaoDTO dto) {
        log.info("Recebido do Kafka: {}", dto);
        
        // Salvando no Redis
        redisTemplate.opsForValue().set("notificacao:" + dto.getId(), "OK", Duration.ofMinutes(5));
        log.info("Chave salva no Redis para o ID: {}", dto.getId());
    }
}
