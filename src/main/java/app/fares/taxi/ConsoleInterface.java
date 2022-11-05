package app.fares.taxi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    MessagesText messagesText = new MessagesText();
    ArrayList<DriverData> driversInfo = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    DriverData signedOnDriver;
    int driverNumber;

    public void mainLoop() throws Exception {
        while (true) {
            System.out.println(messagesText.getPleaseTypeCommand());
            System.out.println(messagesText.getTypeHelpToSeeCommands());
            String action = in.nextLine();
            switch (action.toLowerCase()) {
                case "help":
                    displayActionsList();
                    break;
                case "print":
                    printDriversList();
                    break;
                case "sign in":
                    signOnAsDriver();
                    break;
                case "sign out":
                    signOutFromDriverAccount();
                    break;
                case "add":
                    addNewDriver();
                    break;
                case "edit":
                    editDriver();
                    break;
                case "delete":
                    deleteDriver();
                    break;
                case "calculate":
                    calculateTheCheapestFare();
                    break;
                case "history":
                    viewCostsHistory();
                    break;
                case "exit":
                    finishAppForTaxi();
                    return;
            }
            System.out.println(" ");
        }
    }

    private void signOutFromDriverAccount() {
        signedOnDriver = null;
        System.out.println(messagesText.getPleaseSignIn());
    }

    private void finishAppForTaxi() {
        System.out.println(messagesText.getExitApp());
    }

    private void displayActionsList() {
        if (!isUserSignedOn()) {
            System.out.println(messagesText.getTypeCommandToSignIn());
        } else {
            System.out.println(messagesText.getTypeCommandToEditDriver());
            System.out.println(messagesText.getTypeCommandToDeleteDriver());
            System.out.println(messagesText.getTypeCommandToCalculateFare());
            System.out.println(messagesText.getTypeCommandToSeeHistory());
            System.out.println(messagesText.getTypeCommandToSignOut());
        }
        System.out.println(messagesText.getTypeCommandToSeeAllDrivers());
        System.out.println(messagesText.getTypeCommandToRegisterNewDriver());
    }

    private void viewCostsHistory() {
        if (!isUserSignedOn()) {
            return;
        }
        if (signedOnDriver.getCalculatedCosts().size() > 0) {
            System.out.println("Previous calculated costs:");
            for (double calculatedFareForTravel : signedOnDriver.getCalculatedCosts()) {
                System.out.println(calculatedFareForTravel);
            }
        } else {
            System.out.println(messagesText.getNoCalculatedCosts());
        }

    }

    public void calculateTheCheapestFare() throws IOException {
        if (!isUserSignedOn()) {
            return;
        }
        System.out.println(messagesText.getTypePathToCSVFile());
        String pathToCSVFile = in.nextLine();
        List<String> fileLines = Files.readAllLines(Path.of(pathToCSVFile));
        for (String line : fileLines) {
            String[] csvFileOneLineInfo = line.split(",");
            double[] oneLineValues = new double[csvFileOneLineInfo.length];
            for (int i = 0; i < oneLineValues.length; i++) {
                oneLineValues[i] = Double.parseDouble(csvFileOneLineInfo[i]);
            }
            TravelData travelData = new TravelData(oneLineValues[0], oneLineValues[1], oneLineValues[2]);
            double distanceTraveledUnits = signedOnDriver.getBaseFareDistance() - travelData.getDistanceTraveled();
            double fare;
            if (travelData.getDistanceTraveled() > signedOnDriver.getBaseFareDistance()) {
                fare = signedOnDriver.getBaseFarePrice() + (distanceTraveledUnits * travelData.getCostPerDistanceTraveled());
            } else {
                fare = signedOnDriver.getBaseFarePrice() + distanceTraveledUnits;
            }
            signedOnDriver.getCalculatedCosts().add(fare);
            System.out.println(fare);
        }


    }


    public void printDriversList() {
        if (driversInfo.size() > 0) {
            System.out.println("All drivers list:");
            for (int i = 0; i < driversInfo.size(); i++) {
                DriverData driver = driversInfo.get(i);
                System.out.println("Index value: " + (i + 1) + ". Driver information: " + driver);
            }
        } else {
            System.out.println(messagesText.getNoDriverExists());
        }

    }

    public void addNewDriver() {
        System.out.println("Register new driver.");
        String[] dataToInput = {"your name", "your surname", "your email", "type of your vehicle", "base fare price",
                "base fare distance"};
        String[] emptyMassive = new String[dataToInput.length];
        for (int i = 0; i < dataToInput.length; i++) {
//            String input = dataToInput[i];
            System.out.println("Please input " + dataToInput[i]);
            emptyMassive[i] = in.nextLine();
        }
        DriverData driverData = new DriverData(emptyMassive[0], emptyMassive[1], emptyMassive[2], emptyMassive[3],
                Integer.parseInt(emptyMassive[4]), Double.parseDouble(emptyMassive[5]));
        driversInfo.add(driverData);
        System.out.println("New driver was successfully registered.");
        System.out.println("Driver's index is " + driversInfo.size());
    }

    public void signOnAsDriver() {
        if (driversInfo.size() == 0) {
            System.out.println(messagesText.getNoDriverExists());
            return;
        }
        System.out.println("Type the index of driver to sign in account");

        try {
            driverNumber = Integer.parseInt(in.nextLine()) - 1;

        } catch (NumberFormatException e) {
            System.out.println("Incorrect index format");
            return;
        }
        if (!(0 <= driverNumber && driverNumber < driversInfo.size())) {
            System.out.println("Index is out of range");
        } else {
            signedOnDriver = driversInfo.get(driverNumber);
            System.out.println("Signed in successfully.");
            System.out.println("Hello, " + signedOnDriver.getName() + "!");
        }
    }

    public void editDriver() {
        if (!isUserSignedOn()) {
            return;
        }
        System.out.println("Current driver info:");
        System.out.println(driversInfo.get(driverNumber));
//        DriverData dataBeforeEdit = new DriverData(signedOnDriver.getName(), signedOnDriver.getSurname(),
//                signedOnDriver.getEmail(), signedOnDriver.getVehicletype(), signedOnDriver.getBaseFarePrice(),
//                signedOnDriver.getBaseFareDistance());
        String[] dataToEdit = {"your name", "your surname", "your email", "type of your vehicle", "base fare price",
                "base fare distance"};
        String[] selectedField = {"'name'", "'surname'", "'email'", "'vehicle'", "'fare'", "'distance'"};
        for (int i = 0; i < dataToEdit.length; i++) {
            System.out.println("If you what to edit " + dataToEdit[i] + " type " + selectedField[i]);
        }
//        System.out.println("If you want to leave without saving changed, type 'cancel'.");
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
                        System.out.println("Base fare price was not changed due to incorrect value");
                    }
                    break;
                case "distance":
                    System.out.println("Type new value for " + dataToEdit[5]);
                    try {
                        signedOnDriver.setBaseFareDistance(Double.parseDouble(in.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Base fare distance was not changed due to incorrect value");
                    }
                    break;
                case "save":
                    System.out.println("All changes successfully saved");
                    continueEditing = false;
                    break;
//                case "cancel":
//                    System.out.println("Editing is canceled.");
//                    signedOnDriver = dataBeforeEdit;
//                    continueEditing = false;
//                    break;
            }
            if (continueEditing) {
            System.out.println("Type 'save' to save changes or choose next field to edit.");
            }

        }
