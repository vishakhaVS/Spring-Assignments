/*
import java.sql.*;

public class MyDatabase {
    public static void main(String[] args) throws SQLException {


        String driverName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverName).newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionString = "jdbc:mysql://localhost:3306/springDemo";
        String username = "root";
        String password = "Vishakha@1234";
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection(connectionString,
                    username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM user");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        while (resultSet.next()) {
            try {
                System.out.println(resultSet.getString("name"));
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }}*/
