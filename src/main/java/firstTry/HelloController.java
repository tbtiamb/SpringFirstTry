package firstTry;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

//@Controller
@RestController
//@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    //@ResponseBody
    public String printHello(){//(ModelMap model) {
        //model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }
}