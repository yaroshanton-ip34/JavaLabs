/**
 * Class Refrigerator.
 * Represents a specific type of electrical appliance - a refrigerator
 */

 final class Refrigerator extends Appliance {
    private static final EmissionBand BAND = new EmissionBand(150, 500);

    // Creates a new object with the given name and capacity
    public Refrigerator(String name, int ratedPowerWatts) {
        super(name, ratedPowerWatts);
    }

    // Returns a fixed range of electromagnetic radiation from the refrigerator
    @Override
    public EmissionBand getEmissionBand() {
        return BAND;
    }
}