package io.developerinator.app.advice;

import io.developerinator.app.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    /**
     * Handles Access denied exception thrown by spring security
     *
     * @param e exception thrown
     * @return error dto
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResponseDto accessDeniedException(AccessDeniedException e) {
        return new ErrorResponseDto(e.getMessage());
    }

    /**
     * Handles Illegal Argument exception
     *
     * @param e exception thrown
     * @return error dto
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDto illegalArgument(IllegalArgumentException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponseDto(e.getMessage());
    }

    /**
     * Handles Invalid request body exception
     *
     * @param e exception thrown
     * @return error dto
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponseDto httpMessageNotReadable(HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponseDto("Missing or invalid request body found");
    }

    /**
     * Handles Illegal State Exception
     *
     * @param e exception thrown
     * @return error dto
     */
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResponseDto illegalStateException(IllegalStateException e) {
        return new ErrorResponseDto(e.getMessage());
    }

    /**
     * Handles all exception not handled by other advice
     *
     * @param e exception thrown
     * @return error dto
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponseDto catchAllException(Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorResponseDto(e.getMessage());
    }
}
