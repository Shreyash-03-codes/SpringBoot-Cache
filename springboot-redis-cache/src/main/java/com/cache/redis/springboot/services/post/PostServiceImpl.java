package com.cache.redis.springboot.services.post;

import com.cache.redis.springboot.dtos.post.CreatePostDto;
import com.cache.redis.springboot.dtos.post.PostDeleteResponseDto;
import com.cache.redis.springboot.dtos.post.PostResponseDto;
import com.cache.redis.springboot.dtos.post.UpdatePostDto;
import com.cache.redis.springboot.entities.Post;
import com.cache.redis.springboot.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Override
    public PostResponseDto createPost(CreatePostDto createPostDto) {

        Post post=modelMapper.map(createPostDto,Post.class);
        Post saved=postRepository.save(post);
        PostResponseDto postResponseDto=modelMapper.map(saved,PostResponseDto.class);
        return postResponseDto;
    }

    @Override
    @Cacheable(cacheNames = "posts",key = "'all'")
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map((p)->modelMapper.map(p,PostResponseDto.class))
                .toList();
    }

    @Override
    @Cacheable(cacheNames = "posts",key = "#id")
    public PostResponseDto getPostById(Long id) {
        Post post= postRepository.findById(id).orElseThrow(()->new RuntimeException("Post Not found"));
        return modelMapper.map(post,PostResponseDto.class);
    }

    @Override
    @CachePut(cacheNames = "posts",key = "#updatePostDto.id")
    public PostResponseDto updatedPost(UpdatePostDto updatePostDto) {
        Post post=postRepository.findById(updatePostDto.getId()).orElseThrow(()->new RuntimeException("Post not found"));
        post.setTitle(updatePostDto.getTitle());
        post.setDescription(updatePostDto.getDescription());
        post.setLikes(updatePostDto.getLikes());
        post.setComments(updatePostDto.getComments());
        Post saved=postRepository.save(post);
        return modelMapper.map(saved,PostResponseDto.class);
    }

    @Override
    @CacheEvict(cacheNames = "posts",key = "#id")
    public PostDeleteResponseDto deletePostById(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new RuntimeException("Post not found"));
//        postRepository.delete(post);
        return PostDeleteResponseDto
                .builder()
                .message("Post Deleted successfully.")
                .build();
    }
}
