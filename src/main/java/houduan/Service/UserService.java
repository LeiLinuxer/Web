package houduan.Service;

import houduan.DAO.JdbcUserDao;
import houduan.DatabaseUtil;
import houduan.Object.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
// 业务类：专门处理用户相关业务（注册、登录等）
public class UserService {

    @Autowired
    private JdbcUserDao userDao;

    public boolean register(User user) throws SQLException {
        if (userDao.existsByUsername(user.getUsername())) {
            return false;
        }

        return userDao.insert(user);
    }

    public User login(String username, String password) throws SQLException {
        if(userDao.SelectDatabaseUser(username, password)) {
            return userDao.getTemp();
        } else {
            return null;
        }
    }

}