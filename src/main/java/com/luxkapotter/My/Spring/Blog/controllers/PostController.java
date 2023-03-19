package com.luxkapotter.My.Spring.Blog.controllers;

import com.luxkapotter.My.Spring.Blog.entities.Post;
import com.luxkapotter.My.Spring.Blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/posts")
    public String getPosts(ModelMap model){
        List<Post> list = service.findAll();
        model.addAttribute("post", list);
        return "posts";
    }

    @GetMapping(value = "/posts/{id}")
    public ModelAndView postById(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post obj = service.findById(id);
        mv.addObject("post", obj);
        return mv;
    }

    @GetMapping(value = "/newPost")
    public String getPostForm(){
        return "postForm";
    }

    @PostMapping(value = "/newPost")
    public String savePost(Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newPost";
        }
        post.setDate(LocalDate.now());
        service.savePost(post);
        return "redirect:/posts";
    }
}
