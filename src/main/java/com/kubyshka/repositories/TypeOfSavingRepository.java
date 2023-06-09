package com.kubyshka.repositories;

import com.kubyshka.entity.TypeOfSaving;
import org.springframework.data.repository.CrudRepository;

public interface TypeOfSavingRepository extends CrudRepository<TypeOfSaving, Integer> {
    TypeOfSaving findByName(String name);
}
