package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Tag;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record TagDTO(String tagId, String tag) implements Serializable {

    public static List<Tag> toTag(String tagId, List<String> tags) {
        if (tags == null) {
            return Collections.emptyList();
        }

        return tags.stream().map(item -> {
            return Tag.builder()
                    .tag(item)
                    .build();
        }).collect(Collectors.toList());
    }

    public static List<TagDTO> toTagDTO(List<Tag> tags) {
        if (tags == null) {
            return Collections.emptyList();
        }

        return tags.stream().map(item -> {
            return new TagDTO(item.getId(), item.getTag());
        }).collect(Collectors.toList());
    }

}
