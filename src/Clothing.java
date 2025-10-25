import java.util.Objects;

public class Clothing implements Comparable<Clothing> {
    // 5 полів класу (бренд, тип, розмір, ціна, колір)
    private final String brand;
    private final String type;
    private final String size;
    private final double price;
    private final String color;

    // Конструктор
    public Clothing(String brand, String type, String size, double price, String color) {
        // Валідація на null в полях
        if (brand == null || type == null || size == null || color == null) {
            throw new IllegalArgumentException("Поля не можуть бути null");
        }

        // Валідація на ціну, яка менша за 0
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від’ємною");
        }

        this.brand = brand;
        this.type = type;
        this.size = size;
        this.price = price;
        this.color = color;
    }

    // Гетери
    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    // Перевизначення методу equals для порівняння об’єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clothing clothing = (Clothing) obj;
        return Double.compare(clothing.price, price) == 0 &&
                Objects.equals(brand, clothing.brand) &&
                Objects.equals(type, clothing.type) &&
                Objects.equals(size, clothing.size) &&
                Objects.equals(color, clothing.color);
    }

    // Перевизначення методу hasCode після equals
    @Override
    public int hashCode() {
        return Objects.hash(brand, type, size, price, color);
    }

    // Для зручного та зрозумілого виведення
    @Override
    public String toString() {
        return String.format("Clothing{brand='%s', type='%s', size='%s', price=%.2f, color='%s'}", brand, type, size, price, color);
    }

    // Сортування методом compareTo
    @Override
    public int compareTo(Clothing other) {
        int brandCompare = this.brand.compareTo(other.brand);
        if (brandCompare != 0) {
            return brandCompare;
        } else {
            return Double.compare(other.price, this.price);
        }
    }
}