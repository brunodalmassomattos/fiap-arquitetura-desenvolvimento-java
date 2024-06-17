package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.post.Tag;
import br.com.fiap.apiredesocial.dto.AllPostDTO;
import br.com.fiap.apiredesocial.repositories.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    private TagRepository tagRepository;

    public List<Tag> save(List<Tag> tags) {
        return this.tagRepository.saveAll(tags);
    }

    public List<Tag> getAllPost(List<String> tags) {
        return this.tagRepository.findAllByTagIn(tags);
    }
}
