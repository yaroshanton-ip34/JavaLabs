// Class Sentence. Represents a sentence made of words and punctuation marks.
public class Sentence {
    private Word[] words;
    private Punctuation[] punctuations;

    // Splits the text into words and punctuation marks
    public Sentence(String sentenceText) {
        sentenceText = sentenceText.replaceAll("[\\t\\s]+", " ").trim();
        String[] wordParts = sentenceText.split("(?=[,.:;!?])|\\s+");

        int wCount = 0, pCount = 0;
        for (String part : wordParts) {
            if (part.matches("[,.:;!?]")) pCount++;
            else if (!part.isEmpty()) wCount++;
        }

        words = new Word[wCount];
        punctuations = new Punctuation[pCount];

        int wi = 0, pi = 0;
        for (String part : wordParts) {
            if (part.matches("[,.:;!?]")) {
                punctuations[pi++] = new Punctuation(part.charAt(0));
            } else if (!part.isEmpty()) {
                words[wi++] = new Word(part);
            }
        }
    }

    // Returns number of words in the sentence
    public int getWordCount() {
        return words.length;
    }

    // Removes repeated first letters
    public void processWords() {
        for (Word w : words) {
            w.removeDuplicateFirstLetter();
        }
    }

    // Converts the sentence to a string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word w : words) sb.append(w).append(" ");
        for (Punctuation p : punctuations) sb.append(p);
        return sb.toString().trim();
    }
}
