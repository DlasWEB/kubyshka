package com.kubyshka.service;

import com.kubyshka.entity.SavingGroupByCurrencyContainer;

import java.util.HashMap;
import java.util.List;

public interface SavingGroupByCurrency {
    public List<SavingGroupByCurrencyContainer> convertListObjectToListSavingGroupByCurrencyContainer(
            List<Object[]> allSavingsGroupByCurrency);

    public List<SavingGroupByCurrencyContainer> getListSavingGroupByCurrencyWithAllAmountInRUB(
            List<SavingGroupByCurrencyContainer> allSavings, HashMap<String, Float> currenciesAndCourses);
}