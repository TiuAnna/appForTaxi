package app.fares.taxi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverAccountHelper {

    private ArrayList<DriverData> driversInfo;
    Scanner in = new Scanner(System.in);
    DriverData signedOnDriver;
    int driverNumber;

    public DriverAccountHelper(int driverNumber, ArrayList<DriverData> driversInfo) {

        this.driverNumber = driverNumber;
        this.driversInfo = driversInfo;
    }

    public boolean isUserSignedOn() {
        if (signedOnDriver == null) {
            System.out.println(MessagesText.PLEASE_SIGN_IN);
            return false;
        } else {
            return true;
        }

    }

    public void addNewDriver() {
        System.out.println("Register a new driver:");
        String[] dataToInput = {"your name", "your surname", "your email", "type of your vehicle", "base fare price",
                "base fare distance"};
        String[] emptyMassive = new String[dataToInput.length];
        for (int i = 0; i < dataToInput.length; i++) {
            System.out.println("Please input " + dataToInput[i]);
            emptyMassive[i] = in.nextLine();
        }
        DriverData driverData = new DriverData(emptyMassive[0], emptyMassive[1], emptyMassive[2], emptyMassive[3],
                Integer.parseInt(emptyMassive[4]), Double.parseDouble(emptyMassive[5]));
        driversInfo.add(driverData);
        System.out.println("New driver was successfully registered.");
        System.out.println("Driver's index is " + driversInfo.size());
    }

    public void editDriver() {
        if (!isUserSignedOn()) {
            return;
        }
        System.out.println("Current driver info:");
        System.out.println(driversInfo.get(driverNumber));
        String[] dataToEdit = {"your name", "your surname", "your email", "type of your vehicle", "base fare price",
                "base fare distance"};
        String[] selectedField = {"'name'", "'surname'", "'email'", "'vehicle'", "'fare'", "'distance'"};
        for (int i = 0; i < dataToEdit.length; i++) {
            System.out.println("If you what to edit " + dataToEdit[i] + " type " + selectedField[i]);
        }
        boolean continueEditing = true;
        while (continueEditing) {
            String answer = in.nextLine();
            switch (answer.toLowerCase()) {
                case "name":
                    System.out.println("Type new value for " + dataToEdit[0]);
                    signedOnDriver.setName(in.nextLine());
                    break;
                case "surname":
                    System.out.println("Type new value for " + dataToEdit[1]);
                    signedOnDriver.setSurname(in.nextLine());
                    break;
                case "email":
                    System.out.println("Type new value for " + dataToEdit[2]);
                    signedOnDriver.setEmail(in.nextLine());
                    break;
                case "vehicle":
                    System.out.println("Type new value for " + dataToEdit[3]);
                    signedOnDriver.setVehicletype(in.nextLine());
                    break;
                case "fare":
                    System.out.println("Type new value for " + dataToEdit[4]);
                    try {
                        signedOnDriver.setBaseFarePrice(Integer.parseInt(in.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println(MessagesText.INCORRECT_PRICE_ERROR);
                    }
                    break;
                case "distance":
                    System.out.println("Type new value for " + dataToEdit[5]);
                    try {
                        signedOnDriver.setBaseFareDistance(Double.parseDouble(in.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println(MessagesText.INCORRECT_DISTANCE_ERROR);
                    }
                    break;
                case "save":
                    System.out.println("All changes successfully saved");
                    continueEditing = false;
                    break;
            }
            if (continueEditing) {
            System.out.println("Type 'save' to save changes or choose next field to edit.");
            }

        }
        System.out.println("Current driver info:");
        System.out.println(driversInfo.get(driverNumber));
    }

    protected void viewCostsHistory() {
        if (!isUserSignedOn()) {
            return;
        }
        if (signedOnDriver.getCalculatedCosts().size() > 0) {
            System.out.println("Previous calculated costs:");
            for (double calculatedFareForTravel : signedOnDriver.getCalculatedCosts()) {
                System.out.println(calculatedFareForTravel);
            }
        } else {
            System.out.println(MessagesText.NO_CALCULATED_COSTS);
        }

    }

    public void calculateTheCheapestFare() throws IOException {
        if (!isUserSignedOn()) {
            return;
        }
        System.out.println(MessagesText.TYPE_PATH_TO_CSV_FILE);
        String pathToCSVFile = in.nextLine();
        List<String> fileLines = Files.readAllLines(Path.of(pathToCSVFile));
        for (String line : fileLines) {
            String[] csvFileOneLineInfo = line.split(",");
            double[] oneLineValues = new double[csvFileOneLineInfo.length];
            for (int i = 0; i < oneLineValues.length; i++) {
                oneLineValues[i] = Double.parseDouble(csvFileOneLineInfo[i]);
            }
            TravelData travelData = new TravelData(oneLineValues[0], oneLineValues[1], oneLineValues[2]);
            double distanceTraveledUnits = travelData.getDistanceTraveled() - signedOnDriver.getBaseFareDistance();
            double fare;
            if (travelData.getDistanceTraveled() > signedOnDriver.getBaseFareDistance()) {
                fare = signedOnDriver.getBaseFarePrice() + (distanceTraveledUnits / travelData.getTraveledUnit() * travelData.getCostPerDistanceTraveled());
            } else {
                fare = signedOnDriver.getBaseFarePrice();
            }
            signedOnDriver.getCalculatedCosts().add(fare);
            System.out.println(fare);
        }
    }

    public void deleteDriver() {
        if (!isUserSignedOn()) {
            return;
        }
        System.out.println("Do you really want to delete your account?");
        System.out.println("Type 'yes' to confirm deletion.");
        String answer = in.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            driversInfo.remove(driverNumber);
            System.out.println("Account was successfully deleted.");
            signedOnDriver = null;
        } else {
            System.out.println("Deletion is canceled.");
        }
    }
}
