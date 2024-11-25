package com.tushar.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference; // Import Jackson annotation

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@Table(name = "userss")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String password;
    private String email;
    private String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore  // Optionally, you can also ignore posts in User to break the cycle in both directions
    private List<Post> posts = new ArrayList<>();
}
