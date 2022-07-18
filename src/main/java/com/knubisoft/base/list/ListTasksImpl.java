package com.knubisoft.base.list;

import java.util.*;

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
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) throws IllegalArgumentException, NullPointerException, RuntimeException {
        if(first == null || second == null || third == null){
            throw new RuntimeException();
        }
        List<Long> res = new ArrayList<>();
        for (Integer integer : first) {
            if(integer == null){
                throw new NullPointerException();
            }
            res.add(Long.valueOf(integer));
        }
        res.addAll(second);
        for (String s : third) {
            if (s == null){
                throw new NullPointerException();
            }
            res.add(Long.parseLong(s));
        }
        System.out.println(res);
        return res;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> array = new ArrayList<>();
        array.addAll(first);
        array.addAll(second);
        array.addAll(third);
        int max = array.get(0);
        for (Integer integer : array) {
            if (integer > max) {
                max = integer;
            }
        }
        //return Collections.max(array);
        return max;
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> array = new ArrayList<>();
        array.addAll(first);
        array.addAll(second);
        array.addAll(third);
        int min = array.get(0);
        for (Integer integer : array) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
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
    public String getLastElement(LinkedList<String> list) throws NoSuchElementException {
        if(list == null){
            throw new NoSuchElementException();
        }
        if (list.isEmpty()){
            return "";
        }
        if(list.getLast()==null){
            throw new NoSuchElementException();
        }
        else {
            return list.getLast();
        }

    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        return null;
    }
}
