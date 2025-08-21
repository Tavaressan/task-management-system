package br.com.dio;


import br.com.dio.persistence.dao.BoardDAO;
import br.com.dio.persistence.migration.MigrationStrategy;

import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

public class Main {

    private final static BoardDAO boardDAO = new BoardDAO();


    public static void main(String[] args) throws SQLException {
        try (var connection = getConnection()) {
            new MigrationStrategy(connection).executeMigration();
        }
    }
}