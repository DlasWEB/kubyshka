package com.kubyshka.service;

import com.kubyshka.entity.Saving;
import com.kubyshka.entity.SavingGroupByTypeOfSavingContainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SavingGroupByTypeOfSavingImpl implements SavingGroupByTypeOfSaving {

    public List<SavingGroupByTypeOfSavingContainer> getListSavingGroupByTypeOfSavingContainer (List<Saving> allSavingsRUB) {
        List<SavingGroupByTypeOfSavingContainer> savingGroupByTypeOfSavingContainerList = new ArrayList<>();
        for (Saving row : allSavingsRUB) {
            SavingGroupByTypeOfSavingContainer savingGroupByTypeOfSavingContainer = new SavingGroupByTypeOfSavingContainer();
            savingGroupByTypeOfSavingContainer.setTypeOfSaving((String) row.getSaving_type());
            savingGroupByTypeOfSavingContainer.setAmount((Integer) row.getAmount());
            savingGroupByTypeOfSavingContainerList.add(savingGroupByTypeOfSavingContainer);
        }
        return savingGroupByTypeOfSavingContainerList;
    }

    public Map<SavingGroupByTypeOfSavingContainer, Integer> getMapSavingGroupByTypeOfSavingContainer (
            List<SavingGroupByTypeOfSavingContainer> savingGroupByTypeOfSavingContainerList) {
        Map<SavingGroupByTypeOfSavingContainer, Integer> collectSavingGroupByTypeOfSavingContainerMap =
                savingGroupByTypeOfSavingContainerList
                        .stream()
                        .collect(Collectors.groupingBy(
                                saving -> saving,
                                Collectors.summingInt(s -> s.getAmount())
                        ));
        return collectSavingGroupByTypeOfSavingContainerMap;
    }

}
