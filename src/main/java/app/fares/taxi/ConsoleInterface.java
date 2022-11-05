package app.fares.taxi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface extends ApplicationManager{

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


}
