/**
 * Лабораторна робота №4
 * Виконав: Ярош Антон
 * Група: ІП-34
 * Порядковий номер: 15
 * Дія з текстом: В кожному слові заданого тексту, видалити всі наступні входження першої літери цього слова.
 * Тип: StringBuilder
 */

// The main function. Initializes test data and processes it
public class Main {
    public static void main(String[] args) {
        String[] tests = {
                // Array of test data
                "australia india argentina",
                " australia india argentina",
                "australia    india argentina",
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

        // Process each test input
        for (String input : tests) {
            System.out.println("\nTesting input: " + input);
            processText(input);
        }
    }

    /**
     * Processes the given text and prints the result.
     * Checks input for errors, creates Text object, and runs the main operation.
     */
    public static void processText(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Error. text is empty or null.");
                return;
            }

            Text text = new Text(input);
            text.process();
            System.out.println("Result: " + text);
        } catch (Exception e) {
            System.out.println("Error. " + e.getMessage());
        }
    }
}
