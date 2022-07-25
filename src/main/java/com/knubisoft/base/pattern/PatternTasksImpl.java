package com.knubisoft.base.pattern;

import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if (text == null || text.length() == 0 || text.equals(" ")) {
            throw new IllegalArgumentException();
        }
        Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
        return p.matcher(text).find();
    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        String res = "";
        Pattern p = Pattern.compile("^pq*$");
        if (p.matcher(text).find()) {
            res = "Found a match!";
        } else {
            res = "Not matched!";
        }
        return res;
    }

    @Override
    public String matchStartAndEnd(String text) {
        Pattern p = Pattern.compile("^[^g].*$[^g]");
        String res = "";
        if (p.matcher(text).find()) {
            res = "Found a match!";
        } else {
            res = "Not matched!";
        }
        return res;
    }

    @Override
    public String matchIpAddress(String text) {
        return null;
    }

    @Override
    public String matchVowels(String text) {
        return null;
    }

    @Override
    public boolean validatePIN(String text) {
        return false;
    }

    @Override
    public String divideDigit(int digit) {
        return null;
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        return null;
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        return false;
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        return null;
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        return false;
    }

    @Override
    public String insertDash(String text) {
        return null;
    }
}
