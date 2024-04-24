package br.com.fiap.apiredesocial.repositories;

import br.com.fiap.apiredesocial.domain.post.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
