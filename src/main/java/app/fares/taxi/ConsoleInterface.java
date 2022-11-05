package app.fares.taxi;

public class ConsoleInterface extends ApplicationManager{

    public void mainLoop() throws Exception {
        while (true) {
            System.out.println(messagesText.getPleaseTypeCommand());
            System.out.println(messagesText.getTypeHelpToSeeCommands());
            String action = driverAccountHelper.in.nextLine();
            switch (action.toLowerCase()) {
                case "help":
                    displayActionsList();
                    break;
                case "print":
                    displayDriversList();
                    break;
                case "sign in":
                    signOnAsDriver();
                    break;
                case "sign out":
                    signOutFromDriverAccount();
                    break;
                case "add":
                    driverAccountHelper.addNewDriver();
                    break;
                case "edit":
                    driverAccountHelper.editDriver();
                    break;
                case "delete":
                    driverAccountHelper.deleteDriver();
                    break;
                case "calculate":
                    driverAccountHelper.calculateTheCheapestFare();
                    break;
                case "history":
                    driverAccountHelper.viewCostsHistory();
                    break;
                case "exit":
                    finishAppForTaxi();
                    return;
            }
            System.out.println(" ");
        }
    }


}
