package hw.persistence.repository;

import hw.persistence.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void create(UserEntity user);
    Optional<UserEntity> getByEmail(String email);
    Optional<UserEntity> getByNickname(String username);
    void updateBio(UserEntity user);
}
