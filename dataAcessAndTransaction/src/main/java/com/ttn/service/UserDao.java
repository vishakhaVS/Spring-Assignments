package com.ttn.service;

import com.ttn.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public
class UserDao {

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void userCount() {
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }

    public void getUserName() {
        String sql = "SELECT NAME FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForObject(sql, new Object[]{"vishakha@1234"}, String.class));
    }

    void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,dob,age)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(), user.getPassword(), user.getName(), user.getDob(), user.getAge()});
    }

    public void queryForMapDemo() {
        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{"vishakha@1234"}));
    }

    public void queryForListDemo() {
        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }

    public void getUserRow() {
        String sql = "SELECT * FROM user WHERE username = ?";

        System.out.println(jdbcTemplate.queryForObject(sql, new Object[]{"vishakha@1234"}, new UserMapper()));
    }

    @Autowired
    SessionFactory sessionFactoryBean;

    public void sessionFactoryDemo() {
        String sql = "SELECT COUNT(*) from User";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());
    }
}
