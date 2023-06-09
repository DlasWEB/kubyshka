package com.kubyshka.service;

import com.kubyshka.entity.Saving;
import com.kubyshka.entity.SavingGroupByTypeOfSavingContainer;

import java.util.List;
import java.util.Map;

public interface SavingGroupByTypeOfSaving {
    public List<SavingGroupByTypeOfSavingContainer> getListSavingGroupByTypeOfSavingContainer (List<Saving> allSavingsRUB);
    public Map<SavingGroupByTypeOfSavingContainer, Integer> getMapSavingGroupByTypeOfSavingContainer (
            List<SavingGroupByTypeOfSavingContainer> savingGroupByTypeOfSavingContainerList);
}
