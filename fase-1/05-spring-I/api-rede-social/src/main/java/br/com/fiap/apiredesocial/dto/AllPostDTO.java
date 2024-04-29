package br.com.fiap.apiredesocial.dto;

import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.domain.post.Tag;

import java.util.ArrayList;
import java.util.List;

public record AllPostDTO(String id, String title, String content, Integer likes, UserDTO user, List<TagDTO> tags) {

    public static List<AllPostDTO> fromGetAll(List<Post> allPost) {
        List<AllPostDTO> allPostDTOS = new ArrayList<>();

        AllPostDTO allPostDTO;
        for (Post post : allPost) {
            allPostDTO = new AllPostDTO(
                    post.getId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getLikes(),
                    new UserDTO(null, post.getUser().getName(), post.getUser().getEmail(), null),
                    TagDTO.toTagDTO(post.getTags())
            );
            allPostDTOS.add(allPostDTO);
        }

        return null;
    }
}
