package app.fares.taxi;

public class MessagesText {

    public static final String COMMAND_TO_DISPLAY_COMMANDS = "help";
    public static final String COMMAND_TO_SIGN_IN = "sign in";
    public static final String COMMAND_TO_EDIT_ACCOUNT = "edit";
    public static final String COMMAND_TO_DELETE_ACCOUNT = "delete";
    public static final String COMMAND_TO_CALCULATE_FARE = "calculate";
    public static final String COMMAND_TO_DISPLAY_COSTS_HISTORY = "history";
    public static final String COMMAND_TO_SIGN_OUT = "sign out";
    public static final String COMMAND_TO_DISPLAY_DRIVERS = "print";
    public static final String COMMAND_TO_ADD_DRIVER = "add";
    public static final String COMMAND_TO_EXIT_APP = "exit";
    public static final String COMMAND_TO_SAVE_CHANGES = "save";
    public static final String COMMAND_TO_CHANGE_VALUE = "change";

    public static final String NAME_VALUE = "name";
    public static final String SURNAME_VALUE = "surname";
    public static final String EMAIL_VALUE = "email";
    public static final String VEHICLE_VALUE = "vehicle";
    public static final String BASE_FARE_VALUE = "fare";
    public static final String DISTANCE_VALUE = "distance";

    public static final String PLEASE_TYPE_COMMAND = "Please, type a command.";
    public static final String PLEASE_SIGN_IN = "You signed out. Sign in to manage driver account.";

    public static final String TEMPLATE_TYPE_COMMAND = "If you want to %s, type '%s'.";
    public static final String TYPE_HELP_TO_SEE_COMMANDS = String.format(
            TEMPLATE_TYPE_COMMAND,
            "see all currently possible commands",
            COMMAND_TO_DISPLAY_COMMANDS);
    public static final String TYPE_COMMAND_TO_SIGN_IN = String.format(
            TEMPLATE_TYPE_COMMAND,
            "sign in",
            COMMAND_TO_SIGN_IN);
    public static final String TYPE_COMMAND_TO_EDIT_DRIVER = String.format(
            TEMPLATE_TYPE_COMMAND,
            "edit selected driver",
            COMMAND_TO_EDIT_ACCOUNT);
    public static final String TYPE_COMMAND_TO_DELETE_DRIVER = String.format(
            TEMPLATE_TYPE_COMMAND,
            "delete your account",
            COMMAND_TO_DELETE_ACCOUNT);
    public static final String TYPE_COMMAND_TO_CALCULATE_FARE = String.format(
            TEMPLATE_TYPE_COMMAND,
            "calculate the cheapest fare",
            COMMAND_TO_CALCULATE_FARE);
    public static final String TYPE_COMMAND_TO_SEE_HISTORY = String.format(
            TEMPLATE_TYPE_COMMAND,
            "view the history of calculated costs",
            COMMAND_TO_DISPLAY_COSTS_HISTORY);
    public static final String TYPE_COMMAND_TO_SIGN_OUT = String.format(
            TEMPLATE_TYPE_COMMAND,
            "sign out",
            COMMAND_TO_SIGN_OUT);
    public static final String TYPE_COMMAND_TO_SEE_ALL_DRIVERS = String.format(
            TEMPLATE_TYPE_COMMAND,
            "print drivers list",
            COMMAND_TO_DISPLAY_DRIVERS);
    public static final String TYPE_COMMAND_TO_ADD_DRIVER = String.format(
            TEMPLATE_TYPE_COMMAND,
            "add new driver",
            COMMAND_TO_ADD_DRIVER);
    public static final String TYPE_COMMAND_TO_FINISH_APP = String.format(
            TEMPLATE_TYPE_COMMAND,
            "exit the application",
            COMMAND_TO_EXIT_APP);
    public static final String TYPE_COMMAND_TO_CHANGE_PASS = String.format(
            TEMPLATE_TYPE_COMMAND,
            "change the pass",
            COMMAND_TO_CHANGE_VALUE);

    public static final String TYPE_PATH_TO_CSV_FILE = "Type path to the .csv file for fare calculation";

    public static final String EXIT_APP = "Exit the application.\n" + "See you next time. =)";
    public static final String NO_CALCULATED_COSTS = "There is no calculated costs yet.";
    public static final String NO_DRIVER_EXISTS = "There is no drivers yet.\n" + "Please use command '" + COMMAND_TO_ADD_DRIVER + "' to create new one.";

    private static final String TEMPLATE_VALUE_ERROR = "%s was not changed due to incorrect value";
    public static final String INCORRECT_PRICE_ERROR = String.format(TEMPLATE_VALUE_ERROR, "Base fare price");
    public static final String INCORRECT_DISTANCE_ERROR = String.format(TEMPLATE_VALUE_ERROR, "Base fare distance");









}
