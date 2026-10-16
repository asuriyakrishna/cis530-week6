package edu.bellevue.cis530.week6.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	@NotNull(message = "User ID is required")
	@Min(value = 1, message = "User ID must be at least 1")
	private Long userId;

	private Long id;

	@NotBlank(message = "Title is required")
	private String title;

	@NotBlank(message = "Body is required")
	private String body;
}
