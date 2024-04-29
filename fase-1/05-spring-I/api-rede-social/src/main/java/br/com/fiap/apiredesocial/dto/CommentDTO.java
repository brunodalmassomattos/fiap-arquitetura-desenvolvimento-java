package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Comment;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record CommentDTO(String id, List<String> comments) {
    public static List<CommentDTO> toCommentsDTO(List<Comment> comments) {
        if (comments == null) {
            return Collections.emptyList();
        }

        return comments.stream().map(item -> {
            return new CommentDTO(item.getId(), Collections.singletonList(item.getComment()));
        }).collect(Collectors.toList());
    }
}
