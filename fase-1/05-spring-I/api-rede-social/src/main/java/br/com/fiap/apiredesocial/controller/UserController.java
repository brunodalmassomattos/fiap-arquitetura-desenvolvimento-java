package br.com.fiap.apiredesocial.controller;

import br.com.fiap.apiredesocial.domain.user.User;
import br.com.fiap.apiredesocial.dto.UserDTO;
import br.com.fiap.apiredesocial.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> user(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.save(new User(null, userDTO.name(), userDTO.email(), userDTO.password())));
    }


}
