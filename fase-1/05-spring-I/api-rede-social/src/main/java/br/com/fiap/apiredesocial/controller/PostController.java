package br.com.fiap.apiredesocial.controller;

import br.com.fiap.apiredesocial.dto.PostDTO;
import br.com.fiap.apiredesocial.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.create(postDTO));
    }

    @GetMapping("/like/{postId}")
    public ResponseEntity<Void> like(@PathVariable("postId") String postId) {
        this.postService.addLike(postId);
        return ResponseEntity.ok().build();
    }

}
