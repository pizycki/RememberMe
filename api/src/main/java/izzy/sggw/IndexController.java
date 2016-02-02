package izzy.sggw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Paweł on 30.01.2016.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index.html";
    }
}
