package com.thewhite.aoplesson.repository;

import com.thewhite.aoplesson.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sergei Vorona
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByTextContainsIgnoreCase(String searchString);
}
