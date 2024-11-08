package com.tushar.blog.repositories;

import com.tushar.blog.model.Category;
import com.tushar.blog.model.Post;
import com.tushar.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
