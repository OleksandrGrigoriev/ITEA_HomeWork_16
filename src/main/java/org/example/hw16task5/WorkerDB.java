package org.example.hw16task5;

import java.sql.*;

public class WorkerDB {
    private final String URL = "jdbc:mysql://localhost:3306/my_joins_db";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public WorkerDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void task16(int numberOfTask) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            if (numberOfTask == 1) {
                ResultSet resultSet = statement.executeQuery(
                        "select employee.id, employee.telephone, personal_info.address\n" +
                                "from employee inner join personal_info \n" +
                                "on employee.id = personal_info.employee_id");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String age = resultSet.getString("telephone");
                    String address = resultSet.getString("address");

                    System.out.println(id + " " + age + " " + address);
                }
            } else if (numberOfTask == 2) {
                ResultSet resultSet = statement.executeQuery(
                        "select employee.id, personal_info.date_birth, employee.telephone\n" +
                                "from \n" +
                                "employee inner join personal_info\n" +
                                "on employee.id = personal_info.employee_id \n" +
                                "where personal_info.married = 0");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String dateOfBirth = resultSet.getString("date_birth");
                    String telephone = resultSet.getString("telephone");

                    System.out.println(id + " " + dateOfBirth + " " + telephone);
                }
            } else {
                ResultSet resultSet = statement.executeQuery(
                        "select employee.id, personal_info.date_birth, employee.telephone\n" +
                                "from \n" +
                                "employee inner join personal_info inner join salary_job\n" +
                                "on employee.id = personal_info.employee_id \n" +
                                "and employee.id = salary_job.employee_id \n" +
                                "where job_title = 'manager'");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String dateOfBirth = resultSet.getString("date_birth");
                    String telephone = resultSet.getString("telephone");

                    System.out.println(id + " " + dateOfBirth + " " + telephone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
