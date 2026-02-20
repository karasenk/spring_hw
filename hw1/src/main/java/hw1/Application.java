package hw1;


import hw1.entity.UserEntity;
import hw1.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "hw1")
public class Application {
    public static void main(String[] args) {
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //UserService userService = (UserService) applicationContext.getBean("UserService");

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserService userService = context.getBean(UserService.class);
        userService.create("Анастасия");
        UserEntity user = userService.get(1);
        System.out.println(user.getId() + " " + user.getName());
        userService.updateName(1, "Таисия");
        user = userService.get(1);
        System.out.println(user.getId() + " " + user.getName());
        userService.delete(1);
        user = userService.get(1);
        System.out.println(user);
    }
}