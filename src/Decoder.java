
public class Decoder {

    static char[] engAlphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g',
                                    'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                                    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y','z'};

    static char[] rusAlphabet = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                            'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                            'т', 'у', 'ф', 'х', 'ц', 'ч', 'щ', 'ш', 'э', 'ю', 'я'};

    public static String decode(String text, int key, char[] alphabet) {
        if (key < 0) {
            key = alphabet.length + key;
        }

        char[] cipherText = text.toCharArray();
        StringBuilder DecryptedText = new StringBuilder();

        for (Character symbol : cipherText) {
            if (Character.isAlphabetic(symbol)) {
                if (Character.isLowerCase(symbol)) {
                    DecryptedText.append(charDecoder(alphabet, symbol, key));
                } else {
                    DecryptedText.append(Character.toUpperCase(charDecoder(alphabet, Character.toLowerCase(symbol), key)));
                }
            }
            else DecryptedText.append(symbol);
        }
        return DecryptedText.toString();
    }

    public static String encrypt(String text, int key, char[] alphabet) {
        if (key < 0) {
            key = alphabet.length + key;
        }
        return decode(text, alphabet.length - key, alphabet);
    }

    private static char charDecoder(char[] alphabet, Character symbol, int key) {
        char returnChar = symbol;
        for (int i = 0; i < alphabet.length; i++) {
            if (symbol.equals(alphabet[i])) {
                returnChar = alphabet[(i + key) % alphabet.length];
            }
        }
        return returnChar;
    }
}

