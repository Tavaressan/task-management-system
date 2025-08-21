package br.com.dio.persistence.dao;

import br.com.dio.persistence.config.ConnectionConfig;
import br.com.dio.persistence.entity.BoardEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {



    public void insert (final BoardEntity entity) {
        final String sql = "INSERT INTO boards (name) values (?)";
        try (
                var connection = ConnectionConfig.getConnection();
                var statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insert (final List<BoardEntity> boards){

    }

    public void update (final BoardEntity entity) {
        final String sql = "UPDATE boards SET name = ? WHERE id = ?";
        try (
                var connection = ConnectionConfig.getConnection();
                var statement = connection.prepareStatement(sql)
                ){
            statement.setString(1, entity.getName());
            statement.setLong(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void delete (final long id){
        final String sql = "DELETE FROM boards WHERE id = ?";
        try (
                var connection = ConnectionConfig.getConnection();
                var statement = connection.prepareStatement(sql)
        ){
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

//    public BoardEntity findById(final long id){
//
//        var entity = new BoardEntity();
//        final String sql = "SELECT b.id board_id,\n" +
//                "\t b.name name \n" +
//                "FROM boards b \n" +
//                "LEFT JOIN cards c \n" +
//                "ON b.id = c.board_id" +
//                " WHERE id = ?;";
//        try (
//                var connection = ConnectionConfig.getConnection();
//                var statement = connection.prepareStatement(sql)
//        ){
//            statement.setLong(1, id);
//            statement.executeQuery();
//            var resultSet = statement.getResultSet();
//            if (resultSet.next()){
//                entity.setId(resultSet.getLong("board_id"));
//                entity.setName(resultSet.getString("name"));
//            }
//        } catch (SQLException ex){
//            ex.printStackTrace();
//        }
//    }

    public List<BoardEntity> findAll(){
        List<BoardEntity> entities = new ArrayList<>();
        try (
                var connection = ConnectionConfig.getConnection();
                var statement = connection.createStatement()
        ){
            statement.executeQuery("SELECT * FROM boards ORDER BY name");
            var resultSet = statement.getResultSet();
            while (resultSet.next()) {
                var entity = new BoardEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entities.add(entity);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return entities;
    }
}
