package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.post.Comment;
import br.com.fiap.apiredesocial.domain.post.Post;
import br.com.fiap.apiredesocial.domain.post.Tag;
import br.com.fiap.apiredesocial.dto.AllPostDTO;
import br.com.fiap.apiredesocial.dto.PostDTO;
import br.com.fiap.apiredesocial.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;
    private TagService tagService;
    private CommentService commentService;

    public PostDTO create(PostDTO postDTO) {
        Post savePost = this.postRepository.save(PostDTO.toPost(postDTO));
        return new PostDTO(savePost.getId(), savePost.getTitle(), savePost.getContent(), savePost.getLikes(), postDTO.userId(), null);
    }

    public void addLike(String postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setLikes(post.getLikes() + 1);

        this.postRepository.save(post);
    }

    public void addComment(String postIdRequest, String commentRequest) {
        var post = this.postRepository.getReferenceById(postIdRequest);

        Comment comment = Comment.builder()
                .comment(commentRequest)
                .post(post)
                .build();

        this.commentService.save(comment);
    }

    public List<AllPostDTO> getAll() {
        return AllPostDTO.fromGetAll(this.postRepository.findAll());
    }

    public List<AllPostDTO> getPostsByTags(List<String> tags) {
        return AllPostDTO.toAllPostDTO(this.tagService.getAllPost(tags));
    }
}
