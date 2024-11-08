package com.tushar.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference; // Import Jackson annotations

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private String title;

    @Column(length = 1000)
    private String content;

    private String imageName;

    private Date postDate;

    @ManyToOne
    @JsonIgnore  // Ignore this field in the Post serialization to prevent recursion
    private User user;

    @ManyToOne
    @JsonIgnore  // Ignore this field in the Post serialization to prevent recursion
    private Category category;
}

