package houduan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrieviousController {

        // 访问路径：http://localhost:8080/test
        @GetMapping("/test")
        public String test(Model model) {
            // 向模型中添加数据（key为"message"，value为"Hello Thymeleaf!"）
            model.addAttribute("message", "Hello Thymeleaf!");
            // 返回视图名：对应 /WEB-INF/templates/index.html
            return "index";
        }
}