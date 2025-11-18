package houduan.Controller;

import houduan.Object.User;
import houduan.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class SignInController {
    private final UserService userService;

    @Autowired
    public SignInController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/SignServlet", method = RequestMethod.POST) // 修正引用
    @ResponseBody //响应体
    public Object SignIn(@RequestParam(value = "username", required = true) String username,
                       @RequestParam(value = "password", required = true) String password) throws SQLException {

        try{

            if(userService.login(username,password)!=null){
                User user=userService.login(username,password);
                return user;
            } else {
                return "invalid_credentials";
            }

        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }


    }
}



