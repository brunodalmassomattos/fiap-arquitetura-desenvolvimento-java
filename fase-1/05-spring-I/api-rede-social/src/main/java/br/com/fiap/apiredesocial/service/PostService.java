package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.dto.PostDTO;
import br.com.fiap.apiredesocial.dto.TagDTO;
import br.com.fiap.apiredesocial.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;
    private TagService tagService;

    public PostDTO create(PostDTO postDTO) {
        Post retorno = this.postRepository.save(PostDTO.toPost(postDTO));

        if (postDTO.tags() == null || postDTO.tags().isEmpty()) {
            return new PostDTO(retorno.getTitle(), retorno.getContent(), retorno.getId(), new ArrayList<>());
        }

        this.tagService.save(TagDTO.toTag(postDTO.tags(), retorno.getId()));
        return new PostDTO(retorno.getTitle(), retorno.getContent(), retorno.getId(), new ArrayList<>());
    }
}
