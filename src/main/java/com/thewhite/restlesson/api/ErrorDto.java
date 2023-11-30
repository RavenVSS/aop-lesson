package com.thewhite.restlesson.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @author Sergei Vorona
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Schema(description = "ДТО ошибки")
public class ErrorDto {
    private String errorMessage;
}
