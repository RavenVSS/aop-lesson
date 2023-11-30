package com.thewhite.restlesson.service;

import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.service.argument.CreateMessageArgument;

import java.util.List;

/**
 * @author Sergei Vorona
 */
public interface MessageService {

    Message create(CreateMessageArgument argument);

    Message getExisting(Long id);

    List<Message> search(String searchText);

    List<Message> getAll();
}
