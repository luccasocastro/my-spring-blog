package com.luxkapotter.My.Spring.Blog.services;

import com.luxkapotter.My.Spring.Blog.entities.Post;
import com.luxkapotter.My.Spring.Blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(Long id){
        return repository.findById(id).get();
    }

    public void savePost(Post post){
        repository.save(post);
    }

    public void deletePost(Long id){
        repository.deleteById(id);
    }

}
