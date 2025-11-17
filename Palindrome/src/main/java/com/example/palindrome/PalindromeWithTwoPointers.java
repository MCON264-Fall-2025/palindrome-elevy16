package com.example.palindrome;

public final class PalindromeWithTwoPointers {
    private PalindromeWithTwoPointers() { /* utility */ }

    /**
     * Implement a method that uses the two-pointer technique
     *
     * @param s input string (must not be null)
     * @return true if palindrome
     * @throws IllegalArgumentException if s is null
     */
    public static boolean isPalindrome(String s) {

        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // Normalize input
        String cleaned = normalize(s);

        // Set up 2 pointers
        int left = 0;
        int right = cleaned.length() - 1;

        // Move pointers toward the center
        while (left < right) {
            char leftChar = cleaned.charAt(left);
            char rightChar = cleaned.charAt(right);

            if (leftChar != rightChar) {
                return false; // characters don't match = not a palindrome
            }

            left++;
            right--;
        }
        return true; // everything matched = palindrome

    }

    // package-private for testing if needed
    static String normalize(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}

