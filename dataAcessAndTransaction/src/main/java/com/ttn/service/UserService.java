package com.ttn.service;

import com.ttn.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Service
public class UserService {


    @Autowired
    @Qualifier("dataSource")

    DataSource dataSource;

    void printUserNamesDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    @Autowired
    @Qualifier("dbcp2datasource")
    DataSource dbcp2datasource;

    void printUserNamesdbcp2datasource() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    @Autowired
    @Qualifier("dataSourceSingleton")
    DataSource dataSourceSingleton;

    void printUserNamesdataSourceSingleton() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }
}

@Repository
class UserDao {

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    void userCount() {
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }

    void getUserName() {
        String sql = "SELECT NAME FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForObject(sql, new Object[]{"vishakha@123"}, String.class));
    }

    void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,dob,age)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(), user.getPassword(), user.getName(), user.getDob(), user.getAge()});
    }

    void queryForMapDemo() {
        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{"vishakha@123"}));
    }

    void queryForListDemo() {
        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }

    void getUserRow() {
        String sql = "SELECT * FROM user WHERE username = ?";

        System.out.println(jdbcTemplate.queryForObject(sql, new Object[]{"vishakha@123"}, new UserMapper()));
    }

    @Autowired
    SessionFactory sessionFactoryBean;

    void sessionFactoryDemo() {
        String sql = "SELECT COUNT(*) FROM User";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());
    }
}

@Repository
class user1Repo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SessionFactory sessionFactoryBean;

    //@Transactional(propagation = Propagation.REQUIRED)
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    //@Transactional(propagation = Propagation.NESTED)
    //@Transactional(propagation = Propagation.MANDATORY)
    //@Transactional(propagation = Propagation.SUPPORTS)
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)

}








