package com.cache.redis.springboot.controllers;

import com.cache.redis.springboot.dtos.post.CreatePostDto;
import com.cache.redis.springboot.dtos.post.PostDeleteResponseDto;
import com.cache.redis.springboot.dtos.post.PostResponseDto;
import com.cache.redis.springboot.dtos.post.UpdatePostDto;
import com.cache.redis.springboot.dtos.response.ApiResponse;
import com.cache.redis.springboot.services.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@RequestBody CreatePostDto createPostDto){
        ApiResponse<PostResponseDto> response=new ApiResponse<>(postService.createPost(createPostDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@RequestBody UpdatePostDto updatePostDto){
        ApiResponse<PostResponseDto> response=new ApiResponse<>(postService.updatedPost(updatePostDto));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostResponseDto>>> getAllPosts(){
        ApiResponse<List<PostResponseDto>> response=new ApiResponse<>(postService.getAllPosts());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> getPostById(@PathVariable("id") Long id){
        ApiResponse<PostResponseDto> response=new ApiResponse<>(postService.getPostById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<PostDeleteResponseDto>> deletePostById(@PathVariable("id") Long id){
        ApiResponse<PostDeleteResponseDto> response=new ApiResponse<>(postService.deletePostById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
