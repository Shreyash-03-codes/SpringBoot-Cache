package com.example.demo.services.post;

import com.example.demo.dtos.post.CreatePostRequest;
import com.example.demo.dtos.post.PostDeleteResponse;
import com.example.demo.dtos.post.PostResponse;
import com.example.demo.entities.Post;
import com.example.demo.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostResponse createPost(CreatePostRequest createPostRequest) {
        Post post=modelMapper.map(createPostRequest,Post.class);
        Post saved=postRepository.save(post);
        PostResponse postResponse=modelMapper.map(saved,PostResponse.class);
        return postResponse;
    }

    @Override
    @Cacheable(cacheNames = "post_cache",key = "#id")
    public PostResponse getPostById(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new RuntimeException("Post not found"));
        PostResponse postResponse=modelMapper.map(post,PostResponse.class);
        return postResponse;
    }

    @Override
    @Cacheable(cacheNames = "post_cache",key = "#id")
    public List<PostResponse> getPosts(Long id) {

        List<Post> posts=postRepository.findAll();

        return posts
                .stream()
                .map((p)->modelMapper.map(p,PostResponse.class))
                .toList();
    }

    @Override
    @CacheEvict(value = "post_cache",key = "#id")
    public PostDeleteResponse deletePost(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new RuntimeException("Post Not found"));
        postRepository.delete(post);
        return PostDeleteResponse
                .builder()
                .message("Post deleted with id "+id+" successfully")
                .build();
    }

    @Override
    @CachePut(cacheNames = "post_cache",key = "#id")
    public PostResponse updatePost(CreatePostRequest createPostRequest,long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new RuntimeException("Post Not found"));
        post.setComments(createPostRequest.getComments());
        post.setLikes(createPostRequest.getLikes());
        post.setTitle(createPostRequest.getTitle());
        post.setDescription(createPostRequest.getDescription());
        Post saved=postRepository.save(post);
        PostResponse postResponse=modelMapper.map(saved,PostResponse.class);
        return postResponse;
    }
}
