package houduan.DAO;


import houduan.Object.User;
import java.sql.SQLException;

// DAO 接口：定义用户相关的数据库操作（只声明方法，不写实现）
public interface UserDAO {
    // 1. 查：用户名是否存在
    boolean existsByUsername(String username) throws SQLException;

    // 2. 增：插入新用户
    boolean insert(User user) throws SQLException;

    boolean SelectDatabaseUser(String username, String password) throws SQLException;
    // 后续可添加其他操作（如查用户、更新用户等）
}