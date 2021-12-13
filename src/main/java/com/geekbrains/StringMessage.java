package com.geekbrains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
public class StringMessage extends AbstractMessage {

    private String content;
    private LocalDateTime time;

    public StringMessage(String content) {
        this.content = content;
    }
}

