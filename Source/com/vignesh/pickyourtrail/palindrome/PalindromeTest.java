package com.vignesh.pickyourtrail.palindrome;

/**
 * Created by Vignesh G on 11-Apr-19.
 */
public class PalindromeTest {

    public static void main(String args[]) {

        PalindromeHelper helper = new PalindromeHelper();
        String userInput = helper.readStringFromUser();
        int palindromeCount = helper.countPalindromes(userInput);
        System.out.println("Number of possible Palindromic substrings : " + palindromeCount);

    }

}
