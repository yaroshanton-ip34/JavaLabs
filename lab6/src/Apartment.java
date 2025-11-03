import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Class Apartment.
 * Models an apartment containing a set of electrical appliances
 */

public final class Apartment {
    private final Appliance[] items;
    private int size;

    // Creates a new object with the specified maximum number of devices
    public Apartment(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Error. The capacity of the array must be positive.");
        }
        this.items = new Appliance[capacity];
        this.size = 0;
    }

    // Exception that signals an attempt to add a device with an existing name
    public static class DuplicateApplianceException extends Exception {
        public DuplicateApplianceException(String msg) {
            super(msg);
        }
    }

    // Exception that signals an overflow of the array of devices in the apartment
    public static class ApartmentOverflowException extends Exception {
        public ApartmentOverflowException(String msg) {
            super(msg);
        }
    }

    // Exception that signals the absence of the desired device with the specified name
    public static class NotFoundException extends Exception {
        public NotFoundException(String msg) {
            super(msg);
        }
    }

    // Adds a new appliance to the apartment
    public void add(Appliance appliance)
            throws DuplicateApplianceException, ApartmentOverflowException {
        if (appliance == null) {
            throw new IllegalArgumentException("Error. Cannot add null.");
        }
        if (size == items.length) {
            throw new ApartmentOverflowException("Array filled: " + items.length);
        }
        final String newKey = key(appliance.getName());
        for (int i = 0; i < size; i++) {
            if (key(items[i].getName()).equals(newKey)) {
                throw new DuplicateApplianceException(
                        "A device with a name '" + appliance.getName() + "' already exists.");
            }
        }
        items[size++] = appliance;
    }

    // Turn on a device by its name
    public void turnOnByName(String name) throws NotFoundException {
        Appliance a = findByName(name);
        a.turnOn();
    }

    // Searches for a device by its name
    private Appliance findByName(String name) throws NotFoundException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Error. The search name is empty.");
        }
        String key = key(name);
        for (int i = 0; i < size; i++) {
            if (key(items[i].getName()).equals(key)) return items[i];
        }
        throw new NotFoundException("Device '" + name + "' not found.");
    }

    // Calculates the total power of all turned on appliances in the apartment
    public int totalPowerWatts() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].isOn()) sum += items[i].getRatedPowerWatts();
        }
        return sum;
    }

    // Sorts devices by rated power in ascending order
    public void sortByRatedPowerAscending() {
        Arrays.sort(items, 0, size, Comparator.comparingInt(Appliance::getRatedPowerWatts));
    }

    // Returns the first device whose electromagnetic radiation range overlaps with the specified one
    public Appliance findFirstByEmissionOverlap(EmissionBand query) {
        if (query == null) {
            throw new IllegalArgumentException("Error. Empty search range.");
        }
        for (int i = 0; i < size; i++) {
            if (items[i].getEmissionBand().overlaps(query)) return items[i];
        }
        return null;
    }

    // Returns a copy of an array of all devices currently in the apartment
    public Appliance[] toArray() {
        return Arrays.copyOf(items, size);
    }

    // Creates a normalized key for comparing device names
    private static String key(String s) {
        return s.toLowerCase(Locale.ROOT).trim();
    }
}