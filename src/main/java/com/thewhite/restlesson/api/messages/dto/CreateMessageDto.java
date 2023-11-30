package com.thewhite.restlesson.api.messages.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * @author Sergei Vorona
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "ДТО для создания сообщения")
public class CreateMessageDto {

    @NotBlank
    @Schema(description = "Текст сообщения", requiredMode = REQUIRED)
    String text;
}
