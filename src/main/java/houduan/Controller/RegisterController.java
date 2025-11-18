package houduan.Controller;


import houduan.Object.User;
import houduan.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod; // 修正导入
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;

@Controller
public class RegisterController{
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    // 使用构造器注入，避免 IDE 报警并更利于测试
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/RegisterServlet", method = RequestMethod.POST) // 修正引用
    @ResponseBody //响应体
    public String register(@RequestParam(value = "username", required = false) String username,
                           @RequestParam(value = "realName", required = false) String realName,
                           @RequestParam(value="password", required = false) String password, // 密码参数接收
                           @RequestParam(value = "age", required = false) String ageStr) {

        // 2. 还是原来的参数校验
        if (username == null || username.trim().isEmpty()) {
            return "username_empty";
        }
        if (realName == null || realName.trim().isEmpty()) {
            return "realname_empty";
        }
        int age;
        try {
            age = ageStr != null && !ageStr.isEmpty() ? Integer.parseInt(ageStr) : 0;
            if (age < 0 || age > 150) {
                return "age_invalid_range";
            }
        } catch (NumberFormatException e) {
            return "age_invalid_format";
        }

        // 3. 调用 UserService 处理业务（原来的逻辑移到 service 里了）
        User user = new User(username, realName, password, age); // 创建用户对象
        try {
            if(userService.register(user)) {
                return "success";
            } else {
                return "username_exists";
            }
            /*TODO: 要返回success和fail*/
        } catch (SQLException e) {
            logger.error("Database error when registering user {}", username, e);
            return "db_error";
        }
    }
}
