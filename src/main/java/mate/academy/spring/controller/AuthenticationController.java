package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseMapper userResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseMapper mapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = mapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        return userResponseMapper.toDto(authenticationService
                .register(requestDto.getEmail(),
                        requestDto.getPassword()));
    }
}
