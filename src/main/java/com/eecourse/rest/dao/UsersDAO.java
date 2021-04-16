package com.eecourse.rest.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private static final DataSource dataSource = MyDataSource.dataSource;

    public static List<Employee> getEmployees() {

        String sql = "SELECT * FROM hr.employees LIMIT 10";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            List<Employee> employees = new ArrayList<Employee>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                ));
            }
            rs.close();
            ps.close();
            return employees;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public static class Employee {
        private int id;

        public Employee(int id, String name, String lastName) {
            this.id = id;
            this.name = name;
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        private String name;
        private String lastName;

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }


}
