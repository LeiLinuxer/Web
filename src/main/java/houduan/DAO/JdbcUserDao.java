package houduan.DAO;



import houduan.Object.User;
import houduan.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
@Repository
// DAO 实现类：用 JdbcTemplate 实现数据库操作
public class JdbcUserDao implements UserDAO {

    // 注入 Spring 管理的 JdbcTemplate（后续在 XML 中配置）
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    private User temp;

    public User getTemp() {
        return temp;
    }
    // 实现“用户名是否存在”查询
    @Override
    public boolean existsByUsername(String username) throws SQLException {
        String sql = "SELECT COUNT(1) FROM User_table WHERE username = ?";
        // 用 JdbcTemplate 执行查询，返回结果（1 表示存在，0 表示不存在）
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count != null && count > 0;
    }

    // 实现“插入用户”操作
    @Override
    public boolean insert(User user) throws SQLException {
        String sql = "INSERT INTO User_table (username, real_name, age) VALUES (?, ?, ?,?)";
        // 用 JdbcTemplate 执行更新，返回影响行数
        int rows = jdbcTemplate.update(sql,
                user.getUsername(),
                user.getRealName(),
                user.getPassword(),
                user.getAge());
        return rows > 0;
    }

    @Override
    public boolean SelectDatabaseUser(String username, String password) throws SQLException {
        try{
            String sqlg = "SELECT * FROM User_table WHERE username = ? AND password = ?";
            String sqlc= "SELECT COUNT(1) FROM User_table WHERE username = ? AND password = ?";
            Integer count = jdbcTemplate.queryForObject(sqlc, Integer.class, username, password);
            if(count != null && count > 0){
                jdbcTemplate.queryForObject(sqlg, (rs, rowNum) -> {
                    temp=new User(
                            rs.getString("username"),
                            rs.getString("real_name"),
                            rs.getString("password"),
                            rs.getInt("age")
                    );
                    return temp;
                }, username, password);
                return true;
            }
            temp=null;
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}