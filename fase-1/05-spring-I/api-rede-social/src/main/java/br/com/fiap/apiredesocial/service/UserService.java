package br.com.fiap.apiredesocial.service;

import br.com.fiap.apiredesocial.domain.user.User;
import br.com.fiap.apiredesocial.dto.UserDTO;
import br.com.fiap.apiredesocial.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserDTO save(User userRequest) {
        User save = this.userRepository.save(userRequest);
        return new UserDTO(save.getName(), save.getEmail(), save.getPassword());
    }

}
