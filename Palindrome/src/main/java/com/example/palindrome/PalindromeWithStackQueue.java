package com.example.palindrome;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class PalindromeWithStackQueue {

    /**
     * Implement a method that uses a Stack and a Queue
     * to determine whether the input string is a palindrome.
     * Palindromes read the same forwards and backwards,
     * ignoring case and non-alphanumeric characters.
     * Use Stack and Queue provided by Java's standard library.
     */
    public static boolean isPalindrome(String s) {

        if (s == null) { // check for null
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // Normalize: keep only letters and digits, make lowercase
        String cleaned = normalize(s);

        // Create stack and queue of characters
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Put all characters into both stack and queue
        for (int i = 0; i < cleaned.length(); i++) {
            char c = cleaned.charAt(i);
            stack.push(c); // goes in LIFO order
            queue.add(c); // goes in FIFO order
        }

        // Compare characters from front (queue) and back (stack)
        while (!stack.isEmpty()) {
            char fromStack = stack.pop(); // from the end
            char fromQueue = queue.remove(); // from the beginning

            if (fromStack != fromQueue) {
                return false; // mismatch = not a palindrome
            }
        }
        return true; // if no mismatch = palindrome

    }

    // Optional helper method for normalization
    public static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
