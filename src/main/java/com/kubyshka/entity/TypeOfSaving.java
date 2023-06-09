package com.kubyshka.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity

public class TypeOfSaving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "[\\wа-яА-я\\s\\wа-яА-я]{1,25}"
            , message = "Может содержать только заглавные буквы и строчные буквы кирилицы и латиницы, " +
                        "цифры и пробелы (не > 2х подряд) и быть длиной от 1 до 25 символов.")
    private String name;

    public TypeOfSaving() {
    }

    public TypeOfSaving(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
