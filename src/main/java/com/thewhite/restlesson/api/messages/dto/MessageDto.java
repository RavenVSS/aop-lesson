package com.thewhite.restlesson.api.messages.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Sergei Vorona
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    Long id;

    String text;

    LocalDateTime createDate;
}
