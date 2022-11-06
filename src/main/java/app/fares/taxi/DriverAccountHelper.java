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
        String[] dataToEdit = {MessagesText.NAME_VALUE, MessagesText.SURNAME_VALUE, MessagesText.EMAIL_VALUE,
                MessagesText.VEHICLE_VALUE, MessagesText.BASE_FARE_VALUE, MessagesText.DISTANCE_VALUE};
        for (String fieldName : dataToEdit) {
            String chooseFiledToEdit = String.format(
                    MessagesText.TEMPLATE_TYPE_COMMAND,
                    "edit your " + fieldName,
                    fieldName
            );
            System.out.println(chooseFiledToEdit);
        }
        boolean continueEditing = true;
        while (continueEditing) {
            String answer = in.nextLine();
            switch (answer.toLowerCase()) {
                case MessagesText.NAME_VALUE -> {
                    System.out.println("Type new value for " + dataToEdit[0]);
                    signedOnDriver.setName(in.nextLine());
                }
                case MessagesText.SURNAME_VALUE -> {
                    System.out.println("Type new value for " + dataToEdit[1]);
                    signedOnDriver.setSurname(in.nextLine());
                }
                case MessagesText.EMAIL_VALUE -> {
                    System.out.println("Type new value for " + dataToEdit[2]);
                    signedOnDriver.setEmail(in.nextLine());
                }
                case MessagesText.VEHICLE_VALUE -> {
                    System.out.println("Type new value for " + dataToEdit[3]);
                    signedOnDriver.setVehicletype(in.nextLine());
                }
                case MessagesText.BASE_FARE_VALUE -> {
                    System.out.println("Type new value for " + dataToEdit[4]);
                    try {
                        signedOnDriver.setBaseFarePrice(Integer.parseInt(in.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println(MessagesText.INCORRECT_PRICE_ERROR);
                    }
                }
                case MessagesText.DISTANCE_VALUE -> {
                    System.out.println("Type new value for " + dataToEdit[5]);
                    try {
                        signedOnDriver.setBaseFareDistance(Double.parseDouble(in.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println(MessagesText.INCORRECT_DISTANCE_ERROR);
                    }
                }
                case MessagesText.COMMAND_TO_SAVE_CHANGES -> {
                    System.out.println("All changes successfully saved");
                    continueEditing = false;
                }
            }
            if (continueEditing) {
            System.out.println("Type '" + MessagesText.COMMAND_TO_SAVE_CHANGES + "' to save changes or choose next field to edit.");
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
