package com.thewhite.aoplesson.service;

import com.thewhite.aoplesson.model.Message;
import com.thewhite.aoplesson.repository.MessageRepository;
import com.thewhite.aoplesson.service.argument.CreateMessageArgument;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Sergei Vorona
 */
@ExtendWith(SoftAssertionsExtension.class)
class MessageServiceImplIT {

    private final MessageRepository repository = mock(MessageRepository.class);
    private final MessageService service = new MessageServiceImpl(repository);

    @Test
    void create(SoftAssertions assertions) {
        // Arrange
        when(repository.save(any())).thenReturn(Message.builder()
                                                       .id(1L)
                                                       .text("test")
                                                       .build());

        // Act
        Message message = service.create(CreateMessageArgument.builder()
                                                              .text("test")
                                                              .build());

        // Assert
        assertions.assertThat(message)
                  .isNotNull();
    }
}