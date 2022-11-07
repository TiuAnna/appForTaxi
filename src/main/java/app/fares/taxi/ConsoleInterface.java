package app.fares.taxi;

public class ConsoleInterface extends ApplicationManager {

    public void mainLoop() throws Exception {
        while (true) {
            System.out.println(MessagesText.PLEASE_TYPE_COMMAND);
            System.out.println(MessagesText.TYPE_HELP_TO_SEE_COMMANDS);
            String action = driverAccountHelper.in.nextLine();
            action = action.toLowerCase();
            switch (action) {
                case MessagesText.COMMAND_TO_DISPLAY_COMMANDS       -> displayActionsList();
                case MessagesText.COMMAND_TO_DISPLAY_DRIVERS        -> displayDriversList();
                case MessagesText.COMMAND_TO_SIGN_IN                -> signInAsDriver();
                case MessagesText.COMMAND_TO_SIGN_OUT               -> signOutFromDriverAccount();
                case MessagesText.COMMAND_TO_ADD_DRIVER             -> driverAccountHelper.addNewDriver();
                case MessagesText.COMMAND_TO_EDIT_ACCOUNT           -> driverAccountHelper.editDriver();
                case MessagesText.COMMAND_TO_DELETE_ACCOUNT         -> driverAccountHelper.deleteDriver();
                case MessagesText.COMMAND_TO_CALCULATE_FARE         -> driverAccountHelper.calculateTheCheapestFare();
                case MessagesText.COMMAND_TO_DISPLAY_COSTS_HISTORY  -> driverAccountHelper.viewCostsHistory();
                case MessagesText.COMMAND_TO_EXIT_APP               -> {
                    finishAppForTaxi();
                    return;
                }
                default   -> System.out.println(MessagesText.INCORRECT_COMMAND_ERROR);
            }
            System.out.println(" ");
        }
    }


}
