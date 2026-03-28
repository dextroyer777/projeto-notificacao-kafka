package notificacao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import notificacao.dto.NotificacaoDTO;
import notificacao.service.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificacaoController.class)
class NotificacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KafkaProducerService producerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveRetornarStatusAceitoAoEnviarNotificacao() throws Exception {
        NotificacaoDTO dto = new NotificacaoDTO("10", "Ola", "filipe@dev.com");

        mockMvc.perform(post("/notificacoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isAccepted());
    }
}
