package com.eecourse.rest.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

public class MyDataSource {
    public static DataSource dataSource = init();

    private static DataSource init() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("hr");
        dataSource.setPassword("secret_password");
        dataSource.setUser("myuser");
        dataSource.setURL("jdbc:mysql://185.204.3.211:3306/");
        return dataSource;
    }
}
