package br.com.fiap.apiredesocial.domain.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String tags;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
