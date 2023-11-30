package com.thewhite.restlesson.service.argument;

import lombok.Builder;
import lombok.Value;

/**
 * @author Sergei Vorona
 */
@Value
@Builder
public class CreateMessageArgument {
    String text;
}
