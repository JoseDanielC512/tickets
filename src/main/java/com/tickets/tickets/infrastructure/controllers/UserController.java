package com.tickets.tickets.infrastructure.controllers;

import com.tickets.tickets.domain.model.GitHubUserResponse;
import com.tickets.tickets.domain.ports.input.GitHubUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final GitHubUserUseCase gitHubUserUseCase;

    public UserController(GitHubUserUseCase gitHubUserUseCase) {
        this.gitHubUserUseCase = gitHubUserUseCase;
    }

    @GetMapping("/github/users")
    public ResponseEntity<GitHubUserResponse> getGitHubUsers(@RequestParam("q") String query) {
        // Se obtiene la respuesta de GitHub y se mapea a un DTO
        GitHubUserResponse response = gitHubUserUseCase.searchUsers(query);
        return ResponseEntity.ok(response);
    }
}
