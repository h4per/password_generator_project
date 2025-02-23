// Connecting libraries

import java.util.Scanner;
import java.security.SecureRandom;

import com.nulabinc.zxcvbn.Zxcvbn;
import com.nulabinc.zxcvbn.Strength;


public class PasswordGenerator {

    //Constants containing character sets
    private static final String UppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LowercaseLetters = UppercaseLetters.toLowerCase();
    private static final String AllDigits = "0123456789";
    private static final String SpecialChars = "!\"#$%&'()*+,-./:;<>=?@[]^_`{}~|";

    // Constant for generation fully random password
    private static final String AllChars = UppercaseLetters + LowercaseLetters + AllDigits + SpecialChars;

    // Method for generating password
    public static String generatePassword() {
        Scanner input = new Scanner(System.in); // Scanner to read user input

        StringBuilder readyPassword = new StringBuilder(); //String builder for containing the final password
        SecureRandom random = new SecureRandom(); // For random generation

        // Defining the length of the password
        System.out.print("\nEnter password length: ");
        int length = input.nextInt();

        // Checks whether the password length is valid
        if (length <= 0) {
            System.out.println("Invalid length. Please input a positive integer.");
            return generatePassword();
        }

        // Asking user what type of characters in their password
        System.out.print("Do you want to include uppercase letters? (y/n): ");
        boolean upperCaseIncluded = input.next().equalsIgnoreCase("y");

        System.out.print("Do you want to include lowercase letters? (y/n): ");
        boolean lowerCaseIncluded = input.next().equalsIgnoreCase("y");

        System.out.print("Do you want to include digits? (y/n): ");
        boolean digitIncluded = input.next().equalsIgnoreCase("y");

        System.out.print("Do you want to include special characters? (y/n): ");
        boolean specialCharIncluded = input.next().equalsIgnoreCase("y");

        // Setting the generation of password on user's choices
        StringBuilder UserPresets = new StringBuilder();
        if (upperCaseIncluded) {
            UserPresets.append(UppercaseLetters);
        }
        if (lowerCaseIncluded) {
            UserPresets.append(LowercaseLetters);
        }
        if (digitIncluded) {
            UserPresets.append(AllDigits);
        }
        if (specialCharIncluded) {
            UserPresets.append(SpecialChars);
        }

        // Checks whether user choose any character types
        if (UserPresets.isEmpty()) {
            System.out.println("You must select at least one option to include! Please enter the length and options again.");
            return generatePassword();
        }

        // Generation of the password by picking random characters from the selected set
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(UserPresets.length());
            readyPassword.append(UserPresets.charAt(index));
        }
        return readyPassword.toString();
    }

    // Method for generating password using ready presets
    public static String presetsPassword () {
        Scanner input = new Scanner(System.in); // Scanner to read user input

        StringBuilder readyPassword = new StringBuilder(); //String builder for containing the final password
        SecureRandom random = new SecureRandom(); // For random generation

        StringBuilder readyPresets = new StringBuilder(); //String builder for containing the presets

        // Showing which presets could be chosen
        System.out.print("\nHere our presets:\n1)Uppercase letters with special symbols.\n2)Lowercase letters with special symbols.\n3)Digits with special symbols.\n4)Uppercase and lowercase letters.\n");
        System.out.print("\nChoose one of the presets: ");

        int presets = input.nextInt();

        // Generation of the password on user's chosen presets
        if(presets == 1) {
            readyPresets.append(UppercaseLetters).append(SpecialChars);
        }
        else if(presets == 2) {
            readyPresets.append(LowercaseLetters).append(SpecialChars);
        }
        else if(presets == 3) {
            readyPresets.append(AllDigits).append(SpecialChars);
        }
        else if(presets == 4) {
            readyPresets.append(UppercaseLetters).append(LowercaseLetters);
        }
        else {
            // If the user enters an invalid option, restart the function
            System.out.println("You must select at least one option to include!");
            return presetsPassword();
        }

        // Defining the length of the password
        System.out.print("\nEnter password length: ");
        int length = input.nextInt();

        // Checks whether the password length is valid
        if (length <= 0) {
            System.out.println("Invalid length. Please input a positive integer.");
            return generatePassword();
        }

        // Generation of the password by picking random characters from the presets
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(readyPresets.length());
            readyPassword.append(readyPresets.charAt(index));
        }
        return readyPassword.toString();
    }

    // Method for generating password with all characters
    public static String generateCompletelyRandomPassword() {
        Scanner input = new Scanner(System.in); // Scanner to read user input

        SecureRandom random = new SecureRandom(); // For random generation
        StringBuilder password = new StringBuilder(); //String builder for containing the final password

        // Defining the length of the password
        System.out.print("\nEnter password length: ");
        int length = input.nextInt();

        // Checks whether the password length is valid
        if (length <= 0) {
            System.out.println("Invalid length. Please input a positive integer.");
            return generatePassword();
        }

        // Generation of the password using all characters
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(AllChars.length());
            password.append(AllChars.charAt(index));
        }
        return password.toString();
    }

    public static String passwordStrength(String passwordToCheck) {
        Zxcvbn zxcvbn = new Zxcvbn();
        Strength strength = zxcvbn.measure(passwordToCheck);

        System.out.println("\nPassword Strength Analysis:");
        System.out.println("Score: " + strength.getScore() + " (0 = Very Weak, 4 = Very Strong)");
        System.out.println("Crack time estimate: " + strength.getCrackTimesDisplay().getOfflineSlowHashing1e4perSecond());

        return passwordToCheck;
    }

    // Main method that displays menu and options on generating the password
    public static void main(String[] args) {

        // Greeting message and menu
        System.out.print("\nHello and welcome! This is will help you to generate a strong password!(´｡• ᵕ •｡)\n");
        System.out.print("Here is our options:\n1) Setting the password on your own. \n2) Using ready presets.\n3) Generate literally random password!\n\nChoose one of the options: ");

        Scanner input = new Scanner(System.in);  // Scanner to read user input
        int options = input.nextInt();

        // Calling functions and generating the password on user's choices
         if(options == 1) {
             String password = generatePassword();
             String passwordStrenght = passwordStrength(password);

             System.out.println("\n(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧\nYour generated password is here! --> " + passwordStrenght);
         }
         else if(options == 2) {
                String password = presetsPassword();
                String passwordStrenght = passwordStrength(password);

                System.out.println("\n(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧\nYour generated password is here! --> " + passwordStrenght);
         }
         else if(options == 3) {
             String password = generateCompletelyRandomPassword();
             String passwordStrenght = passwordStrength(password);

             System.out.println("\n(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧\nYour completely random generated password is here! --> " + passwordStrenght);
         }
         else {
                System.out.println("Goodbye! ( ° ∀ ° )ﾉﾞ");
        }
    }
}