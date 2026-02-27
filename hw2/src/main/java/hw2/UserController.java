package hw2;

import hw2.persistence.entity.UserEntity;
import hw2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable("id") UUID id) {
        return service.get(id);
    }

    @PostMapping
    public void saveUser(@RequestParam String name) {
        service.save(name);
    }
}
