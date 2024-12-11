package com.tickets.tickets.domain.ports.input;

import com.tickets.tickets.domain.model.GitHubUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface GitHubUserUseCase {
    GitHubUserResponse searchUsers(String query);
}
