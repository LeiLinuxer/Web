package houduan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class dengluController {
    @RequestMapping("/login")
    public String redirectToVueApp() {
        return "forward:./vue/login.html";
    }
}
