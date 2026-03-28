package notificacao.service;

import notificacao.dto.NotificacaoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class KafkaProducerServiceTest {

    @Mock
    private KafkaTemplate<String, NotificacaoDTO> kafkaTemplate;

    @InjectMocks
    private KafkaProducerService producerService;

    @Test
    void deveEnviarMensagemParaOKafkaComSucesso() {
        // Arrange
        NotificacaoDTO dto = new NotificacaoDTO("1", "Teste", "filipe@dev.com");

        // Act
        producerService.enviar(dto);

        // Assert
        verify(kafkaTemplate, times(1)).send(eq("notificacoes-topic"), eq(dto));
    }
}
