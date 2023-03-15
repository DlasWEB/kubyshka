package com.kubyshka.entity;

import javax.persistence.*;

@Entity
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String saving_name;

    private Float amount;

    private String currency_name;

    private String saving_type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    
    public Saving() {
    }

    public Saving(String saving_name, Float amount, String currency_name, String saving_type, User user) {
        this.author = user;
        this.saving_name = saving_name;
        this.amount = amount;
        this.currency_name = currency_name;
        this.saving_type = saving_type;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<ничьё>";
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
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
}
