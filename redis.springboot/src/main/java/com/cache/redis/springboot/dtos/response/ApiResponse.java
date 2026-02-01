package com.cache.redis.springboot.dtos.response;

import com.cache.redis.springboot.dtos.error.ApiError;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse <T>{
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
        this.data=null;
        this.error=error;
    }
}
