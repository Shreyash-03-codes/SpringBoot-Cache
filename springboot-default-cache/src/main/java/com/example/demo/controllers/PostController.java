package com.example.demo.controllers;

import com.example.demo.dtos.post.CreatePostRequest;
import com.example.demo.dtos.post.PostDeleteResponse;
import com.example.demo.dtos.post.PostResponse;
import com.example.demo.dtos.response.ApiResponse;
import com.example.demo.services.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<PostResponse>> createPost(@RequestBody CreatePostRequest createPostRequest){
        ApiResponse<PostResponse> response=new ApiResponse<>(postService.createPost(createPostRequest));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> updatedPost(@RequestBody CreatePostRequest createPostRequest,@PathVariable("id") Long id){
        ApiResponse<PostResponse> response=new ApiResponse<>(postService.updatePost(createPostRequest,id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> getPostById(@PathVariable("id") Long id){
        ApiResponse<PostResponse> response=new ApiResponse<>(postService.getPostById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostResponse>>> getPosts(Long id){
        ApiResponse<List<PostResponse>> response=new ApiResponse<>(postService.getPosts(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<PostDeleteResponse>> deletePost(@PathVariable("id") Long id){
        ApiResponse<PostDeleteResponse> response=new ApiResponse<>(postService.deletePost(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
