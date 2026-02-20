package hw1.repository;

import hw1.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static hw1.repository.DBconfig.prepareStatement;

@Repository
public class UserRepository {
    private static final List<UserEntity> users = new ArrayList<>();
    private static int k = 1;
    private static final String SQL_GET_BY_ID = "SELECT * FROM usr WHERE id = ?;";
    private static final String SQL_INSERT = "INSERT INTO usr (name) VALUES (?);";
    private static final String SQL_DELETE_ONE = "DELETE FROM usr WHERE id = ?;";
    private static final String SQL_UPDATE_NAME = "UPDATE usr SET name = ? WHERE id = ?;";

    public boolean create(String name) {
        users.add(new UserEntity(k, name));
        k++;
        return true;
//        try{
//            PreparedStatement preparedStatement = prepareStatement(SQL_INSERT);
//            preparedStatement.setString(1, name);
//            return preparedStatement.executeUpdate() != 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
    }

    public UserEntity get(long id) {
        for (UserEntity user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
//        try {
//            PreparedStatement preparedStatement = prepareStatement(SQL_GET_BY_ID);
//            preparedStatement.setLong(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//            return convertFromResultSet(rs);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }

    public boolean updateName(long id, String name) {
        for (UserEntity user : users) {
            if (user.getId() == id) {
                user.setName(name);
                return true;
            }
        }
        return false;
//        try{
//            PreparedStatement preparedStatement = prepareStatement(SQL_UPDATE_NAME);
//            preparedStatement.setString(1, name);
//            preparedStatement.setLong(2, id);
//            return preparedStatement.executeUpdate() != 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
    }

    public boolean delete(long id) {
        for (UserEntity user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }
        return false;
//        try {
//            PreparedStatement preparedStatement = prepareStatement(SQL_DELETE_ONE);
//            preparedStatement.setLong(1, id);
//            return preparedStatement.executeUpdate() != 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
    }

/*    private UserEntity convertFromResultSet(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return new UserEntity(
                    rs.getLong("id"),
                    rs.getString("name")
            );
        }
        return null;
    }*/
}