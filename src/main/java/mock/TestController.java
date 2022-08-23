package mock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
    @RequestMapping(value = "/mockurl.html", method = RequestMethod.GET)
	public String testMock() {
    	System.out.println("Inside mock 1");
		return "mock";
	}
    

    @RequestMapping(value = "/mockmavurl.html", method = RequestMethod.GET)
	public ModelAndView testMockMav() {
    	System.out.println("Inside mock 2");

    	ModelAndView mav = new ModelAndView("mock");
		return mav;
	}
    

//    @RequestMapping(value = "/mockObject", method = RequestMethod.GET)
//	public @ResponseBody String testObject(@RequestParam(value = "country") Country country) {
//		return country.getName();
//	}

    @RequestMapping(value = "/mockObject", method = RequestMethod.GET)
	public @ResponseBody String testObject(@RequestParam(value = "country") String country) {
		return country;
	}
}
