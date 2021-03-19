package com.tomgregory;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class JenkinsSbApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void findAllTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8019/ride")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}
	
	@Test
	public void findByIdTest() throws Exception  {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8019/ride/1")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andReturn();
	}
	
	@Test
	public void findByIdNegativeTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8019/ride/5")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andReturn();
	}
	
	@Test
	public void createRideTest() throws Exception {
		String rideData = "{\n" + 
				"    \"name\":\"Monorail\",\n" + 
				"    \"description\":\"Sedate Ride\",\n" + 
				"    \"thrillFactor\":2,\n" + 
				"    \"VomitFactor\":1\n" + 
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8019/ride")
				.contentType(MediaType.APPLICATION_JSON)
				.content(rideData)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}
}
