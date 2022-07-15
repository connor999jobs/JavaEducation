package com.knubisoft.base.bool;

public class BoolTasksImpl implements BoolTasks {

    @Override
    public Boolean isTrueAutobox(boolean value) {
        return value;
    }

    @Override
    public Boolean isFalseAutobox(boolean value) {
        return value;
    }

    @Override
    public boolean isTrueUnbox(Boolean value) {
        return false;
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {
        return null;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        return false;
    }

    @Override
    public boolean orFunction(int digit, String string) {
        return false;
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        return false;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int generatedThirdDigit, int range) {
        return false;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        if (firstArray == null || secondArray == null) {
            return false;
        }
        return firstArray.length == secondArray.length;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        if (username == null || name == null || maxLength == 0) {
            return false;
        }
        return (username.length() <= maxLength) && (name.length() <= maxLength) && (username.length() == name.length());
    }
}
