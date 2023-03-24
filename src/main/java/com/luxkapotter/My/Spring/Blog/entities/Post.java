package com.luxkapotter.My.Spring.Blog.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    @NotBlank
    @Lob
    private String body;

    public Post(Long id, String title, String author, LocalDate date, String body) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
