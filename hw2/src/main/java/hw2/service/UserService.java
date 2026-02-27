package hw2.service;

import hw2.persistence.entity.UserEntity;
import hw2.persistence.repository.InMemoryRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final InMemoryRepository repository;
    // antipattern! service should be stateless
    @Value("${logging.enabled}")
    private Boolean isLoggingEnabled;

    public void save(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }

        UserEntity user = UserEntity.builder()
                .name(name)
                .build();

        repository.save(user);

        if (isLoggingEnabled) {
            System.out.println("new user saved");
        }
    }

    public UserEntity get(UUID id) {
        return repository.get(id);
    }
}
