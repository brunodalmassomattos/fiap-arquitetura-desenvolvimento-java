package br.com.fiap.apiredesocial.repositories;

import br.com.fiap.apiredesocial.domain.post.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
    List<Tag> findAllByTagIn(List<String> tags);
}
