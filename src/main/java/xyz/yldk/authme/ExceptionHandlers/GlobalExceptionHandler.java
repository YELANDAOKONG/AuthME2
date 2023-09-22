package xyz.yldk.authme.ExceptionHandlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;
import xyz.yldk.authme.Objects.JsonResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e)
    {
        JsonResult jsonResult = new JsonResult(
                405,
                "Method not allowed",
                null
        );
        return jsonResult;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HttpClientErrorException.class)
    public JsonResult handleHttpClientErrorException(HttpClientErrorException e)
    {
        JsonResult jsonResult = new JsonResult(
                e.getStatusCode().value(),
                e.getMessage(),
                null
        );
        return jsonResult;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NoHandlerFoundException.class)
    public JsonResult handleNoHandlerFoundException(NoHandlerFoundException e)
    {
        JsonResult jsonResult = new JsonResult(
                404,
                "Not Found",
                null
        );
        return jsonResult;
    }





    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException.class)
    public JsonResult handleRuntimeException(RuntimeException e)
    {
        JsonResult jsonResult = new JsonResult(
                500,
                "Internet Server Error",
                null
        );
        return jsonResult;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception e)
    {
        JsonResult jsonResult = new JsonResult(
                500,
                "Internet Server System Error",
                null
        );
        return jsonResult;
    }




}
