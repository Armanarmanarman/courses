package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCursorHolder {
    private static ResultSet results;

    public ResultSet getResults() {
        return results;
    }

    public Statement getStatement() {
        return statement;
    }

    private Statement statement;

    public DBCursorHolder(final ResultSet resultSet, final Statement statement) {
        this.results = resultSet;
        this.statement = statement;
    }

    public static void getResults(DBCursorHolder d) {
        System.out.println(results);
    }

    public void closeCursor() {
        try {
            this.results.close();
            this.statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
