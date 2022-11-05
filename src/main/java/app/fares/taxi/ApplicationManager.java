package app.fares.taxi;

import java.util.ArrayList;

public class ApplicationManager {
    int driverNumber;
    ArrayList<DriverData> driversInfo = new ArrayList<>();


    protected DriverAccountHelper driverAccountHelper = new DriverAccountHelper(driverNumber, driversInfo);

    public void signInAsDriver() {
        if (driversInfo.size() == 0) {
            System.out.println(MessagesText.NO_DRIVER_EXISTS);
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
        System.out.println(MessagesText.PLEASE_SIGN_IN);
    }

    protected void finishAppForTaxi() {
        System.out.println(MessagesText.EXIT_APP);
    }

    protected void displayActionsList() {
        if (!driverAccountHelper.isUserSignedOn()) {
            System.out.println(MessagesText.TYPE_COMMAND_TO_SIGN_IN);
        } else {
            System.out.println(MessagesText.TYPE_COMMAND_TO_EDIT_DRIVER);
            System.out.println(MessagesText.TYPE_COMMAND_TO_DELETE_DRIVER);
            System.out.println(MessagesText.TYPE_COMMAND_TO_CALCULATE_FARE);
            System.out.println(MessagesText.TYPE_COMMAND_TO_SEE_HISTORY);
            System.out.println(MessagesText.TYPE_COMMAND_TO_SIGN_OUT);
        }
        System.out.println(MessagesText.TYPE_COMMAND_TO_SEE_ALL_DRIVERS);
        System.out.println(MessagesText.TYPE_COMMAND_TO_ADD_DRIVER);
        System.out.println(MessagesText.TYPE_COMMAND_TO_FINISH_APP);
    }

    public void displayDriversList() {
        if (driversInfo.size() > 0) {
            System.out.println("All drivers list:");
            for (int i = 0; i < driversInfo.size(); i++) {
                DriverData driver = driversInfo.get(i);
                System.out.println("Index value: " + (i + 1) + ". Driver information: " + driver);
            }
        } else {
            System.out.println(MessagesText.NO_DRIVER_EXISTS);
        }

    }

//    public DriverAccountHelper getDriverAccountHelper() {
//        return driverAccountHelper;
//    }
}
