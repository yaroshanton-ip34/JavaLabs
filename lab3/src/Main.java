/**
 * Лабораторна робота 3
 * Виконав: Ярош Антон
 * Група: ІП-34
 * Порядковий номер: 15
 * Варіант завдання: Визначити клас одяг, який складається як мінімум з 5-и полів.
 */

// Виконавчий метод
public static void main(String[] args) {

    // Створення масиву об'єктів Clothing
    Clothing[] clothes = {
            new Clothing("Nike", "Куртка", "L", 120.0, "Чорний"),
            new Clothing("Adidas", "Штани", "M", 80.0, "Сірий"),
            new Clothing("Nike", "Футболка", "S", 40.0, "Білий"),
            new Clothing("Puma", "Кофта", "M", 60.0, "Синій"),
            new Clothing("Adidas", "Куртка", "L", 150.0, "Зелений"),
            new Clothing("Nike", "Штани", "XL", 140, "Оранжевий")
    };

    System.out.println("Початковий масив");
    for (Clothing c : clothes) {
        System.out.println(c);
    }

    // Сортування за брендом (по алфавіту за зростанням) та за ціною (за спаданням) згідно завдання
    Arrays.sort(clothes);

    System.out.println("\nВідсортований масив за брендом (по алфавіту за зростанням) та за ціною (за спаданням)");
    for (Clothing c : clothes) {
        System.out.println(c);
    }

    // Заданий об’єкт для пошуку згідно завдання
    Clothing target = new Clothing("Nike", "Футболка", "S", 40.0, "Білий");

    // Пошук ідентичного об'єкта
    boolean found = false;
    for (Clothing c : clothes) {
        if (c.equals(target)) {
            found = true;
            System.out.println("\nІдентичний об’єкт:\n" + c);
            break;
        }
    }

    if (!found) {
        System.out.println("\nІдентичний об’єкт не знайдено.");
    }
}