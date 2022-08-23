package mock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MockControllerTest extends BaseTest {
	
	@Test
	public void mockObject() throws Exception {
		
		Country country = new Country();
		country.setName("United States");
		country.setCode("US");
		
		MvcResult mvcResult = this.mockMvc.perform(get("/mockObject")
//				.contentType(TestUtil.APPLICATION_JSON_UTF8)
//                .content(TestUtil.convertObjectToJsonBytes(country))
				.param("country", "US")
                )
		.andExpect(status().isOk())
		//.andExpect(status().isBadRequest())
		.andReturn();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String contentAsString = mvcResult.getResponse().getContentAsString();
		System.out.println("Response is : " + contentAsString);
		
		TypeReference<String> mapType = new TypeReference<String>() {};
		String jsonToPrintOutput = objectMapper.readValue(contentAsString, mapType);
		
		System.out.println(jsonToPrintOutput);
		
	}
	
	
	
	
	

	@Test
	public void homeIcod() throws Exception {
		this.mockMvc.perform(get("/mockurl.html")).andExpect(status().isOk())// we are expecting status to be ok
		 .andExpect(view().name("mock"));//it will redirect to jsp page
//		 .andExpect(forwardedUrl("/WEB-INF/jsp/mock.jsp"));
	}
	
//	@Test
//	public void homeIcodUsingTiles() throws Exception {
//		this.mockMvc.perform(get("/mockurl.html")).andExpect(status().isOk())// we are expecting status to be ok
//		 .andExpect(view().name("mock"))//it will redirect to jsp page
//		 //.andExpect(content().source(containsString("Manage Entities")));		
//		 ;
//	}
//	
//	
//	@Test
//	public void testMav() throws Exception {
//		this.mockMvc.perform(get("/mockmavurl.html")).andExpect(status().isOk())// we are expecting status to be ok
//		 .andExpect(view().name("mock"))//it will redirect to jsp page
//		 .andExpect(forwardedUrl("/WEB-INF/jsp/mock.jsp"));
//	}

}