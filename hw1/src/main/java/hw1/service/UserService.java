package hw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hw1.entity.UserEntity;
import hw1.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public boolean create(String name){
        return repository.create(name);
    }
    public UserEntity get(long id){
        return repository.get(id);
    }
    public boolean updateName(long id, String name){
        return repository.updateName(id, name);
    }
    public boolean delete(long id){
        return repository.delete(id);
    }
}
