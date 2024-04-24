package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.domain.post.Tag;
import br.com.fiap.apiredesocial.dto.PostDTO;
import br.com.fiap.apiredesocial.dto.TagDTO;
import br.com.fiap.apiredesocial.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;
    private TagService tagService;

    public PostDTO create(PostDTO postDTO) {
        Post savePost = this.postRepository.save(PostDTO.toPost(postDTO));

        List<Tag> saveTag = new ArrayList<>();
        if (postDTO.tags() != null || !postDTO.tags().isEmpty()) {
            saveTag = this.tagService.save(TagDTO.toTag(postDTO.tags(), savePost.getId()));

        }

        return new PostDTO(savePost.getId(), savePost.getTitle(), savePost.getContent(), savePost.getId(), saveTag.stream().map(Tag::getTag).collect(Collectors.toList()));
    }
}
