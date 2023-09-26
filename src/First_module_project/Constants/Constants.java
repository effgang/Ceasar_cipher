package Project.Constants;

import java.util.List;

public class Constants {

    public static final String MAIN_MENU = """
            Choose a task from the numbers below
            1. Decryption
            2. Encryption
            3. Brute Force
            4. Exit
            Enter your Menu choise:
            """;
    public static final List<String> SYSTEM_FILES = List.of(".bash_profile", "", "");

    public static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'x', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    private Constants() {
    }
}
