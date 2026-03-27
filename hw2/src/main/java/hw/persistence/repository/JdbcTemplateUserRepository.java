package hw.persistence.repository;

import hw.persistence.entity.Status;
import hw.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateUserRepository implements UserRepository{
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static final String CREATE_SQL = "INSERT INTO usr (nickname, email, bio, password) VALUES (:nickname, :email, :bio, :password);";
    private static final String GET_BY_NICKNAME_SQL = "SELECT * FROM usr WHERE username = :username;";
    private static final String GET_BY_EMAIL_SQL = "SELECT * FROM usr WHERE email = :email;";
    private static final String UPDATE_BIO_SQL = "UPDATE usr SET bio = :bio WHERE id = :id;";
    @Override
    public void create(UserEntity user) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("nickname", user.getNickname())
                .addValue("email", user.getEmail())
                .addValue("bio", user.getBio())
                .addValue("password", user.getPassword());

        jdbcTemplate.update(CREATE_SQL, params);

    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("email", email);
        try {
            UserEntity entity = jdbcTemplate.queryForObject(
                    GET_BY_EMAIL_SQL,
                    params,
                    (resultSet, rowNum) -> {
                        return new UserEntity(
                                resultSet.getLong("id"),
                                resultSet.getObject("status", Status.class),
                                resultSet.getString("nickname"),
                                resultSet.getString("bio"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getDate("join_date"));
                    });
            return Optional.ofNullable(entity);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> getByNickname(String nickname) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("nickname", nickname);
        try {
            UserEntity entity = jdbcTemplate.queryForObject(
                    GET_BY_NICKNAME_SQL,
                    params,
                    (resultSet, rowNum) -> {
                        return new UserEntity(
                                resultSet.getLong("id"),
                                resultSet.getObject("status", Status.class),
                                resultSet.getString("nickname"),
                                resultSet.getString("bio"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getDate("join_date"));
                    });
            return Optional.ofNullable(entity);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void updateBio(UserEntity user) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("bio", user.getBio())
                .addValue("id", user.getId());
        jdbcTemplate.update(UPDATE_BIO_SQL, params);
    }
}
