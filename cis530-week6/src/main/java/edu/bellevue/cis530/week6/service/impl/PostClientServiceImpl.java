package edu.bellevue.cis530.week6.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bellevue.cis530.week6.client.JsonPlaceholderClient;
import edu.bellevue.cis530.week6.dto.PostDto;
import edu.bellevue.cis530.week6.service.PostClientService;

@Service
public class PostClientServiceImpl implements PostClientService {

	private final JsonPlaceholderClient jsonPlaceholderClient;

	public PostClientServiceImpl(JsonPlaceholderClient jsonPlaceholderClient) {
		this.jsonPlaceholderClient = jsonPlaceholderClient;
	}

	@Override
	public List<PostDto> getPosts() {
		return jsonPlaceholderClient.getPosts();
	}

	@Override
	public PostDto getPostById(Long id) {
		return jsonPlaceholderClient.getPostById(id);
	}
}
