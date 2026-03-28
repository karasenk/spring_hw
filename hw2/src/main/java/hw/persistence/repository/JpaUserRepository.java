package hw.persistence.repository;

import hw.persistence.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

public class JpaUserRepository implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return Optional.of(entityManager.find(UserEntity.class, email));
    }

    @Override
    public Optional<UserEntity> getByNickname(String nickname) {
        return Optional.of(entityManager.find(UserEntity.class, nickname));
    }

    @Override
    public void updateBio(UserEntity user) {
        entityManager.merge(user);
    }
}
