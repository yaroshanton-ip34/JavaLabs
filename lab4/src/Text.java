// Class Text. Represents the whole text made of one or more sentences.
public class Text {
    private Sentence[] sentences;

    // Creates a text from a string
    public Text(String text) {
        if (text == null) {
            throw new NullPointerException("Text is null.");
        }

        text = text.replaceAll("[\\t\\s]+", " ").trim();

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text is empty.");
        }

        String[] sentenceParts = text.split("(?<=[.!?])\\s*");
        sentences = new Sentence[sentenceParts.length];

        int totalWordCount = 0;

        for (int i = 0; i < sentenceParts.length; i++) {
            sentences[i] = new Sentence(sentenceParts[i]);
            totalWordCount += sentences[i].getWordCount();
        }

        if (totalWordCount > 20) {
            throw new IllegalArgumentException(
                    "There are more than 20 words in the sentence.");
        }
    }

    // Processes all sentences in the text
    public void process() {
        for (Sentence s : sentences) {
            s.processWords();
        }
    }

    // Converts the whole text to a string for printing
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : sentences) sb.append(s).append(" ");
        return sb.toString().trim();
    }
}
