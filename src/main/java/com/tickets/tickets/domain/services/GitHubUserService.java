package com.tickets.tickets.domain.services;

import com.tickets.tickets.domain.model.GitHubUserResponse;
import com.tickets.tickets.domain.ports.input.GitHubUserUseCase;
import com.tickets.tickets.domain.ports.output.GitHubAdapterPort;
import org.springframework.stereotype.Service;

@Service
public class GitHubUserService implements GitHubUserUseCase {

    private final GitHubAdapterPort gitHubAdapterPort;

    public GitHubUserService(GitHubAdapterPort gitHubAdapterPort) {
        this.gitHubAdapterPort = gitHubAdapterPort;
    }

    @Override
    public GitHubUserResponse searchUsers(String query) {
        // Llamada al adaptador para obtener la respuesta de GitHub
        GitHubUserResponse gitHubUserResponse = gitHubAdapterPort.fetchUsersFromGitHub(query);
        return gitHubUserResponse;
    }
}
