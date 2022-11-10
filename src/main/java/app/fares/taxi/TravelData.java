package app.fares.taxi;

/**
 * Constructor for a data from csv file used for fare calculation
 *
 * @author Anna Tiulkacheva
 * @version 1.0
 * @since 2022-11-10
 */

public class TravelData {
    private double distanceTraveled;
    private double traveledUnit;
    private double costPerDistanceTraveled;

    public TravelData(double distanceTraveled, double traveledUnit, double CostPerDistanceTraveled) {
        this.distanceTraveled = distanceTraveled;
        this.traveledUnit = traveledUnit;
        this.costPerDistanceTraveled = CostPerDistanceTraveled;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getTraveledUnit() {
        return traveledUnit;
    }

    public double getCostPerDistanceTraveled() {
        return costPerDistanceTraveled;
    }

}
