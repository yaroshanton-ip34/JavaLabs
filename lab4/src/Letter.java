// Class Letter. Represents one character in a word.
public class Letter {
    // Stores the letter value
    private final char value;

    // Saves the letter
    public Letter(char value) {
        this.value = value;
    }

    // Returns the character value
    public char getValue() {
        return value;
    }

    // Compares two letters ignoring upper or lower case
    public boolean equalsIgnoreCase(Letter other) {
        return Character.toLowerCase(this.value) == Character.toLowerCase(other.value);
    }

    // Converts letter to string for printing
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
