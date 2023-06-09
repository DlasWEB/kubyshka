package com.kubyshka.repositories;

import com.kubyshka.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
    Currency findByName(String name);
}
