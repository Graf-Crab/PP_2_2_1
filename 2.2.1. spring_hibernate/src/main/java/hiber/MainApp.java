package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User olga = new User("Olga", "Buzova", "buzz@gmail.ru");
        User ksenia = new User("Ksenia", "Borodina", "borodino@mail.ru");
        User alena = new User("Alena", "Vodonaeva", "water777@mail.ru");
        User valera = new User("Valerii", "Meladze", "viagra@yandex.ru");

        olga.setCar(new Car("Tesla",01));
        ksenia.setCar(new Car("Bugatti",02));
        alena.setCar(new Car("Volvo",03));
        valera.setCar(new Car("Toyta",01));

        userService.add(olga);
        userService.add(ksenia);
        userService.add(alena);
        userService.add(valera);

        List<User> users = userService.getUsers();

        for (User user : users) {
            System.out.println(user.toString());
            System.out.println();
        }
        System.out.println("------------------");
        System.out.println("Выведен весь список водителей");
        System.out.println("------------------");

        User user = userService.getResult("Tesla", 01);
        System.out.println(user);
        System.out.println("Водитель найден");
        System.out.println("------------------");

        context.close();
    }
}