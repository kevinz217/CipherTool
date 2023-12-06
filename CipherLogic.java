import java.util.Scanner;
public class CipherLogic {
    private Ciphers cipher;
    private Scanner scanner;

    public CipherLogic() {
        cipher = null;
        scanner = new Scanner(System.in);
    }

    public void start() {
        startOf();
        theLoop();
    }

    private void startOf() {
        System.out.print("---------------------------------------\n");
        System.out.print("Hello! Welcome to my cipher menu thing!\n");
        System.out.print("Would you like to change the shift and key? ");
        String input = scanner.nextLine();
        if (input.equals("y")) {
            System.out.print("What would you like the shift to be? ");
            int shift = scanner.nextInt();
            scanner.nextLine();
            System.out.print("What would you like the key to be? ");
            String key = scanner.nextLine();
            cipher = new Ciphers(shift, key);
        } else {
            cipher = new Ciphers();
        }
        System.out.println("Created the Cipher!");
    }

    private void theLoop() {
        int input = 0;
        while (input != 6) {
            mainMenu();
            System.out.print("Enter a number: ");
            input = scanner.nextInt();
            if (input == 1) {
                System.out.print("Enter the new shift: ");
                int newShift = scanner.nextInt();
                scanner.nextLine();
                cipher.setShift(newShift);
            }
            if (input == 2) {
                System.out.print("Enter the new key: ");
                String newKey = scanner.nextLine();
                cipher.setKey(newKey);
            }
            if (input == 3) {
                System.out.println("----------------------------");
                System.out.println("Your current shift is: " + cipher.getShift());
                System.out.println("Your current key is: " + cipher.getKey());
            }
            if (input == 4) {
                System.out.println("----------------------------");
                System.out.println("1. Caesar/Rot13");
                System.out.println("2. Binary");
                System.out.println("3. Morse");
                System.out.println("4. Random");
                System.out.print("Enter selection: ");
                int moreInput = scanner.nextInt();
                scanner.nextLine();
                if (moreInput == 1) {
                    System.out.println("----------------------------");
                    System.out.println("Rot or Caesar? ");
                    String response = scanner.nextLine();
                    response = response.toLowerCase();
                    if (response.equals("rot")) {
                        System.out.print("Enter your message: ");
                        String response2 = scanner.nextLine();
                        String encryptedMsg = cipher.Rot13(response2);
                        System.out.println("Your encrypted message is: " + encryptedMsg);
                    } else if (response.equals("caesar")) {
                        System.out.print("Enter your message");
                        String response2 = scanner.nextLine();
                        String encryptedMsg = cipher.Caesar(response2);
                        System.out.println("Your encrypted message is: " + encryptedMsg);
                    } else {
                        System.out.println("Not a valid answer!");
                    }
                }
                if (moreInput == 2) {
                    System.out.println("----------------------------");
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    String encryptedMsg = cipher.Binary(message);
                    System.out.println("Your encrypted message is: " + encryptedMsg);
                }
                if (moreInput == 3) {
                    System.out.println("----------------------------");
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    String encryptedMsg = cipher.Morse(message);
                    System.out.println("Your encrypted message is: " + encryptedMsg);
                }
                if (moreInput == 4) {
                    System.out.println("----------------------------");
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    String encryptedMsg = cipher.random(message);
                    System.out.println("Your encrypted message is: " + encryptedMsg);
                }
            }
            if (input == 5) {
                System.out.println("----------------------------");
                System.out.println("1. Caesar/Rot13");
                System.out.println("2. Binary");
                System.out.println("3. Morse");
                System.out.print("Enter selection: ");
                int moreInput = scanner.nextInt();
                scanner.nextLine();
                if (moreInput == 1) {
                    System.out.println("----------------------------");
                    System.out.print("Rot or Caesar? ");
                    String response = scanner.nextLine();
                    response = response.toLowerCase();
                    if (response.equals("rot")) {
                        System.out.print("Enter your message: ");
                        String response2 = scanner.nextLine();
                        String encryptedMsg = cipher.CaesarD(response2, 13);
                        System.out.println("Your decrypted message is: " + encryptedMsg);
                    } else if (response.equals("caesar")) {
                        System.out.print("Enter your message: ");
                        String response2 = scanner.nextLine();
                        System.out.print("Enter the shift: ");
                        int theShift = scanner.nextInt();
                        scanner.nextLine();
                        String encryptedMsg = cipher.Caesar(response2, theShift);
                        System.out.println("Your decrypted message is: " + encryptedMsg);
                    } else {
                        System.out.println("Not a valid answer!");
                    }
                }
                if (moreInput == 2) {
                    System.out.println("----------------------------");
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    String encryptedMsg = cipher.BinaryD(message);
                    System.out.println("Your decrypted message is: " + encryptedMsg);
                }
                if (moreInput == 3) {
                    System.out.println("----------------------------");
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    String encryptedMsg = cipher.MorseD(message);
                    System.out.println("Your decrypted message is: " + encryptedMsg);
                }
            }
            if (input == 6) {
                System.out.println("Thank you for using this interface!");
            } else if (input <= 0 || input > 6) {
                System.out.println("That is not a valid input!");
            }
        }
    }

    // the menu that is shown to the user
    private void mainMenu() {
        System.out.println("------- Main Menu --------");
        System.out.println("-------------------------");
        System.out.println("1. Change shift");
        System.out.println("2. Change key");
        System.out.println("3. Cipher Info");
        System.out.println("4. Encrypt");
        System.out.println("5. Decrypt");
        System.out.println("6. Exit");
        System.out.println();
    }
}