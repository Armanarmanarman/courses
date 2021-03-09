package database;

import model.Courses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.DriverManager;

//
public class DBUtils {


    public static void showAll() {
        try {
            String query = "SELECT * FROM courses";
            //establishing connection with SQL DB
            Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres").createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())//iterate through results
            {
                Courses courses = new Courses();
                courses.setId(resultSet.getInt("id"));//set data form DB to courses attributes
                courses.setTitle(resultSet.getString("title"));//accessing data through column label
                courses.setDescription(resultSet.getString(3));//we also can access through column index(starts with 1)
                courses.setDiscipline(resultSet.getString(4));

                System.out.println(courses);//print to console

            }
        } catch (SQLException e) {
            System.out.println("Exception occured: " + e);
            ;
        }

    }

    public static void getByTitle(String[] title) {
        {
            try {
                final String query = String.format("SELECT * FROM courses WHERE title = %s", title);//setting query
                Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres").createStatement();
                ResultSet resultSet = statement.executeQuery(query);//executing query above
                while (resultSet.next()) {
                    Courses courses = new Courses();
                    courses.setId(resultSet.getInt(1));
                    courses.setTitle(resultSet.getString(2));
                    courses.setDescription(resultSet.getString(3));
                    courses.setDiscipline(resultSet.getString(4));

                    System.out.println(courses);

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
    public static int getCurrentId() {
        {
            try {
                final String query = String.format("SELECT * FROM courses");
                Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres").createStatement();
                ResultSet resultSet = statement.executeQuery(query);//executing query above
                Courses courses = new Courses();
                while (resultSet.next()) {

                    courses.setId(resultSet.getInt(1));




                }
                return courses.getId();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return 0;
    }

    public static void getByDiscipline(String[] discipline) {
        {
            try {
                final String query = String.format("SELECT * FROM courses WHERE discipline = %s", discipline);//setting query
                Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres").createStatement();
                ResultSet resultSet = statement.executeQuery(query);//executing query above
                while (resultSet.next()) {
                    Courses courses = new Courses();
                    courses.setId(resultSet.getInt(1));
                    courses.setTitle(resultSet.getString(2));
                    courses.setDescription(resultSet.getString(3));
                    courses.setDiscipline(resultSet.getString(4));

                    System.out.println(courses);

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public static void deleteTable(final String tableName) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres");
            final Statement statement = connection.createStatement();
            final String query = String.format("DELETE FROM %s", tableName);
            statement.execute(query);
            final ResultSet resultSet = statement.executeQuery(query);
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertIntoTable(String tableName, String[] rowValues) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres");//establishing connection with SQL DB
            final Statement statement = connection.createStatement();
            final String columnsString = String.join(", ", rowValues);//joining input values through ','
            final String query = String.format("INSERT INTO %s VALUES ( %s )", tableName, columnsString);
            statement.execute(query);
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
