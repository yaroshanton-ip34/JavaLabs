// Class Punctuation. Represents a punctuation mark in the text.
public class Punctuation {
    // Stores the punctuation symbol
    private final char symbol;

    // Saves the punctuation symbol
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    // Returns the punctuation symbol as a string
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
