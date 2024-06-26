package br.com.fiap.apiredesocial.controller;

import br.com.fiap.apiredesocial.domain.user.User;
import br.com.fiap.apiredesocial.dto.LoginRequestDTO;
import br.com.fiap.apiredesocial.dto.ResponseDTO;
import br.com.fiap.apiredesocial.infra.security.TokenService;
import br.com.fiap.apiredesocial.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getId(), user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}
