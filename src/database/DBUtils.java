package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.sql.DriverManager;

//
public class DBUtils {

    public static void insertIntoTable(String tableName, String[] rowValues) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres");
            final Statement statement = connection.createStatement();
            final String columnsString = String.join(", ", rowValues);
            final String query = String.format("INSERT INTO %s VALUES ( %s )", tableName, columnsString);
            statement.execute(query);
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public static DBCursorHolder filterFromTable(final Connection connection, final String tableName, final String[] selectColumns,
//                                                 final String[] filterArguments) throws SQLException {
//        final Statement statement = connection.createStatement();
//
//        String whereKeyWord;
//        if (filterArguments.length == 0) {
//            whereKeyWord = "";
//        } else {
//            whereKeyWord = "WHERE";
//        }
//
//        final String filterArgumentsString = Stream.of(filterArguments).collect(Collectors.joining(" "));
//
//        String selectColumnsString;
//        if (selectColumns.length == 0) {
//            selectColumnsString = "*";
//        } else {
//            selectColumnsString = Stream.of(selectColumns).collect(Collectors.joining(", "));
//        }
//        final String query = String.format("SELECT %s FROM %s %s %s", selectColumnsString,
//                tableName, whereKeyWord, filterArgumentsString);
//        final ResultSet resultSet = statement.executeQuery(query);
//
//        return new DBCursorHolder(resultSet, statement);
//    }

//        final String filterArgumentsString = Stream.of(filterArguments).collect(Collectors.joining(" "));
//
//        String selectColumnsString;
//        if (selectColumns.length == 0) {
//            selectColumnsString = "*";
//        } else {
//            selectColumnsString = Stream.of(selectColumns).collect(Collectors.joining(", "));
//        }
//



    public static void deleteTable(final String tableName) {
        try {
            final Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "posgres");
            final Statement statement = connection.createStatement();
            final String query = String.format("DELETE FROM %s", tableName);
            statement.execute(query);
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
