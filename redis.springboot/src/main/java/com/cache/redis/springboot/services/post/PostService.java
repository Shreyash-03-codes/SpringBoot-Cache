package com.cache.redis.springboot.services.post;

import com.cache.redis.springboot.dtos.post.CreatePostDto;
import com.cache.redis.springboot.dtos.post.PostDeleteResponseDto;
import com.cache.redis.springboot.dtos.post.PostResponseDto;
import com.cache.redis.springboot.dtos.post.UpdatePostDto;

import java.util.List;

public interface PostService {
    PostResponseDto createPost(CreatePostDto createPostDto);

    List<PostResponseDto> getAllPosts();

    PostResponseDto getPostById(Long id);

    PostResponseDto updatedPost(UpdatePostDto updatePostDto);

    PostDeleteResponseDto deletePostById(Long id);
}
