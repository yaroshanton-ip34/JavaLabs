/**
 * Class EmissionBand.
 * Describes the range of electromagnetic radiation of a particular electrical device in megahertz
 */

public final class EmissionBand {
    private final double fromMHz;
    private final double toMHz;

    // Creates a new object with the specified boundaries
    public EmissionBand(double fromMHz, double toMHz) {
        if (Double.isNaN(fromMHz) || Double.isNaN(toMHz)) {
            throw new IllegalArgumentException("Error. Range parameters cannot be NaN.");
        }
        if (fromMHz < 0 || toMHz < 0) {
            throw new IllegalArgumentException("Error. Frequencies must be non-negative.");
        }
        if (fromMHz > toMHz) {
            throw new IllegalArgumentException("Error. The start of the range cannot be greater than the end.");
        }
        this.fromMHz = fromMHz;
        this.toMHz = toMHz;
    }

    // Checks whether the current range overlaps with the specified one
    public boolean overlaps(EmissionBand other) {
        if (other == null) return false;
        return this.fromMHz <= other.toMHz && other.fromMHz <= this.toMHz;
    }

    // Returns a text representation of a range
    @Override
    public String toString() {
        return String.format("[%.3f–%.3f] MHz", fromMHz, toMHz);
    }
}