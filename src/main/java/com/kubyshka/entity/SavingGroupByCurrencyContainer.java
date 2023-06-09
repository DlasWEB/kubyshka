package com.kubyshka.entity;

public class SavingGroupByCurrencyContainer {
    private long amount;
    private String currency;

    public SavingGroupByCurrencyContainer() {
    }

    public SavingGroupByCurrencyContainer(long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
