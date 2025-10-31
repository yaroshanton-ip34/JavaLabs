/**
 * Class MicrowaveOven.
 * Represents a specific type of electrical appliance - a microwave oven
 */

public final class MicrowaveOven extends Appliance {
    private static final EmissionBand BAND = new EmissionBand(2400, 2500);

    // Creates a new object with the given name and rated power
    public MicrowaveOven(String name, int ratedPowerWatts) {
        super(name, ratedPowerWatts);
    }

    // Returns a fixed range of microwave electromagnetic radiation
    @Override
    public EmissionBand getEmissionBand() {
        return BAND;
    }
}