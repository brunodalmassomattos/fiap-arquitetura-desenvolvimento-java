package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Post;
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
                    .posts(Post.builder()
                            .id(postId)
                            .build())
                    .build();
        }).collect(Collectors.toList());
    }

}
