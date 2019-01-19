package com.group4.project.DataService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.group4.project.DataService.DAO.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DataServiceApplicationTests {
	private MockMvc mockMvc;
	

	@Test
	public void contextLoads() {
	}
	
	@InjectMocks
	private UserDAO dao;
	@Before
	public void setUp() throws Exception{
		
	}
	

}

