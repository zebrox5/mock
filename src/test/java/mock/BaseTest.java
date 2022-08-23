package mock;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:mock-servlet-test.xml")
@WebAppConfiguration
public class BaseTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	protected MockMvc mockMvc;
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		 TestSetup.setup(true, true, true);
//	}
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void givenWac_whenServletContext_thenItProvidesIcodController () {
		ServletContext servletContext = webApplicationContext.getServletContext();
		
		assertNotNull(servletContext);
		assertTrue(servletContext instanceof MockServletContext);
		assertNotNull(webApplicationContext.getBean("testController"));
	}
//	 private MockMvc mockMvc;

//	    @Before
//	    public void setup() {
//	        this.mockMvc = MockMvcBuilders.standaloneSetup(new IcodController()).build();
//	    }
//
//	    @Test
//	    public void testHomePage() throws Exception {
//	        this.mockMvc.perform(get("/"))
//	                .andExpect(status().isOk())
//	                .andExpect(view().name("index"))
//	                .andDo(MockMvcResultHandlers.print())
//	                .andReturn();
//	    }
//
//	    @Test
//	    public void testMessagePage() throws Exception {
//	        this.mockMvc.perform(get("/message")).andExpect(status().isOk())
//	                .andExpect(content().string("Hello there!"));
//	    }
}