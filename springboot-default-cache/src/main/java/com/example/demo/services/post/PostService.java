package com.example.demo.services.post;

import com.example.demo.dtos.post.CreatePostRequest;
import com.example.demo.dtos.post.PostDeleteResponse;
import com.example.demo.dtos.post.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse createPost(CreatePostRequest createPostRequest);

    PostResponse getPostById(Long id);

    List<PostResponse> getPosts(Long id);

    PostDeleteResponse deletePost(Long id);

    PostResponse updatePost(CreatePostRequest createPostRequest,long id);
}
