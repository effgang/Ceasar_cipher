package Project;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Project.Constants.MenuConstants.MAIN_MENU;


public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int choise;
        while (true) {
            System.out.println(MAIN_MENU);
            try {
                choise = console.nextInt();
            } catch (InputMismatchException e) {
                String badValue = console.nextLine();
                System.out.println("It's not a number: " + badValue);
                choise =5;
            }
            switch (choise) {
                case 1 -> System.out.println("1");//вызовы методов по шифровке и тд
                case 2 -> System.out.println("2");
                case 3 -> System.out.println("3");
                case 4 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Think about your number and try again :)");
            }
        }
    }
}
