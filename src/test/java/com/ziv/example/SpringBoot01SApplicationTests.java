package com.ziv.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ziv.example.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01SApplicationTests {

	private MockMvc mvc;
	
	public void befor() {
		this.mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void contextLoads() {
		RequestBuilder req = get("/user");
		try {
			mvc.perform(req).andExpect(status().isOk()).andExpect(content().string("还漏"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
