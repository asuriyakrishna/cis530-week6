package edu.bellevue.cis530.week6.client;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import edu.bellevue.cis530.week6.dto.PostDto;
import edu.bellevue.cis530.week6.exception.ApiClientException;
import edu.bellevue.cis530.week6.exception.ResourceNotFoundException;

@Component
public class JsonPlaceholderClient {

	private final WebClient webClient;

	public JsonPlaceholderClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public List<PostDto> getAllPosts() {
		try {
			return webClient.get()
					.uri("/posts")
					.retrieve()
					.bodyToFlux(PostDto.class)
					.collectList()
					.block();
		} catch (WebClientResponseException exception) {
			throw new ApiClientException("JSONPlaceholder returned an error while retrieving posts", exception);
		} catch (WebClientRequestException exception) {
			throw new ApiClientException("Unable to connect to JSONPlaceholder", exception);
		}
	}

	public PostDto getPostById(Long id) {
		try {
			return webClient.get()
					.uri("/posts/{id}", id)
					.retrieve()
					.bodyToMono(PostDto.class)
					.block();
		} catch (WebClientResponseException.NotFound exception) {
			throw new ResourceNotFoundException("Post with ID " + id + " was not found");
		} catch (WebClientResponseException exception) {
			throw new ApiClientException("JSONPlaceholder returned an error while retrieving post " + id, exception);
		} catch (WebClientRequestException exception) {
			throw new ApiClientException("Unable to connect to JSONPlaceholder", exception);
		}
	}

	public List<PostDto> getPostsByUserId(Long userId) {
		try {
			return webClient.get()
					.uri(uriBuilder -> uriBuilder.path("/posts").queryParam("userId", userId).build())
					.retrieve()
					.bodyToFlux(PostDto.class)
					.collectList()
					.block();
		} catch (WebClientResponseException exception) {
			throw new ApiClientException("JSONPlaceholder returned an error while retrieving posts for user " + userId,
					exception);
		} catch (WebClientRequestException exception) {
			throw new ApiClientException("Unable to connect to JSONPlaceholder", exception);
		}
	}
}
