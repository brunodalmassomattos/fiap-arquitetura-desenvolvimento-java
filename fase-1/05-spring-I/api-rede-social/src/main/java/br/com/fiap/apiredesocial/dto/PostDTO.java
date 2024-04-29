package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Comment;
import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.domain.post.Tag;
import br.com.fiap.apiredesocial.domain.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record PostDTO(String id, String title, String content, int likes, String userId, List<String> tags) {

    public static Post toPost(PostDTO postDTO) {
        return Post.builder()
                .title(postDTO.title())
                .content(postDTO.content())
                .likes(0)
                .user(User.builder().id(postDTO.userId).build())
                .tags(fromTag(postDTO.tags))
                .build();
    }

    private static List<Tag> fromTag(List<String> tags) {
        return tags.stream()
                .map(tag -> Tag.builder().tag(tag).build())
                .collect(Collectors.toList());
    }
}
