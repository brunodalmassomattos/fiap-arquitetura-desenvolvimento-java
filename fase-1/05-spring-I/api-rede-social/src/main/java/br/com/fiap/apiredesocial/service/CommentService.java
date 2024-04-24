package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.post.Comment;
import br.com.fiap.apiredesocial.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

}
