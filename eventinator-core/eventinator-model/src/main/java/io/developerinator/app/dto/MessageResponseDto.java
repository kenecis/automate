package io.developerinator.app.dto;

import lombok.Data;

/**
 * Created by jvillanueva on 8/20/16.
 */
@Data
public class MessageResponseDto {

    private String message;

    public MessageResponseDto(String message) {
        this.message = message;
    }
}
