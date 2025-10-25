import java.util.Random;

public class Main {
    /* Лабораторну роботу виконав студнт Ярош Антон із групи ІП-34
    С5 = 0. С7 = 1. С11 = 4. Порядковий номер = 15. (Згідно пункту 1 лабораторного завдання) */
    public static void matrixOperations() {
        Random rand =  new Random();

        // Тип даних матриць Byte (згідно пункту 3 лабораторного завдання)
        // Генерація рядків та стовпців
        byte rows = (byte) (rand.nextInt(10) + 1);
        byte cols = (byte) (rand.nextInt(10) + 1);

        // Діапазон елементів матриці
        byte min = -25;
        byte max = 25;

        // Генерація матриці B
        byte[][] array_B = new byte[rows][cols];
        for (int i = 0; i < array_B.length; i++) {
            for (int j = 0; j < array_B[i].length; j++) {
                array_B[i][j] = (byte) (rand.nextInt(max - min + 1) + min);
            }
        }

        // Діапазон константи
        byte min_const = -5;
        byte max_const = 5;

        // Генерація константи
        byte constant = (byte) (rand.nextInt(max_const - min_const + 1) + min_const);

        // Створення матриці С та обчислення за формулою С = a * B (згідно пункту лабораторного 2 завдання)
        byte[][] array_C = new byte[rows][cols];
        for (int i = 0; i < array_C.length; i++) {
            for (int j = 0; j < array_C[i].length; j++) {
                array_C[i][j] = (byte) (constant * array_B[i][j]);
            }
        }

        /* Обчислення суми найбільших елементів в рядках матриці з парними номерами
        та найменших елементів в рядках матриці з непарними номерами (згідно пункту лабораторного 4 завдання) */
        int sum_of_elements = 0;
        for (int i = 0; i < array_C.length; i++) {
            if ((i + 1) % 2 == 0) {
                sum_of_elements += findMax(array_C[i]);
            } else {
                sum_of_elements += findMin(array_C[i]);
            }
        }

        // Вивід матриці В
        System.out.print("Matrix B (" + rows + "x" + cols + "): \n");
        for (byte[] row : array_B) {
            for (byte value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Вивід константи
        System.out.println("\nConstant: " + constant);

        // Вивід обчисленої матриці С
        System.out.print("\nMatrix C (" + rows + "x" + cols + "): \n");
        for (byte[] row : array_C) {
            for (byte value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Вивід обчисленої суми
        System.out.println("\nSum: " + sum_of_elements);
    }

    // Функція пошуку найбільших елементів в рядках матриці із парними номерами
    private static int findMax(byte[] arrayC) {
        int max = arrayC[0];
        for (int value : arrayC) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Функція пошуку найменших елементів в рядках матриці із непарними номерами
    private static int findMin(byte[] arrayC) {
        int min = arrayC[0];
        for (int value : arrayC) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Основна функція
    public static void main(String[] args) {
        matrixOperations();
    }
}