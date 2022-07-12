package com.knubisoft.base.numbers;

import java.math.BigInteger;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {

    }

    @Override
    public boolean isUglyInt(int number) {
        return false;
    }

    @Override
    public int addDigits(int number) {
        int i;
        int x1 = number;
        int[] arr;
        int c = 0;
        if (number == 0) {
            return 0;
        }
        while ((number > 9)) {
            for (; number > 0; number /= 10) {
                c += 1;
            }
            arr = new int[c];
            for (int j = 0; x1 > 0; x1 /= 10, j++) {
                i = x1 % 10;
                arr[j] = i;
            }
            for (int value : arr) {
                number = number + value;
                x1 = number;
            }
        }
        return number;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        return false;
    }

    @Override
    public boolean isPrime(int number) {
        return false;
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        return false;
    }

    @Override
    public BigInteger factorial(int number) {
        return BigInteger.ZERO;
    }

    @Override
    public boolean palindrome(int number) {
        if (number == 0) {
            return true;
        }
        int i;
        int x1 = number;
        int[] arr;
        int c = 0;
        for (; number > 0; number /= 10) {
            c += 1;
        }
        arr = new int[c];
        for (int j = 0; x1 > 0; x1 /= 10, j++) {
            i = x1 % 10;
            arr[j] = i;
        }

        for (int k = 0, j = arr.length - 1; k < arr.length; k++, j--) {
            if (arr[k] == arr[j]) {
                if ((arr.length / 2 == k) && (arr[k] == arr[j])) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean isAutomorphic(int number) {
        return false;
    }
}
