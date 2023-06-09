package com.kubyshka.repositories;

import com.kubyshka.entity.Saving;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavingsRepository extends CrudRepository<Saving, Integer> {
    @Query(value = "select " +
                        "s.currency_name, sum(s.amount) " +
                    "from Saving s " +
                    "where s.author.id = :id " +
                    "group by s.currency_name")
    List<Object[]> findGroupByCurrency(Long id);
    Iterable<Saving> findByAuthorId(Long authorId);
}
