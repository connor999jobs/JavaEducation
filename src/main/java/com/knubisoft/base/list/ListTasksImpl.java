package com.knubisoft.base.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        return new ArrayList<>(List.of(elements));
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) throws IllegalArgumentException {
        if (indexes == null) {
            throw new IllegalArgumentException("Indexes cannot be null");
        }
        for (int index : indexes) {
            if (index < 0 || index > elements.size()) {
                throw new IllegalArgumentException("value cannot be less then zero or bigger then size of list");
            }
            elements.add(elements.size(), elements.get(index));
        }
        return elements;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        return null;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        return null;
    }

    @Override
    public int getListSize(List<String> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        return null;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        return -1;
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        return null;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
        return null;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        return null;
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        return null;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        return null;
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        return null;
    }
}
