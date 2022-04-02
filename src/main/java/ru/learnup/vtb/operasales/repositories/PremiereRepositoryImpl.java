package ru.learnup.vtb.operasales.repositories;

import org.springframework.stereotype.Repository;
import ru.learnup.vtb.operasales.entities.Premiere;
import ru.learnup.vtb.operasales.entities.Ticket;

import java.util.*;

@Repository
public class PremiereRepositoryImpl implements PremiereRepository {

    private static Map<String, Premiere> repository = new HashMap<>();

    @Override
    public List<Premiere> getAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Premiere get(String name) {
        return repository.get(name);
    }

    @Override
    public void create(Premiere premiere) {
        repository.put(premiere.getName(), premiere);
    }

    @Override
    public Premiere delete(String name) {
        return repository.remove(name);
    }

}
