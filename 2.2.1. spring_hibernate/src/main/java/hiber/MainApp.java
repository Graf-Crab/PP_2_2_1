package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Maxim", "Lastname1", "1@mail.ru", new Car("Porsche", 3)));
        userService.add(new User("Igor", "Lastname2", "2@mail.ru", new Car("BMW", 5)));
        userService.add(new User("Roma", "Lastname3", "3@mail.ru", new Car("Volkswagen", 7)));
        userService.add(new User("Kirill", "Lastname4", "4@mail.ru", new Car("Reno", 8)));

        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println(user.toString());
            System.out.println();
        }

        User user = userService.getUserByCar("Porsche", 3);
        System.out.println(user);

        context.close();
    }
}