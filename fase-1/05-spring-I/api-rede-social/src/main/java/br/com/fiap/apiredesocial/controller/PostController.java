package br.com.fiap.apiredesocial.controller;

import br.com.fiap.apiredesocial.dto.AllPostDTO;
import br.com.fiap.apiredesocial.dto.PostDTO;
import br.com.fiap.apiredesocial.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping
    public ResponseEntity<List<AllPostDTO>> getAll() {
        return ResponseEntity.ok(this.postService.getAll());
    }

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO) {
        PostDTO post = postService.create(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @PostMapping("/like/{postId}")
    public ResponseEntity<Void> like(@PathVariable("postId") String postId) {
        this.postService.addLike(postId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/comment/{postId}")
    public ResponseEntity<Void> comment(@PathVariable("postId") String postId, @RequestBody String comment) {
        this.postService.addComment(postId, comment);
        return ResponseEntity.ok().build();
    }

}
