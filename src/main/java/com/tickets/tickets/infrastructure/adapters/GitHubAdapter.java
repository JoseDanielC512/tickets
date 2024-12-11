package com.tickets.tickets.infrastructure.adapters;

import com.tickets.tickets.domain.model.GitHubUserResponse;
import com.tickets.tickets.domain.ports.output.GitHubAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubAdapter implements GitHubAdapterPort {

    private static final String GITHUB_API_URL = "https://api.github.com/search/users?q=";

    @Override
    public GitHubUserResponse fetchUsersFromGitHub(String query) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(GITHUB_API_URL + query, GitHubUserResponse.class);
    }
}
