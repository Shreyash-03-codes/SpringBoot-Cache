package com.cache.redis.springboot.repositories;

import com.cache.redis.springboot.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
