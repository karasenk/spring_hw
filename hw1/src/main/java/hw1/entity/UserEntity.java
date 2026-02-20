package hw1.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class UserEntity {
    private final long id;
    @Setter
    private String name;

    @Autowired
    public UserEntity(long id, String name){
        this.id = id;
        this.name = name;
    }
}
