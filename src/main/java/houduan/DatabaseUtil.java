package houduan;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    // 静态代码块：加载配置 + 注册驱动
    static {
        try (InputStream is = DatabaseUtil.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (is == null) {
                throw new RuntimeException("找不到 database.properties 配置文件");
            }
            Properties prop = new Properties();
            prop.load(is);
            driver = prop.getProperty("jdbc.driver");
            url = prop.getProperty("jdbc.url");
            username = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");
            Class.forName(driver); // 注册 JDBC 驱动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // 关闭资源
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}