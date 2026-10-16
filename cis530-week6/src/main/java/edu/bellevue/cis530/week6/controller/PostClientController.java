package edu.bellevue.cis530.week6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<PostDto>> getAllPosts() {
		return ResponseEntity.ok(postClientService.getAllPosts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
		return ResponseEntity.ok(postClientService.getPostById(id));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(postClientService.getPostsByUserId(userId));
	}
}
