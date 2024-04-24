package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.post.Tag;
import br.com.fiap.apiredesocial.dto.TagDTO;
import br.com.fiap.apiredesocial.repositories.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    private TagRepository tagRepository;

    public TagDTO save(List<Tag> tags) {

        this.tagRepository.saveAll(tags);

        return null;
    }
}
