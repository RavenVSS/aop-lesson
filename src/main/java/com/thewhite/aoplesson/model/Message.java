package com.thewhite.aoplesson.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

/**
 * Сущность - сообщение
 *
 * @author Sergei Vorona
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Message {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String text;

    LocalDateTime createDate;
}
