package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Tag;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record PostDTO(String title, String content, String userId, List<String> tags) {
    public static List<Tag> toTagPost(List<String> tags) {

        if (tags == null) {
            return Collections.emptyList();
        }

        return tags.stream()
                .map(item -> {
                    Tag tag = new Tag();
                    tag.setTags(item);
                    return tag;
                })
                .collect(Collectors.toList());
    }
}
