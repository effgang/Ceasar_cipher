package ru.sergey.ceasar.cipher.services;

import ru.sergey.ceasar.cipher.constants.Constants;
import ru.sergey.ceasar.cipher.exception.FilesException;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import static ru.sergey.ceasar.cipher.constants.Constants.ALPHABET;

public class Validator {

    public void readCheck(String fileName) throws FilesException {
        Path path = pathValidation(fileName);

        if (Files.isDirectory(path)) {
            throw new FilesException("File is directory " + path);
        }
        if (Files.notExists(path)) {
            throw new FilesException("file doesn't exist " + path);
        }
    }

    public void writeCheck(String fileName) throws FilesException {
        Path path = pathValidation(fileName);

        if (Files.isDirectory(path)) {
            throw new FilesException("File is directory " + path);
        }
    }

    public Path pathValidation(String fileName) throws FilesException {

        for (String systemFile : Constants.SYSTEM_FILES) {
            if (fileName.endsWith(systemFile)) {
                throw new FilesException("This is system file");
            }
        }

        try {
            return Path.of(fileName);
        } catch (InvalidPathException e) {
            throw new FilesException("Invalid path because of: " + e.getReason());
        }
    }

    public static boolean keyValidation(int key) {
        if (key > ALPHABET.size() || key < 1) {
            System.out.println("Your key should be between 1 and 25 inclusive");
            return false;
        }
        return true;

    }
}

