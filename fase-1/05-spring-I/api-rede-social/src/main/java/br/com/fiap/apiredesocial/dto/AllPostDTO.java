package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Post;

import java.util.List;
import java.util.stream.Collectors;

public record AllPostDTO(String id, String title, String content, Integer likes, UserDTO user, List<TagDTO> tags,
                         List<CommentDTO> comments) {

    public static List<AllPostDTO> fromGetAll(List<Post> allPost) {
        return allPost.stream()
                .map(post -> new AllPostDTO(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getLikes(),
                        new UserDTO(post.getUser().getId(), post.getUser().getName(), post.getUser().getEmail(), null),
                        TagDTO.toTagDTO(post.getTags()),
                        CommentDTO.toCommentsDTO(post.getComments())
                ))
                .collect(Collectors.toList());
    }
}
