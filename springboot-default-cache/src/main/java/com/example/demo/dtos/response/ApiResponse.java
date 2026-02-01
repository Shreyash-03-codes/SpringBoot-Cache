package com.example.demo.dtos.response;

import com.example.demo.dtos.error.ApiError;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse<T> {

    private LocalDateTime dateTime;
    private T data;
    private ApiError error;

    public ApiResponse(){
        this.dateTime=LocalDateTime.now();
    }

    public ApiResponse(T data){
        this();
        this.data=data;
        this.error=null;
    }

    public ApiResponse(ApiError error){
        this();
        this.error=error;
        this.data=null;
    }
}
