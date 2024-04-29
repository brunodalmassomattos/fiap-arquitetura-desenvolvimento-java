package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Tag;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record TagDTO(String postId, List<String> tags) implements Serializable {

    public static List<Tag> toTag(List<String> tags, String postId) {
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
            return new TagDTO(null, Collections.singletonList(item.getTag()));
        }).collect(Collectors.toList());
    }

}
