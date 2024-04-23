package br.com.fiap.apiredesocial.controller;

import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.domain.post.Tag;
import br.com.fiap.apiredesocial.domain.user.User;
import br.com.fiap.apiredesocial.dto.PostDTO;
import br.com.fiap.apiredesocial.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostDTO postDTO) {
        Post post = Post.builder()
                .title(postDTO.title())
                .content(postDTO.content())
                .like(0)
                .user(User.builder()
                        .id(postDTO.userId())
                        .build())
                .tags(PostDTO.toTagPost(postDTO.tags()))
                .build();

        this.postService.create(post);

        return null;
    }

}
