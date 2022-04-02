package ru.learnup.vtb.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.learnup.vtb.operasales.entities.Ticket;
import ru.learnup.vtb.operasales.services.TicketService;

@Controller
public class TicketController {

    private static TicketService service;

    @Autowired
    public TicketController(TicketService service) {
        this.service = service;
    }

    public void buyTicket(String name) {
        Ticket ticket = service.buyTicket(name);
        if (ticket != null) {
            System.out.println("Билет куплен: " + ticket.toString());
        } else {
            System.out.println("Нет свободных мест");
        }
    }

    public void returnTicket(Integer number, String name) {
        if (service.returnTicket(new Ticket(number, name))) {
            System.out.println("Билет успешно возвращен");
        } else {
            System.out.println("Билет не найден");
        }
    }
}
