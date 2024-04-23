package br.com.fiap.apiredesocial.domain.user;

import br.com.fiap.apiredesocial.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Post> post = new ArrayList<>();

}
