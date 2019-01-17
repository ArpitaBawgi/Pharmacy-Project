package com.group4.project.DataService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.group4.project.DataService.DAO.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DataServiceApplicationTests {

	private MockMvc mockMvc;

	@InjectMocks
	private UserDAO dao;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(dao).build();
	}
/*
	@Test
	public void testUser() throws Exception {
		mockMvc.perform(get("/json").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.*", Matchers.hasSize(3)));
	}*/

	@Test
	public void verifyToDoById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/post/json").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.userID").exists()).andExpect(jsonPath("$.userName").exists())
				.andExpect(jsonPath("$.password").exists()).andExpect(jsonPath("$.userID").value(4))
				.andExpect(jsonPath("$.userName").value("Nitin")).andExpect(jsonPath("$.password").value("nitin123"))
				.andDo(print());
	}

}
