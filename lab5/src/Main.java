/**
 * Лабораторна робота №5
 * Виконав: Ярош Антон
 * Група: ІП-34
 * Порядковий номер: 15
 * Варіант завдання: Визначити ієрархію електроприладів. Увімкнути деякі електроприлади в розетку.
 * Підрахувати споживану потужність. Провести сортування приладів у квартирі на основі потужності.
 * Знайти прилад у квартирі, що відповідає заданому діапазону електромагнітного випромінювання.
 */

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