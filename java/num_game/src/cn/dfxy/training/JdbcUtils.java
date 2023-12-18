package cn.dfxy.training;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static Properties properties;

    static {
        InputStream db = JdbcUtils.class.getClassLoader()
                .getResourceAsStream("db.properties");
        properties = new Properties();
        try {
            properties.load(db);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String url = properties.getProperty("url");
    private static String user = properties.getProperty("user");
    private static String password = properties.getProperty("password");
    private static String driverClass = properties.getProperty("driverClass");
    private static Connection conn = null;


    /**
     * getConnection ()方法，获得数据库连接方法
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * close方法，关闭数据库过程中的所有资源，包括数据集，PreparedStatement 对
     * 象和数据库连接对象
     *
     * @param rs    数据集
     * @param pstmt PreparedStatement对象
     * @param conn  连接对象
     */
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}