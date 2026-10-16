package edu.bellevue.cis530.week6.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bellevue.cis530.week6.dto.PostDto;
import edu.bellevue.cis530.week6.service.PostClientService;

@RestController
@RequestMapping("/client/posts")
public class PostClientController {

	private final PostClientService postClientService;

	public PostClientController(PostClientService postClientService) {
		this.postClientService = postClientService;
	}

	@GetMapping
	public List<PostDto> getPosts() {
		return postClientService.getPosts();
	}

	@GetMapping("/{id}")
	public PostDto getPostById(@PathVariable Long id) {
		return postClientService.getPostById(id);
	}
}
