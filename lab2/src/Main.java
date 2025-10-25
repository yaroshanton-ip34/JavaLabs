/**
 * Лабораторна робота №2
 * Виконав: Ярош Антон
 * Група: ІП-34
 * Порядковий номер: 15
 * Дія з текстом: В кожному слові заданого тексту, видалити всі наступні входження першої літери цього слова.
 * Тип: StringBuilder
 */

// The main function. Initializes test data and processes it
public class Main {
    public static void main(String[] args) {
        // Array of test data
        String[] testData = {
                "australia india argentina",
                " australia india argentina",
                "australia     india argentina",
                null,
                "",
                "australia india argentina ",
                "word1 word2 word3 word4 word5 word6 word7 word8 word9 " +
                        "word10 word11 word12 word13 word14 word15 word16 word17 word18 word19 word20 word21",
                "australia india @argentina",
                "peoPle Sentences AntArctic avocado",
                "AAAAA BBBBB CCCCC",
                "aAAAA bBBBB cCCCC",
                "Aaaaa Bbbbb Ccccc"
        };

        // The process of processing each text
        for (int i = 0; i < testData.length; i++) {
            String test = testData[i];
            System.out.println("\n Testing input: " + test);
            processText(test);
        }
    }

    /**
     * The processing function. This is where text validation and processing is performed according to the variant.
     * Checks performed:
     * 1. Text must not to be empty or null.
     * 2. The first character must be a letter.
     * 3. Words must be separated by a single space only.
     * 4. No trailing spaces allowed.
     * 5. Maximum of 20 words allowed.
     * 6. The first character of each word must be a letter.
     * 7. If unexpected error occurs, it will display a corresponding message.
     *
     * @param test input string to validate and process
     */
    public static void processText(String test) {
        try {
            StringBuilder text = new StringBuilder(test);

            // Check if the text is empty
            if (text.isEmpty()) {
                System.out.println("Error. The text is empty.");
                return;
            }
            // Check if the first symbol of text is a letter
            else if (!Character.isLetter(text.charAt(0))) {
                System.out.println("Error. The first symbol is not a letter.");
                return;
            }

            // Validating of spaces at the end of the text and between words
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ' && i != text.length() - 1) {
                    i++;
                    if (text.charAt(i) == ' ') {
                        System.out.println("Error. Between two words there are two or more spaces.");
                        return;
                    }
                    i--;
                } else if (text.charAt(i) == ' ' && i == text.length() - 1) {
                    System.out.println("Error. There is a space at the end of the sentence.");
                    return;
                }
            }

            // Split text into words
            String[] words = text.toString().split(" ");

            // Check the maximum number of words allowed
            if (words.length > 20) {
                System.out.println("Error. There are more than 20 words in the sentence.");
                return;
            }

            System.out.print("Result: ");

            /**
             * Processing each word:
             * Removing all subsequent occurrences of the first letter of the word.
             */
            for (int i = 0; i < words.length; i++) {
                StringBuilder word = new StringBuilder(words[i]);
                char firstLetter = word.charAt(0);

                // Check the first character if the word
                if (!Character.isLetter(word.charAt(0))) {
                    System.out.println("... \nError. The first symbol of word is not a letter.");
                    return;
                }

                // Remove all subsequent occurrences of the word being processed
                for (int j = 1; j < word.length(); j++) {
                    if (firstLetter == word.charAt(j)) {
                        word.deleteCharAt(j);
                        j--;
                    } else if (firstLetter == Character.toUpperCase(word.charAt(j))) {
                        word.deleteCharAt(j);
                        j--;
                    } else if (firstLetter == Character.toLowerCase(word.charAt(j))) {
                        word.deleteCharAt(j);
                        j--;
                    }
                }
                // Print the processed word + space
                System.out.print(word + " ");
            }
            System.out.println();
        }
        // Handle null input
        catch (NullPointerException e) {
            System.out.println("Error. The text is null.");
        }
        // Handle unexpected exceptions
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}