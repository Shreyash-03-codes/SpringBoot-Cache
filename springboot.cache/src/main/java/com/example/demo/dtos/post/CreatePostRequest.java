package com.example.demo.dtos.post;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class CreatePostRequest {
    private String title;

    private String description;

    private Long likes;

    private List<String> comments;
}
