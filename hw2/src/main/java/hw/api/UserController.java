package hw.api;

import hw.persistence.entity.UserEntity;
import hw.service.UserService;
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

    @GetMapping("/registration")
    public String getRegistrationForm(){
        return "registration";
    }

    @PostMapping("/registration")
    public void registerUser(@RequestBody String name, @RequestBody String password) {
        service.register(name, password);
    }
}
