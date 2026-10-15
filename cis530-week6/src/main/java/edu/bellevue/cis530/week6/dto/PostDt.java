package edu.bellevue.cis530.week6.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Data 
@AllArgsConstructor 
public class PostDt {

	@NotNull (message = "User ID is required")
	@Min (value = 1, message = "User ID must be atleast 1")
	private Long userId;
	private Long id;
	@NotBlank(message = "Title is required")
	private String title;
	@NotBlank (message = "Body is required")
	private String body;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
