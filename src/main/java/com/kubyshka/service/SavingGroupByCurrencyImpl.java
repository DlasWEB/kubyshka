package com.kubyshka.service;

import com.kubyshka.entity.SavingGroupByCurrencyContainer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SavingGroupByCurrencyImpl implements SavingGroupByCurrency {

    @Override
    public List<SavingGroupByCurrencyContainer> convertListObjectToListSavingGroupByCurrencyContainer(List<Object[]> allSavingsGroupByCurrency) {

        List<SavingGroupByCurrencyContainer> savingGroupByCurrencyContainerList = new ArrayList<>();

        for (Object[] row : allSavingsGroupByCurrency) {
            SavingGroupByCurrencyContainer savingGroupByCurrencyContainer = new SavingGroupByCurrencyContainer();
            savingGroupByCurrencyContainer.setAmount((Long) row[1]);
            savingGroupByCurrencyContainer.setCurrency((String) row[0]);
            savingGroupByCurrencyContainerList.add(savingGroupByCurrencyContainer);
        }
        return savingGroupByCurrencyContainerList;
    }

    @Override
    public List<SavingGroupByCurrencyContainer> getListSavingGroupByCurrencyWithAllAmountInRUB(
            List<SavingGroupByCurrencyContainer> allSavings, HashMap<String, Float> currenciesAndCourses) {
        for (SavingGroupByCurrencyContainer saving : allSavings) {
            String currency = saving.getCurrency();
            Float amount = (float) saving.getAmount();
            Iterator<Map.Entry<String, Float>> new_Iterator
                    = currenciesAndCourses.entrySet().iterator();
            while (new_Iterator.hasNext()) {
                Map.Entry<String, Float> new_Map
                        = (Map.Entry<String, Float>)
                        new_Iterator.next();
                if (new_Map.getKey().equals(currency)) {
                    long newAmount = (long) (amount * new_Map.getValue());
                    saving.setAmount(newAmount);
                }

            }
        }
        return allSavings;
    }
}