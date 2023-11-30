package com.thewhite.restlesson.repository;

import com.thewhite.restlesson.model.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

/**
 * Репозиторий с "базой данных" в памяти.
 *
 * @author Sergei Vorona
 */
@Component
public class MessageRepositoryImpl implements MessageRepository {

    private final Map<Long, Message> myPerfectDb = new HashMap<>();
    private long nextId = 0L;

    @Override
    public Message create(Message message) {
        myPerfectDb.put(message.getId(), message);
        return message;
    }

    @Override
    public Message findById(Long id) {
        return myPerfectDb.get(id);
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(myPerfectDb.values());
    }

    @Override
    public List<Message> findAllBySearchString(String searchString) {
        return myPerfectDb.values()
                          .stream()
                          .filter(message -> containsIgnoreCase(message.getText(), searchString))
                          .collect(Collectors.toList());
    }

    /**
     * Генерирует уникальный идентификатор
     */
    @Override
    public long getNextId() {
        return ++nextId;
    }
}
