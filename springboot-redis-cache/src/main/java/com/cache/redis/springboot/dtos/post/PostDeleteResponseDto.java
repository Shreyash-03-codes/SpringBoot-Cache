package com.cache.redis.springboot.dtos.post;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDeleteResponseDto implements Serializable {
    private String message;
}
