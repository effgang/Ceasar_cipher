package ru.sergey.ceasar.cipher.process;

import ru.sergey.ceasar.cipher.constants.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.sergey.ceasar.cipher.constants.Constants.APPEND_KEY;

public class CryptoProcessor {

    public String encrypt(String text, int key) {
        return crypt(text, key);
    }

    public String decrypt(String text, int key) {
        int decryptKey = Constants.ALPHABET.size() - key;
        return encrypt(text, decryptKey);
    }

    public String bruteForce(String text) {
        String word;
        for (int key = 1; key < Constants.ALPHABET.size(); key++) {
            String result = decrypt(text, key);
            String[] temp = result.split(" ");
            for (int j = 0; j < temp.length; j++) {
                word = temp[j];
                for (String commonWord : Constants.COMMON_WORDS) {
                    Pattern pattern = Pattern.compile("a-z+");
                    Matcher matcher = pattern.matcher(word);
                    while (matcher.find()) {
                        word = text.substring(matcher.start(), matcher.end());
                    }
                    if (word.equals(commonWord)) {
                        return result + "\n" + APPEND_KEY + key;
                    }
                }
            }
        }
        return text;
    }

    private static String crypt(String text, int key) {
        String textLowerCase = text.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < textLowerCase.length(); i++) {
            char tempChar = textLowerCase.charAt(i);
            int indexInAlphabet = Constants.ALPHABET.indexOf(tempChar);
            if (indexInAlphabet == -1) {
                result.append(tempChar);
                continue;
            }
            result.append(Constants.ALPHABET.get((indexInAlphabet + key) % Constants.ALPHABET.size()));

        }
        return result.toString();
    }
}
