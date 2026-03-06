package hw.service;

import hw.persistence.entity.UserEntity;
import hw.persistence.repository.InMemoryRepository;
import hw.util.HashUtil;
import hw.util.PasswordValidateUtil;
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

    public void register(String name, String password) {
        if (StringUtils.isBlank(name)) {
            if (isLoggingEnabled){
                System.out.println("USER SAVING FAILED: Name must not be null or empty");
            }
            return;
        }

        if (!PasswordValidateUtil.validate(password)){
            if (isLoggingEnabled){
                System.out.println("""
                    USER SAVING FAILED:
                    Password must contain
                    at least one uppercase latin letter
                    at least one lowercase latin letter
                    at least one digit
                    must not contain whitespaces
                    must have from 8 to 32 symbols
                    """);
            }
            return;
        }

        UserEntity user = UserEntity.builder()
                .name(name)
                .password(HashUtil.hashPassword(password))
                .build();

        repository.save(user);

        if (isLoggingEnabled) {
            System.out.println("USER SAVED");
        }
    }

    public UserEntity get(UUID id) {
        return repository.get(id);
    }

}
