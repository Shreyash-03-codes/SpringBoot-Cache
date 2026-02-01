package com.cache.redis.springboot.dtos.error;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {
    private String status;
    private String description;
}
