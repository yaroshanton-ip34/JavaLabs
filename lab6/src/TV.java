/**
 * Class TV.
 * Represents a specific type of electrical appliance - a television
 */

public final class TV extends Appliance {
    private static final EmissionBand BAND = new EmissionBand(50, 900);

    // Creates a new TV with the specified name and rated power
    public TV(String name, int ratedPowerWatts) {
        super(name, ratedPowerWatts);
    }

    // Returns a fixed range of electromagnetic radiation from the TV
    @Override
    public EmissionBand getEmissionBand() {
        return BAND;
    }
}