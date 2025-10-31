/**
 * Class Appliance.
 * Describes a generalized model of an electrical appliance.
 */

public abstract class Appliance {
    private final String name;
    private final int ratedPowerWatts;
    private boolean on;

    // Creates a new electrical appliance with the specified name and power
    protected Appliance(String name, int ratedPowerWatts) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Error. The device name cannot be empty.");
        }
        if (ratedPowerWatts <= 0) {
            throw new IllegalArgumentException("Error. The power must be positive.");
        }
        this.name = name;
        this.ratedPowerWatts = ratedPowerWatts;
        this.on = false;
    }

    // Returns the device name
    public final String getName() {
        return name;
    }

    // Returns the rated power of the device in watts
    public final int getRatedPowerWatts() {
        return ratedPowerWatts;
    }

    // Returns the device status
    public final boolean isOn() {
        return on;
    }

    // Turn on the device
    public void turnOn() {
        this.on = true;
    }

    // Determines the electromagnetic radiation range of a specific device
    public abstract EmissionBand getEmissionBand();

    // Returns a text representation of the device in a user-friendly format
    @Override
    public String toString() {
        return String.format(
                "%s{name='%s', rated=%dW, on=%s, emission=%s}",
                getClass().getSimpleName(), name, ratedPowerWatts, on, getEmissionBand());
    }
}