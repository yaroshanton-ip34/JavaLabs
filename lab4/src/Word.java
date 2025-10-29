// Class Word. Represents a word made of an array of letters.
public class Word {
    private Letter[] letters;

    // Creates a word from a string
    public Word(String str) {
        str = str.trim();
        letters = new Letter[str.length()];
        for (int i = 0; i < str.length(); i++) {
            letters[i] = new Letter(str.charAt(i));
        }
    }

    // Removes all next occurrences of the first letter
    public void removeDuplicateFirstLetter() {
        if (letters.length == 0) return;

        Letter first = letters[0];
        StringBuilder sb = new StringBuilder();
        sb.append(first.getValue());

        for (int i = 1; i < letters.length; i++) {
            if (!first.equalsIgnoreCase(letters[i])) {
                sb.append(letters[i].getValue());
            }
        }

        String result = sb.toString();
        letters = new Letter[result.length()];
        for (int i = 0; i < result.length(); i++) {
            letters[i] = new Letter(result.charAt(i));
        }
    }

    // Converts the word to a string for printing
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter l : letters) sb.append(l.getValue());
        return sb.toString();
    }
}
