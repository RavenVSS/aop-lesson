package com.thewhite.restlesson.api.messages.mapper;

import com.thewhite.restlesson.api.messages.dto.CreateMessageDto;
import com.thewhite.restlesson.api.messages.dto.MessageDto;
import com.thewhite.restlesson.model.Message;
import com.thewhite.restlesson.service.argument.CreateMessageArgument;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;
import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * @author Sergei Vorona
 */
@Mapper(componentModel = SPRING)
public interface MessageMapper {

    CreateMessageArgument toCreateArgument(CreateMessageDto dto);

    @Mapping(target = "createDate", expression = "java(modifyCreateDate(message))")
    MessageDto toDto(Message message);

    List<MessageDto> toDtoList(List<Message> messages);


    default LocalDateTime modifyCreateDate(Message message) {
        return message.getCreateDate().withSecond(0);
    }

    @AfterMapping
    default void toLoverCaseText(CreateMessageDto dto, @MappingTarget CreateMessageArgument.CreateMessageArgumentBuilder builder) {
        String loverCaseText = dto.getText().toLowerCase();

        builder.text(loverCaseText);
    }
}