//            if (answer.equalsIgnoreCase("yes")) {
//                System.out.println("Type new value for " + dataToEdit[i]);
//                modifiedDriverData[i] = in.nextLine();
//            } else {
//                modifiedDriverData[i] = signedOnDriver.getValue(i);
//            }
//        signedOnDriver.setName(modifiedDriverData[0]);
//        signedOnDriver.setSurname(modifiedDriverData[1]);
//        signedOnDriver.setEmail(modifiedDriverData[2]);
//        signedOnDriver.setVehicletype(modifiedDriverData[3]);
//        try {
//            signedOnDriver.setBaseFarePrice(Integer.parseInt(modifiedDriverData[4]));
//        } catch (NumberFormatException e) {
//            System.out.println("Base fare price was not changed due to incorrect value");
//        }
//        try {
//            signedOnDriver.setBaseFareDistance(Double.parseDouble(modifiedDriverData[5]));
//        } catch (NumberFormatException e) {
//            System.out.println("Base fare distance was not changed due to incorrect value");
//        }

        System.out.println("Current driver info:");
        System.out.println(driversInfo.get(driverNumber));
    }

    public boolean isUserSignedOn() {
        if (signedOnDriver == null) {
            System.out.println(messagesText.getPleaseSignIn());
            return false;
        } else {
            return true;
        }

    }

    public void deleteDriver() {
        if (!isUserSignedOn()) {
            return;
        }
        System.out.println("Do you really want to delete your account?");
        System.out.println("Type 'yes' to edit.");
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
