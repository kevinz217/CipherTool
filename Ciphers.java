public class Ciphers {
    private String key;
    private int shift;
    // APCSA as default key, 13 as default shift
    public Ciphers() {
        shift = 13;
        key = "APCSA";
    }

    public Ciphers(int shift, String key) {
        this.shift = shift;
        this.key = key;
    }

    public void setKey(String newKey) {
        key = newKey;
    }

    public String getKey() {
        return key;
    }

    public void setShift(int newShift) {
        shift = newShift;
    }

    public int getShift() {
        return shift;
    }

    public String Rot13(String message) {
        String encryptedStr = "";
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            // checks if the character is a letter
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) (Character.toUpperCase(currentChar) + 13);

                // handles wrapping around the alphabet, uses the unicode of the letter
                if (encryptedChar > 'Z') {
                    encryptedChar = (char) (encryptedChar - 'Z' + 'A' - 1);
                }
                encryptedStr += encryptedChar;
            } else {
                // if the character is not a letter, it will still add it
                encryptedStr += currentChar;
            }
        }
        return encryptedStr;
    }

    public String Caesar(String message) {
        String encryptedStr = "";
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            // checks if the character is a letter
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) (Character.toUpperCase(currentChar) + shift);

                // handles wrapping around the alphabet, uses the unicode of the letter
                if (encryptedChar > 'Z') {
                    encryptedChar = (char) (encryptedChar - 'Z' + 'A' - 1);
                }
                encryptedStr += encryptedChar;
            } else {
                // if the character is not a letter, it will still add it
                encryptedStr += currentChar;
            }
        }
        return encryptedStr;
    }

    public String Caesar(String message, int shiftInt) {
        String encryptedStr = "";
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            // checks if the character is a letter
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) (Character.toUpperCase(currentChar) + shiftInt);

                // handles wrapping around the alphabet, uses the unicode of the letter
                if (encryptedChar > 'Z') {
                    encryptedChar = (char) (encryptedChar - 'Z' + 'A' - 1);
                }
                encryptedStr += encryptedChar;
            } else {
                // if the character is not a letter, it will still add it
                encryptedStr += currentChar;
            }
        }
        return encryptedStr;
    }

    public String CaesarD(String encryptedMessage, int newShift) {
        return Caesar(encryptedMessage, -newShift);
    }

    public String Binary(String message) {
        String encodedStr = "";
        for (char c : message.toCharArray()) {
            String binaryString = Integer.toBinaryString(c);
            // makes each binary string as 8 digits
            encodedStr += (String.format("%8s", binaryString).replace(' ', '0'));
        }
        return encodedStr;
    }

    public String BinaryD(String message) {
        String encodedStr = "";
        for (int i = 0; i < message.length(); i += 8) {
            String byteString = message.substring(i, Math.min(i + 8, message.length()));
            int charCode = Integer.parseInt(byteString, 2);
            encodedStr += ((char) charCode);
        }
        return encodedStr;
    }

    public String Morse(String message) {
        String encryptedStr = "";
        for (char currentChar : message.toUpperCase().toCharArray()) {
            if (Character.isLetter(currentChar)) {
                int index = currentChar - 'A';
                String[] morseAlphabet = getMorseAlphabet();
                encryptedStr += (morseAlphabet[index]) + " ";
            } else if (Character.isDigit(currentChar)) {
                int index = currentChar - '0';
                String[] morseDigits = getMorseDigits();
                encryptedStr += (morseDigits[index]) + " ";
            } else if (currentChar == ' ') {
                encryptedStr += " ";
            }
        }

        return encryptedStr;
    }

    public static String MorseD(String morseCode) {
        String encryptedStr = "";
        String[] words = morseCode.split("\\s{3,}");
        for (String word : words) {
            String[] morseChars = word.split("\\s+");
            for (String morseChar : morseChars) {
                String decodedChar = decodeMorseChar(morseChar);
                encryptedStr += decodedChar;
            }
            encryptedStr += " ";
        }
        return encryptedStr;
    }

    private static String decodeMorseChar(String morseChar) {
        String[] morseAlphabet = getMorseAlphabet();
        for (int i = 0; i < morseAlphabet.length; i++) {
            if (morseAlphabet[i].equals(morseChar)) {
                return Character.toString((char) ('A' + i));
            }
        }

        String[] morseDigits = getMorseDigits();
        for (int i = 0; i < morseDigits.length; i++) {
            if (morseDigits[i].equals(morseChar)) {
                return Integer.toString(i);
            }
        }
        return "";
    }

    public String random(String message) {
        int randomNum = (int) (Math.random() * 3);
        if (randomNum == 0) {
            return Rot13(message);
        }
        if (randomNum == 1) {
            return Binary(message);
        }
        if (randomNum == 2) {
            return Morse(message);
        }
        return "";
    }

    private static String[] getMorseAlphabet() {
        return new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
    }

    private static String[] getMorseDigits() {
        return new String[]{
                "-----", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----."
        };
    }

}
