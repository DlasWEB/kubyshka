package com.kubyshka.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Pattern(regexp = "[\\wа-яА-я\\s\\wа-яА-я]{1,25}"
            , message = "Может содержать только заглавные буквы и строчные буквы кирилицы и латиницы, " +
            "цифры и пробелы (не > 2х подряд) и быть длиной от 1 до 25 символов.")
    private String saving_name;
    @NotNull(message = "Значение суммы сбережения не может быть пустым и должно быть >0")
    @Min(value = 1, message = "Значение суммы сбережения не может быть пустым и должно быть >0")
    private int amount;

    private String currency_name;

    private String saving_type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Saving() {
    }

    public Saving(String saving_name, int amount, String currency_name, String saving_type, User user) {
        this.author = user;
        this.saving_name = saving_name;
        this.amount = amount;
        this.currency_name = currency_name;
        this.saving_type = saving_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSaving_name() {
        return saving_name;
    }

    public void setSaving_name(String saving_name) {
        this.saving_name = saving_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public String getSaving_type() {
        return saving_type;
    }

    public void setSaving_type(String saving_type) {
        this.saving_type = saving_type;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "id=" + id +
                ", saving_name='" + saving_name + '\'' +
                ", amount=" + amount +
                ", currency_name='" + currency_name + '\'' +
                ", saving_type='" + saving_type + '\'' +
                '}';
    }
}
