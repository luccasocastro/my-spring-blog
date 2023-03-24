package com.luxkapotter.My.Spring.Blog.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "tb_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @NotBlank
    @Getter @Setter
    private String title;
    @NotBlank
    @Getter @Setter
    private String author;
    @Getter @Setter
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    @Getter @Setter
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
