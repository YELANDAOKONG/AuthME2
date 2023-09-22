package xyz.yldk.authme.ExceptionHandlers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import xyz.yldk.authme.Objects.JsonResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                          HttpServletRequest request)
    {
        JsonResult jsonResult = new JsonResult(
                405,
                "Method not allowed",
                null
        );
        return jsonResult;
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public JsonResult handleHttpClientErrorException(HttpClientErrorException e,
                                                          HttpServletRequest request)
    {
        JsonResult jsonResult = new JsonResult(
                e.getStatusCode().value(),
                e.getMessage(),
                null
        );
        return jsonResult;
    }



    @ExceptionHandler(RuntimeException.class)
    public JsonResult handleRuntimeException(RuntimeException e,
                                                     HttpServletRequest request)
    {
        JsonResult jsonResult = new JsonResult(
                500,
                "Internet Server Error",
                null
        );
        return jsonResult;
    }




}
