package com.thewhite.restlesson.api.messages;

import com.thewhite.restlesson.api.messages.dto.CreateMessageDto;
import com.thewhite.restlesson.api.messages.dto.MessageDto;
import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.repository.MessageRepository;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @author Sergei Vorona
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureWebTestClient
@ExtendWith(SoftAssertionsExtension.class)
class MessageControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private MessageRepository repository;

    @Test
    void postCreate(SoftAssertions assertions) {
        // Arrange
        String text = "test-text";
        CreateMessageDto dto = new CreateMessageDto(text);

        // Act
        MessageDto response = webTestClient.post()
                                           .uri("messages/create")
                                           .contentType(APPLICATION_JSON)
                                           .bodyValue(dto)
                                           .exchange()
                                           .expectStatus()
                                           .isOk()
                                           .expectBody(MessageDto.class)
                                           .returnResult()
                                           .getResponseBody();

        // Assert
        assertions.assertThat(response)
                  .usingRecursiveComparison()
                  .withStrictTypeChecking()
                  .ignoringFields("createDate")
                  .isEqualTo(MessageDto.builder()
                                       .id(1L)
                                       .text(text)
                                       .build());

        assertions.assertThat(repository.findById(1L))
                  .usingRecursiveComparison()
                  .withStrictTypeChecking()
                  .ignoringFields("createDate")
                  .isEqualTo(Message.builder()
                                    .id(1L)
                                    .text(text)
                                    .build());
    }
}