package ltmck;

public class Vigenere {
    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private String key;

    public Vigenere(String key) {
        this.key = key;
    }

    public String encode(String message) {
        String encoded = "";
        int keyIndex = 0;

        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            if (Character.isLetter(messageChar)) {
                int messageIndex = ALPHABET.indexOf(Character.toLowerCase(messageChar));
                char keyChar = key.charAt(keyIndex % key.length());
                int keyIndexInAlphabet = ALPHABET.indexOf(Character.toLowerCase(keyChar));
                int encodedIndex = (messageIndex + keyIndexInAlphabet) % 26;
                char encodedChar = ALPHABET.charAt(encodedIndex);

                if (Character.isUpperCase(messageChar)) {
                    encoded += Character.toUpperCase(encodedChar);
                } else {
                    encoded += encodedChar;
                }

                keyIndex++;
            } else {
                encoded += messageChar;
            }
        }

        return encoded;
    }

    public String decode(String message) {
        String decoded = "";
        int keyIndex = 0;

        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            if (Character.isLetter(messageChar)) {
                int messageIndex = ALPHABET.indexOf(Character.toLowerCase(messageChar));
                char keyChar = key.charAt(keyIndex % key.length());
                int keyIndexInAlphabet = ALPHABET.indexOf(Character.toLowerCase(keyChar));
                int decodedIndex = (messageIndex - keyIndexInAlphabet + 26) % 26;
                char decodedChar = ALPHABET.charAt(decodedIndex);

                if (Character.isUpperCase(messageChar)) {
                    decoded += Character.toUpperCase(decodedChar);
                } else {
                    decoded += decodedChar;
                }

                keyIndex++;
            } else {
                decoded += messageChar;
            }
        }

        return decoded;
    }
}