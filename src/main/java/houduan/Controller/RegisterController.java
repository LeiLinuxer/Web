package houduan.Controller;


import houduan.Object.User;
import houduan.Service.Result;
import houduan.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Result<Void>> register(@RequestParam(value = "username", required = false) String username,
                                                 @RequestParam(value = "realName", required = false) String realName,
                                                 @RequestParam(value="password", required = false) String password, // 密码参数接收
                                                 @RequestParam(value = "age", required = false) String ageStr) {
        System.out.println("进");
        // 2. 还是原来的参数校验
        if (username == null || username.trim().isEmpty()) {
            return ResponseEntity.status(400).body(Result.fail(400,"用户名为空"));
        }
        if (realName == null || realName.trim().isEmpty()) {
            return ResponseEntity.status(400).body(Result.fail(400,"姓名为空"));
        }
        int age;
        try {
            age = ageStr != null && !ageStr.isEmpty() ? Integer.parseInt(ageStr) : 0;
            if (age < 0 || age > 150) {
                return ResponseEntity.status(400).body(Result.fail(400,"年龄范围错误"));
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body(Result.fail(400,"年龄格式错误"));
        }

        // 3. 调用 UserService 处理业务（原来的逻辑移到 service 里了）
        User user = new User(username, realName, password, age); // 创建用户对象
        try {
            if(userService.register(user)) {
                return ResponseEntity.ok(Result.success("成功"));
            } else {
                Result<Void> result = Result.fail(409, "用户名已存在");
                return ResponseEntity.status(409).body(Result.fail(409,"用户名已经存在"));
            }

        } catch (Exception e) {
            System.err.println("注册接口异常：");
            e.printStackTrace(); // 生产环境建议用logback/log4j记录，而非System.err
            // 前端：只返回通用提示，不暴露底层错误
            return ResponseEntity.status(500).body(Result.fail(500, "系统暂时繁忙，请稍后再试"));

        }
    }
}
