package io.developerinator.app.dto;

import lombok.Data;

/**
 * Created by jvillanueva on 8/20/16.
 */
@Data
public class ErrorResponseDto {
    private String error;

    public ErrorResponseDto(String error) {
        this.error = error;
    }
}
