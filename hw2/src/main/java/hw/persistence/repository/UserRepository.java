package hw.persistence.repository;

import hw.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    void create(UserEntity user);
    Optional<UserEntity> getByEmail(String email);
    Optional<UserEntity> getByNickname(String nickname);
    void updateBio(UserEntity user);
}
