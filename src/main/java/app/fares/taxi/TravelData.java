package app.fares.taxi;

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

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public double getTraveledUnit() {
        return traveledUnit;
    }

    public void setTraveledUnit(double traveledUnit) {
        this.traveledUnit = traveledUnit;
    }

    public double getCostPerDistanceTraveled() {
        return costPerDistanceTraveled;
    }

    public void setCostPerDistanceTraveled(double costPerDistanceTraveled) {
        this.costPerDistanceTraveled = costPerDistanceTraveled;
    }

}
