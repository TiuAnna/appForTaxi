package app.fares.taxi;

/**
 * appForTaxi was created as a technical test assignment
 * to create a taxi fare calculation application that supports the following functions:
 * 1. Create an application that allows you to register, delete and update driver profiles
 * 2. Create a fare calculation function that uses the registered driver to calculate the cheapest fare
 * 3. Save the calculated cost of the fare so that it can be viewed later can view later.
 *
 * @author Anna Tiulkacheva
 * @version 1.0
 * @since 2022-11-10
 */

public class Application{
    public static void main(String[] args) throws Exception {
        ConsoleInterface consoleInterface = new ConsoleInterface();
        consoleInterface.mainLoop();
    }

}
