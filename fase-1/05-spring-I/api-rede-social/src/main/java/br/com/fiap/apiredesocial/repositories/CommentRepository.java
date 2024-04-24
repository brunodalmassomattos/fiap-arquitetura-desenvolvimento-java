package br.com.fiap.apiredesocial.repositories;

import br.com.fiap.apiredesocial.domain.post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
