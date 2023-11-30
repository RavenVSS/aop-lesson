package com.thewhite.aoplesson.service;

import com.thewhite.aoplesson.model.Message;
import com.thewhite.aoplesson.service.argument.CreateMessageArgument;

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
