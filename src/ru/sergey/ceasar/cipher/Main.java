package ru.sergey.ceasar.cipher;

import ru.sergey.ceasar.cipher.exception.FilesException;
import ru.sergey.ceasar.cipher.services.CryptoService;
import ru.sergey.ceasar.cipher.services.Validator;
import ru.sergey.ceasar.cipher.constants.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FilesException {
        CryptoService cryptoService = new CryptoService();
        Scanner console = new Scanner(System.in);

        int choice;
        String inputFile = null;
        String outputFile = null;
        int key = 0;

        while (true) {
            System.out.print(Constants.MAIN_MENU);
            try {
                choice = console.nextInt();
                if (choice < 4 && choice != 0) {
                    System.out.println("Enter your input file");
                    console.nextLine();
                    inputFile = console.nextLine();
                }
                if (choice == 1 || choice == 2) {
                    System.out.println("Enter your key");
                    do {
                        key = console.nextInt();
                        console.nextLine();
                    }
                    while (!Validator.keyValidation(key));
                }
                if (choice < 4 && choice != 0) {
                    System.out.println("Enter your output file");
                    outputFile = console.nextLine();
                }

            } catch (InputMismatchException e) {
                String badValue = console.nextLine();
                System.out.println("It's not a number: " + badValue);
                continue;
            }
            switch (choice) {
                case 1 -> cryptoService.encryptFile(inputFile, outputFile, key);
                case 2 -> cryptoService.decryptFile(inputFile, outputFile, key);
                case 3 -> cryptoService.bruteForce(inputFile, outputFile);
                case 4 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Think about your number and try again :)");
            }
        }
    }
}
