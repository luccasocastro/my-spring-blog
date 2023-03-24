package com.luxkapotter.My.Spring.Blog.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

public record CommentResponseDTO(
    @NotBlank
    String title,
    @Lob 
    @NotBlank
    String body,
    @DateTimeFormat(pattern = "dd/MM/yyyy") 
    LocalDate date) {
}
