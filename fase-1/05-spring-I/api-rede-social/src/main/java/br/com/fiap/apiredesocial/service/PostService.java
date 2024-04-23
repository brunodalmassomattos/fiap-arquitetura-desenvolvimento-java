package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;


    public void create(Post post) {
    }
}
