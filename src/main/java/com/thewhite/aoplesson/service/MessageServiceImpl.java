package com.thewhite.aoplesson.service;

import com.thewhite.aoplesson.exception.NotFoundException;
import com.thewhite.aoplesson.model.Message;
import com.thewhite.aoplesson.repository.MessageRepository;
import com.thewhite.aoplesson.service.argument.CreateMessageArgument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
    @Transactional
    public Message create(CreateMessageArgument argument) {
        return repository.save(Message.builder()
                                      .text(argument.getText())
                                      .createDate(LocalDateTime.now())
                                      .build());
    }

    @Override
    @Transactional(readOnly = true)
    public Message getExisting(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new NotFoundException("Сообщение не найдено."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> search(String searchText) {
        return repository.findAllByTextContainsIgnoreCase(searchText);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> getAll() {
        return repository.findAll();
    }
}
