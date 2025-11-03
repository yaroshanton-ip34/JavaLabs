/**
 * Лабораторна робота №6
 * Виконав: Ярош Антон
 * Група: ІП-34
 * Порядковий номер: 15
 * Інтерфейс: Set
 * Внутрішня структура колекції: Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%
 */

import java.util.Arrays;
import java.util.List;

// Class Main. Demonstrates class capabilities.
public final class Main {
    public static void main(String[] args) {
        try {
            Apartment apt = new Apartment(6);

            // Add some electrical appliances
            aptAdd(apt, new Refrigerator("Fridge", 180));
            aptAdd(apt, new TV("LivingRoom TV", 120));
            aptAdd(apt, new MicrowaveOven("Microwave", 1200));
            aptAdd(apt, new VacuumCleaner("Dyson", 900));

            // Attempting to add a device with a duplicate name
            try {
                aptAdd(apt, new Refrigerator("fridge", 200));
            } catch (Apartment.DuplicateApplianceException dup) {
                System.out.println("Duplicate error: " + dup.getMessage());
            }

            apt.turnOnByName("Fridge");
            apt.turnOnByName("Microwave");

            System.out.println("Total consumed power (ON): " + apt.totalPowerWatts() + " W");

            // Sort devices by rated power in ascending order
            apt.sortByRatedPowerAscending();
            System.out.println("Sorted by rated power:");
            for (Appliance a : apt.toArray()) {
                System.out.println(a);
            }

            // Search for a device whose electromagnetic radiation range overlaps with the specified one
            EmissionBand query = new EmissionBand(2401, 2412);
            Appliance hit = apt.findFirstByEmissionOverlap(query);
            if (hit != null) {
                System.out.println("Found overlapping emission with " + query + ": " + hit);
            } else {
                System.out.println("No appliance overlaps " + query);
            }

            // Empty collection
            TypedSet<String> s1 = new TypedSet<>();
            s1.add("Laptop");
            s1.add("TV");
            s1.add("Fridge");

            // With one element
            TypedSet<String> s2 = new TypedSet<>("Microwave");

            // From the collection
            TypedSet<String> s3 = new TypedSet<>(List.of("Vacuum", "Kettle", "TV"));

            System.out.println("s1: " + s1);
            System.out.println("s2: " + s2);
            System.out.println("s3: " + s3);

            // Association
            s1.addAll(s3);
            System.out.println("After addAll: " + s1);
        } catch (Exception fatal) {
            // Handle any unexpected runtime errors
            System.err.println("Unexpected error. " + fatal.getMessage());
        }
    }

    private static void aptAdd(Apartment apt, Appliance appliance)
            throws Apartment.DuplicateApplianceException, Apartment.ApartmentOverflowException {
        apt.add(appliance);
    }
}