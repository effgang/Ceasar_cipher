package ru.sergey.ceasar.cipher.services;

import ru.sergey.ceasar.cipher.exception.FilesException;
import ru.sergey.ceasar.cipher.process.CryptoProcessor;

import static ru.sergey.ceasar.cipher.constants.Constants.INFO;

public class CryptoService {
    private CryptoProcessor cryptoProcessor = new CryptoProcessor();
    private FileService fileService = new FileService();

    public void encryptFile(String fileName, String outputFile, int key) throws FilesException {
        String text = fileService.readFile(fileName);
        String answer = cryptoProcessor.encrypt(text, key);
        fileService.writeFiles(outputFile, answer);
        System.out.println(INFO);
    }

    public void decryptFile(String fileName, String outputFile, int key) throws FilesException {
        String text = fileService.readFile(fileName);
        String answer = cryptoProcessor.decrypt(text, key);
        fileService.writeFiles(outputFile, answer);
        System.out.println(INFO);
    }

    public void bruteForce(String fileName, String outputFile) throws FilesException {
        String text = fileService.readFile(fileName);
        String answer = cryptoProcessor.bruteForce(text);
        fileService.writeFiles(outputFile, answer);
        System.out.println(INFO);
    }
}

