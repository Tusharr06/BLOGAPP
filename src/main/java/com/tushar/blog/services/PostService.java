package com.tushar.blog.services;

import com.tushar.blog.model.Category;
import com.tushar.blog.model.Post;
import com.tushar.blog.model.User;
import com.tushar.blog.repositories.CategoryRepo;
import com.tushar.blog.repositories.PostRepo;
import com.tushar.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Post> getAllByUser(User user) {return postRepo.findByUser(user);
    }
    public List<Post> getAllByCategory(Category category){
        return postRepo.findByCategory(category);
    }
    public Post getPostById(int id) {
        return postRepo.findById(id).get();
    }
    public Post savePost(Post post ,Integer userId,Integer categoryId) {
        User user = userRepo.findById(userId).get();
        Category category = categoryRepo.findById(categoryId).get();
      Post postSaved = new Post();
      postSaved.setUser(user);
      postSaved.setCategory(category);
       postSaved.setTitle(post.getTitle());
      postSaved.setContent(post.getContent());
return postRepo.save(postSaved);
    }
    public Post updatePost(Post post,Integer userId,Integer categoryId) {

        User user = userRepo.findById(userId).get();
        Category category = categoryRepo.findById(categoryId).get();
        Post postSaved = new Post();
        postSaved.setUser(user);
        postSaved.setPostDate(post.getPostDate());
        postSaved.setImageName(post.getImageName());
        postSaved.setCategory(category);
        postSaved.setTitle(post.getTitle());
        postSaved.setContent(post.getContent());
        return postRepo.save(postSaved);
    }
    public void deletePost(int id) {
        postRepo.deleteById(id);
    }
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

}