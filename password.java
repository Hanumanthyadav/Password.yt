import java.util.Scanner;
import java.util.Random;

class PasswordGenerator {
    static String pd(int totalletters, int totalnumbers, int totalsymbols) {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < totalletters; ++i) {
            password.append(letters.charAt(rand.nextInt(letters.length())));
        }

        for (int i = 0; i < totalsymbols; ++i) {
            password.append(symbols.charAt(rand.nextInt(symbols.length())));
        }

        for (int i = 0; i < totalnumbers; ++i) {
            password.append(numbers.charAt(rand.nextInt(numbers.length())));
        }

        // Shuffle the password
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int j = rand.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of letters in the password: ");
        int totalLetters = scanner.nextInt();

        System.out.print("Enter the number of numbers in the password: ");
        int totalNumbers = scanner.nextInt();

        System.out.print("Enter the number of symbols in the password: ");
        int totalSymbols = scanner.nextInt();

        if (totalLetters <= 0 || totalNumbers <= 0 || totalSymbols <= 0) {
            System.out.println("Invalid input. Please enter positive integers for the number of letters, numbers, and symbols.");
            return;
        }

        String password = pd(totalLetters, totalNumbers, totalSymbols);
        System.out.println("Your Password is: " + password);
    }
}
