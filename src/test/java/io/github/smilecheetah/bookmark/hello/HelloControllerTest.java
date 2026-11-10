package io.github.smilecheetah.bookmark.hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloReturnsGreeting() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello, bookmark!"));
	}

	@Test
	void unknownPathReturns404() throws Exception {
		mockMvc.perform(get("/nope"))
			.andExpect(status().isNotFound());
	}

}
