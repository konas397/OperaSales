package ru.learnup.vtb.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.operasales.controllers.PremiereController;
import ru.learnup.vtb.operasales.controllers.TicketController;
import ru.learnup.vtb.operasales.entities.Premiere;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

@SpringBootApplication
public class OperaSalesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OperaSalesApplication.class, args);

        // Создаем две оперы
        ctx.getBean(PremiereController.class).getAllPremiere();
        ctx.getBean(PremiereController.class).createPremiere(new Premiere("Опера 1", "Опера 1 описание", 5, 100, new HashSet<>()));
        ctx.getBean(PremiereController.class).createPremiere(new Premiere("Опера2", "Опера 2 описание", 20, 300, new HashSet<>()));
        System.out.println();
        ctx.getBean(PremiereController.class).getAllPremiere();

        // Изменяем параметры Оперы 1
        System.out.println();
        ctx.getBean(PremiereController.class).getPremiereInfo("Опера 1");
        ctx.getBean(PremiereController.class).changePremiere(new Premiere("Опера 1", "Измененное описание для Оперы 1", 21, 500, null));
        ctx.getBean(PremiereController.class).getPremiereInfo("Опера 1");

        // Удаляем Оперу 1
        System.out.println();
        ctx.getBean(PremiereController.class).deletePremiere("Опера 1");
        ctx.getBean(PremiereController.class).deletePremiere("Опера 1");

        // Смотрим, что осталось
        System.out.println();
        ctx.getBean(PremiereController.class).getAllPremiere();
        ctx.getBean(PremiereController.class).getPremiereInfo("Опера2");

        // Пробуем купить билет на Оперу 2
        System.out.println();
        ctx.getBean(TicketController.class).buyTicket("Опера2");
        ctx.getBean(PremiereController.class).getPremiereInfo("Опера2");

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер билета для возврата:");
        int number = scanner.nextInt();
        System.out.println("Введите наименование премьеры для возврата:");
        String name = scanner.next();
        ctx.getBean(TicketController.class).returnTicket(number, name);
        ctx.getBean(PremiereController.class).getPremiereInfo("Опера2");
    }

}
