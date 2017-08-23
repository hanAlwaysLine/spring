import java.sql.*;

/**
 * Created by Administrator on 2017/8/21.
 */
public class Test {
    public static void main(String args[]){
        Connection con = getConnection();
    }
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:192.168.1.149:orcl","scott","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void free(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void free(Connection connection, PreparedStatement preparedStatement) {
        free(connection, preparedStatement,null);
    }
}
