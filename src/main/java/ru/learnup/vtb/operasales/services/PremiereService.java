package ru.learnup.vtb.operasales.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.vtb.operasales.entities.Premiere;
import ru.learnup.vtb.operasales.repositories.PremiereRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PremiereService {

    private static PremiereRepository repository;

    @Autowired
    public PremiereService(PremiereRepository repository) {
        this.repository = repository;
    }

    public List<String> getAllPremiere() {
        List<Premiere> premieres = repository.getAll();
        List<String> names = new ArrayList<>();
        for (Premiere premiere : premieres) {
            names.add(premiere.getName());
        }
        return names;
    }

    public String getPremiereInfo(String name) {
        Premiere premiere = repository.get(name);
        if (premiere == null) {
            return "Премьера не найдена";
        }
        return premiere.toString();
    }

    public Premiere createPremiere(Premiere premiere) {
        if (premiere.getName() == null || premiere.getName().isEmpty()) {
            throw new IllegalArgumentException("Наименование премьеры не задано");
        }
        if (premiere.getDescription() == null) {
            throw new IllegalArgumentException("Не задано описание");
        }
        if (premiere.getAgeCategory() == null || premiere.getAgeCategory() > 120 || premiere.getAgeCategory() < 0) {
            throw new IllegalArgumentException("Недопустимое значение возрастной категории");
        }
        if (premiere.getAvailableSeats() == null || premiere.getAvailableSeats() < 0) {
            throw new IllegalArgumentException("Количество доступных мест должно быть больше 0");
        }
        repository.create(premiere);
        return premiere;
    }

    public Premiere changePremiere(Premiere changePremiere) {

        if (changePremiere.getName() == null || changePremiere.getName().isEmpty()) {
            throw new IllegalArgumentException("Не задано наименование премьеры");
        }

        Premiere premiere = repository.get(changePremiere.getName());

        if (premiere == null) {
            throw new IllegalArgumentException("Премьера для изменения не найдена");
        }

        if (changePremiere.getDescription() != null) {
            premiere.setDescription(changePremiere.getDescription());
        }
        if (changePremiere.getAgeCategory() != null && changePremiere.getAgeCategory() <= 120 && changePremiere.getAgeCategory() >= 0) {
            premiere.setAgeCategory(changePremiere.getAgeCategory());
        }
        if (premiere.getAvailableSeats() != null && premiere.getAvailableSeats() >= 0) {
            premiere.setAvailableSeats(changePremiere.getAvailableSeats());
        }
        return premiere;
    }

    public Premiere deletePremiere(String name) {
        return repository.delete(name);
    }

}
