package app.fares.taxi;

import java.util.*;

public class DriverData {
    private String name;
    private String surname;
    private String email;
    private String vehicletype;
    private int baseFarePrice;
    private double baseFareDistance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype;
    }

    public int getBaseFarePrice() {
        return baseFarePrice;
    }

    public void setBaseFarePrice(int baseFarePrice) {
        this.baseFarePrice = baseFarePrice;
    }

    public double getBaseFareDistance() {
        return baseFareDistance;
    }

    public void setBaseFareDistance(double baseFareDistance) {
        this.baseFareDistance = baseFareDistance;
    }

    public DriverData(){

    }
    public DriverData(String name, String surname, String email, String vehicletype,
                      int baseFarePrice, double baseFareDistance) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.vehicletype = vehicletype;
        this.baseFarePrice = baseFarePrice;
        this.baseFareDistance = baseFareDistance;
    }

    ArrayList<Double> calculatedCosts = new ArrayList<>();

    public ArrayList<Double> getCalculatedCosts() {
        return calculatedCosts;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (DriverData) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.surname, that.surname) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.vehicletype, that.vehicletype) &&
                this.baseFarePrice == that.baseFarePrice &&
                Double.doubleToLongBits(this.baseFareDistance) == Double.doubleToLongBits(that.baseFareDistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, vehicletype, baseFarePrice, baseFareDistance);
    }

    @Override
    public String toString() {
        return "DriverData[" +
                "name=" + name + ", " +
                "surname=" + surname + ", " +
                "email=" + email + ", " +
                "vehicletype=" + vehicletype + ", " +
                "baseFarePrice=" + baseFarePrice + ", " +
                "baseFareDistance=" + baseFareDistance + ']';
    }

}

