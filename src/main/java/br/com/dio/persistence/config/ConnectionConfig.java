package br.com.dio.persistence.config;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConnectionConfig {
    @Getter
    private static final String DB_URL = "jdbc:mysql://localhost:3307/task-management";

    @Getter
    private static final String DB_USER = "root";

    @Getter
    private static final String DB_PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        var connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
