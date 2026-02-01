package com.cache.redis.springboot.dtos.post;

import lombok.*;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponseDto implements Serializable {
    private Long id;

    private String title;

    private String description;

    private Long likes;

    private List<String> comments;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

}
