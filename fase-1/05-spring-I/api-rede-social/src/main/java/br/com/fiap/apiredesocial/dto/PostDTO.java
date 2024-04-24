package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.domain.user.User;

import java.util.List;

public record PostDTO(String title, String content, String userId, List<String> tags) {

    public static Post toPost(PostDTO postDTO) {
        return Post.builder()
                .title(postDTO.title())
                .content(postDTO.content())
                .likes(0)
                .user(User.builder()
                        .id(postDTO.userId())
                        .build())
                .build();
    }
}
