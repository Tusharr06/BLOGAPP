package com.tushar.blog.controllers;

import com.tushar.blog.model.Post;
import com.tushar.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userid}/category/{categoryid}/posts")
    public ResponseEntity<Post> create(@RequestBody Post post, @PathVariable Integer userid, @PathVariable Integer categoryid) {
        postService.savePost(post, userid, categoryid);
        return ResponseEntity.ok(post);
    }
}
