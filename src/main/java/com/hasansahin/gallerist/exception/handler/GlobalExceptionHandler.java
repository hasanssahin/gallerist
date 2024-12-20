package com.hasansahin.gallerist.exception.handler;

import com.hasansahin.gallerist.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException baseException, WebRequest webRequest) {
        return ResponseEntity.badRequest().body(createApiError(baseException.getMessage(), webRequest));
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest webRequest) {
        Map<String, List<String>> map=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            String fieldName= ((FieldError) error).getField();
            if(map.containsKey(fieldName)){
                map.put(fieldName, addValue(map.get(fieldName), error.getDefaultMessage()));
            }else{
                map.put(fieldName, addValue(new ArrayList<>(), error.getDefaultMessage()));
            }
        });
        return ResponseEntity.badRequest().body(createApiError(map, webRequest));
    }

    private List<String> addValue(List<String> list, String value){
        list.add(value);
        return list;
    }

    private String getHostName() {
        try {
            return Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public <E> ApiError<E> createApiError(E message, WebRequest webRequest) {

        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        Exception<E> exception = new Exception<>();
        exception.setPath(webRequest.getDescription(false).substring(4));
        exception.setCreateTime(new Date());
        exception.setMessage(message);
        exception.setHostName(getHostName());

        apiError.setException(exception);
        return apiError;

    }
}
