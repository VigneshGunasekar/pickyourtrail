package com.vignesh.pickyourtrail.palindrome;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vignesh G on 11-Apr-19.
 */
public class PalindromeHelper implements Palindrome {

    /**
     * method reads string input from user
     *
     * @return String read from console
     */
    public String readStringFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String dtr = scanner.nextLine();
        return dtr;
    }

    /**
     * method finds number of palindromic substrings in a given string
     *
     * @param s - String obtained by user
     * @return palindromic substring count
     */
    @Override
    public int countPalindromes(String s) {
        int count = 0;
        checkValidity(s);
        ArrayList<String> subStrings = getSubStrings(s);
        for (String subString : subStrings) {
            if (isPalindrome(subString)) {
                count++;
            }
        }

        return count;
    }

    /**
     * method checks if the given string is valid as per the given constraints
     *
     * @param s - String obtained from user input
     */
    private void checkValidity(String s) {
        if (s == null) {
            exitApplication("Enter a valid string.");
        }
        int len = s.length();
        if (!(len > 0 && len < 5000)) {
            exitApplication("Enter a string with length between 1 and 5000.");
        }
        String regex = "^[a-z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) {
            exitApplication("Enter a string with only small case letters.");
        }
    }

    /**
     * method prints message and exits application
     *
     * @param message
     */
    private void exitApplication(String message) {
        System.out.println(message);
        System.exit(1);
    }

    /**
     * method obtains possible substrings of a given string
     *
     * @param s
     * @return list of substrings
     */
    private ArrayList<String> getSubStrings(String s) {
        ArrayList<String> subStrings = new ArrayList<String>();
        int len = s.length();
        String subString = null;
        //System.out.println(Possible substrings : );
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                subString = s.substring(i, j);
                //System.out.println(subString);
                subStrings.add(subString);
            }
        }
        return subStrings;
    }

    /**
     * method checks if a string is a palindrome or not
     *
     * @param subString
     * @return
     */
    private boolean isPalindrome(String subString) {
        String reversedString;
        StringBuilder sb = new StringBuilder();
        for (int i = subString.length() - 1; i >= 0; i--) {
            sb.append(subString.charAt(i));
        }
        reversedString = sb.toString();

        return subString.equals(reversedString);
    }
}
