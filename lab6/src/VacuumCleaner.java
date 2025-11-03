/**
 * Class VacuumCleaner.
 * Represents a specific type of electrical appliance - a vacuum cleaner
 */

public final class VacuumCleaner extends Appliance {
    private static final EmissionBand BAND = new EmissionBand(20, 200);

    // Creates a new object with the given name and rated power
    public VacuumCleaner(String name, int ratedPowerWatts) {
        super(name, ratedPowerWatts);
    }

    // Returns a fixed range of electromagnetic radiation from the vacuum cleaner
    @Override
    public EmissionBand getEmissionBand() {
        return BAND;
    }
}