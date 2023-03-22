package com.luxkapotter.My.Spring.Blog.repositories;

import com.luxkapotter.My.Spring.Blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
