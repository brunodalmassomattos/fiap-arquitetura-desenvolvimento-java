package br.com.fiap.apiredesocial.repositories;

import br.com.fiap.apiredesocial.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
