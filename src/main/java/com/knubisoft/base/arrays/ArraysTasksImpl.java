package com.knubisoft.base.arrays;

import java.util.HashSet;

public class ArraysTasksImpl implements ArraysTasks{
    @Override
    public int[] reverse(int[] array) {
        int tmp;
        for (int i = (array.length-1), j = 0; i > (array.length/2)-1; i--, j++) {
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return array;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        return null;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        return null;
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        return -1;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        return -1;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp;
            if (array[i - 1] == 0 && array[i] != 0) {
                tmp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = tmp;
                i--;
            }
            if (i - 1 >= 0 && array[i - 1] == 0 && array[i] != 0) {
                i--;
            }
        }
        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        return -1;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        return null;
    }

    @Override
    public int missingNumber(int[] array) {
        return -1;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        HashSet<Integer> count = new HashSet<>();
        for (int num : array) {
            if (count.contains(num)) {
                return true;
            } else {
                count.add(num);
            }
        }
        return false;
    }
}
