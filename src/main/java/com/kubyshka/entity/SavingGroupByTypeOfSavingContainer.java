package com.kubyshka.entity;

import java.util.Objects;

public class SavingGroupByTypeOfSavingContainer {
    private String typeOfSaving;
    private int amount;

    public SavingGroupByTypeOfSavingContainer() {
    }

    public SavingGroupByTypeOfSavingContainer(int amount, String typeOfSaving) {
        this.typeOfSaving = typeOfSaving;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypeOfSaving() {
        return typeOfSaving;
    }

    public void setTypeOfSaving(String typeOfSaving) {
        this.typeOfSaving = typeOfSaving;
    }

    @Override
    public String toString() {
        return "SavingGroupByTypeOfSavingContainer{" +
                "typeOfSaving='" + typeOfSaving + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingGroupByTypeOfSavingContainer that = (SavingGroupByTypeOfSavingContainer) o;
        return typeOfSaving.equals(that.typeOfSaving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfSaving);
    }
}
