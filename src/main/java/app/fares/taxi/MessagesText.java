package app.fares.taxi;

public class MessagesText {

    String pleaseTypeCommand = "Please, type a command.";
    String typeHelpToSeeCommands = "To see all currently possible commands, type '" + getCommandFromUser(0) +"'.";
    String pleaseSignIn = "You signed out. Sign in to manage driver account.";
    String typeCommandToSignIn = "If you want to sign in, type 'sign in'.";
    String typeCommandToEditDriver = "If you want to edit selected driver, type 'edit'.";
    String typeCommandToDeleteDriver = "If you want to delete your account, type 'delete'.";
    String typeCommandToCalculateFare = "If you want to calculate the cheapest fare, type 'calculate'.";
    String typeCommandToSeeHistory = "If you want to view the history of calculated costs, type 'history'.";
    String typeCommandToSignOut = "If you want to sign out, type 'sign out'.";
    String typeCommandToSeeAllDrivers = "If you want to print drivers list, type 'print'.";
    String typeCommandToRegisterNewDriver = "If you want to add new driver, type 'add'.";
    String exitApp = "Exit the application.\n" + "See you next time. =)";

    String noCalculatedCosts = "There is no calculated costs yet.";
    String typePathToCSVFile = "Type path to the .csv file for fare calculation";
    String noDriverExists = "There is no drivers yet.\n" + "Please use command 'add' to create new one.";


    public String getCommandFromUser(int index) {
        String[] commandFromUser = {"help", "sign in", "edit", "delete", "calculate", "history", "sign out", "print", "add",
                "exit"};
        return commandFromUser[index];
    }



    public String getNoDriverExists() {
        return noDriverExists;
    }

    public String getTypePathToCSVFile() {
        return typePathToCSVFile;
    }

    public String getNoCalculatedCosts() {
        return noCalculatedCosts;
    }

    public String getTypeCommandToSignIn() {
        return typeCommandToSignIn;
    }

    public String getTypeCommandToEditDriver() {
        return typeCommandToEditDriver;
    }

    public String getTypeCommandToDeleteDriver() {
        return typeCommandToDeleteDriver;
    }

    public String getTypeCommandToCalculateFare() {
        return typeCommandToCalculateFare;
    }

    public String getTypeCommandToSeeHistory() {
        return typeCommandToSeeHistory;
    }

    public String getTypeCommandToSignOut() {
        return typeCommandToSignOut;
    }

    public String getTypeCommandToSeeAllDrivers() {
        return typeCommandToSeeAllDrivers;
    }

    public String getTypeCommandToRegisterNewDriver() {
        return typeCommandToRegisterNewDriver;
    }

    public String getExitApp() {
        return exitApp;
    }

    public String getPleaseTypeCommand() {
        return pleaseTypeCommand;
    }

    public String getTypeHelpToSeeCommands() {
        return typeHelpToSeeCommands;
    }

    public String getPleaseSignIn() {
        return pleaseSignIn;
    }

}
