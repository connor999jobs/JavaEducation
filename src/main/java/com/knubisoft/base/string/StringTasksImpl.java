package com.knubisoft.base.string;

import java.util.Arrays;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        char[] s = original.toCharArray();
        char tmp;
        for (int i = (s.length - 1), j = 0; i > (s.length / 2) - 1; i--, j++) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        return new String(s);
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        return null;
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        return null;
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        return null;
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        return false;
    }

    @Override
    public boolean hasLowerCase(String str) {
        return false;
    }

    @Override
    public String uniqueCharacters(String str) {
        return null;
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        return null;
    }

    @Override
    public String toCamelCase(String str) {
        return null;
    }

    @Override
    public String getCountRepeatableString(String str) {
        return null;
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        return null;
    }
}
