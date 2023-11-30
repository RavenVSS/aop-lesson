package com.thewhite.restlesson.service;

import com.thewhite.restlesson.exception.NotFoundException;
import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.repository.MessageRepository;
import com.thewhite.restlesson.service.argument.CreateMessageArgument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Сервис сообщений
 *
 * @author Sergei Vorona
 */
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    @Override
    public Message create(CreateMessageArgument argument) {
        long id = repository.getNextId();

        return repository.create(Message.builder()
                                        .id(id)
                                        .text(argument.getText())
                                        .createDate(LocalDateTime.now())
                                        .build());
    }

    @Override
    public Message getExisting(Long id) {
        return Optional.ofNullable(repository.findById(id))
                       .orElseThrow(() -> new NotFoundException("Сообщение не найдено."));
    }

    @Override
    public List<Message> search(String searchText) {
        return repository.findAllBySearchString(searchText);
    }

    @Override
    public List<Message> getAll() {
        return repository.findAll();
    }
}
