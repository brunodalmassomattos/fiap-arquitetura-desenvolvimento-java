package br.com.fiap.apiredesocial.domain.post;

import br.com.fiap.apiredesocial.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String content;
    private Integer like;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

}
