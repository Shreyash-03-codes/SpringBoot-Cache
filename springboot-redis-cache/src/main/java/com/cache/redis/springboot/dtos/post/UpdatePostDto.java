package com.cache.redis.springboot.dtos.post;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePostDto {
    private Long id;

    private String title;

    private String description;

    private Long likes;

    private List<String> comments;
}
