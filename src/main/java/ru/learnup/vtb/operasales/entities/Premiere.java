package ru.learnup.vtb.operasales.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class Premiere {

    private String name;
    private String description;
    private Integer ageCategory;
    private Integer availableSeats;
    private Set<Ticket> tickets;

    @Override
    public String toString() {
        return name +
                " [" + description + "] " +
                "(Возрастная категория: " + getStringAgeCategory() + ") - " +
                "Количество доступных мест: " + availableSeats + "\n" +
                "Билеты: " + tickets;
    }
    public String getStringAgeCategory() {
        if (ageCategory>18)
            return "18+";
        else
            return ageCategory.toString();
    }
}
