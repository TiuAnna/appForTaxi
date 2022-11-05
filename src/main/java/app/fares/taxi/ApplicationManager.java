package app.fares.taxi;

import java.util.ArrayList;

public class ApplicationManager {
    MessagesText messagesText = new MessagesText();
    int driverNumber;
    ArrayList<DriverData> driversInfo = new ArrayList<>();


    protected DriverAccountHelper driverAccountHelper = new DriverAccountHelper(messagesText, driverNumber, driversInfo);

    public void signOnAsDriver() {
        if (driversInfo.size() == 0) {
            System.out.println(messagesText.getNoDriverExists());
            return;
        }
        System.out.println("Type the index of driver to sign in account");

        try {
            driverAccountHelper.driverNumber = Integer.parseInt(driverAccountHelper.in.nextLine()) - 1;

        } catch (NumberFormatException e) {
            System.out.println("Incorrect index format");
            return;
        }
        if (!(0 <= driverAccountHelper.driverNumber && driverAccountHelper.driverNumber < driversInfo.size())) {
            System.out.println("Index is out of range");
        } else {
            driverAccountHelper.signedOnDriver = driversInfo.get(driverAccountHelper.driverNumber);
            System.out.println("Signed in successfully.");
            System.out.println("Hello, " + driverAccountHelper.signedOnDriver.getName() + "!");
        }
    }

    protected void signOutFromDriverAccount() {
        driverAccountHelper.signedOnDriver = null;
        System.out.println(messagesText.getPleaseSignIn());
    }

    protected void finishAppForTaxi() {
        System.out.println(messagesText.getExitApp());
    }

    protected void displayActionsList() {
        if (!driverAccountHelper.isUserSignedOn()) {
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

    public void displayDriversList() {
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

//    public DriverAccountHelper getDriverAccountHelper() {
//        return driverAccountHelper;
//    }
}
