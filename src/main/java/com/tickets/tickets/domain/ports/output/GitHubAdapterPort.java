package com.tickets.tickets.domain.ports.output;

import com.tickets.tickets.domain.model.GitHubUserResponse;

public interface GitHubAdapterPort {
    GitHubUserResponse fetchUsersFromGitHub(String query);
}
