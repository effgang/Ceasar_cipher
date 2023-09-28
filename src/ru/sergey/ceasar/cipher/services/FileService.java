package ru.sergey.ceasar.cipher.services;

import ru.sergey.ceasar.cipher.exception.FilesException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    private Validator validator = new Validator();


    /**
     * Чтение из файла
     *
     * @throws FilesException
     */

    public String readFile(String inputFiles) throws FilesException {
        try {
            validator.readCheck(inputFiles);
            Path path = Path.of(inputFiles);
            return Files.readString(path);
        } catch (IOException e) {
            throw new FilesException(e.getMessage());
        }
    }

    /**
     * Запись в файл
     *
     * @throws FilesException
     */

    public void writeFiles(String outputFile, String text) throws FilesException {
        try {
            validator.writeCheck(outputFile);
            Path path = Path.of(outputFile);
            Files.writeString(path, text);
        } catch (IOException e) {
            throw new FilesException(e.getMessage());
        }
    }
}
