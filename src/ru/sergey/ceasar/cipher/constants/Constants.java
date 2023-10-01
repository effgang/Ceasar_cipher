package ru.sergey.ceasar.cipher.constants;

import java.util.List;

public class Constants {

    public static final String MAIN_MENU = """
            Choose a task from the numbers below
            1. Encryption
            2. Decryption
            3. Brute Force
            4. Exit
            Enter your Menu choice:""";

    public static final List<String> SYSTEM_FILES = List.of(
            ".bash_profile",
            ".bash_history",
            ".bash_logout"
    );

    public static final List<Character> ALPHABET = List.of(
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    );

    public static final List<String> COMMON_WORDS = List.of(
            "his", "her", "she",
            "are", "you", "your",
            "for", "one", "must",
            "should", "him", "their",
            "them", "the", "this",
            "that", "hello", "hi",
            "some", "because", "will"
    );

    public static final String APPEND_KEY = "Brute Force key is: ";

    public static final String INFO = "Done!";


    private Constants() {

    }
}
